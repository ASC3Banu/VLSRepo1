package com.learning.Service;


import com.learning.model.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseService {
    List<Course> searchCoursesByAuthor(String author) throws SQLException;
    List<Course> searchCoursesByName(String name) throws SQLException;
    List<Course> getAllCourses() throws SQLException;
    boolean addCourseToCart(Course course) throws SQLException;
    boolean deleteCourseFromCart(int courseId) throws SQLException;
}
