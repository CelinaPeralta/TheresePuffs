import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Win_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public Win_Panel() {
		setBackground(Color.WHITE);
		setSize(500, 500);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("congrats you won therese got her puffs back");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 171, 488, 158);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("a game by Celina Peralta and Anand Shetler");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(47, 362, 405, 31);
		add(lblNewLabel_1);

	}

}
