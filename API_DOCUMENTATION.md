# Student Management System API Documentation

This document provides an overview of the Student Management System API endpoints along with their request and response formats.

## Base URL

All API endpoints are relative to the base URL:

```
http://44.222.253.61:8080/student
```

## Endpoints

### 1. Get All Students

Retrieve all students stored in the system.

- **URL**: `/get-all`
- **Method**: GET

#### Response

- **Status Code**: 200 OK
- **Response Body**: JSON array containing student objects.

Example:

```json
[
  {
    "studentName": "John Doe",
    "studentAddress": "123 Main Street",
    "studentClass": "BE",
    "studentPhone": "1234567890",
    "studentMail": "john@example.com"
  },
  {
    "studentName": "Jane Smith",
    "studentAddress": "456 Oak Avenue",
    "studentClass": "BSc",
    "studentPhone": "0987654321",
    "studentMail": "jane@example.com"
  }
]
```

### 2. Get Student by ID

Retrieve a specific student by their ID.

- **URL**: `/get/{id}`
- **Method**: GET
- **Path Parameter**:
  - `{id}`: The unique ID of the student.

#### Response

- **Status Code**: 200 OK
- **Response Body**: JSON object representing the student with the specified ID.

Example:

```json
{
  "studentName": "John Doe",
  "studentAddress": "123 Main Street",
  "studentClass": "BE",
  "studentPhone": "1234567890",
  "studentMail": "john@example.com"
}
```

### 3. Add Student

Add a new student to the system.

- **URL**: `/add`
- **Method**: POST
- **Request Body**: JSON object representing the student to be added.

Example Request Body:

```json
{
  "studentName": "Rohit Mane",
  "studentAddress": "123 Main Street, KarveNagar, Pune",
  "studentClass": "BE",
  "studentPhone": "9763395029",
  "studentMail": "swapniltake1@gmail.com"
}
```

#### Response

- **Status Code**: 200 OK
- **Response Body**: Success message indicating the student has been added.

### 4. Update Student by ID

Update an existing student's information.

- **URL**: `/update/{id}`
- **Method**: PUT
- **Path Parameter**:
  - `{id}`: The unique ID of the student to update.
- **Request Body**: JSON object representing the updated student information.

Example Request Body:

```json
{
  "studentName": "Updated Name",
  "studentAddress": "Updated Address",
  "studentClass": "Updated Class",
  "studentPhone": "Updated Phone",
  "studentMail": "updated@example.com"
}
```

#### Response

- **Status Code**: 200 OK
- **Response Body**: Success message indicating the student has been updated.

### 5. Delete Student by ID

Delete a student from the system.

- **URL**: `/delete/{id}`
- **Method**: DELETE
- **Path Parameter**:
  - `{id}`: The unique ID of the student to delete.

#### Response

- **Status Code**: 200 OK
- **Response Body**: Success message indicating the student has been deleted.
