package Week4_Buisness;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class MP3File 
{
    private String artist;
    private String trackName;
    private double length;

    public MP3File(String artist, String trackName, double length) {
        this.artist = artist;
        this.trackName = trackName;
        this.length = length;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    
    
}

