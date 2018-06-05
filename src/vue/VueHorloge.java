package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import modele.Calendrier;

public class VueHorloge extends JPanel implements Observer {
	private int largeur, hauteur;
	private int heure, heureMax;
	private Calendrier calendrier;

	public VueHorloge(Calendrier calendrier) {
		this.heure = 0;
		this.heureMax = 24;

		this.largeur = 200;
		this.hauteur = 200;

		this.calendrier = calendrier;
		this.calendrier.addObserver(this);

		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(largeur, hauteur));
	}

	public int getLargeur() { return this.largeur; }
	public int getHauteur() { return this.hauteur; }
	public int getHeure() { return this.heure; }
	public int getHeureMax() { return this.heureMax; }

	public void paint(Graphics g) {
		super.paint(g);

		int centreX = this.largeur/2;
		int centreY = this.hauteur/2;
		int rayon = Math.min(centreX, centreY)*80/100;

		double angle = (this.calendrier.getHeure()*((Math.PI)/(24/2))-(Math.PI/2.0));
		int x = centreX + (int)(0.7*rayon*Math.cos(angle));
		int y = centreY + (int)(0.7*rayon*Math.sin(angle));

		g.drawLine(centreX, centreY, x, y);
	}

	public void update(Observable o, Object arg) {
		this.repaint();
	}
}
