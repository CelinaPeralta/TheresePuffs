import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.ListModel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JList;

public class Shop_Panel extends JPanel {

	/**
	 * Create the panel.
	 * 
	 * @param c
	 */

	JLabel lblDie, lblDie_1, lblDie_2, lblPuffs, lblPuffsWon;
	Character c;
	DefaultListModel listModel;
	JList list;

	public Shop_Panel(final Character c) {
		this.c = c;
		setSize(500, 500);
		setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel);
		panel.setLayout(null);

		JLabel lblAttacks = new JLabel("Attacks");
		lblAttacks.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttacks.setBounds(92, 38, 61, 16);
		panel.add(lblAttacks);

		JButton button_2 = new JButton("Buy"
				+ "");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list.getSelectedIndex();
				if(c.getPuffs() >= 100) {
					c.setPuffs(c.getPuffs()-100);
					c.purchaseAttack(listModel.getElementAt(index).toString());
					listModel.remove(index);
				}
			}
		});
		button_2.setBounds(63, 342, 117, 29);
		panel.add(button_2);

		listModel = new DefaultListModel();
		for(String s : c.getAllAttacks()) {
			if(!c.getPurchasedAttacks().contains(s) && !listModel.contains(s))
				listModel.addElement(s);
		}
		list = new JList(listModel);
		list.setBounds(63, 91, 117, 179);
		panel.add(list);

		JLabel lblCost = new JLabel("Cost: ");
		lblCost.setBounds(63, 304, 117, 16);
		panel.add(lblCost);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
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
		lblDie_2.setBounds(66, 284, 128, 16);
		panel_1.add(lblDie_2);

		lblPuffs = new JLabel("Puffs:");
		lblPuffs.setBounds(66, 131, 117, 16);
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
		lblPuffs.setText("Puffs: "+c.getPuffs());
	}

	public class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(c.getPuffs() >= 10) {
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
}
