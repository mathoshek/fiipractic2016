package com.fiipractic.agenda.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fiipractic.agenda.rest.models.Contact;
import com.fiipractic.agenda.rest.services.ContactService;

@RestController
@RequestMapping("/users/{username:.+}/contacts")
public class ContactsController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Contact> getContacts(@PathVariable String username) {
        return contactService.getContactsForUsername(username);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{contactId}")
    public Contact getContact(@PathVariable String username, @PathVariable Long contactId) {
        return contactService.getContactForUsername(username, contactId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Contact createContact(@PathVariable String username, @RequestBody Contact contact) {
        return contactService.createContact(username, contact);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{contactId}")
    public Contact updateContact(@PathVariable String username, @PathVariable Long contactId,
            @RequestBody Contact contact) {
        return contactService.updateContact(username, contactId, contact);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{contactId}")
    public void deleteContact(@PathVariable String username, @PathVariable Long contactId) {
        contactService.deleteContact(username, contactId);
    }

}
