package com.GirrajTechnology.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GirrajTechnology.model.Contact;
import com.GirrajTechnology.repository.ContactRepository;
import com.GirrajTechnology.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

	
	@Autowired
	ContactRepository contactRepository;
	
	@Override
	public ArrayList<Contact> getAllContactInfo() {
		
		ArrayList<Contact> contactList=contactRepository.findAll();
		// TODO Auto-generated method stub
		return contactList;
	}

	@Override
	public void save( Contact contact) {
		contactRepository.save(contact);
		
	}

}
