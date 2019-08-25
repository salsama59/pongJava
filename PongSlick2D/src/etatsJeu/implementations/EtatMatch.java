package etatsJeu.implementations;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import constantes.ConstantesAffichageInfos;
import constantes.ConstantesElements;
import constantes.ConstantesEtat;
import constantes.ConstantesGestionnaires;
import constantes.ConstantesJoueurs;
import elementGraphique.Conteneur;
import elementsJeu.Balle;
import elementsJeu.Filet;
import elementsJeu.Mur;
import elementsJeu.Raquette;
import etatsJeu.interfaces.EtatJeu;
import managers.collisions.GestionnaireCollisionsBalle;
import managers.collisions.GestionnaireCollisionsFilet;
import managers.collisions.GestionnaireCollisionsMur;
import managers.collisions.GestionnaireCollisionsRaquette;
import managers.elements.GestionnaireElements;
import managers.etat.GestionnaireMatch;
import mecanismes.implementations.LogicDeplacementsElementsBalleImpl;
import mecanismes.implementations.LogicDeplacementsElementsCurseurImpl;
import mecanismes.implementations.LogicDeplacementsElementsRaquetteImpl;
import menu.MenuJeu;


public class EtatMatch extends BasicGameState implements EtatJeu
{
	//private Image imageArene;
	public static final int ID = ConstantesEtat.ETAT_MATCH;
	private static String phase = ConstantesEtat.ETAT_MATCH_PHASE_MISE_EN_JEU;
	private StateBasedGame jeu;
	private Mur mur1, mur2;
	private Filet filet1, filet2;
	private Raquette raquette1, raquette2;
	private Balle balle;
	private MenuJeu menuMiseEnJeu;
	private MenuJeu menuResultat;
	private Conteneur conteneurMenuMiseEnJeu;
	private Conteneur conteneurMenuResultat;
	private LogicDeplacementsElementsCurseurImpl logicDeplacementCurseur;
	private LogicDeplacementsElementsRaquetteImpl mecanismeRaquette1;
	private LogicDeplacementsElementsRaquetteImpl mecanismeRaquette2;
	private LogicDeplacementsElementsBalleImpl mecanismeBalle;
	private GestionnaireCollisionsBalle gestionnaireColisionBalle;
	private GestionnaireCollisionsRaquette gestionnaireColisionRaquette1;
	private GestionnaireCollisionsRaquette gestionnaireColisionRaquette2;
	private GestionnaireCollisionsFilet gestionnaireCollisionFilet1;
	private GestionnaireCollisionsFilet gestionnaireCollisionFilet2;
	private GestionnaireCollisionsMur gestionnaireColisionMur1;
	private GestionnaireCollisionsMur gestionnaireColisionMur2;
	private boolean transitionFinPartie;

	@Override
	public void init(GameContainer container, StateBasedGame jeu) throws SlickException 
	{
		this.setJeu(jeu);
		this.setTransitionFinPartie(false);
		this.creerMenu(container);
		this.initialiserElements(container);
		this.initialiserGestionnaires();
		this.initialiserMecanisme();
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame etat, Graphics graphisme) throws SlickException 
	{
		
		if(EtatMatch.getPhase().equals(ConstantesEtat.ETAT_MATCH_PHASE_PARTIE))
		{
			
			//graphisme.drawImage(imageArene, 0, 0, ConstantesJeu.ECRAN_LARGEUR, ConstantesJeu.ECRAN_HAUTEUR, 0, 0, 1280, 720);	
			graphisme.draw(raquette1.getElement());
			graphisme.draw(raquette2.getElement());
			graphisme.draw(balle.getElement());
			graphisme.draw(mur1.getElement());
			graphisme.draw(mur2.getElement());
			graphisme.draw(filet1.getElement());
			graphisme.draw(filet2.getElement());
			
			graphisme.drawString("" + GestionnaireMatch.getInstance().getPointCampDroit(), ConstantesAffichageInfos.INFOS_POSITION_X_SCORE_CAMP_DROITE, ConstantesAffichageInfos.INFOS_POSITION_Y_SCORE_CAMP_DROITE);
			graphisme.drawString("" + GestionnaireMatch.getInstance().getPointCampGauche(), ConstantesAffichageInfos.INFOS_POSITION_X_SCORE_CAMP_GAUCHE, ConstantesAffichageInfos.INFOS_POSITION_Y_SCORE_CAMP_GAUCHE);
		}
		
		if(EtatMatch.getPhase().equals(ConstantesEtat.ETAT_MATCH_PHASE_MISE_EN_JEU))
		{
			//graphisme.drawImage(imageArene, 0, 0, ConstantesJeu.ECRAN_LARGEUR, ConstantesJeu.ECRAN_HAUTEUR, 0, 0, 1280, 720);
			conteneurMenuMiseEnJeu.afficher(graphisme);
		}
		
		if(EtatMatch.getPhase().equals(ConstantesEtat.ETAT_MATCH_PHASE_RESULTAT))
		{
			//graphisme.drawImage(imageArene, 0, 0, ConstantesJeu.ECRAN_LARGEUR, ConstantesJeu.ECRAN_HAUTEUR, 0, 0, 1280, 720);
			conteneurMenuResultat.afficher(graphisme, this.menuResultat.recupererLibelle("ligne.resultat.0") + GestionnaireMatch.getInstance().getCampVainqueur());
		}
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame etat, int delta) throws SlickException 
	{
		
		
		if(EtatMatch.getPhase().equals(ConstantesEtat.ETAT_MATCH_PHASE_PARTIE))
		{
			gestionnaireColisionBalle.gererCollision(delta);
			mecanismeBalle.gererDeplacements(delta, EtatMatch.getPhase(), container);
			
			gestionnaireColisionRaquette1.gererCollision(delta);
			gestionnaireColisionRaquette2.gererCollision(delta);
			mecanismeRaquette1.gererDeplacements(delta, EtatMatch.getPhase(), container);
			mecanismeRaquette2.gererDeplacements(delta, EtatMatch.getPhase(), container);
			
			gestionnaireCollisionFilet1.gererCollision(delta);
			gestionnaireCollisionFilet2.gererCollision(delta);
			
			gestionnaireColisionMur1.gererCollision(delta);
			gestionnaireColisionMur2.gererCollision(delta);
		}
		
		if(EtatMatch.getPhase().equals(ConstantesEtat.ETAT_MATCH_PHASE_MISE_EN_JEU))
		{
			logicDeplacementCurseur.gererDeplacements(delta, EtatMatch.getPhase(), container);
		}
		
	}
	
