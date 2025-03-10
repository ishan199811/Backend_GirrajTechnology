package com.GirrajTechnology.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.GirrajTechnology.model.mongodb.Song;

public interface SongRepository extends MongoRepository<Song, String> {
    // Custom query methods go here
	List<Song> findByArtist(String artist);
}