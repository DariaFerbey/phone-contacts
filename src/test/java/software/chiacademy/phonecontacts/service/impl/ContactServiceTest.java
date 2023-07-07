package software.chiacademy.phonecontacts.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import software.chiacademy.phonecontacts.dao.ContactDAO;
import software.chiacademy.phonecontacts.model.Contact;
import software.chiacademy.phonecontacts.service.ContactService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ContactServiceTest {

    @InjectMocks
    private ContactService contactService;

    @Mock
    private ContactDAO contactDAO;

    private Contact contact;
    private List<Contact> contacts;

    @BeforeEach
    public void init() {
        initMocks(this);

        contact = new Contact();
        contact.setName("xxx");
        contact.setId(1L);
        contact.setEmails(new ArrayList<>());
        contact.setPhones(new ArrayList<>());
    }

    @Test
    public void addTest() {
        contactService.add(contact);
        verify(contactDAO).save(contact);
    }

    @Test
    public void updateTest(){
        when(contactDAO.getUserByName(contact.getName())).thenReturn(contact);
        contact.setName("xxy");
        contactService.update(contact);
        verify(contactDAO).save(contact);
    }

    @Test
    public void getAllContactTest(){
        when(contactDAO.findAll()).thenReturn(contacts);
        contactService.getAllContact();
        verify(contactDAO).findAll();
    }

    @Test
    public void deleteTest(){
        contactService.delete(contact.getId());
        verify(contactDAO).delete(contact);
    }

}
