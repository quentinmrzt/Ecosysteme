package elements;

import java.util.ArrayList;

import vivant.*;

public class Monde {
	protected Carte carte;
	protected ArrayList<Troupeau> troupeaux;
	
	public Monde(int x, int y) {
		carte = new Carte(x,y);
		troupeaux = new ArrayList<Troupeau>(); 
	}
	
	public Carte getCarte() { return carte; }
	public void setCarte(Carte carte) { this.carte = carte; }
	public Troupeau getTroupeaux(int i) { return troupeaux.get(i); }
	public void addTroupeaux(Troupeau t) { troupeaux.add(t); }

	public String toString() {
		// Récupération des animaux
		String tab[][] = new String[carte.lengthCarteY()][carte.lengthCarteX()];

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
		
		for (int y=0 ; y<carte.lengthCarteY() ; y++) {
			table.append("| ");
			for (int x=0 ; x<carte.lengthCarteX() ; x++) {
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

	public void maj() {
		for (Troupeau t: troupeaux) {
			t.maj();
		}
	}
}
