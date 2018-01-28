package etatsJeu.implementations;

import managers.etat.GestionnaireOptions;
import mecanismes.implementations.LogicDeplacementsElementsCurseurImpl;
import menu.MenuJeu;
import menu.SousMenuJeu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import constantes.ConstantesElements;
import constantes.ConstantesEtat;
import elementGraphique.Conteneur;
import etatsJeu.interfaces.EtatJeu;

public class EtatOptions extends BasicGameState implements EtatJeu
{
	
	public static final int ID = ConstantesEtat.ETAT_OPTION;
	private StateBasedGame jeu;
	private Conteneur conteneurMenuOptions;
	private Conteneur conteneurSousMenuOptions;
	private MenuJeu menuOptions;
	private SousMenuJeu sousMenuOptions;
	private LogicDeplacementsElementsCurseurImpl logicDeplacementCurseur;
	private static String phase = ConstantesEtat.ETAT_OPTIONS_PHASE_AFFICHAGE_GENERAL;

	@Override
	public void init(GameContainer gameContainer, StateBasedGame jeu) throws SlickException 
	{
		GestionnaireOptions.getInstance().setGraphisme(gameContainer.getGraphics());
		this.setJeu(jeu);
		
		this.creerMenu(gameContainer);
		//this.initialiserElements(gameContainer);
		//this.initialiserGestionnaires();
		//this.initialiserMecanisme();
		
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame jeu, Graphics graphisme) throws SlickException 
	{
		
		if(EtatOptions.getPhase().equals(ConstantesEtat.ETAT_OPTIONS_PHASE_AFFICHAGE_GENERAL) || EtatOptions.getPhase().equals(ConstantesEtat.ETAT_OPTIONS_PHASE_OPTION_AFICHAGE))
		{
			conteneurMenuOptions.afficher(graphisme);
		}
		
		if(EtatOptions.getPhase().equals(ConstantesEtat.ETAT_OPTIONS_PHASE_OPTION_AFICHAGE))
		{
			conteneurSousMenuOptions.afficher(graphisme);
		}
		
	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame jeu, int delta) throws SlickException 
	{
		logicDeplacementCurseur.gererDeplacements(delta, EtatOptions.getPhase(), gameContainer);
	}
	
	@Override
	public void keyPressed(int key, char c) 
	{
		logicDeplacementCurseur.gererEtats(key, c, this.getJeu().getContainer());
	}
	
	@Override
	public void keyReleased(int key, char c) 
	{
		
		switch (key) 
	    {
			
		 	case Input.KEY_RETURN:
		 	
	 		if(EtatOptions.getPhase().equals(ConstantesEtat.ETAT_OPTIONS_PHASE_AFFICHAGE_GENERAL))
			{
	 			
	 			if(GestionnaireOptions.getInstance().getSelectionMenu().equals(GestionnaireOptions.OPTION1))
	 			{	
	 				EtatOptions.setPhase(ConstantesEtat.ETAT_OPTIONS_PHASE_OPTION_AFICHAGE);
	 			}
	 			else if(GestionnaireOptions.getInstance().getSelectionMenu().equals(GestionnaireOptions.OPTION4))
	 			{
	 				this.getJeu().enterState(GestionnaireOptions.getInstance().getIdEtatPrecedent());
	 			}
	 			
			}
	 		
	        break;
	        
	    }
		
		logicDeplacementCurseur.reinitialisationEtat(key, c);
	    
	}

	@Override
	public int getID() 
	{
		return ID;
	}

	public StateBasedGame getJeu() {
		return jeu;
	}

	public void setJeu(StateBasedGame jeu) {
		this.jeu = jeu;
	}

	public static String getPhase() {
		return phase;
	}

	public static void setPhase(String phase) {
		EtatOptions.phase = phase;
	}

	@Override
	public void creerMenu(GameContainer gameContainer) 
	{
		
		menuOptions = new MenuJeu(null, "menuOptions_fr_FR", ConstantesElements.ELEMENT_MENU_TYPE);
		menuOptions.initialiserMenu(gameContainer, false, null, false);
		this.conteneurMenuOptions = menuOptions.getConteneur();
		
		GestionnaireOptions.getInstance().initialiserListOptions(menuOptions.RecupererLibellesMenu());
		
		logicDeplacementCurseur = new LogicDeplacementsElementsCurseurImpl(menuOptions.getConteneur().getCurseur());
		
		sousMenuOptions = new SousMenuJeu(null, null, menuOptions);
		sousMenuOptions.initialiserSousMenu(gameContainer, false, null, false, "SousMenuOptions1");
		this.conteneurSousMenuOptions = sousMenuOptions.getConteneur();
		
		GestionnaireOptions.getInstance().initialiserListSousOptions1(sousMenuOptions.RecupererLibellesMenu());
		
	}

	@Override
	public void initialiserElements(GameContainer gameContainer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialiserGestionnaires() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialiserMecanisme() {
		// TODO Auto-generated method stub
		
	}

}
