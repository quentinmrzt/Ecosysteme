package vivant;

import java.util.Random;


public abstract class Animal {
	protected boolean male;
	protected int vie;
	protected int nourriture;
	protected int eau;
	protected int age;
	protected int energie;
	protected int viande;
	protected int posX;
	protected int posY;
	
	
	// CONSTRUCTEUR
	public Animal(int x, int y) {
		posX = x;
		posY = y;
		age = 0;

		// sexe aléatoire
		Random r = new Random();
		int valeur = r.nextInt(1);
		if (valeur==0) {
			male = true;
		} else {
			male = false;
		}
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

	
	// AUTRES
	public abstract String toString();
	
	public void deplacement(int direction) {
		if (direction==1) {
			posY--;
		} else if (direction==2) {
			posX++;
		} else if (direction==3) {
			posY++;
		} else if (direction==4) {
			posX--;
		}
	}
	
	// ce qui ce passe chaque jour
	public void maj() {
		nourriture--;
		eau--;
		age++;
		if (nourriture<=0 || eau<=0) {
			vie--;
		}
		energie = vie;
	}
}
