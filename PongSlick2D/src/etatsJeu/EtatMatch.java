package etatsJeu;
import java.util.ArrayList;
import java.util.List;

import managers.collisions.GestionnaireCollisionsBalle;
import managers.collisions.GestionnaireCollisionsFilet;
import managers.collisions.GestionnaireCollisionsMur;
import managers.collisions.GestionnaireCollisionsRaquette;
import managers.elements.GestionnaireElements;
import managers.etat.GestionnaireMatch;
import mecanismes.implementations.LogicDeplacementsElementsBalleImpl;
import mecanismes.implementations.LogicDeplacementsElementsCurseurImpl;
import mecanismes.implementations.LogicDeplacementsElementsRaquetteImpl;

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
import elementGraphique.Texte;
import elementsJeu.Balle;
import elementsJeu.Curseur;
import elementsJeu.Filet;
import elementsJeu.Mur;
import elementsJeu.Raquette;


public class EtatMatch extends BasicGameState 
{
	
	public static final int ID = ConstantesEtat.ETAT_MATCH;
	private static String phase = ConstantesEtat.ETAT_MATCH_PHASE_MISE_EN_JEU;
	private StateBasedGame jeu;
	private Mur mur1, mur2;
	private Filet filet1, filet2;
	private Raquette raquette1, raquette2;
	private Balle balle;
<<<<<<< .mine
	private Curseur curseur;
	private Conteneur menuMiseEnJeu;
	private Conteneur menuResultat;
	private Texte texte1;
	private Texte texte2;
	private Texte texte3;
	private Texte texte4;
	private LogicDeplacementsElementsCurseurImpl logicDeplacementCurseur;
	private LogicDeplacementsElementsRaquetteImpl mecanismeRaquette1;
	private LogicDeplacementsElementsRaquetteImpl mecanismeRaquette2;
	private LogicDeplacementsElementsBalleImpl mecanismeBalle;
=======
	private Curseur curseur;
	private Conteneur menuMiseEnJeu;
	private Conteneur menuResultat;
	private Texte texte1;
	private Texte texte2;
	private Texte texte3;
	private LogicDeplacementsElementsCurseurImpl logicDeplacementCurseur;
	private LogicDeplacementsElementsRaquetteImpl mecanismeRaquette1;
	private LogicDeplacementsElementsRaquetteImpl mecanismeRaquette2;
	private LogicDeplacementsElementsBalleImpl mecanismeBalle;
>>>>>>> .r59
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
		
