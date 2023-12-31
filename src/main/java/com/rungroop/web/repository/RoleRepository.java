package com.rungroop.web.repository;

import com.rungroop.web.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
