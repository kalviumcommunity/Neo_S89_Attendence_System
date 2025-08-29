package com.school;

public class Attendence {
    public static void main(String[] args) {
        System.out.println("----Attendence Management System----");
        Student[] students = new Student[2];
        students[0] = new Student();
        students[0].setDetails(1, "Josuke");
        students[1] = new Student();
        students[1].setDetails(2, "Jotaro");

        System.out.println("---Registered Students---");
        for (Student student : students) {
            if (student != null) {
                student.displayDetails();
            }
        }

        Course[] courses = new Course[2];
        courses[0] = new Course();
        courses[0].setDetails("CJAVA", "Java");
        courses[1] = new Course();
        courses[1].setDetails("CPYTHON", "Python");

        System.out.println("---Registered Courses---");
        for (Course course : courses) {
            if (course != null) {
                course.displayDetails();
            }
        }

        System.out.println("---Marking Attendance---");
        Attendance[] attendanceRecords = new Attendance[2];

        attendanceRecords[0] = new Attendance();
        attendanceRecords[0].markAttendance(1, "CJAVA", true);

        attendanceRecords[1] = new Attendance();
        attendanceRecords[1].markAttendance(2, "CPYTHON", false);

        for (Attendance attendance : attendanceRecords) {
            if (attendance != null) {
                attendance.getAttendance();
            }
        }

        System.out.println("Session 2: Student and Course classes created.");
        System.out.println("Session 3: Attendance feature added.");
    }
}