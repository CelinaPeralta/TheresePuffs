import java.util.*;

/**
 * Created by celinaperalta on 12/29/16.
 */
public class Character {

    private String name;

    //Battle-related attributes
    private int health = 100, luck = 0, attack = 10, agility = 10;
    private double accuracy = 0.5;

    //Gameplay-oriented attributes
    private int puffs = 0, level = 1, experience = 0;

    //Attack array stores 4 attacks per character. Attack has damage/strength and accuracy.
    private Map<String, int[]> attack_list = new HashMap<String, int[]>();


    public Character(String name) {

        this.name = name;
        this.attack_list.put("Punch", new int[]{10, 5});
        this.attack_list.put("Kick", new int[]{20, 7});

    }


    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                '}';
    }
}
