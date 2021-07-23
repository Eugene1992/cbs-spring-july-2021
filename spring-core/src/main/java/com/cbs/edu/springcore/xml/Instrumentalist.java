package com.cbs.edu.springcore.xml;

public class Instrumentalist implements Performer {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private Song song;

    @Override
    public void perform() {
        System.out.println("Playing '" + song.getName() + "' !");
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
