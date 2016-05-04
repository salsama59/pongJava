package etatsJeu;

import java.util.ArrayList;
import java.util.List;

import managers.elements.GestionnaireElements;
import managers.etat.GestionnaireChoixModeJeu;
import managers.joueur.GestionnaireJoueurs;
import mecanismes.implementations.LogicDeplacementsElementsAvatarImpl;
import mecanismes.implementations.LogicDeplacementsElementsCurseurImpl;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Joueur.Joueur;
import constantes.ConstantesElements;
import constantes.ConstantesEtat;
import constantes.ConstantesJoueurs;
import elementGraphique.Avatar;
import elementGraphique.Conteneur;
import elementGraphique.Texte;
import elementsJeu.Curseur;

public class EtatChoixModeJeu extends BasicGameState 
{
	
	public static final int ID = ConstantesEtat.ETAT_CHOIX_MODE;
	private StateBasedGame jeu;
	private Curseur curseur;
	private Conteneur conteneur;
	private Texte texte1;
	private Texte texte2;
	private Texte texte3;
	private LogicDeplacementsElementsCurseurImpl logicDeplacementCurseur;
	private static String phase = ConstantesEtat.ETAT_CHOIX_MODE_PHASE_SELECTION;
	private Joueur joueur1;
	private Joueur joueur2;
	private Avatar avatar1;
	private Avatar avatar2;
	private LogicDeplacementsElementsAvatarImpl logicDeplacementsAvatar1;
	private LogicDeplacementsElementsAvatarImpl logicDeplacementsAvatar2;
	private Texte elementAvatar1;
	private Texte elementAvatar2;

	@Override
	public void init(GameContainer gameContainer, StateBasedGame jeu) throws SlickException 
	{
		
		this.setJeu(jeu);
		GestionnaireChoixModeJeu.getInstance().setJeu(jeu);
		conteneur = new Conteneur((gameContainer.getWidth()/2), (gameContainer.getHeight()/2));
		curseur = new Curseur(ConstantesElements.ELEMENT_CURSEUR_NOM_CHOIX_MODE, false, ConstantesElements.ELEMENT_CURSEUR_TYPE, conteneur.getCentreX() + 130 - 30, conteneur.getCentreY() + 40);
		logicDeplacementCurseur = new LogicDeplacementsElementsCurseurImpl(curseur);
		texte1 = new Texte("Mode Exibition", 0, 0, conteneur, gameContainer, false);
		texte2 = new Texte("Options", 0, 0, conteneur, gameContainer, false);
		texte3 = new Texte("Quitter le jeu", 0, 0, conteneur, gameContainer, false);
		GestionnaireElements.getInstance().ajouterElement(texte1);
		GestionnaireElements.getInstance().ajouterElement(texte2);
		GestionnaireElements.getInstance().ajouterElement(texte3);
		List<Texte> list = new ArrayList<Texte>();
		list.add(texte1);
		list.add(texte2);
		list.add(texte3);
		conteneur.setElementsTextuel(list);
		conteneur.setCurseur(curseur);
		
		joueur1 = new Joueur(ConstantesJoueurs.JOUEUR_ID_1, ConstantesJoueurs.JOUEUR_CAMP_NEUTRE, "");
		joueur2 = new Joueur(ConstantesJoueurs.JOUEUR_ID_2, ConstantesJoueurs.JOUEUR_CAMP_NEUTRE, "");
		
		joueur1.setConnecte(true);
		joueur2.setConnecte(true);
		
		float xAvatar1 = gameContainer.getWidth()/3 + gameContainer.getWidth()/3/2;
		float yAvatar1 = gameContainer.getHeight()/3/2;
		
		float xAvatar2 = xAvatar1;
		float yAvatar2 = gameContainer.getHeight()/3;
		
		avatar1 = new Avatar(joueur1.getId(), gameContainer, xAvatar1, yAvatar1, 40, 40);
		avatar2 = new Avatar(joueur2.getId(), gameContainer, xAvatar2, yAvatar2, 40, 40);
		
		elementAvatar1 = new Texte("V", avatar1.getCoordonneeX() + (avatar1.getElement().getWidth()/2), avatar1.getCoordonneeY() + (avatar1.getElement().getHeight()/2), null, gameContainer, false);
		elementAvatar2 = new Texte("V", avatar2.getCoordonneeX() + (avatar2.getElement().getWidth()/2), avatar2.getCoordonneeY() + (avatar2.getElement().getHeight()/2), null, gameContainer, false);
		
		elementAvatar1.setCoordonneesX(elementAvatar1.getCoordonneesX() - elementAvatar1.getLargeur()/2);
		elementAvatar1.setCoordonneesY(elementAvatar1.getCoordonneesY() - elementAvatar1.getHauteur()/2);
		
		elementAvatar2.setCoordonneesX(elementAvatar2.getCoordonneesX() - elementAvatar2.getLargeur()/2);
		elementAvatar2.setCoordonneesY(elementAvatar2.getCoordonneesY() - elementAvatar2.getHauteur()/2);
		
		avatar1.setElementAvatar(elementAvatar1);
		avatar2.setElementAvatar(elementAvatar2);
		
		logicDeplacementsAvatar1 = new LogicDeplacementsElementsAvatarImpl(avatar1);
		logicDeplacementsAvatar2 = new LogicDeplacementsElementsAvatarImpl(avatar2);
		
		GestionnaireJoueurs.getInstance().ajouterJoueur(joueur1);
		GestionnaireJoueurs.getInstance().ajouterJoueur(joueur2);
		GestionnaireJoueurs.getInstance().ajouterAvatar(avatar1);
		GestionnaireJoueurs.getInstance().ajouterAvatar(avatar2);
		
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame jeu, Graphics graphisme) throws SlickException 
	{
		
		if(EtatChoixModeJeu.getPhase().equals(ConstantesEtat.ETAT_CHOIX_MODE_PHASE_SELECTION))
		{
			conteneur.afficher(graphisme);
		}
		
		if(EtatChoixModeJeu.getPhase().equals(ConstantesEtat.ETAT_CHOIX_MODE_PHASE_EXIBITION_LOBBY))
		{
			
			graphisme.drawLine((gameContainer.getWidth()/3), 0, (gameContainer.getWidth()/3), gameContainer.getHeight());
			graphisme.drawLine((gameContainer.getWidth()/3 * 2), 0, (gameContainer.getWidth()/3 * 2), gameContainer.getHeight());
			
			graphisme.draw(avatar1.getElement());
			
			if(avatar1.isValide())
			{
				avatar1.getElementAvatar().afficher();
			}
			
			graphisme.draw(avatar2.getElement());
			
			if(avatar2.isValide())
			{
				avatar2.getElementAvatar().afficher();
			}
			
		}
		
	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame jeu, int delta) throws SlickException 
	{
		
		if(EtatChoixModeJeu.getPhase().equals(ConstantesEtat.ETAT_CHOIX_MODE_PHASE_SELECTION))
		{
			logicDeplacementCurseur.gererDeplacements(delta, EtatChoixModeJeu.getPhase(), gameContainer);
		}
		
		if(EtatChoixModeJeu.getPhase().equals(ConstantesEtat.ETAT_CHOIX_MODE_PHASE_EXIBITION_LOBBY))
		{
			logicDeplacementsAvatar1.gererDeplacements(delta, EtatChoixModeJeu.getPhase(), gameContainer);
			logicDeplacementsAvatar2.gererDeplacements(delta, EtatChoixModeJeu.getPhase(), gameContainer);
		}
		
	}
	
