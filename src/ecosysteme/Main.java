package ecosysteme;

import modele.Carte;
import vue.Fenetre;

public class Main {
	public static void main(String[] args) {
		Carte carte = new Carte(20,20);
		
		new Fenetre(carte);
	}	
}
