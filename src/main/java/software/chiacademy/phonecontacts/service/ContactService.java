package software.chiacademy.phonecontacts.service;

import software.chiacademy.phonecontacts.model.Contact;

import java.util.List;

public interface ContactService {
    Contact add(Contact contact);
    Contact update(Contact contact);
    List<Contact> getAllContact();
    void delete(long id);

}
