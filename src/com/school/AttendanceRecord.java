package com.school;

public class AttendanceRecord implements Storable {
    private Person person; // Changed from studentId to Person
    private Course course; // Changed from courseId to Course
    private String status;

    public AttendanceRecord(Person person, Course course, String status) {
        this.person = person;
        this.course = course;

        if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            this.status = status.substring(0,1).toUpperCase() + status.substring(1).toLowerCase();
        } else {
            this.status = "Invalid";
            System.out.println("⚠️ Warning: Invalid status entered. Defaulting to 'Invalid'.");
        }
    }

    // Getters
    public Person getPerson() {
        return person;
    }

    public Course getCourse() {
        return course;
    }

    public String getStatus() {
        return status;
    }

    // Display method
    public void displayRecord() {
        System.out.println("Person: " + person.getName() + " (ID: " + person.getId() + ")"
            + " | Course: " + course.getCourseName() + " (ID: " + course.getCourseId() + ")"
            + " | Status: " + status );
    }

    @Override
    public String toDataString() {
        return person.getId() + "," + course.getCourseId() + "," + status;
    }
}
