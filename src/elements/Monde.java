package elements;

import java.util.ArrayList;

import vivant.Troupeau;

public class Monde {
	protected Carte carte;
	protected ArrayList<Troupeau> troupeaux;
	
	public Monde(int x, int y) {
		carte = new Carte(x,y);
	}
	
	public String toString() {
		return carte.toString();
	}
}
