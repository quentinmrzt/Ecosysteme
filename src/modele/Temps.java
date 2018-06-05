package modele;

public class Temps implements Runnable {
	private Calendrier calendrier;
	private int attente;
	
	public Temps(Calendrier calendrier) {
		this.calendrier = calendrier;
		this.attente = 500/24;
		
		this.run();
	}
	
	public void run() {
		while(true) {
			this.calendrier.heureSuivante();
			
			try {
				Thread.sleep(this.attente);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
