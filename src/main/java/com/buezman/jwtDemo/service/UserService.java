package com.buezman.jwtDemo.service;

import com.buezman.jwtDemo.model.Role;
import com.buezman.jwtDemo.model.AppUser;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
