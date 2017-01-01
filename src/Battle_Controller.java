import java.util.ArrayList;
import java.util.Random;


/**
 * Created by celinaperalta on 12/29/16.
 */


public class Battle_Controller {

    //Possibly make character list
    final ArrayList<String> VILLAIN_NAMES = new ArrayList<String>();

    public Battle_Controller() {

    	VILLAIN_NAMES.add("Cenpai"); 
    	VILLAIN_NAMES.add("Selena Persalta"); 
    	VILLAIN_NAMES.add("Sillina Purralta"); 
    	VILLAIN_NAMES.add("Assorted Cans"); 
    	VILLAIN_NAMES.add("Commander Algae"); 
    	VILLAIN_NAMES.add("Matt Bansil");


    }

	Random rand = new Random();
    public void attack(Character attacker, Character attackee, int dieroll1, int dieroll2, int[] attack) {
    	
    }
    
    public int dieRoll() {
    	return rand.nextInt(6)+1;
    }

}
