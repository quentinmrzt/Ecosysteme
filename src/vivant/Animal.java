package vivant;

import java.util.Random;

import elements.Carte;


public abstract class Animal {
	protected boolean male;
	protected boolean meneur;
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
		meneur = false;

		// sexe aléatoire
		Random r = new Random();
		int valeur = r.nextInt(2);
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
	public boolean estMale() { return male; } 
	public void setMale(boolean b) { this.male = b; }
	public boolean estMeneur() { return meneur; } 
	public void setMeneur(boolean b) { this.meneur = b; }
	
	// AUTRES
	public abstract String toString();
	public abstract void manger(Carte carte);
	
	public void boire(Carte carte) {
		// Boire
		if (eau>0 && !carte.getTerrain(posX, posY).boire()) {
			eau--;
		}
	}
	
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
	public void maj(Carte carte) {
		if (nourriture<=0 || eau<=0) {
			vie--;
		}
		
		// Manger
		this.manger(carte);
		
		

		age++;

		energie = vie;
	}
}
