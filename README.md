# 🐧 Pi and Penguin - Exhibition Automation 🖥️

![Python](https://img.shields.io/badge/Language-Python-blue)
![Java](https://img.shields.io/badge/Language-Java-red)
![Tkinter](https://img.shields.io/badge/GUI-Tkinter-lightgrey)
![JavaFX](https://img.shields.io/badge/GUI-JavaFX-orange)
![paramiko](https://img.shields.io/badge/SSH-paramiko-brightgreen)
![Maven](https://img.shields.io/badge/Build-Maven-blueviolet)
![Linux](https://img.shields.io/badge/Platform-Linux-informational)
![Raspberry Pi](https://img.shields.io/badge/Hardware-Raspberry%20Pi-green)

> **Developed by Alan Cyril Sunny**  
> If you find this project helpful, please consider ⭐ [starring the repository](https://github.com/dragonpilee/pi-and-penguin-exhibition)!

---

### 📅 **Event:** NAAC Accreditation Visit  
### 📍 **Venue:** BVM Holy Cross College, Cherpunkal  
### 👨‍💻 **Handled by:** Alan Cyril Sunny (MSc CS, Data Analysis Batch)

---

## 📜 Overview

**Pi and Penguin - Exhibition Automation** is an automated exhibition system crafted for the NAAC accreditation visit. It demonstrates various Linux distributions and Raspberry Pi in an automated manner using a graphical interface. The project showcases technical expertise in automation, system integration, and real-time feedback.

---

## 🎮 Retro Gaming Console with Raspberry Pi 4

A **Raspberry Pi 4** was used to create a **retro gaming console** using **Batocera**. This allows users to enjoy classic games from various consoles in a single, easy-to-use interface, demonstrating the Raspberry Pi's versatility as an entertainment device.

---

## 🚀 Exhibition Features

- **Automated Demos**: Seamlessly demonstrate Linux distributions (Kali, Ubuntu, Fedora, Raspberry Pi) using SSH automation.
- **Real-time Progress Tracking**: Monitor demo status with a dynamic progress bar.
- **Clean and Simple GUI**: Built with **Tkinter** (Python) and **JavaFX** (Java) for a user-friendly interface.
- **Exhibition Logs**: Real-time logs and error outputs displayed in the app.
- **Educational Focus**: Highlights the MSc CS (Data Analysis) batch's automation and data analysis skills.

---

## 🧰 Key Technologies

- **Python**: Core automation logic
- **Java**: Additional functionality, built with Maven
- **Tkinter**: Python GUI
- **JavaFX**: Java GUI
- **paramiko**: SSH automation in Python
- **Maven**: Java build management
- **Linux Distributions**: Kali, Ubuntu, Fedora, Debian, CentOS, etc.
- **Raspberry Pi**: IoT and retro gaming (Batocera)

---

## 🛠️ How It Works

1. **SSH Connections**: Connects to remote machines via SSH to run predefined commands.
2. **Automated Demo Execution**: Executes commands/scripts for each OS or Raspberry Pi.
3. **Live Log and Progress**: Real-time output and progress in the GUI.
4. **Completion Notification**: Notifies user when all demos are complete.

---

## 🖥️ Installation

### Prerequisites

- **Python 3.x**
- **Java JDK**
- **Maven**
- Install Python libraries:
  ```bash
  pip install paramiko tkinter
  ```

### Steps to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/dragonpilee/pi-and-penguin-exhibition.git
   cd pi-and-penguin-exhibition
   ```
2. **Run the Python application**
   ```bash
   python naac.py
   ```
3. **Run the Java application**
   ```bash
   cd java-directory
   mvn clean install
   mvn exec:java -Dexec.mainClass="com.example.ExhibitionAutomation"
   ```
4. **Begin the exhibition**: Click **Start Exhibition** in the Python GUI.

---

## ⚙️ Configuration

Edit the `distributions` dictionary in `pi_and_penguin.py` to set SSH credentials and commands:

```python
distributions = {
    "Kali Linux": {"host": "192.168.1.101", "user": "user1", "password": "password1", "command": "kali-demo-command"},
    "Ubuntu": {"host": "192.168.1.102", "user": "user2", "password": "password2", "command": "ubuntu-demo-command"},
    # Add more distributions as required...
    "Raspberry Pi": {"host": "192.168.1.103", "user": "pi", "password": "raspberry", "command": "pi-demo-command"}
}
```

For Java, configure SSH and commands in the Java application as needed.

---

## 🤝 Contributing

Contributions are welcome! Fork the repository, make improvements, and submit a pull request.

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

**Pi and Penguin - Exhibition Automation** stands as a testament to the dedication and technical skills of **Alan Cyril Sunny**, who single-handedly handled the entire exhibition for the NAAC visit at BVM Holy Cross College, Cherpunkal.

---

### Contact

For questions, feedback, or collaborations:

- **Alan Cyril Sunny**  
  MSc CS (Data Analysis)  
  **BVM Holy Cross College, Cherpunkal**

---

*Crafted with precision and dedication for the NAAC accreditation visit.* 🏅
