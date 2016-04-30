package com.fiipractic.agenda.web.controllers;

import static java.util.stream.Collectors.toMap;

import java.security.Principal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fiipractic.agenda.utils.SecurityUtils;
import com.fiipractic.agenda.web.models.Contact;

@Controller
@RequestMapping("/contacts")
public class ContactsController {
	
	@Autowired
	private RestTemplate restTemplate;

	private static final String REST_URL = "http://localhost:8080/agenda";

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index() {
		return "redirect:/contacts/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String displayContactList(Principal principal, Model model) {
		HttpEntity<String> request = new HttpEntity<>(SecurityUtils.getHttpHeadersWithBasicAuth(principal));
		ResponseEntity<Contact[]> responseEntity = restTemplate
				.exchange(REST_URL + "/users/" + principal.getName() + "/contacts", HttpMethod.GET, request, Contact[].class);
		
		List<Contact> contacts = Arrays.asList(responseEntity.getBody());

		model.addAttribute("contacts", contacts.stream().collect(toMap(Contact::getId, Function.<Contact> identity())));

		return "list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String displayCreateContact(Model model) {
		model.addAttribute("contact", new Contact());
		return "create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String doCreateContact(@ModelAttribute Contact contact, Principal principal) {
		HttpEntity<Contact> request = new HttpEntity<>(contact, SecurityUtils.getHttpHeadersWithBasicAuth(principal));
		ResponseEntity<Contact> responseEntity = restTemplate
				.exchange(REST_URL + "/users/" + principal.getName() + "/contacts", HttpMethod.POST, request, Contact.class);

		return "redirect:/contacts/view?contactId=" + responseEntity.getBody().getId();
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String displayEditContact(@RequestParam Integer contactId, Model model, Principal principal) {
		HttpEntity<String> request = new HttpEntity<>(SecurityUtils.getHttpHeadersWithBasicAuth(principal));
		ResponseEntity<Contact> responseEntity = restTemplate
				.exchange(REST_URL + "/users/" + principal.getName() + "/contacts/" + contactId, HttpMethod.GET, request, Contact.class);
		model.addAttribute("contact", responseEntity.getBody());

		return "edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String doEditContact(@RequestParam Integer contactId, @ModelAttribute Contact contact, Principal principal) {
		HttpEntity<Contact> request = new HttpEntity<>(contact, SecurityUtils.getHttpHeadersWithBasicAuth(principal));
		restTemplate.exchange(REST_URL + "/users/" + principal.getName() + "/contacts/" + contactId, HttpMethod.PUT, request, Object.class);
		return "redirect:/contacts/view?contactId=" + contactId;
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String displayViewContact(@RequestParam Integer contactId, Model model, Principal principal) {
		HttpEntity<String> request = new HttpEntity<>(SecurityUtils.getHttpHeadersWithBasicAuth(principal));
		ResponseEntity<Contact> responseEntity = restTemplate
				.exchange(REST_URL + "/users/" + principal.getName() + "/contacts/" + contactId, HttpMethod.GET,request, Contact.class);
		model.addAttribute("contact", responseEntity.getBody());

		return "view";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String doDeleteContact(@RequestParam Integer contactId, Principal principal) {
		HttpEntity<String> request = new HttpEntity<>(SecurityUtils.getHttpHeadersWithBasicAuth(principal));
		Map<String, String> params = new HashMap<String, String>();
		params.put("restUrl", REST_URL);
		params.put("username", principal.getName());
		params.put("contactId", contactId.toString());
		restTemplate.exchange("{restUrl}/users/{username}/contacts/{contactId}", HttpMethod.DELETE, request, Object.class, params);
		return "redirect:/contacts/list";
	}
}
