import java.util.Random;

/**
 * Created by celinaperalta on 12/29/16.
 */
public class Battle_Controller {

	Random rand = new Random();
    public void attack(Character user, Character enemy, int dieroll1, int dieroll2) {
    	
    }
    
    public int dieRoll() {
    	return rand.nextInt(5)+1;
    }

}
