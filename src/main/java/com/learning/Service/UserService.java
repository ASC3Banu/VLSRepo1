package com.learning.Service;

import com.learning.model.User;
import java.sql.SQLException;


public interface UserService {
    User loginUser(String loginId, String password) throws SQLException;
}

