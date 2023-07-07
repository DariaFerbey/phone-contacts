package software.chiacademy.phonecontacts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import software.chiacademy.phonecontacts.model.Contact;

public interface ContactDAO extends JpaRepository<Contact, Long> {

    @Query("SELECT c FROM Contact c WHERE c.name = :name")
    public Contact getUserByName(@Param("name") String name);

}
