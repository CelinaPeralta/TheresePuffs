import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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

		JButton button = new JButton("+");
		button.setBounds(73, 355, 53, 29);
		add(button);

		JButton button_1 = new JButton("-");
		button_1.setBounds(127, 355, 53, 29);
		add(button_1);

		JButton button_2 = new JButton("+");
		button_2.setBounds(312, 355, 53, 29);
		add(button_2);

		JButton button_3 = new JButton("-");
		button_3.setBounds(366, 355, 53, 29);
		add(button_3);

		JButton button_4 = new JButton("+");
		button_4.setBounds(73, 419, 53, 29);
		add(button_4);

		JButton button_5 = new JButton("-");
		button_5.setBounds(127, 419, 53, 29);
		add(button_5);

		JButton button_6 = new JButton("+");
		button_6.setBounds(312, 419, 53, 29);
		add(button_6);

		JButton button_7 = new JButton("-");
		button_7.setBounds(366, 419, 53, 29);
		add(button_7);

	}

	public class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// pass in move name then do things
			JButton button = (JButton) e.getSource();

		}
	}
}
