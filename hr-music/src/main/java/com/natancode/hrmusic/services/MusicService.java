package com.natancode.hrmusic.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natancode.hrmusic.entities.Music;
import com.natancode.hrmusic.factories.FlyWeightFactory;
import com.natancode.hrmusic.repositories.MusicFlyweightRepository;

@Service
public class MusicService {
	
	@Autowired
	private MusicFlyweightRepository repo;

	private Map<String, Map<String, Music>> memory;
	
	public MusicService() {
		memory = new HashMap<String, Map<String, Music>>();
	}
	
	public Music litenMusic(String user, Long id) {
		Map<String, Music> userPlayList = memory.get(user);
		if(userPlayList == null) {
			userPlayList = new HashMap<>();
			memory.put(user, userPlayList);
		}
		
		Music song = userPlayList.get(id.toString()); //pega a música solicitada na playlist
		if(song == null) {
			song = new Music(FlyWeightFactory.getInstance().getMusic(id, repo));
			userPlayList.put(id.toString(), song);
		}
		System.out.println(String.format("%s is listenning '%s'", user, song.getMusicFlyweight().getName()));
        song.listenning();
		return userPlayList.get(id.toString());
	}
	
}
