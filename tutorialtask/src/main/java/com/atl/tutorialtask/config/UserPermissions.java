package com.atl.tutorialtask.config;

public enum UserPermissions {
    TUTORIAL_READ("tutorial:read"),
    TUTORIAL_INSERT("tutorial:insert"),
    TUTORIAL_EDIT("tutorial:edit");

    private final String permission;

    UserPermissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return this.permission;
    }
}
