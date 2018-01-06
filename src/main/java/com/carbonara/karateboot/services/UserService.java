package com.carbonara.karateboot.services;

import com.carbonara.karateboot.models.UserInfo;
import java.util.List;

public interface UserService {
      void register(UserInfo user);
      void deleteUser(String username);
      UserInfo getActiveUser(String userName);
      public List<UserInfo> getAllUsers();
    }
