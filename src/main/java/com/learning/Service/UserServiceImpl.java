package com.learning.Service;


import com.learning.Repository.UserRepository;
import com.learning.Repository.UserRepositoryDbImpl;
import com.learning.model.User;
import java.sql.SQLException;


public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl() {
        this.userRepository = new UserRepositoryDbImpl();
    }


    @Override
    public User loginUser(String loginId, String password) throws SQLException {
        return userRepository.loginUser(loginId, password);
    }
}
