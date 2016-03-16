package com.fiipractic.agenda.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fiipractic.agenda.rest.models.Contact;
import com.fiipractic.agenda.rest.services.ContactService;

/**
 * File created by a.chmilevski on 3/15/2016 - 1:13 PM.
 * RadiON
 */
@RestController
@RequestMapping("/users/{username:.+}/contacts")
public class ContactsController {

    @Autowired
    private ContactService contactService;

    @PreAuthorize("authentication.name == #username")
    @RequestMapping(method = RequestMethod.GET)
    public List<Contact> getContacts(@PathVariable String username) {
        return contactService.getContactsForUsername(username);
    }

    @PreAuthorize("authentication.name == #username")
    @PostAuthorize("returnObject.user.username == #username")
    @RequestMapping(method = RequestMethod.GET, path = "/{contactId}")
    public Contact getContact(@PathVariable String username, @PathVariable Long contactId) {
        return contactService.getContactForUsername(contactId, username);
    }

    @PreAuthorize("authentication.name == #username")
    @RequestMapping(method = RequestMethod.POST)
    public Contact createContact(@PathVariable String username, @RequestBody Contact contact) {
        return contactService.createContactForUsername(contact, username);
    }

    @PreAuthorize("authentication.name == #username")
    @RequestMapping(method = RequestMethod.PUT, path = "/{contactId}")
    public Contact updateContact(@PathVariable String username, @PathVariable Long contactId, @RequestBody Contact contact) {
        return contactService.updateContactForUsername(contactId, contact, username);
    }

    @PreAuthorize("authentication.name == #username")
    @RequestMapping(method = RequestMethod.DELETE, path = "/{contactId}")
    public void deleteContact(@PathVariable String username, @PathVariable Long contactId) {
        contactService.deleteContactForUsername(contactId, username);
    }
}
