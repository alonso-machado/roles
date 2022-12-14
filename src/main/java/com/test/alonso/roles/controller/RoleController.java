package com.test.alonso.roles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.test.alonso.roles.model.Role;
import com.test.alonso.roles.service.IRoleService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/v1/roles")
public class RoleController {

    @Autowired
    IRoleService roleService;

    @GetMapping(value = "/")
    public List<Role> getRoles() {
        return roleService.getAll();
    }

    @PostMapping(value = "/add")
    @Operation(summary = "Add a new Role")
    @ResponseStatus(HttpStatus.CREATED)
    public Role saveRole(@RequestParam String fullName, @RequestParam String acronym) {
        Role newRole = new Role(fullName, acronym);
        roleService.save(newRole);
        return newRole;
    }

}
