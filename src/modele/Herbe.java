package modele;

public class Herbe extends Case {
	private int min, max, etat;
	
	public Herbe() {
		this.min = 0;
		this.max = 10;
		
		this.etat = 0;
	}
	
	public int getMin() { return this.min; }
	public int getMax() { return this.max; }
	public int getEtat() { return this.etat; }
	
	public void pousse() {
		if(this.etat<this.max) {
			this.etat++;
		}
	}

	@Override
	public String toString() {
		return "Herbe: "+this.etat;
	}
	
	
}