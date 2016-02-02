package etatsJeu;
import java.util.Hashtable;

import managers.collisions.GestionnaireCollisionsBalle;
import managers.collisions.GestionnaireCollisionsFilet;
import managers.collisions.GestionnaireCollisionsMur;
import managers.collisions.GestionnaireCollisionsRaquette;
import managers.elements.GestionnaireElements;
import managers.etat.GestionnaireMatch;
import mecanismes.implementations.LogicDeplacementsEtatsElementsJeuBalleImpl;
import mecanismes.implementations.LogicDeplacementsEtatsElementsJeuRaquetteImpl;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import constantes.ConstantesAffichageInfos;
import constantes.ConstantesElements;
import constantes.ConstantesEtat;
import constantes.ConstantesGestionnaires;
import constantes.ConstantesJoueurs;
import elementsJeu.Balle;
import elementsJeu.Filet;
import elementsJeu.Mur;
import elementsJeu.Raquette;


public class EtatMatch extends BasicGameState 
{
	
	public static final int ID = ConstantesEtat.ETAT_MATCH;
	private Mur mur1, mur2;
	private Filet filet1, filet2;
	private Raquette raquette1, raquette2;
	private Balle balle;
	private LogicDeplacementsEtatsElementsJeuRaquetteImpl mecanismeRaquette1;
	private LogicDeplacementsEtatsElementsJeuRaquetteImpl mecanismeRaquette2;
	private LogicDeplacementsEtatsElementsJeuBalleImpl mecanismeBalle;
	private GestionnaireCollisionsBalle gestionnaireColisionBalle;
	private GestionnaireCollisionsRaquette gestionnaireColisionRaquette1;
	private GestionnaireCollisionsRaquette gestionnaireColisionRaquette2;
	private GestionnaireCollisionsFilet gestionnaireCollisionFilet1;
	private GestionnaireCollisionsFilet gestionnaireCollisionFilet2;
	private GestionnaireCollisionsMur gestionnaireColisionMur1;
	private GestionnaireCollisionsMur gestionnaireColisionMur2;
	private GestionnaireElements gestionnaireElement;
	private GestionnaireMatch gestionnaireMatch;

	@Override
	public void init(GameContainer container, StateBasedGame etat) throws SlickException 
	{
		
		initialiserElements();
		initialiserGestionnaires();
		initialiserMecanisme();
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame etat, Graphics graphisme) throws SlickException 
	{
		
		graphisme.draw(raquette1.getElement());
		graphisme.draw(raquette2.getElement());
		//graphisme.setColor(Color.blue);
		graphisme.draw(balle.getElement());
		graphisme.draw(mur1.getElement());
		graphisme.draw(mur2.getElement());
		graphisme.draw(filet1.getElement());
		graphisme.draw(filet2.getElement());
		graphisme.drawString("" + gestionnaireMatch.getPointCampDroit(), ConstantesAffichageInfos.INFOS_POSITION_X_SCORE_CAMP_DROITE, ConstantesAffichageInfos.INFOS_POSITION_Y_SCORE_CAMP_DROITE);
		graphisme.drawString("" + gestionnaireMatch.getPointCampGauche(), ConstantesAffichageInfos.INFOS_POSITION_X_SCORE_CAMP_GAUCHE, ConstantesAffichageInfos.INFOS_POSITION_Y_SCORE_CAMP_GAUCHE);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame etat, int delta) throws SlickException 
	{
		
		gestionnaireColisionBalle.gererCollision(delta);
		mecanismeBalle.gererDeplacements(delta);
		
		gestionnaireColisionRaquette1.gererCollision(delta);
		gestionnaireColisionRaquette2.gererCollision(delta);
		mecanismeRaquette1.gererDeplacements(delta);
		mecanismeRaquette2.gererDeplacements(delta);
		
		gestionnaireCollisionFilet1.gererCollision(delta);
		gestionnaireCollisionFilet2.gererCollision(delta);
		
		gestionnaireColisionMur1.gererCollision(delta);
		gestionnaireColisionMur2.gererCollision(delta);
		
	}
	
