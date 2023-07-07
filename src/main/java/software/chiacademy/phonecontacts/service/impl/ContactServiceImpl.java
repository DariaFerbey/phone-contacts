package software.chiacademy.phonecontacts.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.chiacademy.phonecontacts.dao.ContactDAO;
import software.chiacademy.phonecontacts.exception.ResourceNotFoundException;
import software.chiacademy.phonecontacts.model.Contact;
import software.chiacademy.phonecontacts.service.ContactService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDAO contactDAO;

    @Override
    public Contact add(Contact contact) {
        return contactDAO.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
        Optional<Contact> contactDb = this.contactDAO.findById(contact.getId());

        if (contactDb.isPresent()) {
            Contact contactUpdate = contactDb.get();
            contactUpdate.setId(contact.getId());
            contactUpdate.setName(contact.getName());
            contactUpdate.setEmails(contact.getEmails());
            contactUpdate.setPhones(contact.getPhones());
            contactDAO.save(contactUpdate);
            return contactUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + contact.getId());
        }
    }

    @Override
    public List<Contact> getAllContact() {
        return this.contactDAO.findAll();
    }

    @Override
    public void delete(long id) {
        Optional<Contact> contactDb = this.contactDAO.findById(id);

        if (contactDb.isPresent()) {
            this.contactDAO.delete(contactDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }
}
