# Socionity-Internship-Assignment-Backend

# Start the project from Scratch
Go to https://start.spring.io/  generate, extract the downloaded zip file and import it into Eclipse. <br/>

Your installed JDK should be at least Java8 Version and establish database connection on eclipse. <br/>

Go to pom.xml and add all required dependencies.

# Modify these according to your database credential
Go to application.properties file
###### MYSQL settings
spring.datasource.url=jdbc:mysql://localhost:3306/database_name <br/>
spring.datasource.username=root <br/>
spring.datasource.password=abcdef
###### Oracle settings
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe <br/>
spring.datasource.username=system <br/>
spring.datasource.password=oracle
###### Tomcat Server
Default server port used by tomcat is 8080 <br/>
I have manually set the server port in the application.properties file- server.port=8060

# Using Postman to validate REST API URL

###### Note:- REST API part is on process
All Usernames:- GET Mapping http://localhost:8060/socionity/users <br/>
Add User:- POST Mapping http://localhost:8060/socionity/user <br/>
Login Validation:- GET Mapping http://localhost:8060/socionity/user/${username}/${password} <br/>
Get User:- GET Mapping http://localhost:8060/socionity/user/${username} <br/>
Update User Detail:- PUT Mapping http://localhost:8060/socionity/user/profile/${username} <br/>
Update User Password:- PUT Mapping http://localhost:8060/socionity/user/password/${username} <br/>
Delete User:- Delete Mapping http://localhost:8060/socionity/user/${username} <br/>

# Logging using Log4j
I have provided logging logic in LoggingExpect.java class i.e followed the Spring AOP concept for all the methods of DAO and Service class after throwing an exception on error level. <br/>

If you want to get the log details into a file then create a folder(named as logs) and add a file(error.log) into that folder and define the path of this log file in the application.properties file- logging.file=logs/error.log
