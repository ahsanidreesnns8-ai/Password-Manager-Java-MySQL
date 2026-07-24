# 🔐 Password Manager (Java + MySQL)

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=openjdk)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge&logo=mysql)
![JDBC](https://img.shields.io/badge/JDBC-Connector-success?style=for-the-badge)
![AES-256-GCM](https://img.shields.io/badge/AES--256-GCM-red?style=for-the-badge)
![PBKDF2](https://img.shields.io/badge/PBKDF2-HmacSHA256-purple?style=for-the-badge)
![BCrypt](https://img.shields.io/badge/BCrypt-Secure%20Hashing-brightgreen?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

A secure **Password Manager** built with **Java** and **MySQL** that protects user credentials using **AES-256-GCM encryption**, **PBKDF2 key derivation**, and **BCrypt password hashing**. The application allows users to securely register, log in, and manage their passwords while ensuring that sensitive information is never stored in plain text.

---

# 📖 Overview

This project demonstrates the practical implementation of modern cryptographic techniques in Java. Every stored password is encrypted using **AES-256-GCM**, while the user's master password is securely hashed with **BCrypt**. Encryption keys are derived using **PBKDF2WithHmacSHA256**, providing strong protection against brute-force attacks.

The application follows secure software development practices and implements complete CRUD functionality for password management.

---

# ✨ Features

## ✅ Authentication

- 👤 User Registration
- 🔐 Secure User Login
- 🔑 BCrypt Password Hashing
- 🚪 Logout Support

---

## ✅ Password Management

- ➕ Add New Credential
- 🔍 Search Saved Credential
- ✏️ Edit Existing Credential
- 🗑️ Delete Credential
- 📋 View All Saved Credentials

---

## ✅ Security

- 🔒 AES-256-GCM Encryption
- 🔑 PBKDF2WithHmacSHA256 Key Derivation
- 🛡️ BCrypt Password Hashing
- 🎲 Unique IV Generated for Every Password
- 💪 Password Strength Checker
- 🔐 Master Password Never Stored in Plain Text

---

## ✅ Database

- 🗄️ MySQL Database
- 🔌 JDBC Connectivity
- 📂 DAO Architecture
- 🔄 Complete CRUD Operations

---

# 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| ☕ Java (JDK 17+) | Core Programming Language |
| 🗄️ MySQL | Database |
| 🔌 JDBC | Database Connectivity |
| 🔐 AES-256-GCM | Password Encryption |
| 🔑 PBKDF2WithHmacSHA256 | Encryption Key Derivation |
| 🛡️ BCrypt | Password Hashing |
| 🔒 Java Cryptography Architecture (JCA) | Cryptographic Operations |

---

# 📂 Project Structure

```text
PasswordManager/
│
├── sql/
│   └── schema.sql
│
├── src/
│   ├── Main.java
│   ├── DatabaseConnection.java
│   ├── CryptoUtil.java
│   ├── KeyDerivation.java
│   ├── PasswordHasher.java
│   ├── PasswordStrengthChecker.java
│   ├── CredentialDAO.java
│   ├── UserDAO.java
│   └── UserSession.java
│
└── lib/
    ├── mysql-connector-j.jar
    └── jbcrypt.jar
```

---

# 🗄️ Database Schema

## Users Table

```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## Credentials Table

```sql
CREATE TABLE credentials (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    site_name VARCHAR(100) NOT NULL,
    site_username VARCHAR(100) NOT NULL,
    encrypted_password TEXT NOT NULL,
    iv VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);
```

---

# 🚀 Getting Started

## 📋 Prerequisites

- Java JDK 17+
- MySQL Server
- MySQL Connector/J
- jBCrypt Library
- IntelliJ IDEA / Eclipse / VS Code

---

## Installation

### 1️⃣ Clone Repository

```bash
git clone https://github.com/your-username/PasswordManager.git
```

### 2️⃣ Open Project

Import the project into your preferred Java IDE.

### 3️⃣ Configure Database

Update your MySQL credentials in:

```text
DatabaseConnection.java
```

### 4️⃣ Create Database

Run:

```text
sql/schema.sql
```

### 5️⃣ Execute

Run:

```text
Main.java
```

---

# 💻 Console Menu

```text
=============================
      PASSWORD MANAGER
=============================

1. Register
2. Login
3. Add Password
4. Search Password
5. Edit Password
6. Delete Password
7. View All Passwords
8. Logout
9. Exit

Enter your choice:
```

---

# 🔒 Security Implementation

## 🔐 AES-256-GCM Encryption

- Encrypts every stored credential.
- Provides confidentiality and authentication.
- Detects any tampering with encrypted data.

---

## 🔑 PBKDF2WithHmacSHA256

- Derives strong encryption keys.
- Protects against brute-force attacks.
- Uses thousands of hashing iterations.

---

## 🛡️ BCrypt Password Hashing

- Securely hashes user passwords.
- Automatically generates random salt.
- Passwords are never stored in plain text.

---

## 🎲 Random Initialization Vector (IV)

- Unique IV generated for every password.
- Prevents identical ciphertext.
- Stored safely with encrypted credentials.

---

## 💪 Password Strength Checker

Passwords are evaluated using:

- ✅ Length
- ✅ Uppercase Letters
- ✅ Lowercase Letters
- ✅ Numbers
- ✅ Special Characters

Ratings:

- 🟥 Weak
- 🟨 Medium
- 🟩 Strong

---

# 📌 Project Features

| Feature | Status |
|----------|--------|
| Project Setup | ✅ Completed |
| Database Design | ✅ Completed |
| JDBC Integration | ✅ Completed |
| User Registration | ✅ Completed |
| User Login | ✅ Completed |
| BCrypt Password Hashing | ✅ Completed |
| PBKDF2 Key Derivation | ✅ Completed |
| AES-256-GCM Encryption | ✅ Completed |
| Password Strength Checker | ✅ Completed |
| Add Password | ✅ Completed |
| Search Password | ✅ Completed |
| Edit Password | ✅ Completed |
| Delete Password | ✅ Completed |
| View All Passwords | ✅ Completed |
| Session Management | ✅ Completed |

---

# 📚 Concepts Demonstrated

- ☕ Java Programming
- 🧩 Object-Oriented Programming (OOP)
- 🔐 AES-256-GCM Encryption
- 🔑 PBKDF2 Key Derivation
- 🛡️ BCrypt Password Hashing
- 🔒 Java Cryptography Architecture (JCA)
- 🗄️ MySQL Database Design
- 🔌 JDBC Connectivity
- 📂 DAO Design Pattern
- 🔐 Secure Password Storage
- 🛠️ CRUD Operations

---

# 🎯 Future Enhancements

- 🖥️ Java Swing / JavaFX GUI
- ☁️ Cloud Synchronization
- 📱 Mobile Application
- 🔑 Two-Factor Authentication (2FA)
- 📄 Import & Export Passwords
- 🔔 Password Expiry Notifications
- 🌙 Dark Theme
- ☁️ Secure Backup & Restore
- 👥 Multi-Device Synchronization

---

# 👨‍💻 Author

## 🌟 M. Ahsan Idrees

🎓 **Cybersecurity Student** — University of Engineering & Technology (UET), Lahore

💻 Passionate about **Cybersecurity**, **Java Development**, **Python**, **C#**, **Web Development**, and **Database Systems**.

### 🛠️ Skills

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Python](https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white)
![C Sharp](https://img.shields.io/badge/C%23-68217A?style=for-the-badge&logo=csharp&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)


### 🌐 Connect With Me

[![GitHub](https://img.shields.io/badge/GitHub-ahsanidreesnns8--ai-181717?style=for-the-badge&logo=github)](https://github.com/ahsanidreesnns8-ai)

[![LinkedIn](https://img.shields.io/badge/LinkedIn-M.%20Ahsan%20Idrees-0A66C2?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/m-ahsan-idrees-664126329)

---

# ⭐ Support

If you found this project useful, consider giving it a **⭐ Star** on GitHub. Your support motivates me to continue building and sharing open-source projects.

---

# 📄 License

This project is licensed under the **MIT License**.

Feel free to use, modify, and distribute this project for educational and personal purposes.
````
