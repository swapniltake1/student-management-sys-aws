# Student Management System

This project is a Student Management System built with Java and Spring Boot. It provides an API for managing student data and is designed to be hosted on AWS EC2 build with a cloud database.

## Features

- **CRUD Operations**: Allows users to create, read, update, and delete student records.
- **Authentication**: Secure endpoints with JWT authentication.
- **Cloud Database**: Utilizes a cloud database for data storage.
- **RESTful API**: Provides a RESTful API for easy integration with front-end applications.
- **Postman Collection**: Includes a Postman collection for testing the API endpoints.

## Technologies Used

- Java
- Spring Boot
- MySQL
- AWS EC2
- Postman

## Setup Instructions

1. Clone the repository:

           `git clone https://github.com/swapniltake1/student-management-sys-aws.git`

           `cd student-management-system`

3. Modify the `application.properties` file in the `src/main/resources` directory with your database and EC2 instance configuration.

4. Build the project:

           `./mvnw clean package`

5. Run the application:

           `java -jar target/student-management-system.jar`

6. Access the API endpoints using a tool like Postman.

## API Documentation

For API documentation and usage examples, please refer to the [API Documentation](API_DOCUMENTATION.md) file.

## Contributors

- Swapnil Take ([GitHub](https://github.com/swapniltake1))

## License

This project is licensed under the [MIT License](LICENSE).
