# Todo List Application

This is a simple Todo List application built using Spring Boot and Thymeleaf. The application allows users to add, edit, and view todo items.

## Features

- Add new todo items with a title, date, and status.
- Edit existing todo items.
- Prevent selection of past dates when adding or editing todo items.
- Responsive and user-friendly interface.

## Technologies Used

- Spring Boot
- Thymeleaf
- Java
- HTML/CSS
- JavaScript

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- MySQL

### Installation

#### 1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/todo-list.git
   cd todo-list 
```
#### 2. Configure the MySQL database:
   Update the application.properties file with your MySQL database credentials:
    spring.datasource.url=jdbc:mysql://localhost:3306/todo_db(your database name)
    spring.datasource.username=(yourusername)
    spring.datasource.password=(yourpassword)
    spring.jpa.hibernate.ddl-auto=update

#### 3.Build and run the application:
    mvn clean install
    mvn spring-boot:run
#### 4.Access the application:
    Open your browser and go to http://localhost:8080.
    
### Usage
   #### Add Todo Item: 
      Navigate to the "Add Todo Item" page and fill out the form. The status field can be typed manually, and the date field does not allow past dates.

   #### Edit Todo Item: 
      Navigate to the "Edit Todo Item" page for a specific todo item and update the form as needed. The status field can be typed manually, and the date field does not allow past dates.

   #### View Todo List: 
      Navigate to the "View Todo List" page to see all todo items.

### Folder Structure

      todo-list/
      ├── src/
      │   ├── main/
      │   │   ├── java/
      │   │   │   └── com/
      │   │   │       └── example/
      │   │   │           └── todolist/
      │   │   │               ├── controller/
      │   │   │               ├── model/
      │   │   │               ├── repository/
      │   │   │               └── service/
      │   │   ├── resources/
      │   │   │   ├── static/
      │   │   │   ├── templates/
      │   │   │   └── application.properties
      ├── pom.xml
      └── README.md
### Contributing
  Contributions are welcome! Please feel free to submit a pull request.

### License
  This project is licensed under the MIT License.

### Acknowledgements
  Spring Boot
  Thymeleaf
   
