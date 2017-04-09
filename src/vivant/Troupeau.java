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
		// Pas d'animaux diff�rent dans le m�me troupeau
		if (nombre!=0 && getAnimal(0).equals(a)) {
			System.err.println("Erreur: l'animal est diff�rent du troupeau !");
			return;
		}
		
		animaux.add(a);
		nombre++;
	}
	
	public Animal getAnimal(int i) {
		return animaux.get(i);
	}
}
