
package com.learning.Service;

import com.learning.model.Course;
import com.learning.Repository.CourseRepository;
import com.learning.Repository.CourseRepositoryDbImpl;

import java.sql.SQLException;
import java.util.List;

public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl() {
        this.courseRepository = new CourseRepositoryDbImpl();
    }

    @Override
    public List<Course> searchCoursesByAuthor(String author) throws SQLException {
        return courseRepository.searchCoursesByAuthor(author);
    }

    @Override
    public List<Course> searchCoursesByName(String name) throws SQLException {
        return courseRepository.searchCoursesByName(name);
    }

    @Override
    public List<Course> getAllCourses() throws SQLException {
        return courseRepository.getAllCourses();
    }

    @Override
    public boolean addCourseToCart(Course course) throws SQLException {
        return courseRepository.addCourseToCart(course);
    }

    @Override
    public boolean deleteCourseFromCart(int courseId) throws SQLException {
        return courseRepository.deleteCourseFromCart(courseId);
    }
}


