package elementsJeu;

import org.newdawn.slick.geom.Circle;

import constantes.ConstantesElements;

public class Balle extends Element
{
	
	private Circle element = null;
	private float vitesse;
	private boolean enDeplacement = true;
	private int direction = ConstantesElements.ELEMENT_DIRECTION_BAS_GAUCHE;

	public Balle(float centreX, float centreY, float rayon, String nom) 
	{
		super(nom);
		this.setElement(new Circle(centreX,centreY,rayon));
		this.setVitesse(ConstantesElements.ELEMENT_BALLE_VITESSE);
	}

	public float getVitesse() {
		return vitesse;
	}

	public void setVitesse(float vitesse) {
		this.vitesse = vitesse;
	}

	public Circle getElement() {
		return element;
	}

	private void setElement(Circle element) {
		this.element = element;
	}
	
	public float getCentreX()
	{
		return this.getElement().getCenterX();
	}
	
	public float getCentreY()
	{
		return this.getElement().getCenterY();
	}
	
	public void setCentreX(float x)
	{
		this.getElement().setCenterX(x);
	}
	
	public void setCentreY(float y)
	{
		this.getElement().setCenterY(y);
	}
	
	public float getRayon()
	{
		return this.getElement().getRadius();
	}
	
	public void setRayon(float r)
	{
		this.getElement().setRadius(r);
	}
	
	public boolean isEnDeplacement() 
	{
		return enDeplacement;
	}

	public void setEnDeplacement(boolean enDeplacement) 
	{
		this.enDeplacement = enDeplacement;
	}

	public int getDirection() 
	{
		return direction;
	}

	public void setDirection(int direction) 
	{
		this.direction = direction;
	}
	
	public void reinitialiserPosition()
	{
		this.setCentreX(ConstantesElements.ELEMENT_BALLE_CENTRE_X);
		this.setCentreY(ConstantesElements.ELEMENT_BALLE_CENTRE_Y);
	}

}
