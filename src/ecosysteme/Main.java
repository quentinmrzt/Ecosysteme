package ecosysteme;

import modele.Calendrier;
import modele.Carte;
import modele.Temps;
import vue.Fenetre;

public class Main {
	public static void main(String[] args) {
		Carte carte = new Carte(30,20);
		Calendrier calendrier = new Calendrier();
		calendrier.addObserver(carte);
		
		new Fenetre(carte, calendrier);
		new Temps(calendrier);
	}
}
