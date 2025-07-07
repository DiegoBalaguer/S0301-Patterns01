# S03.01 - Patterns01

---

# 🎯 Objectives

- Learn to identify and handle software construction patterns.

---

## 🔹 Level 1

### 📘 Exercise 1 - Singleton

Create a class that replicates the functionality of the 'Undo' command. This class will be used by the `Main` class, which will allow introducing options via the console.

The 'Undo' class must store the last commands entered. It must allow adding or removing commands, as well as listing the last commands entered (similar to the 'history' command in Linux).
The 'Undo' class must necessarily implement a Singleton pattern.

---

## 🔹 Level 2

### 📘 Exercise 1 - Abstract Factory

Create a small manager for international addresses and phone numbers.

The application must allow adding international addresses and phone numbers to the agenda. Taking into account the different formats of different countries, build the agenda, addresses, and phones by implementing an Abstract Factory pattern.

---

## 🔹 Level 3

### 📘 Exercise 1 - Command

Design a parking lot for 4 vehicles: a car, a bicycle, a plane, and a boat.

Show how the Command pattern works, implementing the `start`, `accelerate`, and `brake` methods for each type of vehicle.

---

# 🛠️ Technologies Used

- Java 21

---

## ⚙️ Installation & Execution

### 📋 Requirements

To run this project, you need:

- Java Development Kit (JDK) 21 or higher
- Eclipse or IntelliJ IDEA
- Git

---

### 🛠️ Installation

1. Make sure **JDK 21** or higher is installed.
2. Clone this repository:
   ```sh
   git clone <👉 https://github.com/DiegoBalaguer/S0301-Patterns01.git>
   ```
3. Open the project with your preferred IDE (Eclipse or IntelliJ).

---

### ▶️ Execution

1. From your IDE:
    - Open the `main()` method in the `Principal` class or any exercise class.
    - Run the file directly using your IDE's run configuration.

---

# 🌐 Deployment

This project is for **educational purposes** and is intended for **local development only**. No deployment or external environment is required.

---

## 📦 Repository

You can find the full source code on GitHub:
🔗 👉 https://github.com/DiegoBalaguer/S0301-Patterns01.git

---

## ✅ Author Notes

These exercises are designed to give you practical experience with software design patterns, focusing on Singleton, Abstract Factory, and Command patterns.

Feel free to explore, modify, and expand upon the base code!

Happy coding! 🚀
