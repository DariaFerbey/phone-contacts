package software.chiacademy.phonecontacts.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.chiacademy.phonecontacts.model.Contact;
import software.chiacademy.phonecontacts.service.ContactService;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts(){
        return ResponseEntity.ok().body(contactService.getAllContact());
    }

    @PostMapping
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact) {
        return ResponseEntity.ok().body(this.contactService.add(contact));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable long id,@RequestBody Contact contact) {
        return ResponseEntity.ok().body(contactService.update(contact));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteContact(@PathVariable Integer id) {
        this.contactService.delete(id);
        return HttpStatus.OK;
    }

}
