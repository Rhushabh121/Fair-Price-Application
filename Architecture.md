# **Multitier architecture** 

#### Diagram: Iteration 1 



![title](Images/Architecture.jpeg)

## **Presentation/Interface Layer**

##### MainActivity

The main page of the application which containslist of the posts.

##### NewPostActivity 

The new post activity will let user allows the add their post.

##### ListAdapter

This class is for maintining the list items.

##### Welcome

The landing page for the user onces he logs in to the profile or registers his profile for the first time.  

##### Register

The sign up page  to register a new user.

##### Login

The Login page for User to login to his profile.

##### HomepageActivity 

The main page for the application where user can go to different pages directly with click of a button. 

##### Categories

This class where user can find the posts according to their cagegories, it is kind of like advance search feature.

##### Description 

Description view page for the product that shows further information of the item.

##### Payment

A dialogue format box that acts as a dummy payment page for user to enter the details of their card. 

##### Report

This class mainly shows the policy of app for reporting , not actually a report.  

##### Report Page
  
Main report page where users will select options for reporting a listing


## **Business/Logic Layer**

##### AccessPosts 

From this class the access of the database is done, this will access the Post object data from the database

##### AccessPU 

From this class the access of the database is done, this will access the PU object data from  the database

##### AccessUsers 

From this class the access of the database is done, this will access the User object data from the database

##### Main 

This class gives database part to all other classes.

##### Services

This class gets persistence of all the object classes. 

## **Persistence**

##### PostPersistenceHSQLDB

This class implements the interface of the PostPersistence and connects to the database

##### PUPersistenceHSQLDB

This class implements the interface of the PUPersistence and connects to the database

##### UserPersistenceHSQLDB

This class implements the interface of the UserPersistence and connects to the database

## **Domain Objects**

##### Posts

The class is for object of post, it will be needed when adding a post in the list.

##### User 

The class is User object it will be needed while saving a user in the database.

##### PU

This class is a PostUser object it deals with pirticular user and their posts. this will be in iteration 3
