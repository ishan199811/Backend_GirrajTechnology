package com.GirrajTechnology.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GirrajTechnology.model.Contact;
import com.GirrajTechnology.service.ContactService;





@CrossOrigin(origins = "*")  // Apply CORS to this controller

@RestController
@RequestMapping("/api")
public class ContactController {
	
	@Autowired
	ContactService contactService;

	

	@PostMapping("/saveContact")
	public ResponseEntity<?> submitForm(@RequestBody Contact contact  )  {
		System.out.println(contact);
		  contactService.save(contact);
	
		return ResponseEntity.ok("Our team will connect you Shortly");
	}
	
	@GetMapping("/getAllContact")
	public ResponseEntity<?> getContactDetail(){
	ArrayList<Contact> contactList=contactService.getAllContactInfo();
		return ResponseEntity.ok(contactList);
		
	}
}
