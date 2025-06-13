# dtxplusAssignment

This project contains automated test scripts for validating key functionalities of the DTXPlus application. The automation is developed using Java, TestNG, and Selenium, and is structured for modular, maintainable testing.

---

## 🛠 Setup Instructions & Dependencies

### ✅ Prerequisites

- Java JDK 8 or above
- Maven
- Eclipse or IntelliJ IDE
- Git
- Chrome Browser
- ChromeDriver (compatible version)

### 📦 Project Dependencies

The project uses Maven for dependency management. Key libraries include:

- **Selenium WebDriver**
- **TestNG**
- **Apache POI** (if data-driven testing is included)
- **Extent Reports** (for reporting)

All dependencies are handled via Maven.  
Make sure you have Maven installed. Then, from your project root directory,
To install dependencies, simply run:

```bash
mvn clean install
===============================================================================
# dtxplusAssignment Automation Framework

This repository contains an automated test framework developed for the dtxplusAssignment project using Java, Selenium WebDriver, TestNG, and Maven.

## 📂 Directory Structure
dtxplusAssignment/
│
├── src/
│ ├── main/
│ │ └── java/
│ │ ├── Abstractcomponent/
│ │ │ └── abstractComponentMethods.java
│ │ └── pageObject/
│ │ ├── AddPatient.java
│ │ ├── DashboardPage.java
│ │ └── LoginPage.java
│ ├── main/resources/
│ │
│ └── test/
│ └── java/
│ ├── testCases/
│ │ ├── addPatient.java
│ │ ├── dashboardTestcases.java
│ │ └── loginPageTestcases.java
│ └── testComponents/
│ └── baseClass.java
│
├── src/test/resources/
├── target/
├── test-output/
├── pom.xml
└── README.md



