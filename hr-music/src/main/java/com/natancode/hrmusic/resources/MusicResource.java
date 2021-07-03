package com.natancode.hrmusic.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natancode.hrmusic.entities.Music;
import com.natancode.hrmusic.entities.MusicFlyweight;
import com.natancode.hrmusic.repositories.MusicFlyweightRepository;
import com.natancode.hrmusic.services.MusicService;

@RestController
@RequestMapping(value = "/musics")
public class MusicResource {

	@Autowired
	private MusicFlyweightRepository repo;
	
	@Autowired
	private MusicService service;
	
	@GetMapping
	public ResponseEntity<List<MusicFlyweight>> findAll() {
		List<MusicFlyweight> list = repo.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Music> listenMusic(@PathVariable Integer id) {
		return ResponseEntity.ok(service.litenMusic("Natan", Long.parseLong(id.toString())));
	}
}
