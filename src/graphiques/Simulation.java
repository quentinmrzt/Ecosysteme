package graphiques;

import java.awt.Dimension;

import javax.swing.JFrame;

import elements.*;

public class Simulation extends JFrame {
	public Simulation() {
		super("Simulation de l'Ecosysteme");
		
		setPreferredSize(new Dimension(800, 400));
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);

		// MONDE
	    //Monde monde = new Monde(10,10);
		
		// MENU
		//Menu menu = new Menu(monde);
		//this.setJMenuBar(menu);
		
		// ON MET A JOUR
		//monde.maj();
		
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Simulation();
	}
}
