import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Shop_Panel extends JPanel {

	/**
	 * Create the panel.
	 * 
	 * @param c
	 */

	JLabel lblDie, lblDie_1, lblDie_2, lblPuffs, lblPuffsWon;
	Character c;

	public Shop_Panel(Character c) {
		this.c = c;
		setSize(500, 500);
		setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(null);

		JButton btnGamble = new JButton("Gamble");
		btnGamble.setBounds(66, 410, 117, 29);
		btnGamble.addActionListener(new ButtonListener());
		panel_1.add(btnGamble);

		lblDie = new JLabel("Die 1:");
		lblDie.setBounds(66, 231, 128, 16);
		panel_1.add(lblDie);

		lblDie_1 = new JLabel("Die 2:");
		lblDie_1.setBounds(66, 259, 128, 16);
		panel_1.add(lblDie_1);

		lblDie_2 = new JLabel("Die 3:");
		lblDie_2.setBounds(66, 290, 128, 16);
		panel_1.add(lblDie_2);

		lblPuffs = new JLabel("Puffs:");
		lblPuffs.setBounds(66, 191, 117, 16);
		panel_1.add(lblPuffs);

		lblPuffsWon = new JLabel("Puffs Won:");
		lblPuffsWon.setBounds(66, 338, 117, 16);
		panel_1.add(lblPuffsWon);
		
		updateLabels(new int[]{0, 0, 0}, 0);
	}

	private void updateLabels(int[] rolls, int puffs_won) {
		lblPuffs.setText("Puffs: " + c.getPuffs());
		lblDie.setText(String.valueOf("Die 1: " + rolls[0]));
		lblDie_1.setText(String.valueOf("Die 2: " + rolls[1]));
		lblDie_2.setText(String.valueOf("Die 3: " + rolls[2]));
		lblPuffsWon.setText("Puffs Won: " + puffs_won);
	}

	public class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Random rand = new Random();
			c.setPuffs(c.getPuffs() - 10);
			lblPuffs.setText("Puffs: " + c.getPuffs());
			int[] rolls = { rand.nextInt(6) + 1, rand.nextInt(6) + 1, rand.nextInt(6) + 1 };
			int puffs_won = 0;
			Arrays.sort(rolls);
			if (rolls[0] == rolls[1] && rolls[0] == rolls[2])
				puffs_won = 75;
			else if (rolls[0] == rolls[1] - 1 && rolls[1] == rolls[2] - 1)
				puffs_won = 50;
			else if (rolls[0] == rolls[1] || rolls[1] == rolls[2] || rolls[2] == rolls[0])
				puffs_won = 25;
			c.setPuffs(c.getPuffs() + puffs_won);
			updateLabels(rolls, puffs_won);
		}
	}
}
