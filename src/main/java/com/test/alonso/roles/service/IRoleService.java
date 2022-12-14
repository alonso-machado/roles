package com.test.alonso.roles.service;

import com.test.alonso.roles.model.Role;

import java.util.List;

public interface IRoleService {

    public void save(Role newRole);

    public List<Role> getAll();

}
