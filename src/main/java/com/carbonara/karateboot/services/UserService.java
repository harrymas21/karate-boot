package com.carbonara.karateboot.services;

import com.carbonara.karateboot.models.UserInfo;
import java.util.List;

public interface UserService {
     public UserInfo findUserByEmail(String email);
     public UserInfo findByUsername(String username);
      void saveUser(UserInfo user);
      void deleteUser(String username);
      UserInfo getActiveUser(String userName);
      public List<UserInfo> getAllUsers();
    }
