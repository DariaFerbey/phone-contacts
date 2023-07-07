package software.chiacademy.phonecontacts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import software.chiacademy.phonecontacts.model.Role;

import java.util.Optional;

public interface RoleDAO  extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
