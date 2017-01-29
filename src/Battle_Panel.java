import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import com.sun.xml.internal.ws.api.Component;

public class Battle_Panel extends JPanel {

	private Character c;
	private JLabel lblDie, lblSum, lblDie2, lblHitProbability, lblSelectedMove, lblMoveCost, lblDamage;
	private JPanel player_name, enemy_name;
	private JButton btnNewButton;
	private JProgressBar progressBar, progressBar_1;
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
		JPanel player_name = new JPanel();
		player_name.setBounds(6, 235, 255, 27);
		display.add(player_name);
		player_name.setLayout(null);

		JLabel label_1 = new JLabel(c.getName());
		label_1.setBounds(6, 6, 243, 16);
		player_name.add(label_1);

		JPanel enemy_name = new JPanel();
		enemy_name.setBounds(239, 6, 255, 27);
		display.add(enemy_name);
		enemy_name.setLayout(null);

		JLabel label = new JLabel(next_villain.getName());
		label.setBounds(6, 6, 243, 16);
		enemy_name.add(label);

		progressBar = new JProgressBar();
		progressBar.setBackground(new Color(0, 255, 0));
		progressBar.setForeground(Color.GREEN);
		progressBar.setBounds(6, 209, 255, 20);
		progressBar.setMaximum(c.getMax_health());
		progressBar.setMinimum(0);
		display.add(progressBar);
		progressBar.setValue(c.getMax_health());

		progressBar_1 = new JProgressBar();
		progressBar_1.setBackground(new Color(0, 255, 0));
		progressBar_1.setForeground(Color.GREEN);
		progressBar_1.setBounds(239, 45, 255, 20);
		progressBar_1.setMaximum(next_villain.getMax_health());
		progressBar_1.setMinimum(0);
		display.add(progressBar_1);
		progressBar_1.setValue(next_villain.getMax_health());
		
		JLabel character_img = new JLabel("");
		ImageIcon image = new ImageIcon("images/TheDinosaur.png");
		character_img.setIcon(image);
		character_img.setBounds(81, 103, 78, 108);
		display.add(character_img);

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

				// Attack
				battle_controller.attack(c, next_villain,
						lblSelectedMove.getText().substring("Selected Move: ".length()));

				// Set labels
				lblDie.setText("  Roll 1: " + Integer.toString(battle_controller.getRoll1()));
				lblDie2.setText("  Roll 2: " + Integer.toString(battle_controller.getRoll2()));
				lblSum.setText("Sum: " + Integer.toString(battle_controller.getTotal()));
				lblHitProbability.setText(String.format("Hit Probability: %.2f", battle_controller.calculateHitProbability(c, next_villain)));

				progressBar.setValue(c.getHealth());
				progressBar_1.setValue(next_villain.getHealth());

				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (next_villain.getHealth() <= 0) {
					System.out.println("Enemy died, added 10 puffs");
					//Change player stats
					c.setPuffs(c.getPuffs() + 10);
					c.setAtt_points(c.getAtt_points() + 2);
					c.setExperience(c.getExperience() + 10);
					c.checkLevel();
					c.resetHealth();
					battle_controller.next_level();
					next_villain = battle_controller.getCharacter();
					for (java.awt.Component jc : enemy_name.getComponents()) {
						if (jc instanceof JLabel) {
							((JLabel) jc).setText(next_villain.getName());
						}
					}
					JLabel lbl = (JLabel)enemy_name.getComponent(0);
					lbl.setText(next_villain.getName());
				}
				battle_controller.attack(next_villain, c, next_villain.getRandomAttack());
				if (c.getHealth() <= 0) {
					System.out.println("Player died what to do now");
					c.resetHealth();
					next_villain.resetHealth();
				}
			} else {
				lblSelectedMove.setText("Selected Move: " + button.getText());
				lblMoveCost.setText("Move Cost: " + Character.getAttackValue(button.getText()));
				lblDamage.setText("Damage: " + Character.getAttackStrength(button.getText()));
			}

		}
	}
}
