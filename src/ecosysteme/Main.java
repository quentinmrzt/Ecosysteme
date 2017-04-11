package ecosysteme;

import elements.Monde;
import elements.Plaine;
import elements.Terrain;
import vivant.*;


public class Main {
	public static void main(String[] args) {
		int tailleX = 10;
		int tailleY = 8;
		
		Terrain[][] carte = new Terrain[tailleY][tailleX];
		
		// Par d�faut la carte est une plaine
		for (int j=0 ; j<tailleY ; j++) {
			for (int i=0 ; i<tailleX ; i++) {
				carte[j][i] = new Plaine();
			}
		}
		
		Monde monde = new Monde(carte);
		
		// Troupeau de Mouton
		monde.addTroupeaux(new Troupeau(tailleX, tailleY));
		monde.getTroupeaux(0).addAnimal(new Mouton(0,0));
		monde.getTroupeaux(0).addAnimal(new Mouton(0,0));
		monde.getTroupeaux(0).addAnimal(new Mouton(0,0));
		monde.getTroupeaux(0).addAnimal(new Mouton(0,2));
		// test de meneur
		monde.getTroupeaux(0).getAnimal(3).setAge(1);
		monde.getTroupeaux(0).getAnimal(3).setMale(true);

		// Troupeau de Loup
		monde.addTroupeaux(new Troupeau(tailleX, tailleY));
		monde.getTroupeaux(1).addAnimal(new Loup(9,4));
		monde.getTroupeaux(1).addAnimal(new Loup(9,4));
		monde.getTroupeaux(1).addAnimal(new Loup(9,5));

		System.out.println(monde.getTroupeaux(0).getMemoire().toString());
		System.out.println(monde.toString());

		for (int temps=0 ; temps<=30 ; temps++) {
			System.out.println("Temps: "+temps+".");
			// Mise � jour
			monde.maj();
					
			// Affichage
			System.out.println("Le monde: ");
			System.out.println(monde.toString());
		}
	}	
}
