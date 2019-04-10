package com.andersen.maks.repository;

import com.andersen.maks.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
