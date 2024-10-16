
# 🐧 **Pi and Penguin - Exhibition Automation** 🖥️

> **An automated exhibition system created for the NAAC visit by Alan Cyril Sunny for BVM Holy Cross College, Cherpunkal.**

### 📅 **Event:** NAAC Accreditation Visit  
### 📍 **Venue:** BVM Holy Cross College, Cherpunkal  
### 👨‍💻 **Handled by:** Alan Cyril Sunny (MSc CS, Data Analysis Batch)

## 📜 **Overview**

This project, **Pi and Penguin - Exhibition Automation**, was specially crafted for the NAAC accreditation visit. It demonstrates various Linux distributions and Raspberry Pi in an automated manner using a graphical interface. The project showcases the technical expertise and project management capabilities of the dev , with a focus on automation, system integration, and real-time feedback.

## 🎮 **Retro Gaming Console with Raspberry Pi 4**

In addition to the exhibition automation, I used a **Raspberry Pi 4** to create a **retro gaming console** using **Batocera**. This project allows users to enjoy classic games from various consoles in a single, easy-to-use interface. The console supports multiple gaming systems and is a testament to the capabilities of the Raspberry Pi as an entertainment device.

## 🚀 **Exhibition Features**

- **Automated Demos**: Seamlessly demonstrate Linux distributions such as Kali, Ubuntu, Fedora, and Raspberry Pi using SSH automation.
- **Real-time Progress Tracking**: Monitor the status of each demo through a dynamic progress bar.
- **Clean and Simple GUI**: Built using **Tkinter** for Python and **JavaFX** for Java, offering a user-friendly and intuitive interface.
- **Exhibition Logs**: Real-time logs of demo outputs and any errors, displayed directly in the app.
- **Educational Focus**: Highlights the data analysis and system automation capabilities of the MSc CS (Data Analysis) batch.

## 💡 **Key Technologies**

- **Python**: Core programming language for the automation system.
- **Java**: Provides additional functionality and is integrated with Maven for build management.
- **Tkinter**: Used to design the graphical user interface in Python.
- **JavaFX**: Used for creating a Java-based GUI.
- **paramiko**: SSH library for executing remote commands in Python.
- **Maven**: Build automation tool for Java projects.
- **Linux Distributions**: Demos include Kali Linux, Ubuntu, Fedora, Debian, CentOS, and more.
- **Raspberry Pi**: Integrated to demonstrate IoT and embedded systems projects, including the retro gaming console using Batocera.

## 🛠️ **How It Works**

1. **SSH Connections**: Connects to remote machines using SSH to run predefined commands for each Linux distribution or Raspberry Pi.
2. **Automated Demo Execution**: Executes commands on each system, such as launching scripts or showcasing features of the operating system.
3. **Live Log and Progress**: The output of each command and progress of the demonstration is displayed in real-time in the application’s GUI.
4. **Completion Notification**: When all demos are completed, the user receives a notification, ensuring a smooth exhibition flow.

## 🖥️ **Installation**

### **Pre-requisites**

- **Python 3.x** installed.
- **Java JDK** installed for the Java part of the project.
- **Maven** installed for building the Java application.
- Install required Python libraries:
  ```bash
  pip install paramiko tkinter
  ```

### **Steps to Run the Project**

1. **Clone this repository**:
   ```bash
   git clone https://github.com/your-username/pi-and-penguin-exhibition.git
   ```
2. **Navigate to the project directory**:
   ```bash
   cd pi-and-penguin-exhibition
   ```
3. **Run the Python application**:
   ```bash
   python naac.py
   ```
4. **Run the Java application**:
   - First, navigate to the Java directory (if applicable):
     ```bash
     cd java-directory
     ```
   - Then, use Maven to clean and install the project:
     ```bash
     mvn clean install
     ```
   - Finally, run the Java application:
     ```bash
     mvn exec:java -Dexec.mainClass="com.example.ExhibitionAutomation"
     ```

5. **Begin the exhibition**: Click on **Start Exhibition** in the Python GUI to begin automated demonstrations.

## ⚙️ **Configuration**

To add or modify the SSH credentials and commands for each Linux distribution or Raspberry Pi, edit the `distributions` dictionary in the `pi_and_penguin.py` file as shown below:

```python
distributions = {
    "Kali Linux": {"host": "192.168.1.101", "user": "user1", "password": "password1", "command": "kali-demo-command"},
    "Ubuntu": {"host": "192.168.1.102", "user": "user2", "password": "password2", "command": "ubuntu-demo-command"},
    # Add more distributions as required...
    "Raspberry Pi": {"host": "192.168.1.103", "user": "pi", "password": "raspberry", "command": "pi-demo-command"}
}
```

For Java, configure the SSH connections and commands in the Java application as needed.

## 👨‍💻 **Contributing**

Contributions are welcome! Feel free to fork the repository, make improvements, and submit a pull request.

## 📝 **License**

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

---

**Pi and Penguin - Exhibition Automation** stands as a testament to the dedication and technical skills of **Alan Cyril Sunny**, who single-handedly handled the entire exhibition for the NAAC visit at BVM Holy Cross College, Cherpunkal.

---

### Contact

For any questions, feedback, or collaborations, feel free to reach out:

- **Alan Cyril Sunny**  
  MSc CS (Data Analysis)  
  **BVM Holy Cross College, Cherpunkal**

---

*Crafted with precision and dedication for the NAAC accreditation visit.* 🏅
