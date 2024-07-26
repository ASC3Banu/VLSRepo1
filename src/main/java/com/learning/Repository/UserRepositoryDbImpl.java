package com.learning.Repository;
import com.learning.model.User;
import java.sql.*;

public class UserRepositoryDbImpl implements UserRepository {

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
    public User loginUser(String loginId, String password) throws SQLException {
        String query = "SELECT * FROM login WHERE loginId = ? AND password = ?";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, loginId);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(
                            resultSet.getInt("id"),
                            resultSet.getString("loginId"),
                            resultSet.getString("password")
                    );
                } else {
                    return null;
                }
            }
        }
    }
}