	@Override
	public void keyPressed(int key, char c) 
	{
		
		if(EtatMatch.getPhase().equals(ConstantesEtat.ETAT_MATCH_PHASE_PARTIE))
		{
			mecanismeRaquette1.gererEtats(key, c, this.getJeu().getContainer());
			mecanismeRaquette2.gererEtats(key, c, this.getJeu().getContainer());
			mecanismeBalle.gererEtats(key, c, this.getJeu().getContainer());
		}
		
		if(EtatMatch.getPhase().equals(ConstantesEtat.ETAT_MATCH_PHASE_MISE_EN_JEU))
		{
			
			logicDeplacementCurseur.gererEtats(key, c, this.getJeu().getContainer());
			
		}
		
		if(EtatMatch.getPhase().equals(ConstantesEtat.ETAT_MATCH_PHASE_RESULTAT))
		{
			
			switch (key) 
		    {
				
			 	case Input.KEY_RETURN :
		 		
		 		this.setTransitionFinPartie(true);
		 		
			 	break;
			 	
		    }
			
		}
		
	}
	
	@Override
	public void keyReleased(int key, char c) 
	{
		
		if(EtatMatch.getPhase().equals(ConstantesEtat.ETAT_MATCH_PHASE_PARTIE))
		{
			mecanismeRaquette1.reinitialisationEtat(key, c);
			mecanismeRaquette2.reinitialisationEtat(key, c);
			mecanismeBalle.reinitialisationEtat(key, c);
		}
		
		if(EtatMatch.getPhase().equals(ConstantesEtat.ETAT_MATCH_PHASE_MISE_EN_JEU))
		{
			
			switch (key) 
		    {
				
			 	case Input.KEY_RETURN:
		 		
			 	if(!this.isTransitionFinPartie())
			 	{
			 		GestionnaireMatch.getInstance().attribuerLancementBalle();
					
					if(GestionnaireMatch.getInstance().getIdLanceur() == ConstantesJoueurs.JOUEUR_ID_1)
					{
						balle.setCentreX(ConstantesElements.ELEMENT_RAQUETTE1_ZONE_LANCEMENT_X);
						balle.setCentreY(ConstantesElements.ELEMENT_RAQUETTE1_ZONE_LANCEMENT_Y);
						Raquette r = (Raquette)GestionnaireElements.recupererElementParNom(ConstantesElements.ELEMENT_RAQUETTE1_NOM);
						r.setEtat(ConstantesElements.ELEMENT_ETAT_LANCEMENT);
					}
					else if(GestionnaireMatch.getInstance().getIdLanceur() == ConstantesJoueurs.JOUEUR_ID_2)
					{
						balle.setCentreX(ConstantesElements.ELEMENT_RAQUETTE2_ZONE_LANCEMENT_X);
						balle.setCentreY(ConstantesElements.ELEMENT_RAQUETTE2_ZONE_LANCEMENT_Y);
						Raquette r = (Raquette)GestionnaireElements.recupererElementParNom(ConstantesElements.ELEMENT_RAQUETTE2_NOM);
						r.setEtat(ConstantesElements.ELEMENT_ETAT_LANCEMENT);
					}
					
					EtatMatch.setPhase(ConstantesEtat.ETAT_MATCH_PHASE_PARTIE);
			 	}
	 			
		 		
		        break;
		        
		    }
			
			logicDeplacementCurseur.reinitialisationEtat(key, c);
			
		}
		
		if(EtatMatch.getPhase().equals(ConstantesEtat.ETAT_MATCH_PHASE_RESULTAT))
		{
			
			switch (key) 
		    {
				
			 	case Input.KEY_RETURN:
		 		
		 		try 
		 		{
		 			EtatMatch.setPhase(ConstantesEtat.ETAT_MATCH_PHASE_MISE_EN_JEU);
			 		this.setTransitionFinPartie(false);
					this.reinitialisationEtatMatch(this.getJeu().getContainer(), this.getJeu());
				} 
		 		catch (SlickException e) 
		 		{
					e.printStackTrace();
				}
		 		
			 	break;
		    }
			
		}
		
	}

