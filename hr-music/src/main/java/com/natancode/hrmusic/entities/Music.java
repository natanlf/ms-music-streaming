package com.natancode.hrmusic.entities;

public class Music {
	
    private MusicFlyweight musicFlyweight; //dados intrísecos = não muda
    private Integer playerQty; //dado extrínseco = muda

    public Music(MusicFlyweight musicFlyweight) {
        this.musicFlyweight = musicFlyweight;
        playerQty = 0;
    }

    public void listenning() {
        playerQty++;
    }

    public MusicFlyweight getMusicFlyweight() {
        return musicFlyweight;
    }

    public void setMusicFlyweight(MusicFlyweight musicFlyweight) {
        this.musicFlyweight = musicFlyweight;
    }

    public Integer getPlayerQty() {
        return playerQty;
    }

    public void setPlayerQty(Integer playerQty) {
        this.playerQty = playerQty;
    }

    @Override
    public String toString() {
        return "Music{" +
                "musicFlyweight=" + musicFlyweight +
                ", playerQty=" + playerQty +
                '}';
    }
}
