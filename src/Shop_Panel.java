import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Shop_Panel extends JPanel {

	/**
	 * Create the panel.
	 * 
	 * @param c
	 */

	JLabel lblDie, lblDie_1, lblDie_2, lblPuffs, lblPuffsWon, label;
	Character c;
	DefaultListModel listModel;
	JList list;
	ImageIcon d1, d2, d3;
	String[] dice = new String[]{"","die1.png","die2.png","die3.png","die4.png","die5.png","die6.png"};
	private JLabel die1icon;
	private JLabel die2icon;
	private JLabel die3icon;

	public Shop_Panel(final Character c) {
		this.c = c;
		setSize(500, 500);
		setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		// add(panel);
		panel.setLayout(null);

		JLabel lblAttacks = new JLabel("Purchase Attacks");
		lblAttacks.setForeground(Color.WHITE);
		lblAttacks.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttacks.setBounds(118, 110, 250, 16);
		panel.add(lblAttacks);

		JButton button_2 = new JButton("Buy" + "");
		button_2.setBackground(Color.WHITE);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list.getSelectedIndex();
				if (c.getPuffs() >= 100) {
					c.setPuffs(c.getPuffs() - 100);
					c.purchaseAttack(listModel.getElementAt(index).toString());
					listModel.remove(index);
					listModel.clear();
					for (String s : c.getAllAttacks()) {
						if (!c.getPurchasedAttacks().contains(s) && !listModel.contains(s))
							listModel.addElement(s);// update list
					}

					lblPuffs.setText("Puffs: " + c.getPuffs());

				}
			}
		});
		button_2.setBounds(185, 366, 117, 29);
		panel.add(button_2);

		listModel = new DefaultListModel();

		list = new JList(listModel);
		list.setBorder(null);
		list.setBackground(Color.WHITE);
		list.setForeground(Color.BLACK);
		list.setBounds(63, 148, 117, 179);
		// panel.add(list);

		JLabel lblCost = new JLabel("Cost: 100");
		lblCost.setForeground(Color.WHITE);
		lblCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblCost.setBounds(118, 338, 250, 16);
		panel.add(lblCost);

		lblPuffs = new JLabel("Puffs:");
		lblPuffs.setForeground(Color.WHITE);
		lblPuffs.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuffs.setBounds(118, 72, 250, 16);
		panel.add(lblPuffs);
		lblPuffs.setFont(new Font("Lucida Grande", Font.PLAIN, 16));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		scrollPane.setBounds(133, 138, 214, 179);
		panel.add(scrollPane);

		JLabel lblNewLabel_1 = new JLabel("PUFF MART");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Mishafi Gold", Font.PLAIN, 23));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(118, 23, 250, 50);
		panel.add(lblNewLabel_1);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.add(panel);
		add(tabbedPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		// add(panel_1);
		panel_1.setLayout(null);

		JButton btnGamble = new JButton("Gamble");
		btnGamble.setBounds(181, 366, 117, 29);
		btnGamble.addActionListener(new ButtonListener());
		panel_1.add(btnGamble);

		lblDie = new JLabel("Die 1:");
		lblDie.setHorizontalAlignment(SwingConstants.CENTER);
		lblDie.setBounds(67, 163, 70, 16);
		panel_1.add(lblDie);

		lblDie_1 = new JLabel("Die 2:");
		lblDie_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDie_1.setBounds(204, 163, 70, 16);
		panel_1.add(lblDie_1);

		lblDie_2 = new JLabel("Die 3:");
		lblDie_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDie_2.setBounds(341, 163, 70, 16);
		panel_1.add(lblDie_2);

		lblPuffsWon = new JLabel("Puffs Won:");
		lblPuffsWon.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuffsWon.setBounds(120, 336, 238, 16);
		panel_1.add(lblPuffsWon);

		JLabel lblNewLabel = new JLabel("PUFF-O-MATIC");
		lblNewLabel.setFont(new Font("Yuppy SC", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(120, 57, 238, 33);
		panel_1.add(lblNewLabel);
		tabbedPane.add(panel_1);

		label = new JLabel("Puffs: " + c.getPuffs());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label.setBounds(114, 308, 250, 16);
		panel_1.add(label);
		
		die1icon = new JLabel();
		die1icon.setBounds(67, 192, 70, 70);
		panel_1.add(die1icon);
		
		die2icon = new JLabel();
		die2icon.setBounds(204, 192, 70, 70);
		panel_1.add(die2icon);
		
		die3icon = new JLabel();
		die3icon.setBounds(341, 192, 70, 70);
		panel_1.add(die3icon);
		

		updateLabels(new int[] { 0, 0, 0 }, 0);
	}

	public void updateShop_panel() {
		lblPuffs.setText("Puffs: " + c.getPuffs());
		label.setText("Puffs: " + c.getPuffs());
	}

	private void updateLabels(int[] rolls, int puffs_won) {
		lblPuffs.setText("Puffs: " + c.getPuffs());
		lblDie.setText(String.valueOf("Die 1: " + rolls[0]));
		lblDie_1.setText(String.valueOf("Die 2: " + rolls[1]));
		lblDie_2.setText(String.valueOf("Die 3: " + rolls[2]));
		
		
		
		d1 = new ImageIcon("images/"+dice[rolls[0]]);
		d2 = new ImageIcon("images/"+dice[rolls[1]]);
		d3 = new ImageIcon("images/"+dice[rolls[2]]);
		
		
		die1icon.setIcon(d1);
		die2icon.setIcon(d2);
		die3icon.setIcon(d3);
		
		
		
		lblPuffsWon.setText("Puffs Won: " + puffs_won);
		lblPuffs.setText("Puffs: " + c.getPuffs());
		label.setText("Puffs: " + c.getPuffs());
		listModel.clear();
		for (String s : c.getAllAttacks()) {
			if (!c.getPurchasedAttacks().contains(s) && !listModel.contains(s))
				listModel.addElement(s);
		}
		
	}

	public class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (c.getPuffs() >= 10) {
				Random rand = new Random();
				c.setPuffs(c.getPuffs() - 10);
				lblPuffs.setText("Puffs: " + c.getPuffs());
				int[] rolls = { rand.nextInt(6) + 1, rand.nextInt(6) + 1, rand.nextInt(6) + 1 };
				int puffs_won = 0;
				Arrays.sort(rolls);
				if (rolls[0] == rolls[1] && rolls[0] == rolls[2])
					puffs_won = 30;
				else if (rolls[0] == rolls[1] - 1 && rolls[1] == rolls[2] - 1)
					puffs_won = 25;
				else if (rolls[0] == rolls[1] || rolls[1] == rolls[2] || rolls[2] == rolls[0])
					puffs_won = 15;
				c.setPuffs(c.getPuffs() + puffs_won);
				updateLabels(rolls, puffs_won);
			}
		}
	}
}
