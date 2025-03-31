package jpa.demo_enset.service;

import jakarta.transaction.Transactional;
import jpa.demo_enset.entities.Role;
import jpa.demo_enset.entities.User;
import jpa.demo_enset.repositories.RoleRepository;
import jpa.demo_enset.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }


    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {

        return roleRepository.findByRoleName(roleName);
    }

    public void addRoleToUser(String username, String roleName) {
        User user = findUserByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found: " + username);
        }
        Role role = findRoleByRoleName(roleName);
        if (role == null) {
            throw new RuntimeException("Role not found: " + roleName);
        }
        if (user.getRoles() != null) {
            role.getUsers().add(user);
            user.getRoles().add(role);
        }
        // userRepository.save(user); // Décommenter si nécessaire
    }

    @Override
    public User authentificate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("Bad credentials: " + username);
        }
        if (user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("User not found: " + username);
    }

}
