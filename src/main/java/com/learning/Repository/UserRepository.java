package com.learning.Repository;
import com.learning.model.User;
import java.sql.SQLException;

public interface UserRepository {
    User loginUser(String loginId, String password) throws SQLException;
}

