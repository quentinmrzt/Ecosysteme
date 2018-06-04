package vue;

import java.awt.Dimension;

import javax.swing.JFrame;

import modele.Carte;

public class Fenetre extends JFrame {
	private VueCarte vueCarte;
	
	public Fenetre(Carte carte) {
		this.setPreferredSize(new Dimension(600, 600));
		this.setTitle("Graphique");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		// Panneau
		this.vueCarte = new VueCarte(carte);
		this.add(vueCarte);

		pack();
		this.setVisible(true);
	}
}
