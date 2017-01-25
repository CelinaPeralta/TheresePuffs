import java.util.*;

/**
 * Created by celinaperalta on 12/29/16.
 */
public class Character {

	private String name;
	private Map<String, int[]> all_attacks = new HashMap<String, int[]>();

	// Battle-related attributes
	private int health = 100, luck = 0, attack = 10, agility = 10, accuracy = 50;

	// Gameplay-oriented attributes
	private int puffs = 0, level = 1, experience = 0, att_points = 0;

	// Attack array stores 4 attacks per character. Attack has damage/strength
	// and accuracy.
	private Map<String, int[]> attack_list = new HashMap<String, int[]>();

	public Character(String name) {

		this.name = name;
		all_attacks.put("Miracle Super Punch", new int[] {5, 1});
		all_attacks.put("Punch", new int[] {10, 5});
		all_attacks.put("Smack", new int[] {15, 6});
		all_attacks.put("Kick", new int[] {20, 7});
		all_attacks.put("Explosive Demon Wave", new int[] {25, 8});
		all_attacks.put("Kuchikarakikōha", new int[] {37, 9});
		all_attacks.put("Demonic Piercing Light Murder Gun", new int[] {50, 10});
		all_attacks.put("Double Smack", new int[] {75, 12});

	}

	public int getAttackStrength(String a) {

		return attack_list.get(a)[0];

	}

	public int getAttackValue(String a) {

		return attack_list.get(a)[1];

	}

	public void takeDamage(int damage) {
		health -= damage;
	}
	
	@Override
	public String toString() {
		return "Character{" + "name='" + name + '\'' + '}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void resetHealth() {
		health = 100;
	}

	public int getLuck() {
		return luck;
	}

	public void setLuck(int luck) {
		this.luck = luck;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getPuffs() {
		return puffs;
	}

	public void setPuffs(int puffs) {
		this.puffs = puffs;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Map<String, int[]> getAttack_list() {
		return attack_list;
	}

}
