# AUTOMATION TESTING - JAVA

System Under Test:
1. Website
2. API

Features:
1. REST API using rest-assured
2. Junit
2. Selenium for Website
4. Cucumber

## Prerequisites
* [JDK 11](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A)
* [Git](https://git-scm.com/downloads)
* [Intellij IDEA](https://www.jetbrains.com/idea/download/)
* [Gradle](https://gradle.org/install/)
* [Appium Desktop](https://github.com/appium/appium-desktop)
* [Chromedriver](https://formulae.brew.sh/cask/chromedriver)
* [Chrome Browser](https://www.google.com/chrome/)
* [Geckodriver](https://formulae.brew.sh/formula/geckodriver)
* [Firefox Browser](https://www.mozilla.org/en-US/firefox/new/)

## Getting started
1. Clone the repository

## Cucumber for Java
Add IntelliJ Cucumber for Java plugin:

* Open `Preferences` (⌘ + ,)
* Go to `Plugins > Marketplace`
* Search for `Cucumber for Java` and Install

## Running the Test
* To execute API Test cases
  > ./gradlew clean test --tests test.bukalapak.rest.Posts

* To execute Website Test cases
  > ./gradlew clean cucumber --tags @Web generateCucumberReports

## Report
* Find the reporting file on `build/customreport/overview-features.html`
* Open the reporting file in browser