package vivant;

public abstract class Animal {
	protected int vie;
	protected int nourriture;
	protected int eau;
	protected int age;
	protected int energie;
	
	protected int posX;
	protected int posY;
	
	public Animal(int x, int y) {
		posX = x;
		posY = y;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public abstract String toString();
}
