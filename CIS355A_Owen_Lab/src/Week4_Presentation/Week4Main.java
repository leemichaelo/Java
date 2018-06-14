package Week4_Presentation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Week4_Buisness.MP3File;
import Week4_Buisness.PlayList;
import Week4_Buisness.PlayService;


public class Week4Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        MP3File rickRoll = new MP3File("Rick Astley", "Never Give You Up", 3.56);
        MP3File monkees = new MP3File("Monkees", "Daybream Believer", 2.08);
        MP3File rem = new MP3File("R.E.M.", "Losing My Religion", 4.22);
        
        PlayList currentPlayList = new PlayList ();
        currentPlayList.addSong(rickRoll);
        currentPlayList.addSong(rickRoll);
        currentPlayList.addSong(monkees);
        currentPlayList.addSong(rem);
        
        PlayService playService = PlayService.getInstance();
        playService.setCurrentPlayList(currentPlayList);
        playService.play(0);
        playService.play(1);
        playService.play(2);
        playService.play(3);
        
        
        PlayService myOtherPlayService = PlayService.getInstance();
        
        if (playService == myOtherPlayService)
        {
            System.out.println ("they are the same object");
            playService.play(2);
        }
        
        
    }
    
}
