# Online Electronics Store Backend

## Overview
This is the backend for an Online Electronics Store website built using Spring framework.  
The website is located at: https://github.com/koslinj/Online-Electronics-Store  
  
The backend utilizes Spring Security with JWT tokens for authentication and authorization. MySQL is used as the database management system.  
  
During development I followed MVC (Model View Controller) Architecture. I tried to go along with the best practices for making a REST servcie in Spring

- **Models (Entities)**: Contains the domain models representing database entities.
- **DTOs**: Data Transfer Objects are used for communicating with the client website via JSONs, ensuring separation of concerns and enhancing security.
- **Service Interfaces and Implementations**: Services are organized using interfaces and separate implementations, promoting modularity and maintainability. In my REST API controllers i am using services to divide specific API routes from business logic

## Features
- **Spring Framework**: The backend is developed using Spring, a powerful and widely used Java framework.
- **Spring Security**: JWT tokens are implemented for secure authentication and authorization.
- **MySQL Database**: Data is stored and managed using MySQL, a popular relational database management system.
- **RESTful API**: The backend exposes RESTful endpoints to interact with the frontend or other systems.
- **Schema Connections**: ![image](https://github.com/koslinj/Online-Electronics-Store-Backend/assets/97230028/f478f0a4-69d2-49a1-b184-bc925ed63abd)
The backend utilizes a database connection to store various types of data essential for running the shop. Here's an overview of the data entities managed by the backend:

- **Opinions**: Feedback or reviews provided by users about products or services.
- **Users**: Information about the users registered in the shop application.
- **Addresses**: Details of user addresses for shipping and billing purposes.
- **Purchase Orders**: Records of orders made by users including the purchased products, quantities, and transaction details.
- **Products**: Information about the products available in the shop including their names, descriptions, prices, etc.
- **Product Filters**: Criteria or attributes used for filtering products, such as category, brand, technical details, etc.

## Usage
- Use the exposed API endpoints to perform CRUD operations on electronic products, user accounts, etc.
- Secure endpoints with JWT token authentication and authorization using Spring Security.
- Integrate with the frontend application to provide a complete online electronics store experience.

## Installation
1. **Clone the repository:**
   ```bash
   git clone https://github.com/koslinj/Online-Electronics-Store-Backend.git
   ```
2. **Navigate to the project directory:**
   ```bash
   cd Online-Electronics-Store-Backend
   ```
3. **Set up MySQL database:**
   - Create a MySQL database for the project.
   - Update the `application.properties` file with your database credentials.
4. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```
5. The backend server will start running at `http://localhost:8080`.