	@Override
	public void keyPressed(int key, char c) 
	{
		mecanismeRaquette1.gererEtats(key, c);
		mecanismeRaquette2.gererEtats(key, c);
		mecanismeBalle.gererEtats(key, c);
	}
	
	@Override
	public void keyReleased(int key, char c) 
	{
		mecanismeRaquette1.reinitialisationEtat(key, c);
		mecanismeRaquette2.reinitialisationEtat(key, c);
		mecanismeBalle.reinitialisationEtat(key, c);
	}

	@Override
	public int getID() 
	{
		return ID;
	}
	
	private void initialiserElements()
	{
		mur1 = new Mur(ConstantesElements.ELEMENT_MUR1_COORDONEE_X, ConstantesElements.ELEMENT_MUR1_COORDONEE_Y, ConstantesElements.ELEMENT_MUR1_LARGEUR, ConstantesElements.ELEMENT_MUR1_HAUTEUR, ConstantesElements.ELEMENT_MUR1_NOM);
		mur2 = new Mur(ConstantesElements.ELEMENT_MUR2_COORDONEE_X, ConstantesElements.ELEMENT_MUR2_COORDONEE_Y, ConstantesElements.ELEMENT_MUR2_LARGEUR, ConstantesElements.ELEMENT_MUR2_HAUTEUR, ConstantesElements.ELEMENT_MUR2_NOM);
		raquette1 = new Raquette(ConstantesElements.ELEMENT_RAQUETTE1_COORDONEE_X, ConstantesElements.ELEMENT_RAQUETTE1_COORDONEE_Y, ConstantesElements.ELEMENT_RAQUETTE1_LARGEUR, ConstantesElements.ELEMENT_RAQUETTE1_HAUTEUR, ConstantesElements.ELEMENT_RAQUETTE1_VITESSE, ConstantesElements.ELEMENT_RAQUETTE1_NOM, ConstantesJoueurs.JOUEUR_CAMP_GAUCHE, ConstantesJoueurs.JOUEUR_ID_1);
		raquette2 = new Raquette(ConstantesElements.ELEMENT_RAQUETTE2_COORDONEE_X, ConstantesElements.ELEMENT_RAQUETTE2_COORDONEE_Y, ConstantesElements.ELEMENT_RAQUETTE2_LARGEUR, ConstantesElements.ELEMENT_RAQUETTE2_HAUTEUR, ConstantesElements.ELEMENT_RAQUETTE2_VITESSE, ConstantesElements.ELEMENT_RAQUETTE2_NOM, ConstantesJoueurs.JOUEUR_CAMP_DROITE, ConstantesJoueurs.JOUEUR_ID_2);
		balle = new Balle(ConstantesElements.ELEMENT_BALLE_CENTRE_X, ConstantesElements.ELEMENT_BALLE_CENTRE_Y, ConstantesElements.ELEMENT_BALLE_RAYON, ConstantesElements.ELEMENT_BALLE_NOM);
		filet1 = new Filet(ConstantesElements.ELEMENT_FILET1_COORDONEE_X, ConstantesElements.ELEMENT_FILET1_COORDONEE_Y, ConstantesElements.ELEMENT_FILET1_LARGEUR, ConstantesElements.ELEMENT_FILET1_HAUTEUR, ConstantesElements.ELEMENT_FILET1_NOM, ConstantesJoueurs.JOUEUR_CAMP_GAUCHE);
		filet2 = new Filet(ConstantesElements.ELEMENT_FILET2_COORDONEE_X, ConstantesElements.ELEMENT_FILET2_COORDONEE_Y, ConstantesElements.ELEMENT_FILET2_LARGEUR, ConstantesElements.ELEMENT_FILET2_HAUTEUR, ConstantesElements.ELEMENT_FILET2_NOM, ConstantesJoueurs.JOUEUR_CAMP_DROITE);
	}
	
