# Test Plan
 ### Content
  1. [Introduction](#1)
  2. [Test object](#2)
  3. [Risks](#3)
  4. [Aspects](#4)
  5. [Approaches](#5)
  6. [Results](#6)
  7. [Conclusion](#7)

<a name="1"></a>
 ## 1. Introduction
The plan is how we are going to test the web-application "Time Manager"

<a name="2"></a>
 ## 2. Test object
### 1. Functional adequacy:
-   #### Сomprehensiveness.
    The functions of the "Time Manager" have to realize its full potential.
-   #### Correctness.
    The application, especially its functions, have to work correctly.
-   #### Reasonability.
    Every function in the "Time Manager" has to have a reason to be here.

<a name="3"></a>
## 3. Risks
- If we do not have an Internet connection, we are not able to use the application.

<a name="4"></a>
## 4. Aspects
##### The list of function which we are testing:
1. Sign up
2. Sign in
3. Sign out
4. Add a task
5. Delete a task
6. Edit a task
7. Hash a password

### Functional requirements
#### 1. Sign up
We have to test this one before to start using the main functions of the application. User has to fill some fields in, if all of them are correct, he is able to get inside.
#### 2. Sign in
This function we are testing to understand is that possible to separate authorized and anonymous users. Each of the groups of people has their own opportunities.
#### 3. Sign out
Sign out has almost the same reason as Sign In.
#### 4. Add a task
We need to make sure a user is able to fill his information in,  he is able to upload the task to the task table.
#### 5. Delete a task
A user has to be able to delete a task: chooses the one, clicks on the "delete" button, the task disappears.
#### 6. Edit a task
An authorized user has to have a chance to edit a task: he chooses the task, click on the "edit" button, add task's window opens and he can edit the task.
#### 7. Hash a password
One of the important things is data security. We are testing that to find out the data of all users are keeping in a secure way. After a user puts his data in the fields and presses the "Sign Up" button, his password and his id are encrypting by the system secure.

### Nonfunctional requirements:
#### 1. Intuitive interface
The application must have "Help" option, despite it, a user has to understand easily what he needs to do to get an expecting result.

#### 2. Performance
There should be no delays.

<a name="5"></a>
## 5. Approaches
To test the application we need to write manually some requests. 

<a name="6"></a>
## 6. Results
[Test result](https://github.com/BoryaD/PacMan/blob/master/Testing/Test%20results.md).

<a name="7"></a>
## 7. Conclusion
Using the test, you have good chances to find out the application works well or not.

    
