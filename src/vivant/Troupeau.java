package vivant;

import java.util.ArrayList;
import java.util.Collections;

import elements.Carte;

public class Troupeau {
	protected int nombre;
	ArrayList<Animal> animaux;
	protected Carte memoire;
	protected boolean enGroupe;

	
	public Troupeau(int x, int y) {
		nombre = 0;
		animaux = new ArrayList<Animal>();
		memoire = new Carte(x,y);
	}
	
	// GETTERS et SETTERS
	public void addAnimal(Animal a) {
		// Pas d'animaux différent dans le même troupeau
		if (nombre!=0 && !getAnimal(0).toString().equals(a.toString())) {
			System.err.println("Erreur: l'animal est différent du troupeau !");
			System.exit(1);
		}
		
		animaux.add(a);
		nombre++;
	}
	public Animal getAnimal(int i) { return animaux.get(i); }
	public ArrayList<Animal> getAnimaux() { return animaux; }
	public Carte getMemoire() { return memoire; }
	
	// AUTRES
	public void mort() {
		ArrayList<Integer> mort = new ArrayList<Integer>();
		int i=0;
		
		for (Animal a: animaux) {
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
			nombre--;
		}
	}
	
	// on determine la marche à suivre
	// 0: stationnaire / 1: haut / 2: droite / 3: bas / 4: gauche
	public int deplacement(int i) {
		int x = animaux.get(i).getPosX();
		int y = animaux.get(i).getPosY();
		
		// on peut aller en haut
		if(y>0 && memoire.getTerrain(x, y-1)==null) {
			return 1;
		}
		
		// on peut aller à droite
		if(x<memoire.getTailleX()-1 && memoire.getTerrain(x+1, y)==null) {
			return 2;
		}
		
		// on peut aller en bas
		if(y<memoire.getTailleY()-1 && memoire.getTerrain(x, y+1)==null) {
			return 3;
		}
		
		// on peut aller à droite
		if(x>0 && memoire.getTerrain(x-1, y)==null) {
			return 4;
		}
		
		return 0;
	}
	
	
	public void maj(Carte carte) {			
		// on met à jours chaque animaux
		for (Animal a: animaux) {		
			a.maj();
		}
		
		// on supprime les morts du groupe
		this.mort();
		
		// on regarde s'il reste des survivant
		if (nombre != 0) {
			// l'animal 0 est le meneur
			int x=animaux.get(0).getPosX();
			int y=animaux.get(0).getPosY();
			
			// on regarde si le troupeau est groupé
			enGroupe = true;
			for (Animal a: animaux) {		
				if(x != a.getPosX() || y != a.getPosY()) {
					enGroupe = false;
				}
			}
			
			// on déplace le troupeau
			int i=0;
			for (Animal a: animaux) {
				if (x == a.getPosX() && y == a.getPosY() && enGroupe) {
					a.deplacement(deplacement(i));
					x = animaux.get(0).getPosX();
					y = animaux.get(0).getPosY();
				} else if (x != a.getPosX() || y != a.getPosY()) {
					int direction=0;
					
					if(a.getPosY()>y) {
						direction=1;
					} else if (a.getPosX()<x) {
						direction=2;
					} else if (a.getPosY()<y) {
						direction=3;
					} else if (a.getPosX()>x) {
						direction=4;
					}
					
					a.deplacement(direction);
				}
				
				
				// si le troupeau ne connaissait pas ce lieu, on le garde en mémoire
				if (memoire.getTerrain(a.getPosX(), a.getPosY()) == null) {
					memoire.setTerrain(a.getPosX(), a.getPosY(), carte.getTerrain(a.getPosX(), a.getPosY()));
				}
				i++;
			}
		}
	}
}
