package elements;

public class Foret extends Terrain {	
	public Foret() {
		// stock initial
		herbeIni = 10;
		eauIni = 5;
		arbreIni = 20;
		
		// stock courant
		herbe = herbeIni;
		eau = eauIni;
		arbre = arbreIni;
	}
	
	public String toString() {
		return "F";
	}
}
