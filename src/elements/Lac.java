package elements;

public class Lac extends Terrain {
	public Lac() {
		// stock initial
		herbeIni = 0;
		eauIni = 1000;
		arbreIni = 0;
		
		// stock courant
		herbe = herbeIni;
		eau = eauIni;
		arbre = arbreIni;
	}
	
	public String toString() {
		return "L";
	}
}
