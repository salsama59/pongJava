package jeu;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import constantes.ContantesJeu;

public class LancementJeu 
{
	public static void main(String[] args) 
	{ 
		 try
		 { 
			 AppGameContainer container = new AppGameContainer(new Pong2015()); 
			 initialisationJeu(container);
			 
		 } 
		 catch (SlickException e) 
		 {
			 e.printStackTrace();
		 }
	}
	
	private static void initialisationJeu(AppGameContainer container) throws SlickException
	{
		container.setDisplayMode(ContantesJeu.ECRAN_LARGEUR, ContantesJeu.ECRAN_HAUTEUR, ContantesJeu.ECRAN_AFFICHAGE_FULLSCREEN); 
		container.setTargetFrameRate(ContantesJeu.JEU_FRAMERATE);
		container.start();
	}
}
