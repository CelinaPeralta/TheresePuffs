import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Set;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import javax.swing.JSplitPane;
import javax.swing.JLabel;

public class Battle_Panel extends JPanel {

	private Character c;
	private JLabel lblDie, lblSum, lblDie2, lblHitProbability, lblSelectedMove, lblMoveCost, lblDamage;
	Battle_Controller battle_controller = new Battle_Controller();

	private Character next_villain = battle_controller.getCharacter();

	/**
	 * Create the panel.
	 */
	public Battle_Panel(Character c) {

		this.c = c;

		setBackground(new Color(255, 255, 255));

		setSize(500, 500);
		setLayout(null);

		JPanel display = new JPanel();
		display.setBackground(new Color(0, 0, 0));
		display.setBounds(0, 0, 500, 321);
		add(display);
		display.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(6, 268, 488, 47);
		display.add(panel);
		panel.setLayout(new GridLayout(0, 2, 10, 10));

		lblDie = new JLabel("  Roll 1:");
		panel.add(lblDie);

		lblSum = new JLabel("Sum:");
		panel.add(lblSum);

		lblDie2 = new JLabel("  Roll 2:");
		panel.add(lblDie2);

		lblHitProbability = new JLabel("Hit Probability:");
		panel.add(lblHitProbability);

		// fml how to paint this
		JPanel player_health_bar = new JPanel();
		player_health_bar.setBounds(6, 235, 255, 27);
		display.add(player_health_bar);
		player_health_bar.setLayout(null);

		JLabel label_1 = new JLabel(c.getName());
		label_1.setBounds(6, 6, 243, 16);
		player_health_bar.add(label_1);

		JPanel enemy_health_bar = new JPanel();
		enemy_health_bar.setBounds(239, 6, 255, 27);
		display.add(enemy_health_bar);
		enemy_health_bar.setLayout(null);

		JLabel label = new JLabel(next_villain.getName());
		label.setBounds(6, 6, 243, 16);
		enemy_health_bar.add(label);

		JPanel controls = new JPanel();
		controls.setBackground(new Color(245, 245, 245));
		controls.setBounds(0, 321, 500, 179);
		add(controls);
		controls.setLayout(null);

		// Pass in attack names
		String[] current_attacks = c.getAttack_list();

		JButton attack1 = new JButton(current_attacks[0]);
		attack1.setBounds(33, 92, 171, 29);
		attack1.addActionListener(new ButtonListener());
		controls.add(attack1);

		JButton attack2 = new JButton(current_attacks[1]);
		attack2.setBounds(33, 133, 171, 29);
		attack2.addActionListener(new ButtonListener());
		controls.add(attack2);

		JButton attack3 = new JButton(current_attacks[2]);
		attack3.setBounds(295, 92, 171, 29);
		attack3.addActionListener(new ButtonListener());
		controls.add(attack3);

		JButton attack4 = new JButton(current_attacks[3]);
		attack4.setBounds(295, 133, 171, 29);
		attack4.addActionListener(new ButtonListener());
		controls.add(attack4);

		lblSelectedMove = new JLabel("Selected Move: ");
		lblSelectedMove.setBounds(40, 18, 231, 16);
		controls.add(lblSelectedMove);

		lblMoveCost = new JLabel("Move Cost: ");
		lblMoveCost.setBounds(40, 64, 117, 16);
		controls.add(lblMoveCost);

		lblDamage = new JLabel("Damage:");
		lblDamage.setBounds(305, 64, 117, 16);
		controls.add(lblDamage);

		JButton btnNewButton = new JButton("Attack!");
		btnNewButton.setBounds(295, 16, 171, 23);
		btnNewButton.addActionListener(new ButtonListener());
		controls.add(btnNewButton);
	}

	public class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// pass in move name then do things
			JButton button = (JButton) e.getSource();

			if (button.getText().equals("Attack!")) {
				battle_controller.attack(c, next_villain, lblSelectedMove.getText().substring("Selected Move: ".length()));
				lblDie.setText("Roll 1: " + Integer.toString(battle_controller.getRoll1()));
				lblDie2.setText("Roll 2: " + Integer.toString(battle_controller.getRoll2()));
				lblSum.setText("Sum: " + Integer.toString(battle_controller.getTotal()));
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (next_villain.getHealth() <= 0)
					System.out.println("Enemy died what to do now");
				battle_controller.attack(next_villain, c, next_villain.getRandomAttack());
				if (c.getHealth() <= 0)
					System.out.println("Player died what to do now");
			} else {
				lblSelectedMove.setText("Selected Move: " + button.getText());
				lblMoveCost.setText("Move Cost: " + c.getAttackValue(button.getText()));
				lblDamage.setText("Damage: " + c.getAttackStrength(button.getText()));
			}

		}
	}
}
