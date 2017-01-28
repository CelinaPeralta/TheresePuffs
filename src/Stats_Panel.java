import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class Stats_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	JComboBox atts, move1, move2, move3, move4;
	JLabel lblAttPts, lblHealth, lblAgility, lblAccuracy, lblAttack, lblExp, lblPuffs, lblLevel;
	Character c;

	public Stats_Panel(Character c) {
		this.c = c;
		setSize(500, 500);
		setLayout(null);

		JLabel name = new JLabel(c.getName());
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(155, 35, 186, 16);
		add(name);

		lblAttPts = new JLabel("Attribute Points: " + c.getAtt_points());
		lblAttPts.setBounds(36, 177, 186, 16);
		add(lblAttPts);

		lblHealth = new JLabel("Health: " + c.getHealth());
		lblHealth.setHorizontalAlignment(SwingConstants.LEFT);
		lblHealth.setBounds(36, 211, 186, 16);
		add(lblHealth);

		lblAgility = new JLabel("Agility: " + c.getAgility());
		lblAgility.setHorizontalAlignment(SwingConstants.LEFT);
		lblAgility.setBounds(36, 239, 186, 16);
		add(lblAgility);

		lblAccuracy = new JLabel("Accuracy: " + c.getAccuracy());
		lblAccuracy.setHorizontalAlignment(SwingConstants.LEFT);
		lblAccuracy.setBounds(36, 299, 186, 16);
		add(lblAccuracy);

		lblAttack = new JLabel("Attack: " + c.getAttack());
		lblAttack.setHorizontalAlignment(SwingConstants.LEFT);
		lblAttack.setBounds(36, 271, 186, 16);
		add(lblAttack);

		lblExp = new JLabel("Experience: " + c.getExperience());
		lblExp.setBounds(36, 102, 156, 16);
		add(lblExp);

		lblPuffs = new JLabel("Puffs: " + c.getPuffs());
		lblPuffs.setBounds(36, 130, 156, 16);
		add(lblPuffs);

		lblLevel = new JLabel("Level: " + c.getLevel());
		lblLevel.setBounds(36, 74, 156, 16);
		add(lblLevel);

		JButton addPt = new JButton("+");
		addPt.setBounds(30, 381, 53, 29);
		addPt.addActionListener(new ButtonListener());
		add(addPt);

		JButton subtractPt = new JButton("-");
		subtractPt.setBounds(84, 381, 53, 29);
		subtractPt.addActionListener(new ButtonListener());
		add(subtractPt);

		atts = new JComboBox();
		atts.setBounds(30, 342, 104, 27);
		atts.addItem("Health");
		atts.addItem("Attack");
		atts.addItem("Agility");
		atts.addItem("Accuracy");
		add(atts);

		JComboBox move1 = new JComboBox();
		move1.setBounds(321, 205, 156, 27);
		for (String s : c.getAllAttacks())
			move1.addItem(s);
		move1.setSelectedItem(c.getAttack_list()[0]);
		add(move1);

		JComboBox move2 = new JComboBox();
		move2.setBounds(321, 270, 156, 27);
		for (String s : c.getAllAttacks())
			move2.addItem(s);
		move1.setSelectedItem(c.getAttack_list()[1]);
		add(move2);

		JComboBox move3 = new JComboBox();
		move3.setBounds(321, 322, 156, 27);
		for (String s : c.getAllAttacks())
			move3.addItem(s);
		move1.setSelectedItem(c.getAttack_list()[2]);
		add(move3);

		JComboBox move4 = new JComboBox();
		move4.setBounds(321, 381, 156, 27);
		for (String s : c.getAllAttacks())
			move4.addItem(s);
		move1.setSelectedItem(c.getAttack_list()[3]);
		add(move4);

		JLabel lblMove = new JLabel("Move 1:");
		lblMove.setBounds(248, 209, 61, 16);
		add(lblMove);
		

		JLabel lblMove_1 = new JLabel("Move 2:");
		lblMove_1.setBounds(248, 269, 61, 16);
		add(lblMove_1);

		JLabel lblMove_2 = new JLabel("Move 3:");
		lblMove_2.setBounds(248, 326, 61, 16);
		add(lblMove_2);

		JLabel lblMove_3 = new JLabel("Move 4:");
		lblMove_3.setBounds(248, 385, 61, 16);
		add(lblMove_3);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(192, 435, 117, 29);
		add(btnSave);

	}
	
	private void updateLabels(){
		lblAttPts.setText("Attribute Points: " + c.getAtt_points());;
		lblHealth.setText("Health: " + c.getMax_health());
		lblAgility.setText("Agility: " + c.getAgility()); 
		lblAccuracy.setText("Accuracy: " + c.getAccuracy());
		lblAttack.setText("Attack: " + c.getAttack()); 
		lblExp.setText("Experience: " + c.getExperience()); 
		lblPuffs.setText("Puffs: " + c.getPuffs()); 
		lblLevel.setText("Level: " + c.getLevel());
		
	}

	public class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// pass in move name then do things
			JButton button = (JButton) e.getSource();

			if (button.getText() == "+" && c.getAtt_points() > 0) {
				if (atts.getSelectedItem() == "Health") {
					c.setMax_health(c.getMax_health() + 10);
				}
				if (atts.getSelectedItem() == "Attack") {
					c.setAttack(c.getAttack() + 5);
				}
				if (atts.getSelectedItem() == "Agility") {
					c.setAgility(c.getAgility() + 5);
				}
				if (atts.getSelectedItem() == "Accuracy") {
					c.setAccuracy(c.getAccuracy() + 5);
				}
				c.setAtt_points(c.getAtt_points() - 1);
				System.out.println(c.getAtt_points());
				updateLabels();
			}
			if (button.getText() == "-") {
				if (atts.getSelectedItem() == "Health" && c.getMax_health() - 10 >= 100) {
					c.setMax_health(c.getMax_health() - 10);
					c.setAtt_points(c.getAtt_points() + 1);
				}
				if (atts.getSelectedItem() == "Attack" && c.getAttack() - 5 >= 10) {
					c.setAttack(c.getAttack() - 5);
					c.setAtt_points(c.getAtt_points() + 1);
				}
				if (atts.getSelectedItem() == "Agility" && c.getAgility() - 5 >= 10) {
					c.setAgility(c.getAgility() - 5);
					c.setAtt_points(c.getAtt_points() + 1);
				}
				if (atts.getSelectedItem() == "Accuracy" && c.getAccuracy() - 5 >= 50) {
					c.setAccuracy(c.getAccuracy() - 5);
					c.setAtt_points(c.getAtt_points() + 1);
				}
				System.out.println(c.getAtt_points());
				updateLabels();
			}
			
			if (button.getText() == "Save") {
				c.clearAttack_list();
				c.addAttack((String)move1.getSelectedItem(), 0);
				c.addAttack((String)move2.getSelectedItem(), 1);
				c.addAttack((String)move3.getSelectedItem(), 2);
				c.addAttack((String)move4.getSelectedItem(), 3);
			}

		}
	}
}
