# 🔐 Password Manager (Java + MySQL)

<div align="center">

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-Connector-success?style=for-the-badge)
![AES-256-GCM](https://img.shields.io/badge/AES--256-GCM-red?style=for-the-badge)
![PBKDF2](https://img.shields.io/badge/PBKDF2-HmacSHA256-purple?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

*A secure console-based password manager built using Java, MySQL, AES-256-GCM encryption, and PBKDF2 key derivation.*

</div>

---

# 📖 Overview

This Password Manager is a secure Java application that stores website credentials in an encrypted format inside a MySQL database. Every password is encrypted using **AES-256-GCM**, while the encryption key is derived securely using **PBKDF2WithHmacSHA256**.

The project demonstrates secure password storage techniques, Java Cryptography Architecture (JCA), JDBC database connectivity, and CRUD operations.

---

# ✨ Features

## 🔐 Security

- ✅ AES-256-GCM Encryption
- ✅ PBKDF2WithHmacSHA256 Key Derivation
- ✅ Random Initialization Vector (IV)
- ✅ Password Strength Checker
- ✅ Passwords Stored in Encrypted Format

---

## 📂 Password Management

- ➕ Add Password
- 🔍 Search Password
- ✏️ Edit Password
- 🗑️ Delete Password

---

## 🗄️ Database

- ✅ MySQL Database
- ✅ JDBC Integration
- ✅ DAO Pattern
- ✅ Complete CRUD Operations

---

# 🛠️ Tech Stack

| Technology | Description |
|------------|-------------|
| ☕ Java (JDK 17+) | Programming Language |
| 🗄️ MySQL | Database |
| 🔌 JDBC | Database Connectivity |
| 🔐 AES-256-GCM | Encryption Algorithm |
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
│   ├── PasswordStrengthChecker.java
│   ├── CredentialDAO.java
│   └── Credential.java
│
└── lib/
    └── mysql-connector-j.jar
```

---

# 🗄️ Database Schema

```sql
CREATE TABLE credentials (
    id INT AUTO_INCREMENT PRIMARY KEY,
    site_name VARCHAR(100) NOT NULL,
    site_username VARCHAR(100) NOT NULL,
    encrypted_password TEXT NOT NULL,
    iv VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

# 🚀 Installation

### Clone Repository

```bash
git clone https://github.com/ahsanidreesnns8-ai/PasswordManager.git
```

### Open Project

Open the project in IntelliJ IDEA, Eclipse, or VS Code.

### Configure Database

Update your MySQL username and password inside:

```text
DatabaseConnection.java
```

### Create Database

Run the SQL script:

```text
sql/schema.sql
```

### Run

Execute:

```text
Main.java
```

---

# 💻 Console Menu

```text
=============================
      PASSWORD MANAGER
=============================

1. Add Password
2. Delete Password
3. Search Password
4. Edit Password
5. Exit

Choose an option:
```

---

# 🔒 Security Implementation

## 🔐 AES-256-GCM Encryption

- Encrypts every password before storing it.
- Provides confidentiality and authentication.
- Detects unauthorized modifications.

---

## 🔑 PBKDF2WithHmacSHA256

- Derives a secure encryption key.
- Makes brute-force attacks significantly harder.
- Uses password-based cryptographic key derivation.

---

## 🎲 Random IV

Every encrypted password receives a unique Initialization Vector (IV), ensuring identical passwords never produce identical ciphertext.

---

## 💪 Password Strength Checker

Passwords are evaluated based on:

- ✔ Password Length
- ✔ Uppercase Letters
- ✔ Lowercase Letters
- ✔ Numbers
- ✔ Special Characters

Ratings:

- 🟥 Weak
- 🟨 Medium
- 🟩 Strong

---

# 📸 Sample Database

The application stores encrypted credentials inside MySQL.

| ID | Site | Username | Password |
|----|------|----------|----------|
| 2 | LMS | 2025CYS112@student.uet.edu.pk | 🔒 AES Encrypted |
| 3 | Facebook | ahsanidrees10 | 🔒 AES Encrypted |

Each password is stored together with its unique IV, making every encrypted record unique and secure.

---

# 📌 Implemented Features

| Feature | Status |
|----------|--------|
| Project Setup | ✅ |
| JDBC Connection | ✅ |
| MySQL Integration | ✅ |
| AES-256-GCM Encryption | ✅ |
| PBKDF2 Key Derivation | ✅ |
| Password Strength Checker | ✅ |
| Add Password | ✅ |
| Search Password | ✅ |
| Edit Password | ✅ |
| Delete Password | ✅ |

---

# 📚 Learning Outcomes

This project demonstrates:

- ☕ Java Programming
- 🧩 Object-Oriented Programming
- 🔐 AES-256-GCM Encryption
- 🔑 PBKDF2 Key Derivation
- 🔒 Java Cryptography Architecture (JCA)
- 🗄️ MySQL Database
- 🔌 JDBC Connectivity
- 📂 DAO Design Pattern
- 🛠️ CRUD Operations

---

# 🚀 Future Improvements

- 👤 User Authentication
- 🔑 BCrypt Password Hashing
- 🎲 Random Password Generator
- 🖥️ JavaFX GUI
- ☁️ Cloud Backup
- 📱 Mobile Version
- 🔔 Password Expiry Reminder
- 🔐 Two-Factor Authentication (2FA)

---

# 👨‍💻 Author

## **M. Ahsan Idrees**

🎓 Cybersecurity Student — **University of Engineering & Technology (UET), Lahore**

### 💻 Skills

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Python](https://img.shields.io/badge/Python-3776AB?style=flat-square&logo=python&logoColor=white)
![C Sharp](https://img.shields.io/badge/C%23-68217A?style=flat-square&logo=csharp&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white)


### 🌐 Connect With Me

[![GitHub](https://img.shields.io/badge/GitHub-ahsanidreesnns8--ai-181717?style=for-the-badge&logo=github)](https://github.com/ahsanidreesnns8-ai)

[![LinkedIn](https://img.shields.io/badge/LinkedIn-M.%20Ahsan%20Idrees-0A66C2?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/m-ahsan-idrees-664126329)

---

<div align="center">

## ⭐ If you found this project helpful, consider giving it a Star ⭐ on GitHub.

### Thank you for visiting this repository! 🚀

</div>

---

# 📄 License

This project is licensed under the **MIT License**.

Feel free to use, modify, and distribute it for educational and personal learning purposes.
