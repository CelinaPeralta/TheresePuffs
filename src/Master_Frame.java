import java.awt.CardLayout;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Created by celinaperalta on 12/30/16.
 */
public class Master_Frame extends JFrame {
	
	//Implement a card layout?
	
	private static String CHARACTER_NAME;
	private static Character c;
    Main_Panel main_panel;
    Battle_Panel test = new Battle_Panel(c);
   

    public Master_Frame() {

        //need a battle panel**
        //main panel (options, exit, stats)
        //upgrade panel
        //ugh how to switch between panels lol
    	//http://stackoverflow.com/questions/21422431/switching-between-jpanels-in-a-jframe
    	//ayy lmao .show
    	setTitle("Danny the Dinosaur");
		setSize(500, 500);
		setLayout(new CardLayout());
		
		initComponents();

    }
    
    private void initComponents(){
    	//how to card layout
    	 main_panel = new Main_Panel();
    }

    public static void main(String[] args) {

    	CHARACTER_NAME = JOptionPane.showInputDialog("Enter a character name: ");
    	c = new Character(CHARACTER_NAME);
    	
        Master_Frame frame = new Master_Frame();
        
        //switching code here? or in each panel?

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
