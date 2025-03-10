package com.GirrajTechnology.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GirrajTechnology.model.mongodb.Song;
import com.GirrajTechnology.service.serviceImpl.SongService;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    @Autowired
    private SongService songService;
    
    @GetMapping("/all")
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }
    
    @GetMapping("/{id}")
    public Song getSongById(@PathVariable String id) {
        return songService.getSongById(id);
    }
    
    @GetMapping("/so")
    public String createSong() {
    	System.out.println("created-----------created-------song");
    	 Song songs = new Song("Yad tu aya", "Atif", "@:@");
    	 System.out.println("save-----------created-------song");
     	 
        return songService.saveSong(songs);
    }
    
    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable String id) {
        songService.deleteSong(id);
    }
}