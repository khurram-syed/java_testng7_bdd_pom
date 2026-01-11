# HerokuApp UI Automation – Selenium + Cucumber + TestNG

## PROJECT CONFIGURATION

This project demonstrates a clean, scalable **BDD-based UI test automation framework**
using **Java, Maven, Selenium WebDriver, Cucumber, TestNG**, and **WebDriverManager**.

The framework supports:
- Multiple browsers (Chrome, Firefox, Edge, Safari)
- Tag-based execution
- Clean driver lifecycle management
- Page Object Model (POM)
- Command-line and IDE execution

---

## TECHNOLOGY STACK

- Java 21
- Maven
- Selenium WebDriver
- Cucumber JVM
- TestNG
- WebDriverManager (automatic browser driver management)
- HTML reporting

---

## PROJECT STRUCTURE

```text
herokuapp-test-suite
│
├── src
│   ├── main
│   │   └── java
│   │       └── (reserved for application code if needed)
│   │
│   └── test
│       ├── java
│       │   ├── driver
│       │   │   └── DriverManager.java
│       │   │
│       │   ├── hooks
│       │   │   └── Hooks.java
│       │   │
│       │   ├── pages
│       │   │   ├── LoginPage.java
│       │   │   └── SecurePage.java
│       │   │
│       │   ├── runners
│       │   │   └── TestRunner.java
│       │   │
│       │   └── steps
│       │       ├── ABTestingSteps.java
│       │       └── FormAuthSteps.java
│       │
│       └── resources
│           ├── features
│           │   ├── ab_testing.feature
│           │   └── form_auth.feature
│           │
│           └── testng.xml
│
├── reports
│   └── cucumber-html-reports
│       └── report.html
│
├── target
│
├── pom.xml
└── README.md
```
-----
## DRIVER MANAGEMENT

- Browser drivers are **not stored in the repository**
- **WebDriverManager** automatically:
    - Detects installed browser versions
    - Downloads compatible driver binaries
    - Caches drivers locally for reuse
- Thread-safe driver handling is implemented using `ThreadLocal`

### Supported Browsers
- Chrome (default)
- Firefox
- Edge
- Safari (macOS only)

---

## RUN OPTIONS

### Run from Command Line (Default – Chrome)

```bash
mvn clean test
```
### Run with Specific Browser

```bash
mvn clean test -Dbrowser=chrome
mvn clean test -Dbrowser=firefox
mvn clean test -Dbrowser=edge
mvn clean test -Dbrowser=safari
```
### TAG-BASED EXECUTION

```bash
mvn clean test -Dcucumber.filter.tags="@smoke"
mvn clean test -Dcucumber.filter.tags="@smoke or @sanity"
mvn clean test -Dcucumber.filter.tags="not @wip"
```
### RUN FROM INTELLIJ IDEA

1. Open the project in **IntelliJ IDEA**
2. Navigate to:

```text
src/test/java/runners/TestRunner.java
```
3. Right-click → Run

Or

Right-click any .feature file -> Select Run Feature

---
## REPORTING
- Generated automatically after test execution
- Report location:
```text
reports/cucumber-html-reports/index.html
```
---

### FRAMEWORK DESIGN PRINCIPLES

- BDD for readable and maintainable test scenarios
- Page Object Model (POM) for UI abstraction
- Single DriverManager for browser lifecycle control
- Thread-safe execution using ThreadLocal
- No hard-coded browser drivers or versions
- Clean separation of concerns across framework layers


