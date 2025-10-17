// package com.school;

// public class main {
//     public static void main(String[] args){
//         System.out.println("Welcome to the school attendence management system.");
//    System.out.println("Session 1: Project setupand orientation complete.");


//     }
    
// }



package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("---- School Management System ----");

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

        // Attendance log
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Create attendance records using object references
        attendanceLog.add(new AttendanceRecord(student1, course1, "Present"));
        attendanceLog.add(new AttendanceRecord(student2, course2, "Absent"));
        attendanceLog.add(new AttendanceRecord(student1, course2, "Holiday")); // invalid status


        // Display attendance records
        System.out.println("\n--- Attendance Records ---");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
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
