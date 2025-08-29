package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("---- Attendance Management System ----");

        // Create students
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        // Create courses
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Science");

        // Display students & courses
        System.out.println("--- Registered Students ---");
        s1.displayDetails();
        s2.displayDetails();

        System.out.println("--- Registered Courses ---");
        c1.displayDetails();
        c2.displayDetails();

        // Attendance Records
        System.out.println("--- Attendance Log ---");
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        attendanceLog.add(new AttendanceRecord(s1.getStudentId(), c1.getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(s2.getStudentId(), c2.getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(s1.getStudentId(), c2.getCourseId(), "Late")); // invalid test

        // Display
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        System.out.println("Session 4: Data Encapsulation & Attendance Recording Validation Complete.");
    }
}