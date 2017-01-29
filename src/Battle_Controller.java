import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by celinaperalta on 12/29/16.
 */

public class Battle_Controller {

	// Possibly make character list
	private ArrayList<String> VILLAIN_NAMES = new ArrayList<String>();
	public final int LEVELS;

	private int current_level = 1;
	private Random rand = new Random();

	private int roll1 = 0;
	private int roll2 = 0;
	private int total = 0;

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

		LEVELS = VILLAIN_NAMES.size();

	}

	public Character getCharacter() {
		int name = (int) (Math.random() * (VILLAIN_NAMES.size() - 1));
		Character v = new Character(VILLAIN_NAMES.get(name));
		VILLAIN_NAMES.remove(name);
//		v.setAccuracy((int)Math.random()*50);
//		v.setAgility((int)Math.random()*50);
		v.resetHealth();
		return v;
	}

	// pass in the selected attack through button click or something
	public void attack(Character attacker, Character attackee, String attack_name) {

		roll1 = dieRoll();
		roll2 = dieRoll();
		total = roll1 + roll2;

		if (total >= Character.getAttackValue(attack_name)) {
			int total_dexterity = attacker.getAccuracy() + attackee.getAgility();
			int hit_attempt = rand.nextInt(total_dexterity);

			if (hit_attempt <= attacker.getAccuracy()) {
				attackee.takeDamage(Character.getAttackStrength(attack_name));
			}

		} else {
			// not gonna be println but just for now
			System.out.println(attacker.getName() + " missed " + attackee.getName());
		}

	}

	// this is bad
	public double calculateHitProbability(Character attacker, Character attackee) {
		double prob;

		prob = attacker.getAccuracy() / (double)(attacker.getAccuracy() + attackee.getAgility());

		return prob * 10;
	}

	public int dieRoll() {
		// return some number 1-6
		return rand.nextInt(6) + 1;
	}

	public int getRoll1() {
		return roll1;
	}

	public int getRoll2() {
		return roll2;
	}

	public int getTotal() {
		return total;
	}

	public void next_level() {
		current_level++;
	}

}
