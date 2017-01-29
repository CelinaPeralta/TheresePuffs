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
import javax.swing.SwingConstants;

public class Battle_Panel extends JPanel {

	private Character c;
	private JLabel lblDie, lblSum, lblDie2, lblHitProbability, lblSelectedMove, lblMoveCost, lblDamage, eTxtLbl,
			pTxtLbl;
	private JPanel player_name, enemy_name;
	private JButton btnNewButton;
	private JProgressBar progressBar, progressBar_1;
	private String[] current_attacks;
	private boolean battle_enabled = true;
	Battle_Controller battle_controller = new Battle_Controller();

	private Character next_villain = battle_controller.getCharacter();
	private JButton attack1, attack2, attack3, attack4;

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

		progressBar = new JProgressBar();
		progressBar.setBackground(new Color(0, 0, 0));
		progressBar.setForeground(Color.GREEN);
		progressBar.setBounds(6, 236, 255, 20);
		progressBar.setMaximum(c.getMax_health());
		progressBar.setMinimum(0);
		progressBar.setValue(c.getMax_health());
		display.add(progressBar);

		progressBar_1 = new JProgressBar();
		progressBar_1.setBackground(new Color(0, 255, 0));
		progressBar_1.setForeground(Color.GREEN);
		progressBar_1.setBounds(239, 57, 255, 20);
		progressBar_1.setMaximum(next_villain.getMax_health());
		progressBar_1.setMinimum(0);
		progressBar_1.setValue(next_villain.getMax_health());
		display.add(progressBar_1);

		JLabel character_img = new JLabel("");
		ImageIcon image = new ImageIcon("images/TheDinosaur.png");
		character_img.setIcon(image);
		character_img.setBounds(81, 73, 78, 108);
		display.add(character_img);

		JLabel label = new JLabel(next_villain.getName());
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(239, 17, 243, 16);
		display.add(label);

		JLabel label_1 = new JLabel(c.getName());
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setBounds(18, 177, 243, 16);
		display.add(label_1);
		label_1.setForeground(new Color(255, 255, 255));

		eTxtLbl = new JLabel();
		eTxtLbl.setText(next_villain.getHealth() + "/" + next_villain.getMax_health());
		eTxtLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		eTxtLbl.setForeground(Color.WHITE);
		eTxtLbl.setBounds(386, 40, 95, 16);
		display.add(eTxtLbl);

		pTxtLbl = new JLabel();
		pTxtLbl.setText(c.getHealth() + "/" + c.getMax_health());
		pTxtLbl.setHorizontalAlignment(SwingConstants.LEFT);
		pTxtLbl.setForeground(Color.WHITE);
		pTxtLbl.setBounds(18, 205, 95, 16);
		display.add(pTxtLbl);

		JPanel controls = new JPanel();
		controls.setBackground(new Color(245, 245, 245));
		controls.setBounds(0, 321, 500, 179);
		add(controls);
		controls.setLayout(null);

		// Pass in attack names
		current_attacks = c.getAttack_list();

		attack1 = new JButton(current_attacks[0]);
		attack1.setBounds(33, 92, 171, 29);
		attack1.addActionListener(new ButtonListener());
		controls.add(attack1);

		attack2 = new JButton(current_attacks[1]);
		attack2.setBounds(33, 133, 171, 29);
		attack2.addActionListener(new ButtonListener());
		controls.add(attack2);

		attack3 = new JButton(current_attacks[2]);
		attack3.setBounds(295, 92, 171, 29);
		attack3.addActionListener(new ButtonListener());
		controls.add(attack3);

		attack4 = new JButton(current_attacks[3]);
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
		updateBattlePanel();
	}

	//place all things that should be updated here
	public void updateBattlePanel() {
		current_attacks = c.getAttack_list();
		attack1.setText(current_attacks[0]);
		attack2.setText(current_attacks[1]);
		attack3.setText(current_attacks[2]);
		attack4.setText(current_attacks[3]);
		pTxtLbl.setText(c.getHealth() + "/" + c.getMax_health());
		
	}

	public boolean isBattleEnabled() {
		return battle_enabled;
	}

	public void setBattleEnabled(boolean b) {
		battle_enabled = b;
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
				lblHitProbability.setText(String.format("Hit Probability: %.2f",
						battle_controller.calculateHitProbability(c, next_villain)));

				progressBar.setValue(c.getHealth());
				System.out.println(c.getHealth());
				progressBar_1.setValue(next_villain.getHealth());
				System.out.println(next_villain.getHealth());
				pTxtLbl.setText(c.getHealth() + "/" + c.getMax_health());
				eTxtLbl.setText(next_villain.getHealth() + "/" + next_villain.getMax_health());

				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (next_villain.getHealth() <= 0) {
					System.out.println("Enemy died, added 10 puffs");
					// Change player stats
					c.setPuffs(c.getPuffs() + 10);
					c.setAtt_points(c.getAtt_points() + 2);
					c.setExperience(c.getExperience() + 10);
					c.checkLevel();
					c.resetHealth();
					battle_controller.next_level();
					next_villain = battle_controller.getCharacter();

					// wat
					for (java.awt.Component jc : enemy_name.getComponents()) {
						if (jc instanceof JLabel) {
							((JLabel) jc).setText(next_villain.getName());
						}
					}

					setBattleEnabled(false);
					JLabel lbl = (JLabel) enemy_name.getComponent(0);
					lbl.setText(next_villain.getName());
				} else {
					battle_controller.attack(next_villain, c, next_villain.getRandomAttack());
				}
				if (c.getHealth() <= 0) {
					System.out.println("Player died what to do now");
					c.resetHealth();
					next_villain.resetHealth();
					setBattleEnabled(false);
				}
			} else {
				lblSelectedMove.setText("Selected Move: " + button.getText());
				lblMoveCost.setText("Move Cost: " + Character.getAttackValue(button.getText()));
				lblDamage.setText("Damage: " + Character.getAttackStrength(button.getText()));
			}

		}
	}
}
