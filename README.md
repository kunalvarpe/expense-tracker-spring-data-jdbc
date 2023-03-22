# Expense Tracker
Expense tracker sample spring boot application

![Build Gradle](https://github.com/kunalvarpe/expense-tracker-spring-data-jdbc/workflows/Build%20Gradle/badge.svg)

This project demonstrate the expense tracker app using spring boot application and thymleaf.


## Running expense tracker locally

Expense tracker is Spring Boot application built using the Gradle. ou can build a jar file and run it from the command line (it should work just as well with Java 17 or newer):

```
git clone https://githubcom/kunalvarpe/expense-tracker-spring-data-jdbc.git
cd expense-tracker-spring-data-jdbc
./gradlew build
java -jar build/*.jar
```

You can access the application at http://localhost:8080

or you can run it from Gradle directly using gradle spring boot plugin.

```
./gradlew bootRun
```

## In case you find a bug/suggested improvement for Expense Tracker
Our issue tracker is available [here](https://github.com/kunalvarpe/expense-tracker-spring-data-jdbc/issues)

## Database Configuration

You can find docker compose file in the project which has postgresql container configured. You can up the container by executing:

```shell
docker compose up -d
```

## Working with Expense Tracker in your IDE

### Prerequisites
The following items should be installed in your system:
* Java 17 or newer (full JDK, not a JRE).
* [git command line tool](https://help.github.com/articles/set-up-git)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)
    
### Steps:

1) On the command line run:
    ```
    git clone https://github.com/kunalvarpe/expense-tracker-spring-data-jdbc.git
    ```
2) Inside IntelliJ IDEA
   In the main menu, choose `File -> Open` and select the Expense Tracker [build.gradle](build.gradle). Click on the `Open` button.

   A run configuration named `ExpenseTrackerApplication` should have been created for you if you're using a recent Ultimate version. Otherwise, run the application by right-clicking on the `ExpenseTrackerApplication` main class and choosing `Run 'ExpenseTrackerApplication'`.

3) Navigate to Expense Tracker

   Visit [http://localhost:8080](http://localhost:8080) in your browser.