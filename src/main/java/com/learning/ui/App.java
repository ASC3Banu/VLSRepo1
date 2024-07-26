
package com.learning.ui;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to Coursera!Learning Begins Here");

        MenuUI menuUI = new MenuUI();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            menuUI.displayMenu();
            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (menuUI.loggedInUser == null) {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Login ID: ");
                        String loginId = scanner.nextLine();
                        System.out.print("Enter Password: ");
                        String password = scanner.nextLine();
                        menuUI.loginUser(loginId, password);
                        break;
                    case 2:
                        exit = true;
                        System.out.println("Exiting the application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            } else {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Author Name: ");
                        String author = scanner.nextLine();
                        menuUI.searchCoursesByAuthor(author);
                        break;
                    case 2:
                        System.out.print("Enter Course Name: ");
                        String name = scanner.nextLine();
                        menuUI.searchCoursesByName(name);
                        break;
                    case 3:
                        menuUI.displayAllCourses();
                        break;
                    case 4:
                        System.out.print("Enter Course ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter Course Name: ");
                        String courseName = scanner.nextLine();
                        System.out.print("Enter Author Name: ");
                        String courseAuthor = scanner.nextLine();
                        System.out.print("Enter Duration: ");
                        int duration = scanner.nextInt();
                        System.out.print("Enter Availability (true/false): ");
                        boolean availability = scanner.nextBoolean();
                        menuUI.addCourseToCart(id, courseName, courseAuthor, duration, availability);
                        break;
                    case 5:
                        System.out.print("Enter Course ID to delete: ");
                        int deleteId = scanner.nextInt();
                        menuUI.deleteCourseFromCart(deleteId);
                        break;
                    case 6:
                        menuUI.logoutUser();
                        break;
                    case 7:
                        exit = true;
                        System.out.println("Exiting the application. Goodbye! Learning Never Stops");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        }

        scanner.close();
    }
}
