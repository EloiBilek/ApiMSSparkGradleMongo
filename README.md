---
Title: ApiMSSparkGradleMongo
Description: API Microservice example using Spark, Guice, Gradle and MongDB
Author: Eloi Bilek
Tags: gradle, restful, api, java, spark, guice, mongodb
Created: 2016 Jun 6

---

# ApiMSSparkGradleMongo
==============================
API Microservice example using Spark, Guice, Gradle and MongDB

It 's a very simple example of an RestFul API Microservice, CRUD of User.
Using:
* Java 8
* Gradle 2.12
* Guice DI 4
* Spark Java 2.5
* MongoDB 3.2.4
* Eclipse Java EE IDE - Version: Mars.1 Release (4.5.1)

## Note 1!
This project was started with: New > Gradle > Project Gradle.

![init project](https://github.com/EloiBilek/eloibilek.github.io/raw/master/SGP/init_project.png)

Using the plugin (Add in Eclipse Marketplace). 

![gradle plugin](https://github.com/EloiBilek/eloibilek.github.io/raw/master/SGP/gradle_plugin.png)

To run the project, set the Project Facets in: ApiMSSparkGradleMongo > Properties > Project Facets.

![facets](https://github.com/EloiBilek/eloibilek.github.io/raw/master/SGP/facets.png)

... And add external dependencies on: ApiMSSparkGradleMongo > Properties > Deployment Assembly.

![facets](https://github.com/EloiBilek/eloibilek.github.io/raw/master/SGP/properties_deployment.png)

After importing the project to the Eclipse workspace, run build in: ApiMSSparkGradleMongo > Gradle > Refresh Gradle Project.
Or select task (assemble, build...) in Gradle Tasks perspective.

![gradle tasks](https://github.com/EloiBilek/eloibilek.github.io/raw/master/SGP/gradle_tasks.png)

The Spark is a micro web framework, with a Jetty server content embedded.

Start the project with run in main class: /ApiMSSparkGradleMongo/src/main/java/com/apimssparkgradlemongo/init/Main.java

* http://sparkjava.com
* https://github.com/google/guice

Use for request/response test, Postman of Chrome plugin...

![mssparktest](https://github.com/EloiBilek/eloibilek.github.io/raw/master/SpGM_MS/mssparktest.png)
