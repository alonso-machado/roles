package com.test.alonso.roles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.alonso.roles.model.AssignedRole;

@Repository
public interface AssignedRoleRepository extends JpaRepository<AssignedRole, Long> {
}
