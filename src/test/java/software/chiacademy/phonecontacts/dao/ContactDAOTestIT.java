package software.chiacademy.phonecontacts.dao;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import software.chiacademy.phonecontacts.model.Contact;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class ContactDAOTestIT {

    @Autowired
    private ContactDAO contactDAO;

    @Test
    @Sql("file:src/test/resources/sql/insert_single_user.sql")
    public void getUserByUserNameTest() {
        Contact user = contactDAO.getUserByName("xxx");

        assertEquals(user.getName(), "xxx");
    }
}
