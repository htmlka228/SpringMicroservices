# SpringMicroservices
Demo Spring Boot microservices application

How to run this system:
  1. Create git config repository, the example for this project here: https://github.com/htmlka228/microservices-config-repo
  2. If you need to change anything in the remote config, make that in the application.properties file in the remote config
  3. If you will use my remote config, you should prepare postgres and zipkin server (i'm using docker containers)
  4. Create database, table is creating at startup applications
  5. Run application in this order: Spring Cloud config, Eureka server, 3 microservices, API Getaway and Hystrix dashboard.
  6. Stop applications and fill database.
  7. Run applications as in paragraph 5
  8. Rejoice)
  
