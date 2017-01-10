import java.util.ArrayList;
import java.util.Random;

/**
 * Created by celinaperalta on 12/29/16.
 */

public class Battle_Controller {

	// Possibly make character list
	final ArrayList<String> VILLAIN_NAMES = new ArrayList<String>();
	private Random rand = new Random();

	public Battle_Controller() {

		VILLAIN_NAMES.add("Cenpai");
		VILLAIN_NAMES.add("Selena Persalta");
		VILLAIN_NAMES.add("Sillina Purralta");
		VILLAIN_NAMES.add("Assorted Cans");
		VILLAIN_NAMES.add("Commander Algae");
		VILLAIN_NAMES.add("Matt Bansil");
		VILLAIN_NAMES.add("Celili");
		VILLAIN_NAMES.add("Celulu");
		VILLAIN_NAMES.add("MattyBRaps");

	}

	public void attack(Character attacker, Character attackee, int dieroll1, int dieroll2, int[] attack) {

		int roll1 = dieRoll();
		int roll2 = dieRoll();
		System.out.println("Roll 1: " + roll1 + ", Roll 2: " + roll2 + ", Total: " + (roll1 + roll2));

	}

	public int dieRoll() {

		// return some number 1-6
		return rand.nextInt(6) + 1;
	}

}
