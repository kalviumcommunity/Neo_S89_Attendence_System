// package com.school;

// public class main {
//     public static void main(String[] args){
//         System.out.println("Welcome to the school attendence management system.");
//    System.out.println("Session 1: Project setupand orientation complete.");


//     }
    
// }



package com.school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("---- School Management System ----");

        // --- Setup Services ---
        FileStorageService storageService = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(storageService);

        // Create objects
        Student student1 = new Student("Hemanth", "10th Grade");
        Student student2 = new Student("Sai", "9th Grade");
        Teacher teacher = new Teacher("Mr. John", "Mathematics");
        Staff staff = new Staff("Mary", "Clerk");
        
        // --- Polymorphism Demo ---
        // Create a list of Persons and add different types of objects
        List<Person> people = new ArrayList<>();
        people.add(student1);
        people.add(student2);
        people.add(teacher);
        people.add(staff);
        
        // Display details using polymorphism
        System.out.println("\n--- Person Details (Demonstrating Polymorphism) ---");
        for (Person person : people) {
            person.displayDetails(); // Calls the overridden method for each object type
            System.out.println();
        }

        // Create courses
        Course course1 = new Course("Java");
        Course course2 = new Course("Python");
        List<Course> allCourses = Arrays.asList(course1, course2);

        // Create a list of only students for attendance marking by ID
        List<Student> allStudents = new ArrayList<>();
        for (Person person : people) {
            if (person instanceof Student) {
                allStudents.add((Student) person);
            }
        }

        // --- Mark Attendance using the Service (Overloaded Methods) ---
        System.out.println("\n--- Marking Attendance ---");
        // Method 1: Using object references
        attendanceService.markAttendance(student1, course1, "Present");
        // Method 2: Using IDs
        attendanceService.markAttendance(student2.getId(), course2.getCourseId(), "Absent", allStudents, allCourses);
        attendanceService.markAttendance(student1.getId(), course2.getCourseId(), "Present", allStudents, allCourses);
        // Example of invalid ID
        attendanceService.markAttendance(999, course1.getCourseId(), "Present", allStudents, allCourses);

        // --- Display Attendance Reports (Overloaded Methods) ---
        attendanceService.displayAttendanceLog(); // Display all
        attendanceService.displayAttendanceLog(student1); // Display for Hemanth
        attendanceService.displayAttendanceLog(course2); // Display for Python

        // --- Save Data ---
        attendanceService.saveAttendanceData();
    }
}



// package com.school;

// public class main {
//     public static void main(String[] args) {
//         System.out.println("----Attendance Management System----");

//         // --- Register Students ---
//         Student[] students = new Student[2];

//         students[0] = new Student();
//         students[0].registerStudent(1, "Hemanth");

//         students[1] = new Student();
//         students[1].registerStudent(2, "Sai");

//         System.out.println("---Registered Students---");
//         for (Student student : students) {
//             student.getStudentDetails();
//         }

//         // --- Register Courses ---
//         Course[] courses = new Course[2];

//         courses[0] = new Course();
//         courses[0].registerCourse("CJAVA", "Java");

//         courses[1] = new Course();
//         courses[1].registerCourse("CPYTHON", "Python");

//         System.out.println("---Registered Courses---");
//         for (Course course : courses) {
//             course.getCourseDetails();
//         }

//         // --- Mark Attendance ---
//         System.out.println("---Marking Attendance---");
//         Attendance[] attendanceRecords = new Attendance[2];

//         attendanceRecords[0] = new Attendance();
//         attendanceRecords[0].markAttendance(1, "CJAVA", true);

//         attendanceRecords[1] = new Attendance();
//         attendanceRecords[1].markAttendance(2, "CPYTHON", false);

//         for (Attendance attendance : attendanceRecords) {
//             if (attendance != null) {
//                 attendance.getAttendance();
//             }
//         }

//         System.out.println("Session 3: Attendance feature added.");
//     }
// }
