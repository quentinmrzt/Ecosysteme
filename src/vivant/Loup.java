package vivant;

import elements.Carte;

/*
 * Loup:
 * Hauteur au garrot: M�le: 60 � 90cm / Femelle: 64cm
 * Poids: M�le: 30 � 40kg / Femelle: 25 � 28 kg
 * Dur�e de vie: 5 � 6 ans mais jusqu'� 13 ans
 * Alimentation: 1.5 � 2.5 kg de viande
 * Survie: 2 � 3 semaines sans manger
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
