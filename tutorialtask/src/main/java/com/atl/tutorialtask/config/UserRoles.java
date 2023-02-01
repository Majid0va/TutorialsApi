package com.atl.tutorialtask.config;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.atl.tutorialtask.config.UserPermissions.*;

public enum UserRoles {
    ADMIN(Sets.newHashSet(TUTORIAL_READ, TUTORIAL_INSERT, TUTORIAL_EDIT)),
    GUEST(Sets.newHashSet());

    private final Set<UserPermissions> permissions;

    UserRoles(Set<UserPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermissions> getPermissions() {
        return this.permissions;
    }
}
