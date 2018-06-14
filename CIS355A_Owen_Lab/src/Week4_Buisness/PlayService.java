package Week4_Buisness;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class PlayService 
{
    private PlayList currentPlayList = new PlayList() ;
    private static PlayService playService = new PlayService ();
    
    private PlayService ()
    {
        
    }
    
    public static PlayService getInstance ()
    {
        return playService;
    }
    
    
    public void play (int index)
    {
        MP3File currentSong = currentPlayList.getSongAt(index);
        if (currentSong != null)
        {
            System.out.println("Playing..." + currentSong.getTrackName());
        }
        else
        {
            System.out.println("No Song Available");
        }
    }

    public PlayList getCurrentPlayList() {
        return currentPlayList;
    }

    public void setCurrentPlayList(PlayList currentPlayList) {
        this.currentPlayList = currentPlayList;
    }
    
    
    
    
}

