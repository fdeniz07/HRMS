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

 <img src="https://github.com/fdeniz07/HRMS/blob/master/DB/Db-Schema.png" />



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


 <img src="https://github.com/fdeniz07/HRMS/blob/master/Images/Week%202.JPG" />


## SECTION 3

#### Important: These requirements are written without any backend-frontend distinction. (As in the industry). You have to code the parts required for the backend.

### Request 7: Employers should add jobs to the system.

business poster;
- The general job position should be able to be selected from the selectable list (dropdown). (For example Java Developer) (Required)
- Job description entry should be possible. (For example, we have command of languages ​​such as JAVA, C# etc....)(Required)
- City information should be automatically selected from the list. (Compulsory)
- Min-max entry must be possible for the salary scale. (Optional)
- It should be possible to enter the number of open positions. (Compulsory)
- The application deadline must be entered.

### Request 8: All active job postings in the system should be listed.

- The list should come in the form of a table.
- Company name, general job position name, number of vacant positions, publication date, and deadline information should be on the list.

### Request 9: All active job postings in the system should be listed by date.

- The list should come in the form of a table.
- Company name, general job position name, number of vacant positions, publication date, and deadline information should be on the list.

### Request 10: All active job postings of a company should be listed in the system.

- The list should come in the form of a table.
- Company name, general job position name, number of vacant positions, publication date, and deadline information should be on the list.

### Request 11: Employers should be able to close a banner in the system. (Passive posting)


## Section 4

### Request 12: Candidates should be able to enter their CV into the system.

- Candidates should be able to add their schools to the system. (School name, department)
- These schools should be able to enter the years they studied in the system.
- If he is not graduated, the graduation year should be left blank
- The schools of the candidates should be in reverse order according to the graduation year. If not graduated, this school should be displayed at the top and as "in progress".
- Candidates should be able to enter their work experience. (Business name, position)
- They should be able to enter into the system in which years they had these experiences.
- If he is still working, the year of dismissal must be missed.
- Candidates' experience should be in reverse order by year. If it is still running, this experience should still be displayed at the top and as "in progress".
- Candidates should be able to enter the foreign languages ​​they know into the system. ( Language, Level -> 1-5)
- Candidates must be able to enter photos into the system. The photograph of the candidate will be kept at https://cloudinary.com/pricing system. (External service integration) Use the free account.
- Candidates should be able to enter their github addresses into the system.
- Candidates should be able to enter their linkedin addresses into the system.
- Candidates should be able to enter the programming languages ​​or technologies they know into the system. (Programming/Technology name) For example; React
Candidates should be able to add a cover letter to the system. (For example: I like working very much....)
