package elementsJeu;

import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Vector2f;

import constantes.ConstantesElements;

public class Curseur extends Element 
{
	
	private Polygon element = null;
	private float vitesse;
	private boolean enDeplacement = false;
	private float direction;
	private Vector2f coordonnee = null;
	
	public Curseur(String nom, boolean enCollision, String type, float x, float y)
	{
		super(nom, enCollision, type, null);
		this.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
		this.setElement(new Polygon(new float[]{0f,0f,0f,ConstantesElements.ELEMENT_CURSEUR_HAUTEUR,ConstantesElements.ELEMENT_CURSEUR_LARGEUR,ConstantesElements.ELEMENT_CURSEUR_HAUTEUR/2}));
		this.setVitesse(ConstantesElements.ELEMENT_BALLE_VITESSE);
		this.setCoordonnee(new Vector2f(x, y));
		this.getElement().setX(x);
		this.getElement().setY(y);
		this.setDirection((float) this.getCoordonnee().getTheta());
	}

	public Polygon getElement() {
		return element;
	}

	public void setElement(Polygon element) {
		this.element = element;
	}

	public float getVitesse() {
		return vitesse;
	}

	public void setVitesse(float vitesse) {
		this.vitesse = vitesse;
	}

	public boolean isEnDeplacement() {
		return enDeplacement;
	}

	public void setEnDeplacement(boolean enDeplacement) {
		this.enDeplacement = enDeplacement;
	}

	public float getDirection() {
		return direction;
	}

	public void setDirection(float direction) {
		this.direction = direction;
	}

	public Vector2f getCoordonnee() {
		return coordonnee;
	}

	public void setCoordonnee(Vector2f coordonnee) {
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
	
	
}
