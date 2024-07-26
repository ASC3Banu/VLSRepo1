//package com.learning.ui;
//
//import com.learning.model.Course;
//import com.learning.model.User;
//import com.learning.Service.CourseService;
//import com.learning.Service.CourseServiceImpl;
//import com.learning.Service.UserService;
//import com.learning.Service.UserServiceImpl;
//
//import java.sql.SQLException;
//import java.util.List;
//
//public class MenuUI {
//    private final CourseService courseService;
//    private final UserService userService;
//    public User loggedInUser; // Changed to public for access in App
//
//    public MenuUI() {
//        this.courseService = new com.learning.Service.CourseServiceImpl();
//        this.userService = new UserServiceImpl();
//    }
//
//    public void displayMenu() {
//        if (loggedInUser == null) {
//            System.out.println("\n1. Login User");
//            System.out.println("2. Exit");
//        } else {
//            System.out.println("\n1. Search Courses by Author");
//            System.out.println("2. Search Courses by Name");
//            System.out.println("3. Display All Courses");
//            System.out.println("4. Add Course to Cart");
//            System.out.println("5. Delete Course from Cart");
//            System.out.println("6. Logout User");
//            System.out.println("7. Exit");
//        }
//    }
//
////    public void registerUser(String loginId, String password) {
////        User user = new User(loginId, password);
////        try {
////            boolean isRegistered = userService.registerUser(user);
////            if (isRegistered) {
////                System.out.println("User registered successfully.");
////            } else {
////                System.out.println("Failed to register user.");
////            }
////        } catch (SQLException e) {
////            System.err.println("Error registering user: " + e.getMessage());
////        }
////    }
//
//    public void loginUser(String loginId, String password) {
//        try {
//            User user = userService.loginUser(loginId, password);
//            if (user != null) {
//                loggedInUser = user;
//                System.out.println("User logged in successfully.");
//            } else {
//                System.out.println("Invalid login ID or password.");
//            }
//        } catch (SQLException e) {
//            System.err.println("Error logging in user: " + e.getMessage());
//        }
//    }
//
//    public void searchCoursesByAuthor(String author) {
//        try {
//            List<Course> courses = courseService.searchCoursesByAuthor(author);
//            displayCourses(courses);
//        } catch (SQLException e) {
//            System.err.println("Error searching courses by author: " + e.getMessage());
//        }
//    }
//
//    public void searchCoursesByName(String name) {
//        try {
//            List<Course> courses = courseService.searchCoursesByName(name);
//            displayCourses(courses);
//        } catch (SQLException e) {
//            System.err.println("Error searching courses by name: " + e.getMessage());
//        }
//    }
//
//    public void displayAllCourses() {
//        try {
//            List<Course> courses = courseService.getAllCourses();
//            displayCourses(courses);
//        } catch (SQLException e) {
//            System.err.println("Error displaying all courses: " + e.getMessage());
//        }
//    }
//
//    public void addCourseToCart(int id, String name, String author, int duration, boolean availability) {
//        Course course = new Course(id, name, author, duration, availability);
//        try {
//            boolean isAdded = courseService.addCourseToCart(course);
//            if (isAdded) {
//                System.out.println("Course added to cart successfully.");
//            } else {
//                System.out.println("Failed to add course to cart.");
//            }
//        } catch (SQLException e) {
//            System.err.println("Error adding course to cart: " + e.getMessage());
//        }
//    }
//
//    public void deleteCourseFromCart(int courseId) {
//        try {
//            boolean isDeleted = courseService.deleteCourseFromCart(courseId);
//            if (isDeleted) {
//                System.out.println("Course deleted from cart successfully.");
//            } else {
//                System.out.println("Failed to delete course from cart.");
//            }
//        } catch (SQLException e) {
//            System.err.println("Error deleting course from cart: " + e.getMessage());
//        }
//    }
//
//    public void logoutUser() {
//        loggedInUser = null;
//        System.out.println("User logged out successfully.");
//    }
//
//    private void displayCourses(List<Course> courses) {
//        if (courses.isEmpty()) {
//            System.out.println("No courses found.");
//        } else {
//            for (Course course : courses) {
//                System.out.println(course);
//            }
//        }
//    }
//}
package com.learning.ui;

import com.learning.model.Course;
import com.learning.model.User;
import com.learning.Service.CourseService;
import com.learning.Service.CourseServiceImpl;
import com.learning.Service.UserService;
import com.learning.Service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class MenuUI {
    private final CourseService courseService;
    private final UserService userService;
    public User loggedInUser; // Changed to public for access in App

    public MenuUI() {
        this.courseService = new CourseServiceImpl();
        this.userService = new UserServiceImpl();
    }

    public void displayMenu() {
        if (loggedInUser == null) {
            System.out.println("\n1. Login User");
            System.out.println("2. Exit");
        } else {
            System.out.println("\n1. Search Courses by Author");
            System.out.println("2. Search Courses by Name");
            System.out.println("3. Display All Courses");
            System.out.println("4. Add Course to Cart");
            System.out.println("5. Delete Course from Cart");
            System.out.println("6. Logout User");
            System.out.println("7. Exit");
        }
    }


    public void loginUser(String loginId, String password) {
        try {
            User user = userService.loginUser(loginId, password);
            if (user != null) {
                loggedInUser = user;
                System.out.println("User logged in successfully.");
            } else {
                System.out.println("Invalid login ID or password.");
            }
        } catch (SQLException e) {
            System.err.println("Error logging in user: " + e.getMessage());
        }
    }

    public void searchCoursesByAuthor(String author) {
        try {
            List<Course> courses = courseService.searchCoursesByAuthor(author);
            displayCourses(courses);
        } catch (SQLException e) {
            System.err.println("Error searching courses by author: " + e.getMessage());
        }
    }

    public void searchCoursesByName(String name) {
        try {
            List<Course> courses = courseService.searchCoursesByName(name);
            displayCourses(courses);
        } catch (SQLException e) {
            System.err.println("Error searching courses by name: " + e.getMessage());
        }
    }

    public void displayAllCourses() {
        try {
            List<Course> courses = courseService.getAllCourses();
            displayCourses(courses);
        } catch (SQLException e) {
            System.err.println("Error displaying all courses: " + e.getMessage());
        }
    }

    public void addCourseToCart(int id, String name, String author, int duration, boolean availability) {
        Course course = new Course(id, name, author, duration, availability);
        try {
            boolean isAdded = courseService.addCourseToCart(course);
            if (isAdded) {
                System.out.println("Course added to cart successfully.");
            } else {
                System.out.println("Failed to add course to cart.");
            }
        } catch (SQLException e) {
            System.err.println("Error adding course to cart: " + e.getMessage());
        }
    }

    public void deleteCourseFromCart(int courseId) {
        try {
            boolean isDeleted = courseService.deleteCourseFromCart(courseId);
            if (isDeleted) {
                System.out.println("Course deleted from cart successfully.");
            } else {
                System.out.println("Failed to delete course from cart.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting course from cart: " + e.getMessage());
        }
    }

    public void logoutUser() {
        loggedInUser = null;
        System.out.println("User logged out successfully.");
    }

    private void displayCourses(List<Course> courses) {
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
        } else {
            for (Course course : courses) {
                System.out.println(course);
            }
        }
    }
}

