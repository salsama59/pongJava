package etatsJeu;

import java.util.ArrayList;
import java.util.List;

import managers.elements.GestionnaireElements;
import managers.etat.GestionnaireOptions;
import mecanismes.implementations.LogicDeplacementsElementsCurseurImpl;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import constantes.ConstantesElements;
import constantes.ConstantesEtat;
import donnees.generale.Options;
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
	private Texte texte3;
	private Texte texte4;
	private Texte texte5;
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
		texte3 = new Texte(GestionnaireOptions.OPTION3, 0, 0, conteneur, gameContainer, false);
		texte4 = new Texte(GestionnaireOptions.OPTION4, 0, 0, conteneur, gameContainer, false);
		texte5 = new Texte(GestionnaireOptions.OPTION5, 0, 0, conteneur, gameContainer, false);
		
		GestionnaireElements.getInstance().ajouterElement(texte1);
		GestionnaireElements.getInstance().ajouterElement(texte2);
		GestionnaireElements.getInstance().ajouterElement(texte3);
		GestionnaireElements.getInstance().ajouterElement(texte4);
		GestionnaireElements.getInstance().ajouterElement(texte5);
		
		List<Texte> list = new ArrayList<Texte>();
		list.add(texte1);
		list.add(texte2);
		list.add(texte3);
		list.add(texte4);
		list.add(texte5);
		
		conteneur.setElementsTextuel(list);
		
		texte1.setCoordonneesX(texte1.calculerPositionX());
		texte1.setCoordonneesY(texte1.calculerPositionY());
		texte2.setCoordonneesX(texte2.calculerPositionX());
		texte2.setCoordonneesY(texte2.calculerPositionY());
		texte3.setCoordonneesX(texte3.calculerPositionX());
		texte3.setCoordonneesY(texte3.calculerPositionY());
		texte4.setCoordonneesX(texte4.calculerPositionX());
		texte4.setCoordonneesY(texte4.calculerPositionY());
		texte5.setCoordonneesX(texte5.calculerPositionX());
		texte5.setCoordonneesY(texte5.calculerPositionY());
		
		conteneur.setCurseur(curseur);
		
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame jeu, Graphics graphisme) throws SlickException 
	{
		
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
	 			
	 			String selection = GestionnaireOptions.getInstance().getSelection();
	 			AppGameContainer container = ((AppGameContainer)this.getJeu().getContainer());
	 			
	 			if(selection.equals(GestionnaireOptions.OPTION1))
	 			{
	 				
	 				try 
	 				{
	 					container.setDisplayMode(1366, 768, true);
					}
	 				catch (SlickException e) 
	 				{
						e.printStackTrace();
					}
	 				
	 			}
	 			else if(selection.equals(GestionnaireOptions.OPTION2))
				{
	 				
	 				container.setMusicOn(true);
	 				
	 				try 
	 				{
						Music music = new Music("C:/Users/Rosemonde/Downloads/awildcreatureappears.ogg");
						music.loop();
					}
	 				catch (SlickException e) 
	 				{
						e.printStackTrace();
					}
	 				
				}
	 			else if(selection.equals(GestionnaireOptions.OPTION3))
				{
	 				
	 				Options option = GestionnaireOptions.getInstance().getDonneesOption();
	 				option.setVolumeMusiques(option.getVolumeMusiques() + 1f);
	 				
				}
	 			else if(selection.equals(GestionnaireOptions.OPTION4))
				{
	 				
	 				Options option = GestionnaireOptions.getInstance().getDonneesOption();
	 				option.setVolumeBruitages(option.getVolumeBruitages() + 1f);
	 				
				}
	 			else if(selection.equals(GestionnaireOptions.OPTION7))
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
