package vue;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import modele.Calendrier;
import modele.Carte;

public class Fenetre extends JFrame {
	private VueCarteInformation vueCarteInformation;
	private VueHorloge vueHorloge;
	
	public Fenetre(Carte carte, Calendrier calendrier) {
		this.setPreferredSize(new Dimension(900, 600));
		this.setTitle("Graphique");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		this.setLayout(new FlowLayout());
		
		// Panneau
		this.vueCarteInformation = new VueCarteInformation(carte);
		this.add(vueCarteInformation);
		
		this.vueHorloge = new VueHorloge(calendrier);
		this.add(vueHorloge);

		pack();
		this.setVisible(true);
	}
}
