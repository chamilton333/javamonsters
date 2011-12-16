import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUIrunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Game theGame=new Game();
		GUI theGUI=new GUI(theGame);
		System.out.println("Gui height: "+theGUI.getPreferredSize().height); //DEBUG
	}
	


}

