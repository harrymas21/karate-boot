package com.carbonara.karateboot.services;

import com.carbonara.karateboot.models.UserInfo;
import com.carbonara.karateboot.repos.UserRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    
    @PersistenceContext	
    private EntityManager entityManager;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
	public UserInfo findUserByEmail(String email) {
		return userRepository.findByEmail(email);
        }
    @Override
    public void saveUser(UserInfo user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public UserInfo getActiveUser(String userName) {
        UserInfo activeUserInfo = new UserInfo();
		short enabled = 1;
		List<?> list = entityManager.createQuery("SELECT u FROM UserInfo u WHERE username=? and enabled=?")
				.setParameter(1, userName).setParameter(2, enabled).getResultList();
		if(!list.isEmpty()) {
			activeUserInfo = (UserInfo)list.get(0);
		}
		return activeUserInfo;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<UserInfo> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserInfo findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Override
    public UserInfo getLoggedInUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserInfo loggedInUser = findByUsername(auth.getName());
        return loggedInUser;
    }

    @Override
    public Iterable<UserInfo> getUsersByClub(Integer id) {
        List<UserInfo> usersByClub = entityManager.createQuery("SELECT u FROM UserInfo u WHERE clubid=?")
				.setParameter(1, id).getResultList();
        return usersByClub;
    }

    @Override
    public void resetPassword(Integer id) {
        UserInfo user = findById(id);
        user.setPassword(bCryptPasswordEncoder.encode("123456"));
        userRepository.save(user);
    }

    @Override
    public void disableUser(Integer id) {
        UserInfo user = findById(id);
        short disabled = 0;
        user.setEnabled(disabled);
        userRepository.save(user);
    }

    @Override
    public UserInfo findById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public UserInfo findUserByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }
    
}
