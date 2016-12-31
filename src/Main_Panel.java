import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by celinaperalta on 12/29/16.
 */
public class Main_Panel extends JPanel {
	
	JButton fight_button = new JButton("Fight");
	JButton shop_button = new JButton("Shop");
	JButton stats_button = new JButton("Stats");

    JPanel buttons = new JPanel();

	JLabel title = new JLabel("Danny the Dinosaur: The Quest for Thereese's Puffs");

	Font titleFont = new Font("Verdana", Font.BOLD, 14);


    public Main_Panel() {

        title.setFont(titleFont);

        buttons.setLayout(new GridLayout(1, 3));
        buttons.add(fight_button);
        buttons.add(shop_button);
        buttons.add(stats_button);
    	
        setSize(500, 500);
        setLayout(new BorderLayout());

        add(title, BorderLayout.NORTH);
        add(buttons, BorderLayout.SOUTH);

    }
}
