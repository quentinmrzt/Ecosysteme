package elements;

public class Carte {
	protected Terrain carte[][];
	
	public Carte(int x, int y) {
		carte = new Terrain[y][x];
		
		// Par défaut la carte est une plaine
		for (int j=0 ; j<y ; j++) {
			for (int i=0 ; i<x ; i++) {
				carte[j][i] = new Plaine();
			}
		}
	}
	
	public Terrain getTerrain(int x, int y) {
		return carte[y][x];
	}
	
	public int lengthCarteY() {
		return carte.length;
	}
	
	public int lengthCarteX() {
		return carte[0].length;
	}
	
	public String toString() {
		StringBuilder table = new StringBuilder();
		table.append("L: Lac / F: Foret / P: Plaine\n");
		
		for (int y=0 ; y<lengthCarteY() ; y++) {
			table.append("| ");
			for (int x=0 ; x<lengthCarteX() ; x++) {
				table.append(carte[y][x].toString()+" | ");
			}
			table.append("\n");
		}
		
		return table.toString();
	}
}
