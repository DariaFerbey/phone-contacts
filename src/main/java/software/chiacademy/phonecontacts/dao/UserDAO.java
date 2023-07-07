package software.chiacademy.phonecontacts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import software.chiacademy.phonecontacts.model.Contact;

import java.util.Optional;

public interface UserDAO extends JpaRepository<Contact, Long> {
    Optional<Contact> findByName(String name);
    Boolean existsByName(String name);
}
