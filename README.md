## Project Scope
A REST API Microservices application created using Spring Boot framework in Java, implementing CRUD functionality to store, read, update and delete book data from a database. The purpose of this project is to demonstrate the knowledge and skills I have gained during my software development bootcamp at QA.

## Stacks and Tools
* Java
* Spring Boot
* Maven
* MySQL
* Git/GitHub
* JUnit and Mockito - for testing
* Jira - for project management
* H2 database
* H2 console
* MySQL workbench
* Postman - for making API calls
* Scrum - Agile

## Challenges
There were a few challenges, one was getting the application to work with multiple tables in a ManyToMany relationship between the authors and books tables. The testing part also presented a challenge as the constructor in my Book entity was different to the constructor I made in the Book DTO class, as a result it took some time to resolve the conflict, but I learnt a great deal during the process.

## What went well? / What didn't go as planned?
Overall the project went really well, a lot of the challenges I encountered improved my knowledge of how the spring boot framework works and certainly improved my competency in using Java.

Knowing what I know now, for future projects, I will spend more time planning before jumping into coding the solution just so that the build phase is carried out in the most efficient manner.


## Screenshots of API calls

### Adding a book to the database
![Add a book](https://user-images.githubusercontent.com/106381855/190863163-4655be4f-265a-413b-8e09-5fc92db77353.png)

### Get All books from the database
![Get all books](https://user-images.githubusercontent.com/106381855/190863189-2c3152e2-de29-4049-949d-6a5b7a8067ba.png)

### Updata an existing book __*Before*__
![Update a book before](https://user-images.githubusercontent.com/106381855/190863189-2c3152e2-de29-4049-949d-6a5b7a8067ba.png)

### Update an existing book by ID __*After*__
![Update a book](https://user-images.githubusercontent.com/106381855/190863193-499af3d5-9265-4a1f-992c-9d70b0272cd1.png)

### Find author by nameContaining
![Find author by name](https://user-images.githubusercontent.com/106381855/190863178-5c96aae6-5a8c-4b37-acbf-0e4956a7e6c7.png)

### Find book by ID
![Find book by ID](https://user-images.githubusercontent.com/106381855/190863185-fdb128aa-0711-4062-8615-9375cfbae3e9.png)

### Delete A Book
![Delete a book](https://user-images.githubusercontent.com/106381855/190863171-d1b4c4e3-b146-4466-9ba7-7c12b51d3024.png)

## Screenshots of Database persistence

### books_table
![book_table](https://user-images.githubusercontent.com/106381855/190867636-05744d23-edc4-4e03-924f-9b62a6516719.png)

### authors_table
![author_table](https://user-images.githubusercontent.com/106381855/190867628-135a3907-5f70-411c-8aa2-88a65f729d65.png)

### juction_table
![book_authors](https://user-images.githubusercontent.com/106381855/190867645-0192e5a3-504a-4c8b-b544-90f398b25ac8.png)

### Entity Relationship
![ERD](https://user-images.githubusercontent.com/106381855/190868607-5dec44e0-1675-432f-a39e-cb0ec1521e29.png)

### Testing
![testing_output](https://user-images.githubusercontent.com/106381855/190868750-7a18ec6d-1924-4e49-970c-58fe0a95a5ce.png)

## Possible improvements for future revisions of the project

* Build a frontend for the project using a framework like Angular.
* Create forms so that data can be submited and read in a more pleasing format for the end user.
* Transfer/host the app on a cloud based service such as AWS or Azure.

## Risk Assessment

| Description | Likelihood | Impact | Responsibilty | Response | Mitigation |
| ----------- | -----------| -------| --------------| -------- | ---------- |
| No Internet Connection | Unlikely | High | Me | Connect via mobile  | Find a library or public place that thas free wifi |
| GitHub goes down | Unlikely | Medium | GitHub/MicroSoft | Save code locally on machine while the service comes back online | Ensure code is saved at regular intervals both locally and pushed to remote repository |
| Offsick/Ill | Unlikely | High | Me | Inform tutor/trainer and have contact details readily accessible | Ensure there is a minimum viable product to submit as early as possible during the project|
| Code doesn't compile | Medium | High | Me | Roll back to last working branch/commit | Ensure each working feature branch is commited and pushed at regular intervals|
| Loss of Power | Unlikely | High | Me/Power Networks | Save all work and push to remote, if internet connection available | Have a battery/portable power pack available to run machine long enough to save any work in progress |



## [Link to Jira Board](https://oolardev.atlassian.net/jira/software/projects/CRUD/boards/1 "Jira")
