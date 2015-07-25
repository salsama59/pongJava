package elementsJeu;

import org.newdawn.slick.geom.Rectangle;

import constantes.ConstantesElements;

public class Raquette extends Element
{
	private Rectangle element = null;
	private float vitesse;
	private boolean enDeplacement = false;
	private int direction = ConstantesElements.ELEMENT_DIRECTION_NEUTRE;

	public Raquette(float x, float y, float largeur, float longueur, float v) 
	{
		super();
		this.setElement(new Rectangle(x,y,largeur,longueur));
		this.setVitesse(v);
	}

	public float getVitesse() {
		return vitesse;
	}

	public void setVitesse(float vitesse) {
		this.vitesse = vitesse;
	}

	public Rectangle getElement() {
		return element;
	}

	private void setElement(Rectangle element) {
		this.element = element;
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
	
	public float getLargeur()
	{
		return this.getElement().getWidth();
	}
	
	public float getHauteur()
	{
		return this.getElement().getHeight();
	}
	
	public void setLargeur(float largeur)
	{
		this.getElement().setWidth(largeur);
	}
	
	public void setHauteur(float hauteur)
	{
		this.getElement().setHeight(hauteur);
	}

	public boolean isEnDeplacement() {
		return enDeplacement;
	}

	public void setEnDeplacement(boolean enDeplacement) {
		this.enDeplacement = enDeplacement;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}


}
