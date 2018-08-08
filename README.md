# OVERVIEW OF THE MARKETING-APP :

**The code targets Java 8. I have used Maven to help with dependency management and running the application/tests.**

## ASSUMPTIONS:
- VendorAccount: Only one account exists for a company. Company_Name is mandatory.
- VendorContact: Name,Email_Address are mandatory as it is the minimum information required to contact the VendorContact.
- Docker file : 
- Unit tests are not handling null,blank values of required fields on the JSON models, as the jackson annotations are taking care of it when request is recieved.

## DESCRIPTION OF MODEL:

- MarketingAccountService - it is service interface for the Account.
- MarketingContactService - it is service interface for the Contact.
- MarketingAccountServiceImpl and MarketingContactServiceImpl - these perform the business logic and persists the   VendorAccount,VendorContact entities respectively to backing store..

- VendorAccountDAO, VendorContactDAO - these are DAO interfaces.
- VendorAccountDAOImpl, VendorContactDAOImpl - it is an in memory database (using H2 DB). Used Spring-Boot's CrudRepository to perform CRUD operations.

- AccountController - it is wrapper around MarketingAccountService business logic and exposes the RESTful interface for Account.
- ContactController - it is wrapper around MarketingContactService business logic and exposes the RESTful interface for Contact.

### JSON MODELS:
 - Account : is the request/response JSON model for the Account.
 - Contact : is the request/response JSON model for the Contact. 

### DATABASE MODELS:
- classes represent the VendorAccount/VendorContact in the application.
- the database models are generated based on the requirements provided in the URL
_https://bitbucket.org/dcor_atlassian/atlassian-code-exercise-sr-full-stack-dev-martech/src/master/_
- Table : Vendor_Account, Model : VendorAccount
- Table : Vendor_Contact, Model : VendorContact
- Table : Account_Contact, Model: Created by the hibernate based on the definition of the "VendorAccount" model


## DESCRIPTION OF MAIN TEST CLASSES:

**AccountControllerTest,ContactControllerTest - tests the Spring-Boot REST controller** <br/>
**MarketingAccountServiceTest  - tests the MarketingAccountService.** <br/>
**MarketingContactServiceTest  - tests the MarketingContactService.** <br/>


## HOW TO SETUP THE APPLICATION:

1. Go to the project directory:

**cd marketing-app**

2. To compile/test, run : **"mvn clean test"**

3. To run the application, run : **"mvn spring-boot:run"** and use POSTMAN collection provided to make GET/POST/PUT/DELETE requests by changing the requests accordingly.

 
4. To run unit tests, run: **"mvn test"**

5. The jar has already been built (target/marketing-app-0.0.1-SNAPSHOT.jar). **If you want to rebuild the jar, run: "mvn clean install"**

6. _H2 DB: The H2 Database can be accessed at "http://localhost:8761/h2/" once the application has started and click connect._

7. Make sure database connection URL is **"jdbc:h2:mem:sandeep_muddam"**.

## PRE-REQUISITES FOR THE DEPLOYMENT OF THE MARKETING-APP in AWS:
- Network diagram has to be prepared showing the traffic flow, once it is approved VPC is assigned.
- Security Groups and Subnets have to be defined for inter-modular and external module communications.
- Write the DockerFile to define how the image has to be built.
- CloudFormation Templates can be used to define the configuration of ECS/EC2.
- Task Definitions have to be written for ECS.
- Configure RDS/AWS Dynamo DB based on the requirements
- Configure Log Groups and ElasticSearch
- Configure SNS for alert notifications
- Configure Lambda functions if required
