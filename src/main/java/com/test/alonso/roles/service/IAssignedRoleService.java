package com.test.alonso.roles.service;

import com.test.alonso.roles.model.AssignedRole;
import com.test.alonso.roles.model.Role;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IAssignedRoleService {

    public void save(AssignedRole newAssignedRole);

    public List<AssignedRole> getAll();

    public List<AssignedRole> getAllFromRole(Role role);

}
