package com.quachhengtony.todomanager.repository;

import com.quachhengtony.todomanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
