import java.util.ArrayList;
import java.util.HashMap;
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

	// pass in the selected attack through button click or something
	public void attack(Character attacker, Character attackee, String attack_name) {

		int roll1 = dieRoll();
		int roll2 = dieRoll();
		int total = roll1 + roll2;

		// For debugging
		System.out.println(attacker.getName());
		System.out.println("Roll 1: " + roll1 + ", Roll 2: " + roll2 + ", Total: " + total);
		
		if (total >= attacker.getAttackValue(attack_name)) {
			
			//
			
			
		} else {
			//TODO
		}

	}

	public int dieRoll() {
		// return some number 1-6
		return rand.nextInt(6) + 1;
	}

}
