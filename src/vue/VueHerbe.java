package vue;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class VueHerbe {
	private int taille;
	private Image images[];

	public VueHerbe() {
		try {
			this.taille = 19;
			
			this.images = new Image[10];
			
			for(int i=0 ; i<10 ; i++) {
				images[i] = ImageIO.read(new File("images/herbe_0"+i+".png"));
			}
		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	
	public int getTaille() { return this.taille; }
	public Image getImage(int i) { return this.images[i]; }
}
