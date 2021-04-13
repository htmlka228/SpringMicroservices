# SpringMicroservices
Demo Spring Boot microservices

How start this applications:
  1. Create git config repository, example here https://github.com/htmlka228/microservices-config-repo
  2. If need be, change application.properties in git config
  3. If you will use my configuration then run postgres and zipkin server (i'm using docker containers)
  4. Create database, table is creating at startup applications
  5. Run application in this order: Spring Cloud config, Eureka server, 3 microservices, API Getaway and Hystrix dashboard.
  6. Stop applications and fill database. CSV file is located in this repository (if csv file is not reading, then just copy data in the table, i did this in database in the InteliJ Idea)
  7. Run applications as in paragraph 5
  8. Rejoice)
  
