package vivant;

import elements.Carte;

/*
 * Mouton:
 * Dur�e de vie: 10 � 12 ans mais jusqu'� 20 ans
 * Alimentation: 1.5 � 2kg d'herbe par jour
 * 1 hectare: 7 � 8 moutons
 */
public class Mouton extends Animal {

	public Mouton(int x, int y) {
		super(x,y);

		vie = 10;
		nourriture = 10;
		eau = 10;
		viande = 10;
		energie = vie;
	}

	public String toString() {
		return "M";
	}

	public void manger(Carte carte) {
		if (nourriture>0 && !carte.getTerrain(posX, posY).broute()) {
			nourriture--;
		}
	}
}
