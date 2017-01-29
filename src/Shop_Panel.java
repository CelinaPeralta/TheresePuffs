import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Shop_Panel extends JPanel {

	/**
	 * Create the panel.
	 * @param c 
	 */
	public Shop_Panel(Character c) {
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
		panel_1.add(btnGamble);
		
		JLabel lblDie = new JLabel("Die 1:");
		lblDie.setBounds(66, 231, 128, 16);
		panel_1.add(lblDie);
		
		JLabel lblDie_1 = new JLabel("Die 2:");
		lblDie_1.setBounds(66, 259, 128, 16);
		panel_1.add(lblDie_1);
		
		JLabel lblDie_2 = new JLabel("Die 3:");
		lblDie_2.setBounds(66, 290, 128, 16);
		panel_1.add(lblDie_2);
		
		JLabel lblPuffs = new JLabel("Puffs:");
		lblPuffs.setBounds(66, 191, 117, 16);
		panel_1.add(lblPuffs);
		
		JLabel lblPuffsWon = new JLabel("Puffs Won:");
		lblPuffsWon.setBounds(66, 338, 117, 16);
		panel_1.add(lblPuffsWon);
	}

}
