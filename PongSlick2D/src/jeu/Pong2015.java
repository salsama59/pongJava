package jeu;
import org.newdawn.slick.AppGameContainer; 
import org.newdawn.slick.GameContainer; 
import org.newdawn.slick.SlickException; 
import org.newdawn.slick.state.StateBasedGame;

import constantes.ConstantesJeu;
import etatsJeu.implementations.EtatChoixModeJeu;
import etatsJeu.implementations.EtatMatch;
import etatsJeu.implementations.EtatOptions;

public class Pong2015 extends StateBasedGame
{
	
	private EtatMatch match = null; 
	private EtatChoixModeJeu choixModeJeu = null;
	private EtatOptions options = null;
	private AppGameContainer container = null;

	public Pong2015()
	{
		super(ConstantesJeu.JEU_TITRE);
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException 
	{
		
		if(container instanceof AppGameContainer) 
		{
			this.container = (AppGameContainer) container;
		} 
		 
		 match = new EtatMatch();
		 choixModeJeu = new EtatChoixModeJeu();
		 options = new EtatOptions();
		 addState(choixModeJeu);
		 addState(match);
		 addState(options);
		 
	}
	
	public EtatMatch getMatch() 
	{
		return match;
	}

	public void setMatch(EtatMatch match) {
		this.match = match;
	}

	public AppGameContainer getContainer() 
	{
		return container;
	}

	public void setContainer(AppGameContainer container) 
	{
		this.container = container;
	}
	
}
