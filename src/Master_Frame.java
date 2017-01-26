import javax.swing.*;
import java.awt.*;

/**
 * Created by celinaperalta on 12/30/16.
 */
public class Master_Frame extends JFrame {
	
	//Implement a card layout?

    Main_Panel main_panel = new Main_Panel();
    Character c = new Character("Bob");
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
        add(test);

    }

    public static void main(String[] args) {

        Master_Frame frame = new Master_Frame();

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