		initialiserElements(container);
		initialiserGestionnaires();
		initialiserMecanisme();
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame etat, Graphics graphisme) throws SlickException 
	{
		
		if(EtatMatch.getPhase().equals(ConstantesEtat.ETAT_MATCH_PHASE_PARTIE))
		{
			graphisme.draw(raquette1.getElement());
			graphisme.draw(raquette2.getElement());
			//graphisme.setColor(Color.blue);
			graphisme.draw(balle.getElement());
			graphisme.draw(mur1.getElement());
			graphisme.draw(mur2.getElement());
			graphisme.draw(filet1.getElement());
			graphisme.draw(filet2.getElement());
			
			graphisme.drawString("" + GestionnaireMatch.getInstance().getPointCampDroit(), ConstantesAffichageInfos.INFOS_POSITION_X_SCORE_CAMP_DROITE, ConstantesAffichageInfos.INFOS_POSITION_Y_SCORE_CAMP_DROITE);
			graphisme.drawString("" + GestionnaireMatch.getInstance().getPointCampGauche(), ConstantesAffichageInfos.INFOS_POSITION_X_SCORE_CAMP_GAUCHE, ConstantesAffichageInfos.INFOS_POSITION_Y_SCORE_CAMP_GAUCHE);
		}
		
<<<<<<< .mine
		if(EtatMatch.getPhase().equals(ConstantesEtat.ETAT_MATCH_PHASE_MISE_EN_JEU))
		{
			menuMiseEnJeu.afficher(graphisme);
		}
		
		if(EtatMatch.getPhase().equals(ConstantesEtat.ETAT_MATCH_PHASE_RESULTAT))
		{
			menuResultat.afficher(graphisme, "Le vainqueur est le camp " + GestionnaireMatch.getInstance().getCampVainqueur());
		}
		
=======
		if(EtatMatch.getPhase().equals(ConstantesEtat.ETAT_MATCH_PHASE_MISE_EN_JEU))
		{
			menuMiseEnJeu.afficher(graphisme);
		}
		
		if(EtatMatch.getPhase().equals(ConstantesEtat.ETAT_MATCH_PHASE_RESULTAT))
		{
			menuResultat.afficher(graphisme, "Le vainqueur est : " + GestionnaireMatch.getInstance().getCampVainqueur());
		}
		
>>>>>>> .r59
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
		
		this.initialiserElements(container);
		initialiserGestionnaires();
		initialiserMecanisme();
		initialiserInformationsMatch();
		
	}
	
	private void initialiserElements(GameContainer gameContainer)
	{
		//Elements nécéssaire à la partie
		mur1 = new Mur(ConstantesElements.ELEMENT_MUR1_COORDONEE_X, ConstantesElements.ELEMENT_MUR1_COORDONEE_Y, ConstantesElements.ELEMENT_MUR1_LARGEUR, ConstantesElements.ELEMENT_MUR1_HAUTEUR, ConstantesElements.ELEMENT_MUR1_NOM);
		mur2 = new Mur(ConstantesElements.ELEMENT_MUR2_COORDONEE_X, ConstantesElements.ELEMENT_MUR2_COORDONEE_Y, ConstantesElements.ELEMENT_MUR2_LARGEUR, ConstantesElements.ELEMENT_MUR2_HAUTEUR, ConstantesElements.ELEMENT_MUR2_NOM);
		raquette1 = new Raquette(ConstantesElements.ELEMENT_RAQUETTE1_COORDONEE_X, ConstantesElements.ELEMENT_RAQUETTE1_COORDONEE_Y, ConstantesElements.ELEMENT_RAQUETTE1_LARGEUR, ConstantesElements.ELEMENT_RAQUETTE1_HAUTEUR, ConstantesElements.ELEMENT_RAQUETTE1_VITESSE, ConstantesElements.ELEMENT_RAQUETTE1_NOM, ConstantesJoueurs.JOUEUR_CAMP_GAUCHE, ConstantesJoueurs.JOUEUR_ID_1);
		raquette2 = new Raquette(ConstantesElements.ELEMENT_RAQUETTE2_COORDONEE_X, ConstantesElements.ELEMENT_RAQUETTE2_COORDONEE_Y, ConstantesElements.ELEMENT_RAQUETTE2_LARGEUR, ConstantesElements.ELEMENT_RAQUETTE2_HAUTEUR, ConstantesElements.ELEMENT_RAQUETTE2_VITESSE, ConstantesElements.ELEMENT_RAQUETTE2_NOM, ConstantesJoueurs.JOUEUR_CAMP_DROITE, ConstantesJoueurs.JOUEUR_ID_2);
		balle = new Balle(ConstantesElements.ELEMENT_BALLE_CENTRE_X, ConstantesElements.ELEMENT_BALLE_CENTRE_Y, ConstantesElements.ELEMENT_BALLE_RAYON, ConstantesElements.ELEMENT_BALLE_NOM);
		filet1 = new Filet(ConstantesElements.ELEMENT_FILET1_COORDONEE_X, ConstantesElements.ELEMENT_FILET1_COORDONEE_Y, ConstantesElements.ELEMENT_FILET1_LARGEUR, ConstantesElements.ELEMENT_FILET1_HAUTEUR, ConstantesElements.ELEMENT_FILET1_NOM, ConstantesJoueurs.JOUEUR_CAMP_GAUCHE);
		filet2 = new Filet(ConstantesElements.ELEMENT_FILET2_COORDONEE_X, ConstantesElements.ELEMENT_FILET2_COORDONEE_Y, ConstantesElements.ELEMENT_FILET2_LARGEUR, ConstantesElements.ELEMENT_FILET2_HAUTEUR, ConstantesElements.ELEMENT_FILET2_NOM, ConstantesJoueurs.JOUEUR_CAMP_DROITE);
<<<<<<< .mine
		
		
		//Elements nécéssaire à la mise en jeu
		menuMiseEnJeu = new Conteneur((gameContainer.getWidth()/2) - 150, (gameContainer.getHeight()/2) - 40);
		curseur = new Curseur(ConstantesElements.ELEMENT_CURSEUR_NOM_MISE_EN_JEU, false, ConstantesElements.ELEMENT_CURSEUR_TYPE, menuMiseEnJeu.getCentreX() + 130 - 30, menuMiseEnJeu.getCentreY() + 40);
		logicDeplacementCurseur = new LogicDeplacementsElementsCurseurImpl(curseur);
		
		
		String messageJoueur = "Joueur " + GestionnaireMatch.getInstance().getIdJoueurAvantage() + " veuillez faire votre choix";
		texte1 = new Texte("PILE", 0, 0, menuMiseEnJeu, gameContainer, false);
		texte2 = new Texte("FACE", 0, 0, menuMiseEnJeu, gameContainer, false);
		texte4 = new Texte(messageJoueur, 0, 0, menuMiseEnJeu, gameContainer, false);
		menuMiseEnJeu.setTitreMenu(texte4);
		
		GestionnaireElements.getInstance().ajouterElement(texte1);
		GestionnaireElements.getInstance().ajouterElement(texte2);
		GestionnaireElements.getInstance().ajouterElement(texte4);
		
		List<Texte> list = new ArrayList<Texte>();
		list.add(texte1);
		list.add(texte2);
		
		menuMiseEnJeu.setElementsTextuel(list);
		menuMiseEnJeu.setCurseur(curseur);
		
		GestionnaireMatch.getInstance().miseAjourChoixMiseEnJeuJoueur(curseur.getIndexCourant());
		
		
		//Elements nécessaire aux résultats
		
		menuResultat = new Conteneur((gameContainer.getWidth()/2) - 150, (gameContainer.getHeight()/2) - 40);
		texte3 = new Texte("Le vainqueur est : ", 0, 0, menuResultat, gameContainer, true);
		List<Texte> listResultat = new ArrayList<Texte>();
		listResultat.add(texte3);
		menuResultat.setElementsTextuel(listResultat);
		
=======
		
		
		//Elements nécéssaire à la mise en jeu
		menuMiseEnJeu = new Conteneur((gameContainer.getWidth()/2) - 150, (gameContainer.getHeight()/2) - 40);
		curseur = new Curseur(ConstantesElements.ELEMENT_CURSEUR_NOM, false, ConstantesElements.ELEMENT_CURSEUR_TYPE, menuMiseEnJeu.getCentreX() + 130 - 30, menuMiseEnJeu.getCentreY() + 40);
		logicDeplacementCurseur = new LogicDeplacementsElementsCurseurImpl(curseur);
		texte1 = new Texte("PILE", 0, 0, menuMiseEnJeu, gameContainer, false);
		texte2 = new Texte("FACE", 0, 0, menuMiseEnJeu, gameContainer, false);
		GestionnaireElements.getInstance().ajouterElement(texte1);
		GestionnaireElements.getInstance().ajouterElement(texte2);
		List<Texte> list = new ArrayList<Texte>();
		list.add(texte1);
		list.add(texte2);
		menuMiseEnJeu.setElementsTextuel(list);
		texte1.setCoordonneesX(texte1.calculerPositionX());
		texte1.setCoordonneesY(texte1.calculerPositionY());
		texte2.setCoordonneesX(texte2.calculerPositionX());
		texte2.setCoordonneesY(texte2.calculerPositionY());
		menuMiseEnJeu.setCurseur(curseur);
		
		GestionnaireMatch.getInstance().miseAjourChoixMiseEnJeuJoueur(curseur.getIndexCourant());
		
		
		//Elements nécessaire aux résultats
		
		menuResultat = new Conteneur((gameContainer.getWidth()/2) - 150, (gameContainer.getHeight()/2) - 40);
		texte3 = new Texte("Le vainqueur est : ", 0, 0, menuResultat, gameContainer, true);
		List<Texte> listResultat = new ArrayList<Texte>();
		listResultat.add(texte3);
		menuResultat.setElementsTextuel(listResultat);
		
>>>>>>> .r59
	}
	
	private void initialiserGestionnaires()
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
	
	private void initialiserMecanisme()
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
}
