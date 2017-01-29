import java.util.*;

/**
 * Created by celinaperalta on 12/29/16.
 */
public class Character {

	private String name;

	// Use all_attacks to find index of attack in all_attacks_strengths
	private static ArrayList<String> all_attacks = new ArrayList<String>();
	private static ArrayList<int[]> all_attacks_strengths = new ArrayList<int[]>();

	// Attack array stores 4 attacks per character. Attack has damage/strength
	// and accuracy.
	private String[] attack_list = new String[4];

	// Battle-related attributes
	private int max_health = 100, health = 100, attack = 10, agility = 20, accuracy = 50;

	// Gameplay-oriented attributes
	private int puffs = 0, level = 1, experience = 0, att_points = 5;

	public Character(String name) {

		this.name = name;

		all_attacks.add("Miracle Super Punch");
		all_attacks_strengths.add(new int[] { 5, 1 });

		all_attacks.add("Punch");
		all_attacks_strengths.add(new int[] { 10, 5 });

		all_attacks.add("Smack");
		all_attacks_strengths.add(new int[] { 15, 6 });

		all_attacks.add("Kick");
		all_attacks_strengths.add(new int[] { 20, 7 });

		all_attacks.add("Explosive Demon Wave");
		all_attacks_strengths.add(new int[] { 25, 8 });

		all_attacks.add("Kuchikarakikōha");
		all_attacks_strengths.add(new int[] { 37, 9 });

		all_attacks.add("Demonic Piercing Light Murder Gun");
		all_attacks_strengths.add(new int[] { 50, 10 });

		all_attacks.add("Double Smack");
		all_attacks_strengths.add(new int[] { 75, 12 });

		// ------------------------------TESTING
		// CODE------------------------------------
		attack_list[0] = all_attacks.get(0);
		attack_list[1] = all_attacks.get(1);
		attack_list[2] = all_attacks.get(2);
		attack_list[3] = all_attacks.get(3);

	}

	public void clearAttack_list(){
		for(int i = 0; i < attack_list.length; i++){
			attack_list[i] = null;
		}
	}
	
	//this is v bad code
	public void addAttack(String attack_name, int index){
		attack_list[index] = attack_name;
	}
	
	public ArrayList<String> getAllAttacks() {
		return all_attacks;
	}

	public static int getAttackStrength(String a) {

		int index = all_attacks.indexOf(a);

		return all_attacks_strengths.get(index)[0];

	}

	public static int getAttackValue(String a) {

		int index = all_attacks.indexOf(a);

		return all_attacks_strengths.get(index)[1];

	}

	public void takeDamage(int damage) {
		health -= damage;
	}

	public String getRandomAttack() {
		int num = (int) Math.random() * attack_list.length;
		return attack_list[num];
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

	public int getMax_health() {
		return max_health;
	}

	public void setMax_health(int i) {
		max_health = i;
	}

	public void resetHealth() {
		health = max_health;
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

	public int getAtt_points() {
		return att_points;
	}

	public void setAtt_points(int i) {
		this.att_points = i;
	}

	public String[] getAttack_list() {

		return attack_list;
	}

	// stupid level up system that we should change later
	public void checkLevel() {
		if (experience - 30 > 0) {
			System.out.println("lmao u leveled up");
			level++;
			puffs += 20;
			att_points += 2;
			experience -= 30;
		}
	}

}
