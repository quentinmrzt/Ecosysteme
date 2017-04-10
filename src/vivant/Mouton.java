package vivant;

public class Mouton extends Animal {

	public Mouton(int x, int y) {
		super(x,y);
		
		vie = 10;
		nourriture = 10;
		eau = 10;
		age = 0;
		energie = 10;
	}

	public String toString() {
		return "M";
	}
}
