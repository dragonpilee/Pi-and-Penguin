import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExhibitionAutomation {

    private static JTextArea outputText;
    private static JProgressBar progressBar;

    // Function to run remote command via SSH
    private static String[] runRemoteCommand(String host, String user, String password, String command) {
        String[] output = new String[2]; // output[0]: command output, output[1]: errors
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            session.setPassword(password);

            // Avoid asking for key confirmation
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
            channelExec.setCommand(command);
            channelExec.setErrStream(System.err);

            BufferedReader reader = new BufferedReader(new InputStreamReader(channelExec.getInputStream()));
            channelExec.connect();

            StringBuilder outputBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                outputBuilder.append(line).append("\n");
            }

            output[0] = outputBuilder.toString(); // command output
            output[1] = ""; // no errors for now
            channelExec.disconnect();
            session.disconnect();
        } catch (Exception e) {
            output[1] = e.getMessage(); // capture error message
        }
        return output;
    }

    // Function to demonstrate a Linux distribution
    private static void demonstrateDistribution(String distroName, String host, String user, String password, String demoCommand) {
        outputText.append("Starting " + distroName + " demonstration...\n");
        SwingUtilities.invokeLater(() -> outputText.setCaretPosition(outputText.getDocument().getLength()));
        
        String[] result = runRemoteCommand(host, user, password, demoCommand);
        
        if (!result[1].isEmpty()) {
            outputText.append("Error during " + distroName + " demo: " + result[1] + "\n");
        } else {
            outputText.append("Completed " + distroName + " demo.\n\n");
        }
    }

    // Main function to start the exhibition
    private static void startExhibition() {
        outputText.append("Exhibition started.\n");
        progressBar.setValue(0);

        // Added Raspberry Pi details
        String[][] distributions = {
            {"Kali Linux", "192.168.1.101", "user1", "password1", "kali-start-command"},
            {"Eset Linux", "192.168.1.102", "user2", "password2", "eset-start-command"},
            {"Ubuntu", "192.168.1.103", "user3", "password3", "ubuntu-start-command"},
            {"Arch Linux", "192.168.1.104", "user4", "password4", "arch-start-command"},
            {"Fedora", "192.168.1.105", "user5", "password5", "fedora-start-command"},
            {"Debian", "192.168.1.106", "user6", "password6", "debian-start-command"},
            {"CentOS", "192.168.1.107", "user7", "password7", "centos-start-command"},
            {"Raspberry Pi", "192.168.1.108", "pi", "raspberry", "pi-demo-command"} // New entry for Pi
        };

        int totalTasks = distributions.length;
        int completedTasks = 0;

        for (String[] distro : distributions) {
            demonstrateDistribution(distro[0], distro[1], distro[2], distro[3], distro[4]);
            completedTasks++;
            progressBar.setValue((completedTasks * 100) / totalTasks);
        }

        outputText.append("All demos completed successfully!\n");
        JOptionPane.showMessageDialog(null, "Exhibition completed.");
    }

    // Function to clear output log
    private static void clearOutput() {
        outputText.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Penguin and Pi - Exhibition Automation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 500);
            frame.setLayout(new BorderLayout());

            JPanel panel = new JPanel();
            panel.setBorder(new EmptyBorder(10, 10, 10, 10));
            panel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            JLabel titleLabel = new JLabel("Penguin and Pi");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            panel.add(titleLabel, gbc);

            JButton startButton = new JButton("Start Exhibition");
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    startExhibition();
                }
            });
            gbc.gridwidth = 1;
            gbc.gridy = 1;
            gbc.gridx = 0;
            panel.add(startButton, gbc);

            JButton clearButton = new JButton("Clear Output");
            clearButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    clearOutput();
                }
            });
            gbc.gridx = 1;
            panel.add(clearButton, gbc);

            progressBar = new JProgressBar();
            gbc.gridwidth = 2;
            gbc.gridy = 2;
            panel.add(progressBar, gbc);

            JLabel outputLabel = new JLabel("Exhibition Log:");
            outputLabel.setFont(new Font("Arial", Font.PLAIN, 12));
            gbc.gridwidth = 2;
            gbc.gridy = 3;
            panel.add(outputLabel, gbc);

            outputText = new JTextArea(15, 50);
            outputText.setLineWrap(true);
            outputText.setWrapStyleWord(true);
            JScrollPane scrollPane = new JScrollPane(outputText);
            gbc.gridy = 4;
            panel.add(scrollPane, gbc);

            frame.add(panel, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}
