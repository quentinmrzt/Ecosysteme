package modele;

import java.util.Observable;
import java.util.Observer;

public class Carte extends Observable implements Observer {
	private int tailleX, tailleY;
	private Case carte[][];

	public Carte(int x, int y) {
		this.tailleX = x;
		this.tailleY = y;

		this.carte = new Case[this.tailleX][this.tailleY];

		this.mettreEnHerbe();
	}

	public int getTailleX() { return this.tailleX; }
	public int getTailleY() { return this.tailleY; }
	public Case getCase(int x, int y) { return this.carte[x][y]; }

	// FONCTION
	private void mettreEnHerbe() {
		for (int x=0 ; x<this.tailleX ; x++) {
			for (int y=0 ; y<this.tailleY ; y++) {
				this.carte[x][y] = new Herbe();
			}
		}
	}
	
	private void unJour() {
		for (int x=0 ; x<this.tailleX ; x++) {
			for (int y=0 ; y<this.tailleY ; y++) {
				this.carte[x][y].evolution();
			}
		}
		
		this.setChanged();
		this.notifyObservers();
	}

	public void update(Observable classe, Object notification) {
		if(classe instanceof Calendrier) {
			String strNotification = (String) notification;
			
			switch (strNotification)
			{
			  case "HEURE":
			    break;
			  case "JOUR":
				  this.unJour();
			    break;  
			  case "MOIS":
			    break;  
			  case "ANNEE":
			    break;            
			}
		}
	}
}
