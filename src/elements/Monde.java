package elements;

import java.util.ArrayList;
import java.util.Collections;

import vivant.*;

public class Monde {
	protected Carte carte;
	protected int nombre;
	protected ArrayList<Troupeau> troupeaux;
	
	
	// CONSTRUCTEUR
	public Monde(Terrain[][] t) {
		carte = new Carte(t);
		troupeaux = new ArrayList<Troupeau>(); 
		nombre=0;
	}
	
	
	// GETTERS et SETTERS
	public Carte getCarte() { return carte; }
	public void setCarte(Carte carte) { this.carte = carte; }
	public Troupeau getTroupeaux(int i) { return troupeaux.get(i); }
	public int getNombre() { return nombre; }
	public void addTroupeaux(Troupeau t) { 
		troupeaux.add(t);
		nombre++;
	}

	
	// AUTRES
	public void maj() {
		for (Troupeau t: troupeaux) {
			t.maj(carte);
		}
		this.mort();
	}
	
	public void mort() {
		ArrayList<Integer> mort = new ArrayList<Integer>();
		int i=0;
		
		for (Troupeau t: troupeaux) {
			// si un animal est mort
			if(t.getNombre()==0) {
				mort.add(i);
			}
			i++;
		}
		
		// On inverse pour ne pas avoir de décallage
		Collections.reverse(mort);
		for (int m: mort) {
			troupeaux.remove(m);
			nombre--;
		}
	}
	
	public String toString() {
		// Récupération des animaux
		String tab[][] = new String[carte.getTailleY()][carte.getTailleX()];

		for(Troupeau t: troupeaux) {
			for(Animal a: t.getAnimaux()) {
				if (tab[a.getPosY()][a.getPosX()] != null) {
					int nombre = Character.getNumericValue(tab[a.getPosY()][a.getPosX()].charAt(0))+1;
					tab[a.getPosY()][a.getPosX()] = nombre+a.toString();
				} else {
					tab[a.getPosY()][a.getPosX()] = 1+a.toString();
				}
			}
		}
		
		// Construction du String
		StringBuilder table = new StringBuilder();
		table.append("L: Lac / F: Foret / P: Plaine\nM: Mouton / L: Loup\n");
		
		for (int y=0 ; y<carte.getTailleY() ; y++) {
			table.append("| ");
			for (int x=0 ; x<carte.getTailleX() ; x++) {
				if (tab[y][x] == null) {
					table.append(carte.getTerrain(x,y).toString()+"  | ");
				} else {
					table.append(tab[y][x]+" | ");
				}
			}
			table.append("\n");
		}
		
		return table.toString();	
	}
}
