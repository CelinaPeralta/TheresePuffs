import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Main_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	private String NAV_PANEL = "";

	public Main_Panel() {

		setBackground(new Color(255, 255, 255));

		setSize(500, 500);
		setLayout(null);

		JLabel titleText = new JLabel("Danny the Dinosaur: The Quest for Thereese's Puffs");
		titleText.setBounds(0, 1, 500, 66);
		titleText.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleText);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(0, 145, 500, 185);
		ImageIcon i = new ImageIcon("images/Jay-theCoverphoto.png");
		lblNewLabel.setIcon(i);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(0, 433, 500, 66);
		panel.setBackground(new Color(255, 255, 255));
		add(panel);
		panel.setLayout(new GridLayout(1, 3, 0, 0));

	}

	public String getNav() {
		return NAV_PANEL;
	}



}