	private void initialiserGestionnaires()
	{
		gestionnaireElement = new GestionnaireElements();
		gestionnaireMatch = new GestionnaireMatch();
		
		Hashtable<Integer, Integer> choix = new Hashtable<Integer, Integer>();
		
		choix.put(1, 1);
		choix.put(2, 2);
		
		gestionnaireMatch.setChoix(choix);
		
		gestionnaireElement.ajouterElement(mur1);
		gestionnaireElement.ajouterElement(mur2);
		gestionnaireElement.ajouterElement(raquette1);
		gestionnaireElement.ajouterElement(raquette2);
		gestionnaireElement.ajouterElement(balle);
		gestionnaireElement.ajouterElement(filet1);
		gestionnaireElement.ajouterElement(filet2);
		
		gestionnaireMatch.attribuerLancementBalle();
		
		if(gestionnaireMatch.getIdLanceur() == ConstantesJoueurs.JOUEUR_ID_1)
		{
			balle.setCentreX(ConstantesElements.ELEMENT_RAQUETTE1_ZONE_LANCEMENT_X);
			balle.setCentreY(ConstantesElements.ELEMENT_RAQUETTE1_ZONE_LANCEMENT_Y);
			Raquette r = (Raquette)GestionnaireElements.recupererElementParNom(ConstantesElements.ELEMENT_RAQUETTE1_NOM);
			r.setEtat(ConstantesElements.ELEMENT_ETAT_LANCEMENT);
		}
		else if(gestionnaireMatch.getIdLanceur() == ConstantesJoueurs.JOUEUR_ID_2)
		{
			balle.setCentreX(ConstantesElements.ELEMENT_RAQUETTE2_ZONE_LANCEMENT_X);
			balle.setCentreY(ConstantesElements.ELEMENT_RAQUETTE2_ZONE_LANCEMENT_Y);
			Raquette r = (Raquette)GestionnaireElements.recupererElementParNom(ConstantesElements.ELEMENT_RAQUETTE2_NOM);
			r.setEtat(ConstantesElements.ELEMENT_ETAT_LANCEMENT);
		}
		
		gestionnaireColisionBalle = new GestionnaireCollisionsBalle(balle, gestionnaireElement.getListeElementsFiltrees(ConstantesGestionnaires.FILTRE_GESTIONNAIRE_BALLE));
		gestionnaireColisionRaquette1 = new GestionnaireCollisionsRaquette(raquette1, gestionnaireElement.getListeElementsFiltrees(ConstantesGestionnaires.FILTRE_GESTIONNAIRE_RAQUETTE));
		gestionnaireColisionRaquette2 = new GestionnaireCollisionsRaquette(raquette2, gestionnaireElement.getListeElementsFiltrees(ConstantesGestionnaires.FILTRE_GESTIONNAIRE_RAQUETTE));
		gestionnaireCollisionFilet1 = new GestionnaireCollisionsFilet(filet1, gestionnaireMatch, gestionnaireElement.getListeElementsFiltrees(ConstantesGestionnaires.FILTRE_GESTIONNAIRE_FILET));
		gestionnaireCollisionFilet2 = new GestionnaireCollisionsFilet(filet2, gestionnaireMatch, gestionnaireElement.getListeElementsFiltrees(ConstantesGestionnaires.FILTRE_GESTIONNAIRE_FILET));
		gestionnaireColisionMur1 = new GestionnaireCollisionsMur(mur1, gestionnaireElement.getListeElementsFiltrees(ConstantesGestionnaires.FILTRE_GESTIONNAIRE_MUR));
		gestionnaireColisionMur2 = new GestionnaireCollisionsMur(mur2, gestionnaireElement.getListeElementsFiltrees(ConstantesGestionnaires.FILTRE_GESTIONNAIRE_MUR));
		
	}
	
	private void initialiserMecanisme()
	{
		mecanismeRaquette1 = new LogicDeplacementsEtatsElementsJeuRaquetteImpl(raquette1);
		mecanismeRaquette2 = new LogicDeplacementsEtatsElementsJeuRaquetteImpl(raquette2);
		mecanismeBalle = new LogicDeplacementsEtatsElementsJeuBalleImpl(balle);
	}
}
