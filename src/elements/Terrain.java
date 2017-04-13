package elements;

public abstract class Terrain {
	// stock initial
	int herbeIni;
	int eauIni;
	int arbreIni;
	
	// stock courant
	int herbe;
	int eau;
	int arbre;
	
	public boolean broute() {
		if (herbe>0) {
			herbe--;
			return true;
		}
		return false;
	}
	
	public boolean boire() {
		if (eau>0) {
			eau--;
			return true;
		}
		return false;
	}
	
	public void affReserve() {
		System.out.println("Herbe: "+herbe+"/"+herbeIni+".");
		System.out.println("Eau: "+eau+"/"+eauIni+".");
		System.out.println("Arbe: "+arbre+"/"+arbreIni+".");
	}
	
	public abstract String toString();
}
