package com.test.alonso.roles.service;

import jakarta.transaction.Transactional;

import com.test.alonso.roles.repository.AssignedRoleRepository;
import com.test.alonso.roles.repository.RoleRepository;
import com.test.alonso.roles.model.AssignedRole;
import com.test.alonso.roles.model.Role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignedRoleService implements IAssignedRoleService {

    @Autowired
    AssignedRoleRepository assignedRoleRepository;

    @Autowired
    RoleRepository roleRepository;

    @Transactional
    public void save(AssignedRole newAssignedRole) {
        List<Role> rolesList = roleRepository.findAll();
        if (newAssignedRole.getMyRoles().stream().allMatch(a -> rolesList.contains(a))) {
            assignedRoleRepository.save(newAssignedRole);
        } else {
            // TODO: Custom Exception for Role not existing in the Role Database
            System.out.println("Error in this AssignedRole Roles");
        }

    }

    public List<AssignedRole> getAllFromRole(Role role) {
        List<AssignedRole> assignedRolesList = assignedRoleRepository.findAll();
        return assignedRolesList.stream().filter(value -> value.getMyRoles().contains(role)).toList();
    }

    public List<AssignedRole> getAll() {
        return assignedRoleRepository.findAll();
    }

}
