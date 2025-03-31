package jpa.demo_enset.service;

import jpa.demo_enset.entities.Role;
import jpa.demo_enset.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUsername(String username);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username, String roleName);
    User authentificate(String username, String password);
}
