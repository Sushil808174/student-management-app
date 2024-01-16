# Student Management System

The Student Management System is a comprehensive solution designed to simplify the process of managing student information within a school or educational institution. This system provides a user-friendly interface for administrators to perform various tasks related to student admission, course management, and student profiles. Students can also interact with the system to update their profiles, search for courses, and manage their course enrollments.

## Key Features

- **Admin Operations:**
  - Admit students with detailed information such as name, date of birth, and a unique student code.
  - Upload course details, including course name, description, type, duration, and topics.
  - Assign courses to students based on their unique student codes.
  - Search for students by name and retrieve a list of students assigned to a particular course.

- **Student Operations:**
  - Update student profiles with email, mobile number, parents' names, and addresses.
  - Search for courses assigned to a specific student.
  - Leave courses that are currently assigned to a student.

## Technologies Used

- **Spring Boot:** Framework for building Java-based enterprise applications.
- **Spring Data JPA with Hibernate:** Simplifies data access and manipulation using Java Persistence API (JPA).
- **Swagger:** Used for API documentation, providing a clear and interactive interface for developers.

## Authentication

- Admins: Use email and password for authentication.

## API End-points

## Admin Operation - 
### 1. Admit a Student

- **Endpoint:** `POST /admit-student`
- **Description:** Admit a new student to the school.
- **Request Body:**
  ```json
  {
    "name": "John Doe",
    "dateOfBirth": "1990-01-01",
    "gender": "Male",
    "uniqueStudentCode": "ABC123",
    "addresses": [
      {
        "area": "Residential Area",
        "state": "State",
        "district": "District",
        "pincode": "123456",
        "addressType": "Permanent"
      }
    ]
  }
  

### 2. Register a Admin

- **Endpoint:** `POST /register-admin`
- **Description:** Register a new Admin.
- **Request Body:**
  ```json
  {
    "adminName": "John Doe",
    "email": "john@gmail.com",
    "password": "password",
    "role": "admin",
  }

### 3. Upload Course

- **Endpoint:** `POST /upload-course`
- **Description:** upload a new course.

### 4. Assign Courses to Student

- **Endpoint:** `POST /assign-courses/{studentId}`
- **Description:** Assign courses to a specific student.

### 5. Search Students by Name

- **Endpoint:** `GET /students-by-name/{name}`
- **Description:** Search for students by their name.

### 6. Search Students by Name

- **Endpoint:** `GET /students-by-name/{name}`
- **Description:** Search for students by their name.

### 7. Get Students Assigned to a Course

- **Endpoint:** `GET /students-by-course/{courseId}`
- **Description:** Get students assigned to a specific course.


## Student Operation - 

### 8. Update Profile
- **Endpoint:** `PUT /update-profile/{studentId}`
- **Description:** Update the profile details of a student.

### 9. Search Assigned Courses
- **Endpoint:** `GET /assigned-courses/{studentId}`
- **Description:** Search for courses assigned to a specific student.

### 10. Leave a Course
- **Endpoint:** `DELETE /leave-course/{studentId}/{courseId}`
- **Description:** Leave a course that is currently assigned to the student.
