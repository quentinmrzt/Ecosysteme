package elements;

public class Plaine extends Terrain {
	public Plaine() {
		// stock initial
		herbeIni = 20;
		eauIni = 10;
		arbreIni = 0;
		
		// stock courant
		herbe = herbeIni;
		eau = eauIni;
		arbre = arbreIni;
	}
	
	public String toString() {
		return "P";
	}
}
