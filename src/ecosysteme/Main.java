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
		
		// Par défaut la carte est une plaine
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

		
		// Troupeau de Loup
		monde.addTroupeaux(new Troupeau(tailleX, tailleY));
		monde.getTroupeaux(1).addAnimal(new Loup(9,4));
		monde.getTroupeaux(1).addAnimal(new Loup(9,4));
		monde.getTroupeaux(1).addAnimal(new Loup(9,5));
		
		System.out.println(monde.getTroupeaux(0).getMemoire().toString());
		System.out.println(monde.toString());

		for (int jour=0 ; jour<=30 ; jour++) {
			System.out.println("Jour: "+jour+".");
			// Mise à jour
			monde.maj();
			//System.out.println(monde.getTroupeaux(0).getAnimal(0).getVie());
			
			// Affichage
			System.out.println(monde.toString());
		}
		System.out.println("");
		System.out.println(monde.getTroupeaux(0).getMemoire().toString());

	}	
}
