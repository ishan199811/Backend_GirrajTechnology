package com.GirrajTechnology.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GirrajTechnology.model.Contact;

public interface ContactRepository extends 	JpaRepository<Contact , Long>{
ArrayList<Contact> findAll();
}
