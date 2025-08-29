package com.school;

public class Attendance {
    int studentId;
    String courseId;
    boolean present;

    public void markAttendance(int studentId, String courseId, boolean present) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.present = present;
    }

    public void getAttendance() {
        System.out.println("Student ID: " + studentId + ", Course ID: " + courseId + ", Present: " + present);
    }
}
