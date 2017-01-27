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

public class Battle_Panel extends JPanel {
	
	private Character c;

	/**
	 * Create the panel.
	 */
	public Battle_Panel(Character c) {
		
		this.c = c;
		
		setBackground(new Color(255, 255, 255));

		setSize(500, 500);
		setLayout(null);
		
		JPanel display = new JPanel();
		display.setBounds(0, 0, 500, 321);
		add(display);
		display.setLayout(null);
		
		JPanel controls = new JPanel();
		controls.setBounds(0, 321, 500, 179);
		add(controls);
		controls.setLayout(null);
		
		//Pass in attack names
		String[] current_attacks = c.getAttack_list();
		
		JButton attack1 = new JButton(current_attacks[0]);
		attack1.setBounds(30, 37, 171, 29);
		attack1.addActionListener(new AddButtonListener());
		controls.add(attack1);
		
		JButton attack2 = new JButton(current_attacks[1]);
		attack2.setBounds(30, 92, 171, 29);
		attack2.addActionListener(new AddButtonListener());
		controls.add(attack2);
		
		JButton attack3 = new JButton(current_attacks[2]);
		attack3.setBounds(306, 37, 171, 29);
		attack3.addActionListener(new AddButtonListener());
		controls.add(attack3);
		
		JButton attack4 = new JButton(current_attacks[3]);
		attack4.setBounds(306, 92, 171, 29);
		attack4.addActionListener(new AddButtonListener());
		controls.add(attack4);
	}
	
	public class AddButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			//pass in move name then do things
			JButton button = (JButton)e.getSource();
			
			//delete this later
			System.out.println(c.getAttackValue(button.getText()));
			
			
		}
	}
}
