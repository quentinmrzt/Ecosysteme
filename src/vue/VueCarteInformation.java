package vue;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import modele.Carte;

public class VueCarteInformation extends JPanel {
	private VueCarte vueCarte;
	
	public VueCarteInformation(Carte carte) {
		this.setPreferredSize(new Dimension(600, 600));
		
		this.setBorder(BorderFactory.createTitledBorder("Carte"));
		this.setBackground(Color.WHITE);
		
		this.vueCarte = new VueCarte(carte);
		this.add(this.vueCarte);
	}
}
