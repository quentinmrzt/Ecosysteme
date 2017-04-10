package graphiques;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import elements.*;


public class Menu extends JMenuBar {
	protected JMenu menu;
	protected JMenuItem rejouer;
	protected JMenuItem quitter;
	
	protected Monde monde;
	
	public Menu(Monde monde) {		
		// Un menu
		this.monde = monde;
		
		menu = new JMenu("Menu") ;
		menu.setMnemonic(KeyEvent.VK_M);
		
		// Item pour rejouer
		rejouer = new JMenuItem("Rejouer");
		rejouer.setMnemonic(KeyEvent.VK_B);
		rejouer.setActionCommand("Rejouer");
		rejouer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		// Item pour quitter
		quitter = new JMenuItem("Quitter");
		quitter.setMnemonic(KeyEvent.VK_B);
		quitter.setActionCommand("Quitter");
		quitter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// Intégration des items au menu
		menu.add(rejouer);
		menu.add(quitter);
		
		// Intégration du menu à la bar
		this.add(menu);
	}
}