	@Override
	public int getID() 
	{
		return ID;
	}
	
	
	public void reinitialisationEtatMatch(GameContainer container, StateBasedGame game) throws SlickException
	{
		this.creerMenu(container);
		this.initialiserElements(container);
		initialiserGestionnaires();
		initialiserMecanisme();
		initialiserInformationsMatch();
		
	}
	
	@Override
	public void initialiserElements(GameContainer gameContainer) throws SlickException
	{	
		//Elements n�c�ssaire � la partie
		mur1 = new Mur(ConstantesElements.ELEMENT_MUR1_COORDONEE_X, ConstantesElements.ELEMENT_MUR1_COORDONEE_Y, ConstantesElements.ELEMENT_MUR1_LARGEUR, ConstantesElements.ELEMENT_MUR1_HAUTEUR, ConstantesElements.ELEMENT_MUR1_NOM);
		mur2 = new Mur(ConstantesElements.ELEMENT_MUR2_COORDONEE_X, ConstantesElements.ELEMENT_MUR2_COORDONEE_Y, ConstantesElements.ELEMENT_MUR2_LARGEUR, ConstantesElements.ELEMENT_MUR2_HAUTEUR, ConstantesElements.ELEMENT_MUR2_NOM);
		raquette1 = new Raquette(ConstantesElements.ELEMENT_RAQUETTE1_COORDONEE_X, ConstantesElements.ELEMENT_RAQUETTE1_COORDONEE_Y, ConstantesElements.ELEMENT_RAQUETTE1_LARGEUR, ConstantesElements.ELEMENT_RAQUETTE1_HAUTEUR, ConstantesElements.ELEMENT_RAQUETTE1_VITESSE, ConstantesElements.ELEMENT_RAQUETTE1_NOM, ConstantesJoueurs.JOUEUR_CAMP_GAUCHE, ConstantesJoueurs.JOUEUR_ID_1, null);
		raquette2 = new Raquette(ConstantesElements.ELEMENT_RAQUETTE2_COORDONEE_X, ConstantesElements.ELEMENT_RAQUETTE2_COORDONEE_Y, ConstantesElements.ELEMENT_RAQUETTE2_LARGEUR, ConstantesElements.ELEMENT_RAQUETTE2_HAUTEUR, ConstantesElements.ELEMENT_RAQUETTE2_VITESSE, ConstantesElements.ELEMENT_RAQUETTE2_NOM, ConstantesJoueurs.JOUEUR_CAMP_DROITE, ConstantesJoueurs.JOUEUR_ID_2, null);
		balle = new Balle(ConstantesElements.ELEMENT_BALLE_CENTRE_X, ConstantesElements.ELEMENT_BALLE_CENTRE_Y, ConstantesElements.ELEMENT_BALLE_RAYON, ConstantesElements.ELEMENT_BALLE_NOM, null, null);
		filet1 = new Filet(ConstantesElements.ELEMENT_FILET1_COORDONEE_X, ConstantesElements.ELEMENT_FILET1_COORDONEE_Y, ConstantesElements.ELEMENT_FILET1_LARGEUR, ConstantesElements.ELEMENT_FILET1_HAUTEUR, ConstantesElements.ELEMENT_FILET1_NOM, ConstantesJoueurs.JOUEUR_CAMP_GAUCHE);
		filet2 = new Filet(ConstantesElements.ELEMENT_FILET2_COORDONEE_X, ConstantesElements.ELEMENT_FILET2_COORDONEE_Y, ConstantesElements.ELEMENT_FILET2_LARGEUR, ConstantesElements.ELEMENT_FILET2_HAUTEUR, ConstantesElements.ELEMENT_FILET2_NOM, ConstantesJoueurs.JOUEUR_CAMP_DROITE);
		
		GestionnaireMatch.getInstance().miseAjourChoixMiseEnJeuJoueur(0);
		
	}
	
