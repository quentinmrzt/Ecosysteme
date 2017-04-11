package elements;

import java.util.ArrayList;

import vivant.*;

public class Monde {
	protected Carte carte;
	protected ArrayList<Troupeau> troupeaux;
	
	
	// CONSTRUCTEUR
	public Monde(Terrain[][] t) {
		carte = new Carte(t);
		troupeaux = new ArrayList<Troupeau>(); 
	}
	
	
	// GETTERS et SETTERS
	public Carte getCarte() { return carte; }
	public void setCarte(Carte carte) { this.carte = carte; }
	public Troupeau getTroupeaux(int i) { return troupeaux.get(i); }
	public void addTroupeaux(Troupeau t) { troupeaux.add(t); }

	
	// AUTRES
	public void maj() {
		for (Troupeau t: troupeaux) {
			t.maj(carte);
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