	@Override
	public void keyPressed(int key, char c) 
	{
		
		if(EtatChoixModeJeu.getPhase().equals(ConstantesEtat.ETAT_CHOIX_MODE_PHASE_SELECTION))
		{
			logicDeplacementCurseur.gererEtats(key, c, this.getJeu().getContainer());
		}
		
		if(EtatChoixModeJeu.getPhase().equals(ConstantesEtat.ETAT_CHOIX_MODE_PHASE_EXIBITION_LOBBY))
		{
			logicDeplacementsAvatar1.gererEtats(key, c, this.getJeu().getContainer());
			logicDeplacementsAvatar2.gererEtats(key, c, this.getJeu().getContainer());
		}
		
	}
	
	@Override
	public void keyReleased(int key, char c) 
	{
		
		Input entree = new Input(key);
		
		switch (key) 
	    {
			
		 	case Input.KEY_RETURN:
		 	
	 		if(EtatChoixModeJeu.getPhase().equals(ConstantesEtat.ETAT_CHOIX_MODE_PHASE_SELECTION))
			{
	 			
	 			if(GestionnaireChoixModeJeu.getInstance().getSelection().equals(GestionnaireChoixModeJeu.EXIBITION))
	 			{
	 				EtatChoixModeJeu.setPhase(ConstantesEtat.ETAT_CHOIX_MODE_PHASE_EXIBITION_LOBBY);
	 			}
	 			else if(GestionnaireChoixModeJeu.getInstance().getSelection().equals(GestionnaireChoixModeJeu.OPTIONS))
	 			{
	 				this.getJeu().enterState(EtatOptions.ID);
	 			}
	 			else if(GestionnaireChoixModeJeu.getInstance().getSelection().equals(GestionnaireChoixModeJeu.QUITTER_JEU))
	 			{
	 				this.getJeu().getContainer().exit();
	 			}
	 			
			}
		 	
	        break;
	        
	    }
		
		logicDeplacementCurseur.reinitialisationEtat(key, c);
		
		if(EtatChoixModeJeu.getPhase().equals(ConstantesEtat.ETAT_CHOIX_MODE_PHASE_EXIBITION_LOBBY))
		{
			logicDeplacementsAvatar1.reinitialisationEtat(key, c);
			logicDeplacementsAvatar2.reinitialisationEtat(key, c);
		}
	    
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
		EtatChoixModeJeu.phase = phase;
	}

}
