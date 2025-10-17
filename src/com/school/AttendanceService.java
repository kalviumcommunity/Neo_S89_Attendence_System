package com.school;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    public AttendanceService(FileStorageService storageService) {
        this.storageService = storageService;
        this.attendanceLog = new ArrayList<>();
    }

    // Helper method to find a student by ID
    private Student findStudentById(int studentId, List<Student> allStudents) {
        for (Student student : allStudents) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null; // Not found
    }

    // Helper method to find a course by ID
    private Course findCourseById(int courseId, List<Course> allCourses) {
        for (Course course : allCourses) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        return null; // Not found
    }

    // Overloaded method 1: Mark attendance using object references
    public void markAttendance(Student student, Course course, String status) {
        if (student != null && course != null) {
            AttendanceRecord record = new AttendanceRecord(student, course, status);
            this.attendanceLog.add(record);
        } else {
            System.out.println("Error: Cannot mark attendance with null student or course.");
        }
    }

    // Overloaded method 2: Mark attendance using IDs
    public void markAttendance(int studentId, int courseId, String status, List<Student> allStudents, List<Course> allCourses) {
        Student student = findStudentById(studentId, allStudents);
        Course course = findCourseById(courseId, allCourses);

        if (student == null) {
            System.out.println("⚠️ Warning: Student with ID " + studentId + " not found. Attendance not recorded.");
            return;
        }
        if (course == null) {
            System.out.println("⚠️ Warning: Course with ID " + courseId + " not found. Attendance not recorded.");
            return;
        }

        // Call the other overloaded method
        markAttendance(student, course, status);
    }

    // Overloaded method 1: Display all attendance logs
    public void displayAttendanceLog() {
        System.out.println("\n--- Full Attendance Log ---");
        attendanceLog.forEach(AttendanceRecord::displayRecord);
    }

    // Overloaded method 2: Display logs for a specific student
    public void displayAttendanceLog(Student student) {
        System.out.println("\n--- Attendance Log for " + student.getName() + " ---");
        attendanceLog.stream()
            .filter(record -> record.getPerson().getId() == student.getId())
            .forEach(AttendanceRecord::displayRecord);
    }

    // Overloaded method 3: Display logs for a specific course
    public void displayAttendanceLog(Course course) {
        System.out.println("\n--- Attendance Log for " + course.getCourseName() + " ---");
        attendanceLog.stream()
            .filter(record -> record.getCourse().getCourseId() == course.getCourseId())
            .forEach(AttendanceRecord::displayRecord);
    }

    public void saveAttendanceData() {
        System.out.println("\nSaving attendance data...");
        // Convert List<AttendanceRecord> to List<Storable> for the service
        List<Storable> storableRecords = new ArrayList<>(attendanceLog);
        storageService.saveData(storableRecords, "attendance.txt");
    }
}