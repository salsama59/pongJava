package etatsJeu;
import managers.collisions.GestionnaireCollisionsBalle;
import managers.collisions.GestionnaireCollisionsRaquette;
import managers.elements.GestionnaireElements;
import mecanismes.implementations.LogicDeplacementsEtatsElementsJeuBalleImpl;
import mecanismes.implementations.LogicDeplacementsEtatsElementsJeuRaquetteImpl;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import constantes.ConstantesElements;
import constantes.ConstantesEtat;
import elementsJeu.Balle;
import elementsJeu.Filet;
import elementsJeu.Mur;
import elementsJeu.Raquette;


public class EtatMatch extends BasicGameState 
{
	
	private static final int ID = ConstantesEtat.ETAT_MATCH;
	private Mur mur1, mur2;
	private Filet filet1, filet2;
	private Raquette raquette1, raquette2;
	private Balle balle;
	private LogicDeplacementsEtatsElementsJeuRaquetteImpl mecanismeRaquette;
	private LogicDeplacementsEtatsElementsJeuBalleImpl mecanismeBalle;
	private GestionnaireCollisionsBalle gestionnaireColisionBalle;
	private GestionnaireCollisionsRaquette gestionnaireColisionRaquette;
	private GestionnaireElements gestionnaireElement;

	@Override
	public void init(GameContainer container, StateBasedGame etat) throws SlickException 
	{
		gestionnaireElement = new GestionnaireElements();
		mur1 = new Mur(ConstantesElements.ELEMENT_MUR1_COORDONEE_X, ConstantesElements.ELEMENT_MUR1_COORDONEE_Y, ConstantesElements.ELEMENT_MUR1_LARGEUR, ConstantesElements.ELEMENT_MUR1_HAUTEUR);
		mur2 = new Mur(ConstantesElements.ELEMENT_MUR2_COORDONEE_X, ConstantesElements.ELEMENT_MUR2_COORDONEE_Y, ConstantesElements.ELEMENT_MUR2_LARGEUR, ConstantesElements.ELEMENT_MUR2_HAUTEUR);
		raquette1 = new Raquette(ConstantesElements.ELEMENT_RAQUETTE1_COORDONEE_X, ConstantesElements.ELEMENT_RAQUETTE1_COORDONEE_Y, ConstantesElements.ELEMENT_RAQUETTE1_LARGEUR, ConstantesElements.ELEMENT_RAQUETTE1_HAUTEUR, ConstantesElements.ELEMENT_RAQUETTE1_VITESSE);
		raquette2 = new Raquette(ConstantesElements.ELEMENT_RAQUETTE2_COORDONEE_X, ConstantesElements.ELEMENT_RAQUETTE2_COORDONEE_Y, ConstantesElements.ELEMENT_RAQUETTE2_LARGEUR, ConstantesElements.ELEMENT_RAQUETTE2_HAUTEUR, ConstantesElements.ELEMENT_RAQUETTE2_VITESSE);
		balle = new Balle();
		mecanismeRaquette = new LogicDeplacementsEtatsElementsJeuRaquetteImpl(raquette1);
		gestionnaireElement.ajouterElement(mur1);
		gestionnaireElement.ajouterElement(mur2);
		gestionnaireElement.ajouterElement(raquette1);
		gestionnaireElement.ajouterElement(raquette2);
		gestionnaireElement.ajouterElement(balle);
		
		mecanismeBalle = new LogicDeplacementsEtatsElementsJeuBalleImpl(balle);
		gestionnaireColisionBalle = new GestionnaireCollisionsBalle(balle, gestionnaireElement.getListElements());
		gestionnaireColisionRaquette = new GestionnaireCollisionsRaquette(raquette1, gestionnaireElement.getListElements());
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
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame etat, int delta) throws SlickException 
	{
		mecanismeRaquette.gererDeplacements(delta);
		mecanismeBalle.gererDeplacements(delta);
		gestionnaireColisionBalle.gererCollision(delta);
		gestionnaireColisionRaquette.gererCollision(delta);
	}
	
	@Override
	public void keyPressed(int key, char c) 
	{
		mecanismeRaquette.gererEtats(key, c);
		mecanismeBalle.gererEtats(key, c);
	}
	
	@Override
	public void keyReleased(int key, char c) 
	{
		mecanismeRaquette.reinitialisationEtat(key, c);
		mecanismeBalle.reinitialisationEtat(key, c);
	}

	@Override
	public int getID() 
	{
		return ID;
	}
	
}
