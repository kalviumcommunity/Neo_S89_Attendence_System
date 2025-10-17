package com.school;

public class Course {
    private static int nextCourseId = 101; // auto-increment counter
    private int courseId;
    private String courseName;

    public Course(String courseName) {
        this.courseId = nextCourseId++;
        this.courseName = courseName;
    }

    // Getters
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }
}