	@Override
	public void initialiserGestionnaires()
	{
		
		GestionnaireElements.getInstance().ajouterElement(mur1);
		GestionnaireElements.getInstance().ajouterElement(mur2);
		GestionnaireElements.getInstance().ajouterElement(raquette1);
		GestionnaireElements.getInstance().ajouterElement(raquette2);
		GestionnaireElements.getInstance().ajouterElement(balle);
		GestionnaireElements.getInstance().ajouterElement(filet1);
		GestionnaireElements.getInstance().ajouterElement(filet2);
		
		gestionnaireColisionBalle = new GestionnaireCollisionsBalle(balle, GestionnaireElements.getInstance().getListeElementsFiltrees(ConstantesGestionnaires.FILTRE_GESTIONNAIRE_BALLE));
		gestionnaireColisionRaquette1 = new GestionnaireCollisionsRaquette(raquette1, GestionnaireElements.getInstance().getListeElementsFiltrees(ConstantesGestionnaires.FILTRE_GESTIONNAIRE_RAQUETTE));
		gestionnaireColisionRaquette2 = new GestionnaireCollisionsRaquette(raquette2, GestionnaireElements.getInstance().getListeElementsFiltrees(ConstantesGestionnaires.FILTRE_GESTIONNAIRE_RAQUETTE));
		gestionnaireCollisionFilet1 = new GestionnaireCollisionsFilet(filet1, GestionnaireElements.getInstance().getListeElementsFiltrees(ConstantesGestionnaires.FILTRE_GESTIONNAIRE_FILET));
		gestionnaireCollisionFilet2 = new GestionnaireCollisionsFilet(filet2, GestionnaireElements.getInstance().getListeElementsFiltrees(ConstantesGestionnaires.FILTRE_GESTIONNAIRE_FILET));
		gestionnaireColisionMur1 = new GestionnaireCollisionsMur(mur1, GestionnaireElements.getInstance().getListeElementsFiltrees(ConstantesGestionnaires.FILTRE_GESTIONNAIRE_MUR));
		gestionnaireColisionMur2 = new GestionnaireCollisionsMur(mur2, GestionnaireElements.getInstance().getListeElementsFiltrees(ConstantesGestionnaires.FILTRE_GESTIONNAIRE_MUR));
		
	}
	
	@Override
	public void initialiserMecanisme()
	{
		mecanismeRaquette1 = new LogicDeplacementsElementsRaquetteImpl(raquette1);
		mecanismeRaquette2 = new LogicDeplacementsElementsRaquetteImpl(raquette2);
		mecanismeBalle = new LogicDeplacementsElementsBalleImpl(balle);
	}
	
	private void initialiserInformationsMatch()
	{
		GestionnaireMatch.getInstance().reinitialiserPointsMatch();
	}

	public static String getPhase() {
		return phase;
	}

	public static void setPhase(String phase) {
		EtatMatch.phase = phase;
	}

	public StateBasedGame getJeu() {
		return jeu;
	}

	public void setJeu(StateBasedGame jeu) {
		this.jeu = jeu;
	}

	public boolean isTransitionFinPartie() {
		return transitionFinPartie;
	}

	public void setTransitionFinPartie(boolean transitionFinPartie) {
		this.transitionFinPartie = transitionFinPartie;
	}

	@Override
	public void creerMenu(GameContainer gameContainer) 
	{
		String titreMenuMiseEnJeu = "Joueur " + GestionnaireMatch.getInstance().getIdJoueurAvantage() + " veuillez faire votre choix";
		menuMiseEnJeu = new MenuJeu(null, "menuMiseEnJeu_fr_FR", ConstantesElements.ELEMENT_MENU_TYPE);
		menuMiseEnJeu.initialiserMenu(gameContainer, false, titreMenuMiseEnJeu, false);
		this.conteneurMenuMiseEnJeu = menuMiseEnJeu.getConteneur();
		
		menuResultat = new MenuJeu(null, "menuResultat_fr_FR", ConstantesElements.ELEMENT_MENU_TYPE);
		menuResultat.initialiserMenu(gameContainer, true, null, true);
		this.conteneurMenuResultat = menuResultat.getConteneur();
		
		logicDeplacementCurseur = new LogicDeplacementsElementsCurseurImpl(menuMiseEnJeu.getConteneur().getCurseur());
		
	}
}
