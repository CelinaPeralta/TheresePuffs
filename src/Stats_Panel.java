import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Stats_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public Stats_Panel(Character c) {
		setSize(500, 500);
		setLayout(null);
		
		JLabel name = new JLabel(c.getName());
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(155, 35, 186, 16);
		add(name);
		
		JLabel lblAttPts = new JLabel("Attribute Points: " + c.getAtt_points());
		lblAttPts.setBounds(170, 289, 186, 16);
		add(lblAttPts);
		
		JLabel lblHealth = new JLabel("Health: " + c.getHealth());
		lblHealth.setHorizontalAlignment(SwingConstants.CENTER);
		lblHealth.setBounds(36, 336, 186, 16);
		add(lblHealth);
		
		JLabel lblAgility = new JLabel("Agility: " + c.getAgility());
		lblAgility.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgility.setBounds(36, 396, 186, 16);
		add(lblAgility);
		
		JLabel lblAccuracy = new JLabel("Accuracy: " + c.getAccuracy());
		lblAccuracy.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccuracy.setBounds(274, 396, 186, 16);
		add(lblAccuracy);
		
		JLabel lblAttack = new JLabel("Attack: " + c.getAttack());
		lblAttack.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttack.setBounds(274, 336, 186, 16);
		add(lblAttack);
		
		JLabel lblExp = new JLabel("Experience: " + c.getExperience());
		lblExp.setBounds(170, 233, 156, 16);
		add(lblExp);
		
		JLabel lblPuffs = new JLabel("Puffs: " + c.getPuffs());
		lblPuffs.setBounds(170, 261, 156, 16);
		add(lblPuffs);
		
		JLabel lblLevel = new JLabel("Level: " + c.getLevel());
		lblLevel.setBounds(170, 205, 156, 16);
		add(lblLevel);

	}
}
