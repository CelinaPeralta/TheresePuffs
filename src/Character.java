import java.util.*;

/**
 * Created by celinaperalta on 12/29/16.
 */
public class Character {
	
	//TODO: Make moves upgradable by increasing damage and appending some Roman numeral to it i.e. Move II, Move III

	private String name;

	// Battle-related attributes
	private int health = 100, luck = 0, attack = 10, agility = 10, accuracy = 50;

	// Gameplay-oriented attributes
	private int puffs = 0, level = 1, experience = 0;

	// Attack array stores 4 attacks per character. Attack has damage/strength
	// and accuracy.
	private Map<String, int[]> attack_list = new HashMap<String, int[]>();

	public Character(String name) {

		this.name = name;
		this.attack_list.put("Punch", new int[] { 10, 5 });
		this.attack_list.put("Kick", new int[] { 20, 7 });

	}

	public int getAttackStrength(String a) {

		return attack_list.get(a)[0];

	}

	public int getAttackValue(String a) {

		return attack_list.get(a)[1];

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

	public void setHealth(int health) {
		this.health = health;
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

	public double getAccuracy() {
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
