package com.learning.model;

public class Course {
    private int id;
    private static String name;
    private static String author;
    private int duration;
    private static boolean availability;

    public Course() {}

    public Course(int id, String name, String author, int duration, boolean availability) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.duration = duration;
        this.availability = availability;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public static boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", duration=" + duration +
                ", availability=" + availability +
                '}';
    }
}

