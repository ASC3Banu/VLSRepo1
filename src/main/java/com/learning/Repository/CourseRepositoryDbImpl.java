
package com.learning.Repository;
import com.learning.model.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryDbImpl implements CourseRepository {

    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1/vlsdb";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "mysql";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load JDBC driver", e);
        }
    }

    @Override
    public List<Course> searchCoursesByAuthor(String author) throws SQLException {
        String query = "SELECT * FROM courses WHERE author = ?";
        List<Course> courses = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, author);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    courses.add(new Course(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("author"),
                            resultSet.getInt("duration"),
                            resultSet.getBoolean("availability")
                    ));
                }
            }
        }
        return courses;
    }

    @Override
    public List<Course> searchCoursesByName(String name) throws SQLException {
        String query = "SELECT * FROM courses WHERE name = ?";
        List<Course> courses = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    courses.add(new Course(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("author"),
                            resultSet.getInt("duration"),
                            resultSet.getBoolean("availability")
                    ));
                }
            }
        }
        return courses;
    }

    @Override
    public List<Course> getAllCourses() throws SQLException {
        String query = "SELECT * FROM courses";
        List<Course> courses = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                courses.add(new Course(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("author"),
                        resultSet.getInt("duration"),
                        resultSet.getBoolean("availability")
                ));
            }
        }
        return courses;
    }

    @Override
    public boolean addCourseToCart(Course course) throws SQLException {
        String query = "INSERT INTO cart (courseId, name, author, duration, availability) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, course.getId());
            preparedStatement.setString(2, course.getName());
            preparedStatement.setString(3, course.getAuthor());
            preparedStatement.setInt(4, course.getDuration());
            preparedStatement.setBoolean(5, course.isAvailability());
            int result = preparedStatement.executeUpdate();
            return result > 0;
        }
    }

    @Override
    public boolean deleteCourseFromCart(int courseId) throws SQLException {
        String query = "DELETE FROM cart WHERE courseId = ?";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, courseId);
            int result = preparedStatement.executeUpdate();
            return result > 0;
        }
    }
}
