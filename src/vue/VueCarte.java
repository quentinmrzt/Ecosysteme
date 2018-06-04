package vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import modele.Carte;
import modele.Case;
import modele.Herbe;

public class VueCarte extends JPanel implements Observer {
	private int largeur, hauteur;
	private Carte carte;
	private VueHerbe herbe;

	public VueCarte(Carte carte) {
		this.herbe = new VueHerbe();
		this.carte = carte;
		
		this.largeur = this.carte.getTailleX()*this.herbe.getTaille();
		this.hauteur = this.carte.getTailleY()*this.herbe.getTaille();
		
		this.setPreferredSize(new Dimension(largeur, hauteur));
	}
	
	public void paint(Graphics g) {
		super.paint(g);

		this.dessinerCarte(g);
	}
	
	private void dessinerCarte(Graphics g) {
		for (int x=0 ; x<this.carte.getTailleX() ; x++) {
			for (int y=0 ; y<this.carte.getTailleY() ; y++) {
				int positionX = x*this.herbe.getTaille();
				int positionY = y*this.herbe.getTaille();
				
				Case caseTmp = this.carte.getCase(x, y);
				
				if(caseTmp instanceof Herbe) {
					g.drawImage(herbe.getImage(caseTmp.getEtat()), positionX, positionY, this);
				} else {
					System.out.println("Autre");
				}
			}
		}
	}

	public void update(Observable arg0, Object arg1) {
		System.out.println("REPAINT = VueCarte");

		this.repaint();
		
	}
	
	
}
