package vivant;

import elements.Carte;

/*
 * Loup:
 * Hauteur au garrot: Mâle: 60 à 90cm / Femelle: 64cm
 * Poids: Mâle: 30 à 40kg / Femelle: 25 à 28 kg
 * Durée de vie: 5 à 6 ans mais jusqu'à 13 ans
 * Alimentation: 1.5 à 2.5 kg de viande
 * Survie: 2 à 3 semaines sans manger
 */
public class Loup extends Animal {
	
	public Loup(int x, int y) {
		super(x,y);
		
		vie = 20;
		nourriture = 10;
		eau = 10;
		age = 0;
		viande = 5;
		energie = vie;
	}

	public String toString() {
		return "L";
	}

	public void manger(Carte carte) {
		if (nourriture>0) {
			nourriture--;
		}
	}
}
