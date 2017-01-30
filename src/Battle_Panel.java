import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultCaret;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Battle_Panel extends JPanel {

	Battle_Controller battle_controller = new Battle_Controller();

	private Character c;
	private JLabel lblDie, lblSum, lblDie2, lblHitProbability, lblSelectedMove, lblMoveCost, lblDamage, eTxtLbl,
			pTxtLbl, lblCurrentLevel, label, label_1;
	private JPanel player_name, enemy_name;
	private JButton btnNewButton;
	private JProgressBar progressBar, progressBar_1;
	private String[] current_attacks;

	private Character next_villain;
	private JButton attack1, attack2, attack3, attack4;
	private JLabel winLabel;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public Battle_Panel(Character c) {

		this.c = c;
		setVillain();

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
		progressBar.setBounds(6, 236, 230, 20);
		progressBar.setMaximum(c.getMax_health());
		progressBar.setMinimum(0);
		progressBar.setValue(c.getMax_health());
		display.add(progressBar);

		progressBar_1 = new JProgressBar();
		progressBar_1.setBackground(new Color(0, 255, 0));
		progressBar_1.setForeground(Color.GREEN);
		progressBar_1.setBounds(251, 57, 243, 20);

		progressBar_1.setMinimum(0);

		display.add(progressBar_1);

		JLabel character_img = new JLabel("");
		ImageIcon image = new ImageIcon("images/TheDinosaur.png");
		character_img.setIcon(image);
		character_img.setBounds(81, 73, 78, 108);
		display.add(character_img);

		label = new JLabel(next_villain.getName());
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(239, 17, 243, 16);
		display.add(label);

		label_1 = new JLabel(c.getName());
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setBounds(18, 177, 243, 16);
		label_1.setForeground(new Color(255, 255, 255));
		display.add(label_1);

		eTxtLbl = new JLabel();

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

		lblCurrentLevel = new JLabel("Level " + battle_controller.getCurrentLevel());
		lblCurrentLevel.setForeground(Color.WHITE);
		lblCurrentLevel.setBounds(18, 17, 61, 16);
		display.add(lblCurrentLevel);

		winLabel = new JLabel("");
		winLabel.setHorizontalAlignment(SwingConstants.CENTER);
		winLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		winLabel.setForeground(Color.WHITE);
		winLabel.setBounds(200, 128, 95, 32);
		winLabel.setVisible(false);
		display.add(winLabel);

		textArea = new JTextArea();
		DefaultCaret caret = (DefaultCaret) textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.OUT_BOTTOM);

		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		textArea.setRows(100);
		textArea.setLineWrap(true);
		textArea.setAutoscrolls(true);

		// textArea.setBounds(251, 177, 243, 79);
		// display.add(textArea);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(248, 197, 246, 59);
		scrollPane.add(textArea);
		scrollPane.setViewportView(textArea);
		scrollPane.setBorder(null);
		scrollPane.setFocusable(false);
		display.add(scrollPane);

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

		progressBar_1.setMaximum(next_villain.getMax_health());
		progressBar_1.setValue(next_villain.getHealth());
		eTxtLbl.setText(next_villain.getHealth() + "/" + next_villain.getMax_health());

		updateBattlePanel();

	}

	public void setVillain() {
		if (battle_controller.getCurrentLevel() == battle_controller.LEVELS) {
			System.out.println("we gettin a bossman");
			next_villain = battle_controller.getBoss(c);
		} else {
			System.out.println("we gettin a regular guy");
			next_villain = battle_controller.getVillain();
		}

	}

	// place all things that should be updated here
	public void updateBattlePanel() {
		textArea.setText("");
		current_attacks = c.getAttack_list();
		attack1.setText(current_attacks[0]);
		attack2.setText(current_attacks[1]);
		attack3.setText(current_attacks[2]);
		attack4.setText(current_attacks[3]);
		pTxtLbl.setText(c.getHealth() + "/" + c.getMax_health());

		lblCurrentLevel.setText("Level " + battle_controller.getCurrentLevel());
		if (!battle_controller.isBattleEnabled()) {
			battle_controller.setBattleEnabled(true);

			label.setText(next_villain.getName());

			progressBar_1.setMaximum(next_villain.getMax_health());
			progressBar_1.setValue(next_villain.getHealth());
			eTxtLbl.setText(next_villain.getHealth() + "/" + next_villain.getMax_health());
			progressBar.setValue(c.getHealth());
			progressBar.setMaximum(c.getMax_health());

			winLabel.setVisible(false);
		}

	}

	public void printAttackResult(String attacker, String attackee, int a) {

		String t = "";
		if (a == 1) {
			t = attacker + " hit " + attackee + "\n";
		} else if (a == 0) {
			t = attacker + " missed " + attackee + "\n";
		} else {
			t = attacker + " could not cast attack.\n";
		}

		textArea.append(t);
	}

	public class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// pass in move name then do things
			JButton button = (JButton) e.getSource();

			if (battle_controller.isBattleEnabled()) {
				if (button.getText().equals("Attack!")) {

					// Attack
					printAttackResult(c.getName(), next_villain.getName(), battle_controller.attack(c, next_villain,
							lblSelectedMove.getText().substring("Selected Move: ".length())));

					// Set dice labels
					lblDie.setText("  Roll 1: " + Integer.toString(battle_controller.getRoll1()));
					lblDie2.setText("  Roll 2: " + Integer.toString(battle_controller.getRoll2()));
					lblSum.setText("Sum: " + Integer.toString(battle_controller.getTotal()));
					lblHitProbability.setText(String.format("Hit Probability: %.2f",
							battle_controller.calculateHitProbability(c, next_villain)));

					// Set health bars
					progressBar.setValue(c.getHealth());
					progressBar_1.setValue(next_villain.getHealth());

					// Set health label
					pTxtLbl.setText(c.getHealth() + "/" + c.getMax_health());
					eTxtLbl.setText(next_villain.getHealth() + "/" + next_villain.getMax_health());

					if (next_villain.getHealth() <= 0) {
						// Change player stats
						c.setPuffs(c.getPuffs() + 10);
						c.setAtt_points(c.getAtt_points() + 2);
						c.setExperience(c.getExperience() + 10);
						c.checkLevel();
						c.resetHealth();
						battle_controller.next_level();
						setVillain();
						battle_controller.setBattleEnabled(false);
						winLabel.setVisible(true);
						winLabel.setText("VICTORY!");
					} else {
						printAttackResult(next_villain.getName(), c.getName(),
								battle_controller.attack(next_villain, c, next_villain.getRandomAttack()));
					}
					if (c.getHealth() <= 0) {
						c.resetHealth();
						next_villain.resetHealth();
						battle_controller.setBattleEnabled(false);
						winLabel.setText("DEFEAT!");
						winLabel.setVisible(true);
					}
				} else {
					lblSelectedMove.setText("Selected Move: " + button.getText());
					lblMoveCost.setText("Move Cost: " + Character.getAttackValue(button.getText()));
					lblDamage.setText("Damage: " + Character.getAttackStrength(button.getText()));
				}

			} else {
				System.out.println("battle not enabled");
			}
		}
	}
}
