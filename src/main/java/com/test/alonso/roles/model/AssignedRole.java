package com.test.alonso.roles.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class AssignedRole {

    @Id
    @GeneratedValue
    private long id; // UUID id; if using Mongo
    @NotEmpty
    private String teamId;
    @NotEmpty
    private String userId;

    private Set<Role> myRoles;

    public Set<Role> getMyRoles() {
        return myRoles;
    }

    public void setMyRoles(Set<Role> myRoles) {
        this.myRoles = myRoles;
    }

}
