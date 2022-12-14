package com.test.alonso.roles.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.test.alonso.roles.model.AssignedRole;
import com.test.alonso.roles.model.Role;
import com.test.alonso.roles.service.AssignedRoleService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/assign")
public class AssignedRoleController {

    @Autowired
    AssignedRoleService assignedRoleService;

    @GetMapping(value = "/")
    public List<AssignedRole> getAssignedRoles() {
        return assignedRoleService.getAll();
    }

    @GetMapping(value = "/role")
    public List<AssignedRole> getAssignedRolesFromSpecificRole(@RequestParam @Valid Role role) {
        return assignedRoleService.getAllFromRole(role);
    }

    @PostMapping(value = "/add")
    @Operation(summary = "Assign a new Set of Roles for that particular User inside the Team/Group")
    @ResponseStatus(HttpStatus.CREATED)
    public AssignedRole saveAssignedRole(@RequestParam @Valid AssignedRole assignedRole) {
        assignedRoleService.save(assignedRole);
        return assignedRole;
    }

}
