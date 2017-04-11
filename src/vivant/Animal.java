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

	// GETTERS ET SETTERS
	public int getPosX() { return posX; } 
	public void setPosX(int posX) { this.posX = posX; } 
	public int getPosY() { return posY; } 
	public void setPosY(int posY) { this.posY = posY; } 
	public int getVie() { return vie; } 
	public void setVie(int vie) { this.vie = vie; } 
	public int getNourriture() { return nourriture; } 
	public void setNourriture(int nourriture) { this.nourriture = nourriture; } 
	public int getEau() { return eau; } 
	public void setEau(int eau) { this.eau = eau; } 
	public int getAge() { return age; } 
	public void setAge(int age) { this.age = age; } 
	public int getEnergie() { return energie; } 
	public void setEnergie(int energie) { this.energie = energie; }

	public abstract String toString();
	
	// ce qui ce passe chaque jour
	public void maj() {
		nourriture--;
		eau--;
		age++;
		if (nourriture<=0 && eau<=0) {
			vie--;
		}
		energie = vie;
	}
}
