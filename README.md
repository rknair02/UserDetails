                            Spring Rest API + CRUD Operation – Read Me

This project is a proof of concept (POC).
It's purpose is to demonstrate an implementation of a springboot REST API using H2 as a database.

Dependencies:
a.	spring-boot starter
b.	spring-boot starter web
c.	spring JPA
d.	H2 database (embedded)
e.	log4j for logging
Packages defined
1.	com.abn
UserDetailsApplication .java - 
 spring starter application
2.	com.abn.db.entity 
		person.java ->   Definition of the entity class 
3.	com.abn.db.springDataRepository
PersonSpringDataRepository -> extend the JpaRepository class ( this makes all the basic CURD operations avaliable)
4.	com.abn.error
		CustomGlobalExceptionHandler,DateNotValidException,EmailNotvalidException,
PersonNotFoundException 
		-> custom exceptions created.
5.	com.abn.controller
		UserController -> api controller class for the managing the curd operations


The embedded apache tomcat server and H2 database has been used since the application is small and there is a requirement for usage of embedded database.
		
		
