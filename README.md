Questions!
Can you explain why you came to this file first?
Can you explain why you did not?
Can you explain the basic structure of the project without reading this file? What are your expectations?
Can you explain what the root level files might be for?


# Caesars Digital Java Technical Test

This is the base technical test for use by the technical team to validate your experience in java.

On the day of the technical interview, we will be asking you to finish the tests in this framework.

Please feel free to adjust this framework, but this is not required.

## Packages you might want to get familiar with
- [RestAssured](https://rest-assured.io/) Used for Api Requests
- [Cucumber](https://cucumber.io/docs/bdd/) The format our tests are written in
- [Selenium](https://www.selenium.dev/documentation/) Used for UI automation


## Installation

**When attempting to import this project make sure you are using JAVA 8**

Import this project into your choice of IDE as a Maven project. This is required for it to grab its required dependencies.

This should pull in the dependencies but if this does not work for any reason, you can use maven command line to install them.


```bash
mvn clean install
```
This does require you to have maven installed on your file path though. A way around this is to use [IntelliJ](https://www.jetbrains.com/idea/) which comes bundled with maven. You will only require the free Community version.

## Usage

To either execute UI or API test cases use  **UiRunner** or **ApiRunner** classes.
Examples:

```bash
mvn clean test -Dtest=com.caesars.us.api.runner.ApiTestRunner
```

```bash
mvn clean test -Dtest=com.caesars.us.ui.runner.UiTestRunner
```
