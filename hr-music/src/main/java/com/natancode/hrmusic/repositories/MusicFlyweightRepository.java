package com.natancode.hrmusic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.natancode.hrmusic.entities.MusicFlyweight;

public interface MusicFlyweightRepository extends JpaRepository<MusicFlyweight, Long> {

}
