package etatsJeu;

import java.util.ArrayList;
import java.util.List;

import managers.elements.GestionnaireElements;
import managers.etat.GestionnaireChoixModeJeu;
import managers.etat.GestionnaireOptions;
import mecanismes.implementations.LogicDeplacementsElementsCurseurImpl;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import constantes.ConstantesElements;
import constantes.ConstantesEtat;
import elementGraphique.Conteneur;
import elementGraphique.Texte;
import elementsJeu.Curseur;

public class EtatOptions extends BasicGameState 
{
	
	public static final int ID = ConstantesEtat.ETAT_OPTION;
	private StateBasedGame jeu;
	private Curseur curseur;
	private Conteneur conteneur;
	private Texte texte1;
	private Texte texte2;
	private LogicDeplacementsElementsCurseurImpl logicDeplacementCurseur;
	private static String phase = ConstantesEtat.ETAT_OPTIONS_PHASE_AFFICHAGE_GENERAL;

	@Override
	public void init(GameContainer gameContainer, StateBasedGame jeu) throws SlickException 
	{
		GestionnaireOptions.getInstance().setGraphisme(gameContainer.getGraphics());
		this.setJeu(jeu);
		conteneur = new Conteneur((gameContainer.getWidth()/2) - 150, (gameContainer.getHeight()/2) - 40);
		curseur = new Curseur(ConstantesElements.ELEMENT_CURSEUR_NOM_MISE_EN_JEU, false, ConstantesElements.ELEMENT_CURSEUR_TYPE, conteneur.getCentreX() + 130 - 30, conteneur.getCentreY() + 40);
		logicDeplacementCurseur = new LogicDeplacementsElementsCurseurImpl(curseur);
		
		texte1 = new Texte(GestionnaireOptions.OPTION1, 0, 0, conteneur, gameContainer, false);
		texte2 = new Texte(GestionnaireOptions.OPTION2, 0, 0, conteneur, gameContainer, false);
		
		GestionnaireElements.getInstance().ajouterElement(texte1);
		GestionnaireElements.getInstance().ajouterElement(texte2);
		
		List<Texte> list = new ArrayList<Texte>();
		list.add(texte1);
		list.add(texte2);
		
		conteneur.setElementsTextuel(list);
		
		texte1.setCoordonneesX(texte1.calculerPositionX());
		texte1.setCoordonneesY(texte1.calculerPositionY());
		texte2.setCoordonneesX(texte2.calculerPositionX());
		texte2.setCoordonneesY(texte2.calculerPositionY());
		
		conteneur.setCurseur(curseur);
		
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame jeu, Graphics graphisme) throws SlickException 
	{
		graphisme.setBackground(new Color(255, 255, 255, 255));
			//graphisme.clear();
			graphisme.setColor(new Color(0, 0, 0, 0));
		conteneur.afficher(graphisme);
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
	 			
	 			if(GestionnaireOptions.getInstance().getSelection().equals(GestionnaireOptions.OPTION1))
	 			{
	 				Graphics graphisme = GestionnaireOptions.getInstance().getGraphisme();
	 				
	 				GestionnaireOptions.getInstance().getDonneesOption().setCouleurFond(new Color(255, 255, 255, 255));
	 				GestionnaireOptions.getInstance().getDonneesOption().setCouleurLigne(new Color(0, 0, 0, 0));
	 				graphisme.setBackground(new Color(255, 255, 255, 255));
	 				graphisme.setColor(new Color(0, 0, 0, 0));
	 			}
	 			else if(GestionnaireOptions.getInstance().getSelection().equals(GestionnaireOptions.OPTION2))
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

}
