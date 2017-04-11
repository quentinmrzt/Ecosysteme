package vivant;


/*
 * Mouton:
 * Durée de vie: 10 à 12 ans mais jusqu'à 20 ans
 * Alimentation: 1.5 à 2kg d'herbe par jour
 * 1 hectare: 7 à 8 moutons
 */
public class Mouton extends Animal {

	public Mouton(int x, int y) {
		super(x,y);
		
		vie = 10;
		nourriture = 10;
		eau = 10;
		age = 0;
		energie = vie;
	}

	public String toString() {
		return "M";
	}
}
