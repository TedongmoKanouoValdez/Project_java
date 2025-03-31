package jpa.demo_enset.repositories;

import jpa.demo_enset.entities.Role;
import jpa.demo_enset.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
