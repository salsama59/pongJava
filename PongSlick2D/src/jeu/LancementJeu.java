package jeu;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import constantes.ConstantesJeu;

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
		container.setDisplayMode(ConstantesJeu.ECRAN_LARGEUR, ConstantesJeu.ECRAN_HAUTEUR, ConstantesJeu.ECRAN_AFFICHAGE_FULLSCREEN); 
		container.setTargetFrameRate(ConstantesJeu.JEU_FRAMERATE);
		container.start();
	}
}
