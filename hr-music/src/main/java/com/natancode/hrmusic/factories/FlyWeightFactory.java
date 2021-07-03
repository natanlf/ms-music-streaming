package com.natancode.hrmusic.factories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.natancode.hrmusic.entities.MusicFlyweight;
import com.natancode.hrmusic.repositories.MusicFlyweightRepository;

public class FlyWeightFactory {

	/*@Autowired
	private MusicFlyweightRepository repo;*/
	
	private static FlyWeightFactory instance = new FlyWeightFactory();
    private static Map<String, MusicFlyweight> musicFlyRepository;

    public FlyWeightFactory() {
        musicFlyRepository = new HashMap<String, MusicFlyweight>();
    }

    public static FlyWeightFactory getInstance() {
        return instance;
    }

    public MusicFlyweight getMusic(Long id, MusicFlyweightRepository repo) { //recupera dados intrísecos da música
    	MusicFlyweight mf = musicFlyRepository.get(id);
        if (mf == null) { //caso não tenha o objeto intríseco da música, então criamos
            System.out.println("Creating new Flyweight for "+ id);
            mf = getMusicById(id, repo);
            musicFlyRepository.put(id.toString(), mf);
        }
        return mf;
    }

    private MusicFlyweight getMusicById(Long id, MusicFlyweightRepository repo) { //cria a instancia da música
        return repo.findById(id).get();
    }

    public Integer getSize() {
        return musicFlyRepository.size();
    }
}
