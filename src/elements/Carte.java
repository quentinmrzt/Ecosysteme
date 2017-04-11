package elements;

public class Carte {
	protected Terrain carte[][];
	protected int tailleX;
	protected int tailleY;
	
	
	// CONSTRUCTEUR
	public Carte(int x, int y) {
		tailleX = x;
		tailleY = y;
		carte = new Terrain[y][x];
	}
	
	public Carte(Terrain[][] t) {
		tailleX = t[0].length;
		tailleY = t.length;
		carte = t;
	}
	
	
	// GETTERS et SETTERS
	public Terrain getTerrain(int x, int y) { return carte[y][x]; } 
	public void setTerrain(int x, int y, Terrain t) { carte[y][x]=t; }
	public int getTailleX() { return tailleX; }
	public void setTailleX(int tailleX) { this.tailleX = tailleX; }
	public int getTailleY() { return tailleY; }
	public void setTailleY(int tailleY) { this.tailleY = tailleY; }
	
	
	// AUTRES
	public String toString() {
		StringBuilder table = new StringBuilder();
		table.append("L: Lac / F: Foret / P: Plaine\n");
		
		for (int y=0 ; y<tailleY ; y++) {
			table.append("| ");
			for (int x=0 ; x<tailleX ; x++) {
				if(carte[y][x] == null) {
					table.append("X | ");
				} else {
					table.append(carte[y][x].toString()+" | ");
				}
			}
			table.append("\n");
		}
		
		return table.toString();
	}
}
