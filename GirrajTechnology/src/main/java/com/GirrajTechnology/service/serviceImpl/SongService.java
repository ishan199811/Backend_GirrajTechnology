package com.GirrajTechnology.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GirrajTechnology.model.mongodb.Song;
import com.GirrajTechnology.repository.SongRepository;

@Service
public class SongService {
	 @Autowired
	    private SongRepository songRepository;
	    
	    public List<Song> getAllSongs() {
	        return songRepository.findAll();
	    }
	    
	    public Song getSongById(String id) {
	        return songRepository.findById(id).orElse(null);
	    }
	    
	    public String saveSong(Song song) {
	       
	        		songRepository.save(song);
	    
	        		 return "Saved";
	    }
	    
	    public void deleteSong(String id) {
	        songRepository.deleteById(id);
	    }
	}
