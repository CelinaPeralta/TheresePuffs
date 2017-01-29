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

	private boolean battle_enabled = true;

	public Battle_Controller() {

		// VILLAIN_NAMES.add("Cenpai");
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

	public Character getVillain() {
		int name = (int) (Math.random() * (VILLAIN_NAMES.size() - 1));
		Character v = new Character(VILLAIN_NAMES.get(name));
		VILLAIN_NAMES.remove(name);
		v.resetHealth();
		return v;
	}

	public Character getBoss(Character c) {
		Character b = new Character("Cenpai");
		b.setAccuracy(c.getAccuracy() + (int) Math.random() * 10);
		b.setAgility(c.getAgility() + (int) Math.random() * 10);
		b.setMax_health(c.getMax_health() + (int) Math.random() * 50);
		b.resetHealth();

		return b;

	}

	// pass in the selected attack through button click or something
	// 1 if successful, 0 if a miss, -1 if attack not executed
	public int attack(Character attacker, Character attackee, String attack_name) {

		roll1 = dieRoll();
		roll2 = dieRoll();
		total = roll1 + roll2;

		if (total >= Character.getAttackValue(attack_name)) {
			int max_random_num = attacker.getAccuracy() + attackee.getAgility();
			int hit_attempt = rand.nextInt(max_random_num);

			if (hit_attempt <= attacker.getAccuracy()) {
				attackee.takeDamage(Character.getAttackStrength(attack_name));
				return 1;
			} else {
				System.out.println(attacker.getName() + " missed " + attackee.getName());
				return 0;
			}

		} else {
			System.out.println("Sum not high enough.");
			return -1;
		}
	}

	// this is bad
	public double calculateHitProbability(Character attacker, Character attackee) {
		double prob;

		prob = attacker.getAccuracy() / (double) (attacker.getAccuracy() + attackee.getAgility());

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

	public int getCurrentLevel() {
		return current_level;
	}

	public boolean isBattleEnabled() {
		return battle_enabled;
	}

	public void setBattleEnabled(boolean b) {
		battle_enabled = b;
	}

}
