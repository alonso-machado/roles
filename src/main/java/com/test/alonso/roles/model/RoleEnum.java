package com.test.alonso.roles.model;

import java.util.Arrays;

public enum RoleEnum {
    DEV("Developer"), PO("Product Owner"), QA("Tester");

    private String value;

    private RoleEnum(String value) {
        this.value = value;
    }

    public static RoleEnum fromValue(String value) {
        for (RoleEnum role : values()) {
            if (role.value.equalsIgnoreCase(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException(
                "Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
    }

}
