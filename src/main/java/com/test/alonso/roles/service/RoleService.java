package com.test.alonso.roles.service;

import jakarta.transaction.Transactional;
import com.test.alonso.roles.repository.RoleRepository;
import com.test.alonso.roles.model.Role;

import java.util.List;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {

    @Autowired
    RoleRepository roleRepository;

    @Transactional
    public void save(Role newRole) {
        roleRepository.save(newRole);
    }

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @PostConstruct
    public void start() {
        Role dev = new Role("Developer", "DEV");
        roleRepository.save(dev);
        Role qa = new Role("Tester", "QA");
        roleRepository.save(qa);
        Role po = new Role("Product Owner", "PO");
        roleRepository.save(po);

    }
}
