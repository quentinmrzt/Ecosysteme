package vivant;

import java.util.ArrayList;

public class Troupeau {
	protected int nombre;
	ArrayList<Animal> animaux;
	
	public Troupeau() {
		nombre=0;
		animaux = new ArrayList<Animal>();
	}
	
	public void addAnimal(Animal a) {
		// Pas d'animaux différent dans le même troupeau
		if (nombre!=0 && getAnimal(0).equals(a)) {
			System.err.println("Erreur: l'animal est différent du troupeau !");
			return;
		}
		
		animaux.add(a);
		nombre++;
	}
	
	public Animal getAnimal(int i) {
		return animaux.get(i);
	}
}
