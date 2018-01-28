package com.carbonara.karateboot.services;

import com.carbonara.karateboot.models.Club;
import com.carbonara.karateboot.models.UserInfo;
import java.util.List;

public interface UserService {
     public UserInfo findUserByEmail(String email);
     public UserInfo findUserByPhone(String phone);
     public UserInfo findByUsername(String username);
     public UserInfo findById(Integer id);
     public UserInfo getLoggedInUser();
     void saveUser(UserInfo user);
     UserInfo getActiveUser(String userName);
     public Iterable<UserInfo> listUsers();
     Iterable<UserInfo> getUsersByClub(Integer id);
     void resetPassword(Integer id);
     void disableUser(Integer id);
    }
