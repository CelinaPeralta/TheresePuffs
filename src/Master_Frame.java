import javax.swing.*;
import java.awt.*;

/**
 * Created by celinaperalta on 12/30/16.
 */
public class Master_Frame extends JFrame {

    Main_Panel main_panel = new Main_Panel();

    public Master_Frame() {

        //need a battle panel**
        //main panel (options, exit, stats)
        //upgrade panel
        //ugh how to switch between panels lol
    	setTitle("Danny the Dinosaur");
		setSize(500, 500);
        setLayout(new BorderLayout());
        add(main_panel, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {

        Master_Frame frame = new Master_Frame();

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
