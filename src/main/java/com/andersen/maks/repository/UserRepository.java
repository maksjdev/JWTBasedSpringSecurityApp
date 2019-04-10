package com.andersen.maks.repository;

import com.andersen.maks.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
