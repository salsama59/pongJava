package elementsJeu;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Vector2f;

import constantes.ConstantesElements;
import elementGraphique.Conteneur;
import elementGraphique.Texte;

public class Curseur extends Element 
{
	
	private Polygon element = null;
	private float vitesse;
	private boolean enDeplacement = false;
	private float direction;
	private Vector2f coordonnee = null;
	private Conteneur conteneurAffectation = null;
	private int indexCourant = 0;
	
	public Curseur(String nom, boolean enCollision, String type, float x, float y, Image sprite)
	{
		super(nom, enCollision, type, null, sprite);
		this.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
		this.setElement(new Polygon(new float[]{0f,0f,0f,ConstantesElements.ELEMENT_CURSEUR_HAUTEUR,ConstantesElements.ELEMENT_CURSEUR_LARGEUR,ConstantesElements.ELEMENT_CURSEUR_HAUTEUR/2}));
		this.setVitesse(ConstantesElements.ELEMENT_CURSEUR_VITESSE);
		this.setCoordonnee(new Vector2f(x, y));
		this.getElement().setX(x);
		this.getElement().setY(y);
		this.setDirection((float) this.getCoordonnee().getTheta());
	}

	public Polygon getElement() 
	{
		return element;
	}

	public void setElement(Polygon element) 
	{
		this.element = element;
	}

	public float getVitesse() 
	{
		return vitesse;
	}

	public void setVitesse(float vitesse) 
	{
		this.vitesse = vitesse;
	}

	public boolean isEnDeplacement() 
	{
		return enDeplacement;
	}

	public void setEnDeplacement(boolean enDeplacement) 
	{
		this.enDeplacement = enDeplacement;
	}

	public float getDirection() 
	{
		return direction;
	}

	public void setDirection(float direction) 
	{
		this.direction = direction;
	}

	public Vector2f getCoordonnee() 
	{
		return coordonnee;
	}

	public void setCoordonnee(Vector2f coordonnee) 
	{
		this.coordonnee = coordonnee;
	}
	
	public float getCoordonneeX()
	{
		return this.getElement().getX();
	}
	
	public float getCoordonneeY()
	{
		return this.getElement().getY();
	}
	
	public void setCoordonneeX(float x)
	{
		this.getElement().setX(x);
	}
	
	public void setCoordonneeY(float y)
	{
		this.getElement().setY(y);
	}

	public Conteneur getConteneurAffectation() 
	{
		return conteneurAffectation;
	}

	public void setConteneurAffectation(Conteneur conteneurAffectation) 
	{
		this.conteneurAffectation = conteneurAffectation;
	}
	
	public int getIndexCourant() 
	{
		return indexCourant;
	}

	public void setIndexCourant(int indexCourant) 
	{
		this.indexCourant = indexCourant;
	}
	
	public void initialiserEnplacement()
	{
		
		Texte premierElement = this.getConteneurAffectation().getElementsTextuel().get(0);
		this.setCoordonneeY(premierElement.getCoordonneesY());
		this.setCoordonneeX(premierElement.getCoordonneesX() - this.getElement().getWidth());
		
	}
	
	public void afficher(Graphics graphisme)
	{
		graphisme.draw(this.getElement());
	}
	
}
