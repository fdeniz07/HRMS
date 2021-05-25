# Human Resource Management System ( HRMS )

<br/>

## The following tools / languages will be used in this project;

### Java (Spring Boot based) - on the Backend side - [Main Directory](https://github.com/fdeniz07/HRMS/tree/master/hrms/src/main/java/kodlamaio/hrms) 
### React - on the Frontend side
### Postgresql - on the Database side

<br/>

## Also, they will be included in this project;

### * SOLID architecture 
### * DesignPatterns
### * NLayered Architecture

### * Dependencies:
- Spring Boot DevTools
- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Lombok

## Summary :
Coming soon!

## SECTION 1
Our system has three basic types of users. System staff, Job Seekers and Employers.
System staff: People working on your project. For example Kariyer.Net staff.


### Request 1: Job Seekers must be able to register in the system.

#### Accept conditions:
During registration, the user is asked for name, surname, tcno, year of birth, e-mail, password, password repetition information.
All fields are required. The user is informed.
Registration to the system is made by Mernis verification.
If the verification is not valid, the user is notified.
If there is a previously registered e-mail or tcno, no registration will take place. The user is informed.
Email verification is required for registration to occur.

### Request 2: Employers should be able to register in the system.

#### Accept conditions:
During registration, the user is asked for company name, website, e-mail with the same domain as the website, phone, password, password repeat information. The aim here is to prevent non-companies from joining the system.
All fields are required. The user is informed.
Company records are verified in two ways. Email verification is required for registration to occur. Approval of HRMS staff is required.
If there is a registered e-mail before, registration will not take place. The user is informed.

### Request 3: General job position names should be able to be added to the system. For example Software Developer, Software Architect.

#### Accept conditions:
These positions cannot be repeated. The user is warned.


### ---------------------------------------------------------------

## DATABASE (DB)

### DB - SCHEMA

![HRMS SCHEMA in PostgreSql](https://user-images.githubusercontent.com/81612480/119411476-c8abbf00-bcea-11eb-8a73-81485292509d.jpg)


![DB_Schema pgerd](https://user-images.githubusercontent.com/81612480/119411373-9d28d480-bcea-11eb-8cb3-57de95a0dc16.png)

### DB - SCRIPT CODE

### <a href="DbSchema_Script.sql">Click</a> for script codes.



## SECTION 2

#### IMPORTANT 1: Create fake services for verification. For example, you don't really need to send mail.

#### IMPORTANT 2: Do not code beyond the requirements. This is a software developer behavior against Project management and ALM (Application LifeCycle Management) rules.



#### Request 1: Job Seekers must be able to register in the system.

#### Accept conditions:
During registration, the user is asked for name, surname, tcno, year of birth, e-mail, password, password repetition information.
All fields are required. The user is informed.
Registration to the system is made by making Mernis verification.
If the verification is not valid, the user is notified.
If there is a previously registered e-mail or tcno, no registration will take place. The user is informed.
Email verification is required for registration to occur.

### Request 2: Employers should be able to register in the system.

#### Accept conditions:
During registration, the user is asked for company name, website, e-mail with the same domain as the website, phone, password, password repeat information. The aim here is to prevent non-companies from joining the system.
All fields are required. The user is informed.
Company records are verified in two ways. Email verification is required for registration to occur. Approval of HRMS staff is required.
If there is a registered e-mail before, registration will not take place. The user is informed.

### Request 3: General job position names should be able to be added to the system. For example Software Developer, Software Architect.

#### Accept conditions:
These positions cannot be repeated. The user is warned.

### Request 4: Employers should be able to be listed. (Entire list only)

### Request 5: Job seekers should be able to be listed. (Entire list only)

### Request 6: Job positions should be able to be listed. (Entire list only)

