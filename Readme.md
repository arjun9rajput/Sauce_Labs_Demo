# Swag Labs Test Automation Project

This project is a test automation suite for the Swag Labs application. It uses Cucumber for behavior-driven development (BDD) and JUnit for running tests. Allure is used for generating detailed test reports.

## Table of Contents
1. [Project Structure](#project-structure)
2. [Prerequisites](#prerequisites)
3. [Setup](#setup)
4. [Running Tests](#running-tests)
5. [Generating Cucumber Reports](#generating-cucumber-reports)
6. [Generating Allure Reports](#generating-allure-reports)

## Project Structure

```
src
├── main
│   └── java
│       └── BaseTest
│           └── BaseClass
│       └── Helpers        
│       └── pageObjects            
└── test
    └── java
        └── features
            └── CheckoutFlowTests.feature
        └── runner
            └── TestRunner.java
        
       └── stepdefinitions
              
pom.xml
```


## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven 3.6.3 or higher
- Allure Commandline (for generating Allure reports)

## Setup

1. **Clone the Repository**
   ```sh
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Install Dependencies**
   Ensure that all necessary dependencies are downloaded.
   ```sh
   mvn clean install
   ```

## Running Tests

To run the Cucumber tests, use the following command:
```sh
mvn test
```

## Generating Cucumber Reports

Cucumber generates a default HTML report after running the tests. The report can be found at `target/cucumber-reports.html`.

To view the Cucumber report, open the following file in a web browser:
```sh
target/cucumber-reports.html
```

## Generating Allure Reports

To generate Allure reports, follow these steps:

1. **Run Tests**
   Ensure that your tests have been executed and Allure results have been generated in the `target/allure-results` directory.

2. **Install Allure Commandline**
   If you haven't installed Allure commandline, follow the installation instructions from the [Allure documentation](https://docs.qameta.io/allure/#_installing_a_commandline).

3. **Generate and Serve Allure Report**
   Use the following command to generate and serve the Allure report:
   ```sh
   allure serve target/allure-results
   ```

   This command will generate the Allure report and automatically open it in your default web browser.

## Example Feature File (`example.feature`)

```gherkin
Feature: Swag Labs Inventory Scenarios assignment

  Scenario : Login Swag Labs and select Inventory
    Given I am on Swag Labs Login Page
    When I enter username as "standard_user" and password as "secret_sauce"
    And I click Login Button

```

## Example Step Definition (`ExampleSteps.java`)

```java
public class AddressPageStepDef extends BaseClass{
    AddressPage addressPage=new AddressPage(driver);

    @Then("I should see the address page")
    public void verifyAddressPage() {
        Assert.assertEquals(addressPage.getAddressPageTitle(),"Checkout: Your Information");
    }

    @Then("I enter {string} as first name")
    public void enterFirstName(String firstName) {
        addressPage.enterFirstName(firstName);
    }

    @Then("I enter {string} as last name")
    public void enterLastName(String lastName) {
        addressPage.enterLastName(lastName);
    }

    @Then("I enter {string} as zipcode")
    public void enterZipcode(String zipcode) {
        addressPage.enterZipcode(zipcode);
    }

    @Then("I click on continue button")
    public void clickContinue() {
        addressPage.clickContinue();
    }
}
```

## Test Runner Configuration (`RunCucumberTest.java`)

```java
package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/java/features/CheckoutFlowTests.feature",
        glue = {"StepDefs"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt",
                "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"
        },
        monochrome = true,
        dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

```

By following the instructions in this README, you will be able to set up, run tests, and generate both Cucumber and Allure reports for the Swag Labs test automation project.

Conclusion
This project demonstrates how to automate testing of the Swag Labs application using Cucumber for BDD and Allure for reporting. By following the steps in this documentation, you can set up, run tests, and generate reports to ensure the application functions correctly.