# 🔐 Password Manager (Java + MySQL)

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=openjdk)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge&logo=mysql)
![JDBC](https://img.shields.io/badge/JDBC-Connector-success?style=for-the-badge)
![AES-256](https://img.shields.io/badge/AES--256-GCM-red?style=for-the-badge)
![PBKDF2](https://img.shields.io/badge/PBKDF2-HmacSHA256-purple?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-In%20Development-yellow?style=for-the-badge)
![License](https://img.shields.io/badge/License-Educational-green?style=for-the-badge)

A secure console-based **Password Manager** built with **Java** and **MySQL** that encrypts user credentials using **AES-256-GCM** and derives encryption keys with **PBKDF2**. The application securely stores login credentials while ensuring sensitive information is never stored in plain text.

> ⚠️ **Project Status:** Under Development

---

# 📖 Overview

This project demonstrates the implementation of modern cryptographic techniques in Java. It securely stores website credentials using **AES-256-GCM encryption**, while **PBKDF2WithHmacSHA256** derives a strong encryption key from the user's master password. The application follows secure coding practices such as authenticated encryption, unique IV generation, and password strength validation.

---

# ✨ Features

## ✅ Implemented

- 🔐 AES-256-GCM Encryption
- 🔑 PBKDF2 Key Derivation
- 💪 Password Strength Checker
- ➕ Add New Credentials
- 🗄️ MySQL Database Integration
- 🔌 JDBC Connectivity
- 🎯 Console-Based Interface
- 🎲 Unique IV for Every Password
- 📂 DAO-Based Project Structure

## 🚧 In Progress

- 👤 User Registration
- 🔓 User Login
- 🔍 Search Credentials
- ✏️ Edit Credentials
- 🗑️ Delete Credentials
- 🎲 Password Generator
- 🔑 Session-Based Key Management

---

# 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| ☕ Java (JDK 17+) | Core Application |
| 🗄️ MySQL | Database |
| 🔌 JDBC | Database Connectivity |
| 🔐 AES-256-GCM | Password Encryption |
| 🔑 PBKDF2WithHmacSHA256 | Key Derivation |
| 🛡️ Java Cryptography Architecture | Cryptographic Operations |

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
│   └── UserDAO.java
│
└── lib/
    └── mysql-connector-j-x.x.x.jar
```

---

# 🗄️ Database Schema

## 👤 Users Table

```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    salt VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## 🔐 Credentials Table

```sql
CREATE TABLE credentials (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    site_name VARCHAR(100) NOT NULL,
    site_username VARCHAR(100) NOT NULL,
    encrypted_password TEXT NOT NULL,
    iv VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
);
```

---

# 🚀 Getting Started

## 📋 Prerequisites

- ☕ Java JDK 17+
- 🗄️ MySQL Server
- 🔌 MySQL Connector/J
- 💻 IntelliJ IDEA / Eclipse / VS Code

## ⚙️ Installation

### 1️⃣ Clone Repository

```bash
git clone https://github.com/your-username/PasswordManager.git
```

### 2️⃣ Open the Project

Open the project in your preferred Java IDE.

### 3️⃣ Configure Database

Update your MySQL username and password in:

```
DatabaseConnection.java
```

### 4️⃣ Create Tables

Run:

```
sql/schema.sql
```

### 5️⃣ Start the Application

Run:

```
Main.java
```

---

# 💻 Console Menu

```text
=============================
      PASSWORD MANAGER
=============================

1. Add Password
2. Search Password
3. Edit Password
4. Delete Password
5. Exit

Enter your choice:
```

---

# 🔒 Security Features

### 🔐 AES-256-GCM Encryption

- Encrypts every stored password
- Provides confidentiality and integrity
- Protects against data tampering

### 🔑 PBKDF2 Key Derivation

- Uses PBKDF2WithHmacSHA256
- Derives secure encryption keys
- Makes brute-force attacks significantly harder

### 🎲 Random Initialization Vector (IV)

- New IV for every credential
- Prevents identical ciphertext
- Stored safely alongside encrypted data

### 💪 Password Strength Checker

Evaluates passwords based on:

- ✔ Length
- ✔ Uppercase Letters
- ✔ Lowercase Letters
- ✔ Numbers
- ✔ Special Characters

Ratings:

- 🟥 Weak
- 🟨 Medium
- 🟩 Strong

---

# 📌 Roadmap

| Feature | Status |
|----------|--------|
| ✅ Project Setup | Complete |
| ✅ Database Design | Complete |
| ✅ JDBC Connection | Complete |
| ✅ AES Encryption | Complete |
| ✅ PBKDF2 Key Derivation | Complete |
| ✅ Password Strength Checker | Complete |
| ✅ Add Password | Complete |
| 🚧 User Registration | In Progress |
| 🚧 User Login | In Progress |
| 🚧 Search Password | Planned |
| 🚧 Edit Password | Planned |
| 🚧 Delete Password | Planned |
| 🚧 Password Generator | Planned |
| 🚧 Session Key Management | Planned |

---

# 📚 Learning Objectives

This project demonstrates practical implementation of:

- ☕ Java Programming
- 🧩 Object-Oriented Programming (OOP)
- 🔐 AES Encryption
- 🔑 PBKDF2 Key Derivation
- 🛡️ Java Cryptography Architecture (JCA)
- 🗄️ MySQL Database Design
- 🔌 JDBC Connectivity
- 📂 DAO Design Pattern
- 🔒 Secure Password Storage

---

# ⚠️ Disclaimer

This project is developed for educational purposes to demonstrate secure password management concepts. While it implements several security best practices, production-grade password managers require additional protections such as secure memory handling, hardware-backed keystores, secure backups, and multi-factor authentication.

---

# 👨‍💻 Author

## 🌟 M. Ahsan Idrees

🎓 Cybersecurity Student — University of Engineering & Technology (UET), Lahore

💻 Passionate about Cybersecurity, Java Development, Python, C#, Web Development, and Database Systems.

### 🛠️ Skills

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Python](https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white)
![C Sharp](https://img.shields.io/badge/C%23-68217A?style=for-the-badge&logo=csharp&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)


## 🌐 Connect With Me

[![GitHub](https://img.shields.io/badge/GitHub-ahsanidreesnns8--ai-181717?style=for-the-badge&logo=github)](https://github.com/ahsanidreesnns8-ai)

[![LinkedIn](https://img.shields.io/badge/LinkedIn-M.%20Ahsan%20Idrees-0A66C2?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/m-ahsan-idrees-664126329)

---

# ⭐ Support

If you found this project helpful, please consider giving it a ⭐ on GitHub. It motivates me to build more open-source projects.

---

# 📄 License

This project is licensed for educational and learning purposes.
