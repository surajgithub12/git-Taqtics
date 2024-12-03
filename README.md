# Landmark Website and API Automation Tests

This repository contains Selenium/TestNG automation tests for the Landmark website (https://landmark.taqtics.co) and its authentication API.
Login Credentials:
User: intern@taqtics.co
Password: TestIntern@123

## Setup

1. **Java JDK:** Install a Java Development Kit (JDK) and the JRE System Library is a library that allows Java to function on the system it's being used on.
2. **Selenium Library:** Add Reference library jar files for functioning of webdriver and web element
3. **Selenium WebDriver:** Add Selenium dependencies/ Libraries to Taqtics project
4. **TestNG:** Add TestNG dependencies to Taqtics project which will act as a framework and also create html report.
5. **ChromeDriver:** Download ChromeDriver and update the path in the `InitializeBrowser()` method.

6. **Apache HttpClient:** Add the `httpclient` dependency to your `pom.xml`.
7. **JSON library:** Add a JSON library (e.g., `org.json`) to your `pom.xml`.

## Running the Tests

1. Locate the webelements using Xpath locator. 
2. Compile the code using TestNG framework and TestNG annotation ( @BeforeMethod, @Test, @AfterMethod)
3. Use Implicit wait to match the Selenium Testscript speed with Browser speed.
4. I have used assertions to make your tests robust and reliable.
5. Run the TestNG suite using your IDE or the command line.
6. The TestNG HTML report will be generated in the `test-output` directory.

## Approach   

The tests use Selenium to automate browser interactions for website login scenarios. The API tests use Apache HttpClient to make requests to the `/generateAuthToken` endpoint and verify the responses.  
TestNG is used for test management and reporting.
