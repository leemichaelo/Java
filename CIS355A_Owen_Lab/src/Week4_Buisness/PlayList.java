package Week4_Buisness;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.LinkedList;

public class PlayList 
{
    private LinkedList<MP3File> songList;

    public PlayList() {
        this.songList = new LinkedList<MP3File>();
    }
    
    public void addSong (MP3File song)
    {
        this.songList.add(song);
    }
    
    public void removeSong (MP3File song)
    {
        this.songList.remove(song);
    }
    
    /**
     * gets the song at a specific position
     * @param index
     * @return MP3File or null if empty
     */
    public MP3File getSongAt (int index)
    {
        MP3File result = null;
        if (index >= 0 && index < this.songList.size())
        {
            result = this.songList.get(index);
        }
        return result;
    }
    
    public void clearPlayList ()
    {
        this.songList.clear();
    }
    
    public int size ()
    {
        return this.songList.size();
    }
    
    
}

