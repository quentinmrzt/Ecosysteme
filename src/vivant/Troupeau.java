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
		
		if (nombre!=0) {
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
		int iMeneur;
		if(ageMaxM != 0) {
			iMeneur = meneurM;
		} else {
			iMeneur = meneurF;
		}
		
		// si le meneur a changé, on le met en position 0
		if(iMeneur!=0) {
			Animal ancien = animaux.get(0);
			ancien.setMeneur(false);
			animaux.set(0, animaux.get(iMeneur));
			animaux.set(iMeneur, ancien);
		}
		
		// L'animal en première position est le meneur
		animaux.get(0).setMeneur(true);
		}
	}
	
	public void maj(Carte carte) {			
		// l'animal 0 est (techniquement) le meneur
		int meneurX = animaux.get(0).getPosX();
		int meneurY= animaux.get(0).getPosY();
			
		// on regarde si le troupeau est groupé
		enGroupe = true;
		for (Animal a: animaux) {		
			if(meneurX != a.getPosX() || meneurY != a.getPosY()) {
				enGroupe = false;
			}
		}
			
		for (Animal a: animaux) {
			// on déplace le troupeau
			if (a.estMeneur() && enGroupe) {
				// le meneur et groupé: on avance
				a.deplacement(deplacement(0));
					
				// on met à jour la position du meneur
				meneurX = animaux.get(0).getPosX();
				meneurY = animaux.get(0).getPosY();
			} else if (meneurX != a.getPosX() || meneurY != a.getPosY()) {
				// si on est pas avec le meneur: on se dirige vers lui
				int direction=0;
					
				if(a.getPosY()>meneurY) {
					direction=1;
				} else if (a.getPosX()<meneurX) {
					direction=2;
				} else if (a.getPosY()<meneurY) {
					direction=3;
				} else if (a.getPosX()>meneurX) {
					direction=4;
				}
					
				a.deplacement(direction);
			}

			// si le troupeau ne connaissait pas ce lieu, on le garde en mémoire
			if (memoire.getTerrain(a.getPosX(), a.getPosY()) == null) {
				memoire.setTerrain(a.getPosX(), a.getPosY(), carte.getTerrain(a.getPosX(), a.getPosY()));
			}
				
			// on met à jour l'animal
			a.maj(carte);				
		}
			
		// on supprime les morts du groupe
		this.mort();
			
		// on choisit un nouveau meneur
		this.meneur();
	}
}
