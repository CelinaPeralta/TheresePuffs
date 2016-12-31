import java.util.Random;

/**
 * Created by celinaperalta on 12/29/16.
 */
public class Battle_Controller {

	Random rand = new Random();
    public void attack(Character attacker, Character attackee, int dieroll1, int dieroll2, int[] attack) {
    	
    }
    
    public int dieRoll() {
    	return rand.nextInt(6)+1;
    }

}
