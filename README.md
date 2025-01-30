# SauceE2E - Web Automation Framework

## 📌 Overview
**SauceE2E** is a **Selenium WebDriver** automation framework built using **Java, TestNG, and the Page Object Model (POM)**.  
It supports **Allure Reporting** and integrates seamlessly with **Jenkins for CI/CD**.

---

## 📂 Project Structure
```
SauceE2E/
│-- src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/                 # Base classes (BaseTest)
│   │   │   ├── pages/                # Page Object Model classes
│   │   │   ├── utils/                # Common utilities (DriverManager, ConfigReader)
│   │   │   ├── config/               # Configuration handlers
│   │   ├── resources/
│   │       ├── config/               # YAML config files (environment.yaml)
│   ├── test/
│       ├── java/
│       │   ├── tests/                # Test classes (LoginTest, etc.)
│       ├── resources/
│-- pom.xml                           # Project dependencies & plugins
│-- testng.xml                         # TestNG execution file
│-- allure-results/                    # Allure reports output
│-- README.md                          # Documentation
```

---

## 🛠️ Installation & Setup
### **1️⃣ Prerequisites**
Ensure the following are installed on your system:
- **Java 17+** → Run `java -version`
- **Maven 3.6+** → Run `mvn -version`
- **Allure CLI** → Run `allure --version`
- **Google Chrome & ChromeDriver** (for Selenium)

---

### **2️⃣ Clone the Repository**
```sh
git clone https://github.com/iamrishab2701/SauceE2E.git
cd SauceE2E
```

---

### **3️⃣ Install Dependencies**
Run the following command to download the required dependencies:
```sh
mvn clean install
```

---

## 🏃 **Running Tests**
### **1️⃣ Run All Test Cases**
```sh
mvn test
```

### **2️⃣ Run Specific Test**
```sh
mvn test -Dtest=LoginTest
```

### **3️⃣ Run Tests with TestNG XML**
```sh
mvn test -Dsurefire.suiteXmlFiles=testng.xml
```

---

## 📊 **Generating Allure Reports**
### **1️⃣ Generate Report**
After test execution:
```sh
allure generate --clean allure-results -o allure-report
```

### **2️⃣ Serve Report Locally**
```sh
allure serve allure-results
```

### **3️⃣ Open Report Manually**
If `allure serve` doesn’t work, open it manually:
```sh
open allure-report/index.html
```

---

## 🔄 **Jenkins Integration**
### **1️⃣ Install Jenkins**
```sh
brew install jenkins-lts
brew services start jenkins-lts
```
Access Jenkins at: [http://localhost:8080](http://localhost:8080)

---

### **2️⃣ Set Up Jenkins Job**
1. **Create a New Freestyle Job**
2. **Source Code Management** → Add your GitHub repo
3. **Build Triggers** → Select "Poll SCM" (`H/5 * * * *`)
4. **Build Steps** → Add `Invoke top-level Maven targets`
   - **Goals**: `clean test`
5. **Post-Build Actions** → **Add "Allure Report"**
   - **Path**: `allure-results`
6. **Click "Save" and "Build Now"**

---

## 🔧 **Troubleshooting**
### **1️⃣ Maven Not Found in Jenkins**
If Jenkins cannot find Maven, add this manually:
```sh
echo 'export PATH="/usr/local/bin:$PATH"' >> ~/.zshrc
source ~/.zshrc
```
Then, restart Jenkins:
```sh
brew services restart jenkins-lts
```

### **2️⃣ Allure Report Not Found in Jenkins**
- Go to **Manage Jenkins → Global Tool Configuration**
- Scroll to **Allure Commandline**
- Set the path:  
  ```
  /usr/local/bin/allure
  ```
- Restart Jenkins and try again.

---

## 💛 **Contributing**
1. **Fork the repo**
2. **Create a new branch**
3. **Make your changes**
4. **Submit a Pull Request**

---

## 📝 **License**
This project is licensed under the **MIT License**.

---

🚀 **Happy Testing!** 🎯