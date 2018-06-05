package modele;

import java.util.Observable;

public class Calendrier extends Observable {
	private int heure, jour, mois, annee;
	private final int nbHeure=24, nbJour=31, nbMois=12;
	
	public Calendrier() {
		this.heure = 0;
		this.jour = 1;
		this.mois = 1;
		this.annee = 0;
	}
	
	public int getHeure() { return this.heure; }
	
	public void heureSuivante() {
		this.heure++;
		
		if(this.heure>=this.nbHeure) {
			this.heure = 0;
			
			this.jourSuivant();
		}
		
		this.setChanged();
		this.notifyObservers("HEURE");
	}
	
	public void jourSuivant() {
		this.jour++;
		if(this.jour>this.nbJour) {
			this.jour = 1;
			
			this.moisSuivant();
		}
		
		this.setChanged();
		this.notifyObservers("JOUR");
	}
	
	public void moisSuivant() {
		this.mois++;
		if(this.mois>this.nbMois) {
			this.mois = 1;
			
			anneeSuivante();
		}
		
		this.setChanged();
		this.notifyObservers("MOIS");
	}
	
	public void anneeSuivante() {
		this.annee++;
		
		this.setChanged();
		this.notifyObservers("ANNEE");
	}
	
	public String strNombre(int nombre) {
		if(nombre<10) {
			return "0"+nombre;
		} else {
			return ""+nombre;
		}
	}
	
	public String toString() {
		return "Date = "+this.strNombre(this.heure)+":00:00 - "+this.strNombre(this.jour)+"/"+this.strNombre(this.mois)+"/"+this.strNombre(this.annee);
	}
}
