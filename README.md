# QANTAS DEMO
    * Github URL : https://github.com/rommelchua/qantasDemo

## Overview
This is a sample microservice built with Dropwizard using Jersey client to pull data from Qantas webservice


## HOW TO RUN:
1) Building project with maven will create a snapshot jar file in the target folder with all the required libraries inside the jar.
2) Inside the target folder, there will also be a copy of int.yaml.
3) Go to folder where file was created (target) and run: java -jar qantas-0.0.1-SNAPSHOT.jar server int.yaml
4) To call the microservice, go to the sample url: http://localhost:8080/airports?countryCode=AU&airportCode=BNE&isInternational=true&isRegional=false
5) Note that countryCode, airportCode, isInternational, isRegional query params are all optional
6) Providing queryParams without any value will make the program ignore said query params
7) Any non empty isInternational and isRegional value that is neither true or false will be treated as false


## More sample urls:
http://localhost:8080/airports?countryCode=AU&airportCode=BNE&isInternational=true&isRegional=false
http://localhost:8080/airports?countryCode=AU&airportCode=CAZ&isInternational=false&isRegional=true
http://localhost:8080/airports?countryCode=CH&isInternational=true&isRegional=false
http://localhost:8080/airports
