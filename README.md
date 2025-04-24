# Newspapers.com-Automation

This project contains an automation suite for searching and viewing articles on Newspapers.com via the “Topics” workflow. This is still a work in project and more features and workflow will be added soon. 

- **Framework:** Selenium WebDriver + TestNG  
- **Parallel Execution:** Tests run concurrently in both Chrome and Edge browsers to speed up test cycles.  
- **BDD Style:** Uses Gherkin syntax with Cucumber for readable feature files and step definitions.
- **Page Object Model (POM):** Clean separation of test logic and page interactions.
- **Test Execution:** Managed with TestNG, including parallel testing.


## Setup
1. Clone the repo:  
   ```bash
   git clone https://github.com/jofel06/Newspapers.com-Automation
   cd Newspapers.com-Automation

2. Install Dependencies:
    ```bash
    mvn clean install

## Run Test
1. Specific feature file:
    ```bash
    mvn test "-Dsurefire.suiteXmlFiles=src/test/resources/testng_suites/searchByTopic.xml"
