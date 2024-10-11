import tkinter as tk
from tkinter import ttk, messagebox
import paramiko
import time

# Function to run remote command via SSH
def run_remote_command(host, user, password, command):
    try:
        client = paramiko.SSHClient()
        client.set_missing_host_key_policy(paramiko.AutoAddPolicy())
        client.connect(hostname=host, username=user, password=password)

        stdin, stdout, stderr = client.exec_command(command)
        output = stdout.read().decode()
        errors = stderr.read().decode()

        return output, errors
    except Exception as e:
        return None, str(e)

# Function to demonstrate a Linux distribution
def demonstrate_distribution(distro_name, host, user, password, demo_command):
    output_text.insert(tk.END, f"Starting {distro_name} demonstration...\n")
    root.update_idletasks()
    
    output, errors = run_remote_command(host, user, password, demo_command)
    
    if errors:
        output_text.insert(tk.END, f"Error during {distro_name} demo: {errors}\n")
    else:
        output_text.insert(tk.END, f"Completed {distro_name} demo.\n\n")

# Main function to start the exhibition
def start_exhibition():
    output_text.insert(tk.END, "Exhibition started.\n")
    progress_var.set(0)
    root.update_idletasks()

    # Added Raspberry Pi details
    distributions = {
        "Kali Linux": {"host": "192.168.1.101", "user": "user1", "password": "password1", "command": "kali-start-command"},
        "Eset Linux": {"host": "192.168.1.102", "user": "user2", "password": "password2", "command": "eset-start-command"},
        "Ubuntu": {"host": "192.168.1.103", "user": "user3", "password": "password3", "command": "ubuntu-start-command"},
        "Arch Linux": {"host": "192.168.1.104", "user": "user4", "password": "password4", "command": "arch-start-command"},
        "Fedora": {"host": "192.168.1.105", "user": "user5", "password": "password5", "command": "fedora-start-command"},
        "Debian": {"host": "192.168.1.106", "user": "user6", "password": "password6", "command": "debian-start-command"},
        "CentOS": {"host": "192.168.1.107", "user": "user7", "password": "password7", "command": "centos-start-command"},
        "Raspberry Pi": {"host": "192.168.1.108", "user": "pi", "password": "raspberry", "command": "pi-demo-command"}  # New entry for Pi
    }

    total_tasks = len(distributions)
    completed_tasks = 0

    for distro, details in distributions.items():
        demonstrate_distribution(distro, details["host"], details["user"], details["password"], details["command"])
        completed_tasks += 1
        progress_var.set((completed_tasks / total_tasks) * 100)
        root.update_idletasks()

    output_text.insert(tk.END, "All demos completed successfully!\n")
    messagebox.showinfo("Exhibition", "Exhibition completed.")

# Function to clear output log
def clear_output():
    output_text.delete(1.0, tk.END)

# Create the GUI window
root = tk.Tk()
root.title("Penguin and Pi - Exhibition Automation")

# Main frame
frame = ttk.Frame(root, padding="10")
frame.grid(row=0, column=0, sticky=(tk.W, tk.E, tk.N, tk.S))

# Exhibition title label
title_label = ttk.Label(frame, text="Penguin and Pi", font=("Arial", 16, "bold"))
title_label.grid(row=0, column=0, columnspan=2, pady=10)

# Start button
start_button = ttk.Button(frame, text="Start Exhibition", command=start_exhibition)
start_button.grid(row=1, column=0, padx=10, pady=10, sticky=tk.W)

# Clear button
clear_button = ttk.Button(frame, text="Clear Output", command=clear_output)
clear_button.grid(row=1, column=1, padx=10, pady=10, sticky=tk.E)

# Progress bar
progress_var = tk.DoubleVar()
progress_bar = ttk.Progressbar(frame, length=300, variable=progress_var)
progress_bar.grid(row=2, column=0, columnspan=2, pady=10)

# Output text area
output_label = ttk.Label(frame, text="Exhibition Log:", font=("Arial", 12))
output_label.grid(row=3, column=0, columnspan=2, pady=5)

output_text = tk.Text(frame, height=15, width=70, wrap="word", state="normal")
output_text.grid(row=4, column=0, columnspan=2, pady=5)

# Scrollbar for output text
scrollbar = ttk.Scrollbar(frame, command=output_text.yview)
output_text.config(yscrollcommand=scrollbar.set)
scrollbar.grid(row=4, column=2, sticky='ns')

# Adjust window resizing
root.columnconfigure(0, weight=1)
root.rowconfigure(0, weight=1)

# Start the Tkinter main loop
root.mainloop()
