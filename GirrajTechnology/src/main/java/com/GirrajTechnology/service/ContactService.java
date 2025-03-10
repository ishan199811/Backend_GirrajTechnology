package com.GirrajTechnology.service;

import java.util.ArrayList;
import java.util.List;

import com.GirrajTechnology.model.Contact;





public interface ContactService {

	ArrayList<Contact> getAllContactInfo();

	void save( Contact contact);

}
