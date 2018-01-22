package com.carbonara.karateboot.repos;

import com.carbonara.karateboot.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserInfo, Long> {
	 UserInfo findByEmail(String email);
         UserInfo findByUsername(String username);
}
