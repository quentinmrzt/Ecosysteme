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
	public int getNombre() { return nombre; }
	
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
			animaux.remove(test);
			nombre--;
		}
	}
	
	// on determine la marche à suivre (très basique)
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
	
	public void meneur() {
		int ageMaxM=0;
		int meneurM=0;
		int ageMaxF=0;
		int meneurF=0;
		
		int meneur=0;
		int i=0;
		for (Animal a: animaux) {
			if(a.estMale()) {
				if(a.getAge()>ageMaxM) {
					ageMaxM=a.getAge();
					meneurM=i;
				}
			} else {
				if(a.getAge()>ageMaxF) {
					ageMaxF=a.getAge();
					meneurF=i;
				}
			}
			i++;
		}
		
		// s'il y a un mâle
		if(ageMaxM != 0) {
			meneur = meneurM;
		} else {
			meneur = meneurF;
		}
		
		// si le meneur a changé, on le met en position 0
		if(meneur!=0) {
			Animal tmp = animaux.get(0);
			animaux.set(0, animaux.get(meneur));
			animaux.set(meneur, tmp);
		}
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
			// on choisit un nouveau meneur
			this.meneur();
			
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
