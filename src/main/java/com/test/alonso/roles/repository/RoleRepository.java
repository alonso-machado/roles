package com.test.alonso.roles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.alonso.roles.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
