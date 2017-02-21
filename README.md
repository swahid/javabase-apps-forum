# javabase-apps-forum
Online Forum Posting Sample.

This is sample project use Java, Spring MVC, Spring security and  Hibernate and mysql connectivity.

This is assignment project for an Software Company.
	
#Use Tools:
  1. Spring web 4.0.2 Realese
  2. Spring Security 4.0.2 Realese
  3. Hibernate 
  5. Mysql 5.1.35
  6. jquery 3.1.1
  7. bootstrap 3.3.7
  8. thymeleaf Template Engine
  
#Developer: 
  Saurav Wahid <saurav1161@gmail.com>
  
#SQL Dump Location:
    classpath:resources/META_INF/sql_dump/saurav_test_dump_.sql
    
#Run Instruction: 
    1. Clone Project
    2. Create Mysql Schema 'forum'
    3. Impost sql dump From resource location.
    4. changes Following database configuration propertise file 
        resources/META_INF/propertise/database.propertise
        a. database.url
        b.database.root
        c.database.password
        d. hibernate.hbm2ddl.auto = create (If database not properly import)
    5. Build with Maven 'mvn clean install'
    6. maven update force project (only if import on eclipse)
    7. Run on Tomcat Server
    `localhost:8080/forum`
    
#Project Demo : 
    http://forum-javabase.rhcloud.com/

    
#Note: 
    if `hibernate.hbm2ddl.auto=create` only from First run. after successfull run please change this propertise `hibernate.hbm2ddl.auto=update` From Next Run. 
    `hibernate.hbm2ddl.auto =create` everytime create database and drop exsiting table and value.
    
    This is open source project @copyright 2017 saurav.
    
    
    
