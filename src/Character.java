/**
 * Created by celinaperalta on 12/29/16.
 */
public class Character {

    private String name;

    //Battle-related attributes
    private int health = 10, luck, attack, agility;

    //Gameplay-oriented attributes
    private int puffs = 0, level = 1, experience = 0;


    public Character(String name) {

        this.name = name;

    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                '}';
    }
}
