import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import javax.swing.JSplitPane;

public class Battle_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public Battle_Panel() {
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
		
		JButton attack1 = new JButton("New Button");
		attack1.setBounds(30, 37, 117, 29);
		controls.add(attack1);
		
		JButton attack2 = new JButton("New button");
		attack2.setBounds(30, 92, 117, 29);
		controls.add(attack2);
		
		JButton attack3 = new JButton("New button");
		attack3.setBounds(360, 37, 117, 29);
		controls.add(attack3);
		
		JButton attack4 = new JButton("New button");
		attack4.setBounds(360, 92, 117, 29);
		controls.add(attack4);
	}
	
	public class AddButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			//pass in move name then do things
			
		}
	}
}
