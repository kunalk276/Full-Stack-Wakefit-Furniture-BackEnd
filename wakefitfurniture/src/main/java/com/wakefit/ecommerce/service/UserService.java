package com.wakefit.ecommerce.service;

import com.wakefit.ecommerce.entity.User;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUserById(Long userId);
    User getUserByUserName(String userName);
    List<User> getAllUsers();
    void deleteUser(Long userId);
    User updateUser(Long userId, User user);
}
