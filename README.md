# java-cucumber-example

A sample project for Cucumber and/or Selenium tests.

Language and tools used
- Cucumber
- Java
- Selenium 
- Junit
- Maven
 
## Prerequisites

- Java instlalled
- Java home variable configured(https://www.baeldung.com/java-home-on-windows-mac-os-x-linux)	
- Maven installed
- Maven home variable configured


In order to run browser tests, Selenium will need to be able to drive a browser
installed to your system.
 
 

## Use Maven

Open a command window and run:

    mvn clean test

This runs Cucumber features using Cucumber's JUnit runner. The `@RunWith(Cucumber.class)` annotation on the `CucumberRunner`
class tells JUnit to kick off Cucumber.
 
 