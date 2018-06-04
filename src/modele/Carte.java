package modele;

public class Carte {
	private int tailleX, tailleY;
	private Case carte[][];
	
	public Carte(int x, int y) {
		this.tailleX = x;
		this.tailleY = y;
		
		this.carte = new Case[this.tailleX][this.tailleY];
		
		this.mettreEnHerbe();
	}
	
	public int getTailleX() { return this.tailleX; }
	public int getTailleY() { return this.tailleY; }
	public Case getCase(int x, int y) { return this.carte[x][y]; }
	
	// FONCTION
	private void mettreEnHerbe() {
		for (int x=0 ; x<this.tailleX ; x++) {
			for (int y=0 ; y<this.tailleY ; y++) {
				this.carte[x][y] = new Herbe();
			}
		}
	}
}
