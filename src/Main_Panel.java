import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;

public class Main_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public Main_Panel() {
		setBackground(new Color(255, 255, 255));
		
		setSize(500, 500);
		setLayout(new GridLayout(3, 1, 0, 150));
		
		JLabel titleText = new JLabel("Danny the Dinosaur: The Quest for Thereese's Puffs");
		titleText.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleText);
		
		JLabel lblNewLabel = new JLabel("Insert scandalous Dan Hu pic here");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel);
		panel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JButton fight_button = new JButton("Fight");
		panel.add(fight_button);
		
		JButton shop_button = new JButton("Shop");
		panel.add(shop_button);
		
		JButton stats_button = new JButton("Stats");
		panel.add(stats_button);
		

	}

}
