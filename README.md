# Aquadine - FRONTEND INSTALLATION

To run our application the following installation is required:

* angular cli 

To install the angular cli you should do the following steps:

1. Run commandprompt
2. Copy the followin command: npm install -g @angular/cli
3. Run command in the commandprompt to install the angular cli

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 7.3.6.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

## Aquadine - BACKEND INSTALLATION

To run our application the following programs/software are required:

* [Intellij IDEA Ultimate Edition (latest version)](https://www.jetbrains.com/idea/download/#section=windows)
* [Payara 5 Glassfish Server](https://www.payara.fish/software/downloads/all-downloads/)
* Java
* [Java sdk 1.8 ](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [MySql Workbench](https://dev.mysql.com/downloads/workbench/)



After Pulling the backend zip file,front end file and the Database you should do the following steps:

1. Run intellij IDEA and open the Backend File.
2. You should now be able to browse the applications files in Intellij.
3. Before we run the server we need to configure some things.
4. First go to the datasourcedefinition.java class, in this class edit the user and password fieldn to your own mysql user en password credentials. This is very important or else the application won’t connect to the database!
5. After that go to the “configuration” button left above in Intellij. A window will popup.
6. In this window click on the plus icon and a list of applications will open up. Scroll down and click om 34more. In this list we are looking for “Glassfish” server.
7. After clicking on glassfish server click on local host. This will open up a new window. In the application server menu above you need to give the application the location of the Payara 5 folder. Then you need to select java 1.8 jdk down below. Type domain1 in the domain field. After that go to the deployment window above. There will be an empty field and you need to click on the plus icon.
8. When you click on the plus icon a new window will popup with select deployment and you need to select aquadinePU.war
9. When you’ve completer all these steps click on Apply and Okay.
10. You’ve now setup the backend server.
11. Navigate to mysql workbench application. 
12. Login with you user and password(Like in step 4).
13. Create a new database and name it aquadis. 
14. After that run the aquadis.sql file. This will fill the database with data.
15. Go to Intellij IDEA and press the green play button “Run”. This will start the server. After a couple seconds your browser will open up with a page.
16. The backend is running!
17. Start the frontend (Check other readme)
18. You can now start using Aquadine

IMPORTANT!
Keep mysqlworkbench running and Intellij(back-end) Running while using aquadine.
