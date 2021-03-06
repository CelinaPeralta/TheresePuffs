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
	Stats_Panel stats_panel = new Stats_Panel(c);
	Shop_Panel shop_panel = new Shop_Panel(c);
	Win_Panel win_panel = new Win_Panel();

	static CardLayout layout = new CardLayout();
	static JPanel cardPanel = new JPanel(layout);

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
		cardPanel.add(shop_panel, "SHOP");
		cardPanel.add(win_panel, "WIN");

		JFrame frame = new JFrame();
		frame.setSize(500, 550);
		frame.setResizable(false);
		frame.add(cardPanel);
		frame.add(buttonsPanel, BorderLayout.SOUTH);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	private void updatePanels() {

		cardPanel.remove(stats_panel);
		cardPanel.remove(shop_panel);
		stats_panel = new Stats_Panel(c);
		shop_panel = new Shop_Panel(c);
		cardPanel.add(stats_panel, "STATS");
		cardPanel.add(shop_panel, "SHOP");
		battle_panel.updateBattlePanel();
		shop_panel.updateShop_panel();
		
	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			String panel_name = "";

			if ("Fight".equals(command)) {
				panel_name = "BATTLE";
			} else if ("Stats".equals(command)) {
				panel_name = "STATS";
			} else if ("Shop".equals(command)) {
				panel_name = "SHOP";
			} else {
				panel_name = "MAIN";
			}
			updatePanels();
			layout.show(cardPanel, panel_name);

		}
	}

	public static void main(String[] args) {

		CHARACTER_NAME = JOptionPane.showInputDialog("Enter a character name: ");
		c = new Character(CHARACTER_NAME);

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Master_Frame frame = new Master_Frame();
				if(frame.battle_panel.battle_controller.getCurrentLevel() > 9){
					frame.layout.show(cardPanel, "WIN");
				}
			}
		});

	}

}
