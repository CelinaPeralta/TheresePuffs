import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Created by celinaperalta on 12/30/16.
 */
public class Master_Frame extends JFrame {

	// Implement a card layout?

	private static String CHARACTER_NAME;
	private static Character c;

	Main_Panel main_panel = new Main_Panel();
	Battle_Panel battle_panel = new Battle_Panel(c);
	Stats_Panel stats_panel = new Stats_Panel();

	CardLayout layout = new CardLayout();
	JPanel cardPanel = new JPanel(layout);

	public Master_Frame() {

		JButton main_button = new JButton("Main");
		JButton fight_button = new JButton("Fight");
		JButton shop_button = new JButton("Shop");
		JButton stats_button = new JButton("Stats");
		JPanel buttonsPanel = new JPanel();
		
		buttonsPanel.add(main_button);
		buttonsPanel.add(fight_button);
		buttonsPanel.add(shop_button);
		buttonsPanel.add(stats_button);
		
		fight_button.addActionListener(new ButtonListener());
		shop_button.addActionListener(new ButtonListener());
		stats_button.addActionListener(new ButtonListener());
		main_button.addActionListener(new ButtonListener());

		cardPanel.add(main_panel, "MAIN");
		cardPanel.add(battle_panel, "BATTLE");
		cardPanel.add(stats_panel, "STATS");

		JFrame frame = new JFrame();
		frame.setSize(500, 550);
		frame.add(cardPanel);
		frame.add(buttonsPanel, BorderLayout.SOUTH);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if ("Fight".equals(command)) {
				layout.show(cardPanel, "BATTLE");
			} else if ("Stats".equals(command)) {
				layout.show(cardPanel, "STATS");
			} else if ("Shop".equals(command)) {
				System.out.println("Make the shop");
			} else {
				layout.show(cardPanel, "MAIN");
			}
		}
	}

	public static void main(String[] args) {

		CHARACTER_NAME = JOptionPane.showInputDialog("Enter a character name: ");
		c = new Character(CHARACTER_NAME);

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Master_Frame testCardLayout = new Master_Frame();
			}
		});

	}

}
