package vivant;

import java.util.ArrayList;
import java.util.Collections;

public class Troupeau {
	protected int nombre;
	ArrayList<Animal> animaux;
	
	public Troupeau() {
		nombre = 0;
		animaux = new ArrayList<Animal>();
	}
	
	public void addAnimal(Animal a) {
		// Pas d'animaux différent dans le même troupeau
		if (nombre!=0 && !getAnimal(0).toString().equals(a.toString())) {
			System.err.println("Erreur: l'animal est différent du troupeau !");
			return;
		}
		
		animaux.add(a);
		nombre++;
	}
	
	public Animal getAnimal(int i) {
		return animaux.get(i);
	}

	public ArrayList<Animal> getAnimaux() {
		return animaux;
	}
	
	public void maj() {
		ArrayList<Integer> mort = new ArrayList<Integer>();
		int i=0;
		
		for (Animal a: animaux) {
			a.maj();
			// si un animal est mort
			if (a.getVie() <= 0) {
				mort.add(i);
			}
			i++;
		}
		
		// On inverse pour ne pas avoir de décallage
		Collections.reverse(mort);
		for (int test: mort) {
			System.out.println("Un "+animaux.get(test).toString()+" est mort.");
			animaux.remove(test);
		}
	}
}
