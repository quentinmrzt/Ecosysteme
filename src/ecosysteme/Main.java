package ecosysteme;

import elements.Monde;
import vivant.*;

public class Main {
	public static void main(String[] args) {
		Monde monde = new Monde(10,8);
		
		// Troupeau de Mouton
		monde.addTroupeaux(new Troupeau());
		monde.getTroupeaux(0).addAnimal(new Mouton(0,0));
		monde.getTroupeaux(0).addAnimal(new Mouton(0,0));
		monde.getTroupeaux(0).addAnimal(new Mouton(0,0));
		monde.getTroupeaux(0).addAnimal(new Mouton(0,1));

		
		// Troupeau de Loup
		monde.addTroupeaux(new Troupeau());
		monde.getTroupeaux(1).addAnimal(new Loup(9,4));
		monde.getTroupeaux(1).addAnimal(new Loup(9,4));
		monde.getTroupeaux(1).addAnimal(new Loup(9,5));
		
		// erreur
		//monde.getTroupeaux(0).addAnimal(new Loup(0,2));

		for (int jour=0 ; jour<=30 ; jour++) {
			System.out.println("Jour: "+jour+".");
			// Mise à jour
			monde.maj();
			//System.out.println(monde.getTroupeaux(0).getAnimal(0).getVie());
			
			// Affichage
			System.out.println(monde.toString());
		}
	}	
}
