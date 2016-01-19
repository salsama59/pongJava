package elementsJeu;

import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;

import constantes.ConstantesElements;

public class Balle extends Element
{
	
	private Circle element = null;
	private float vitesse;
	private boolean enDeplacement = true;
	private int sens = ConstantesElements.ELEMENT_SENS_HAUT_GAUCHE;
	@SuppressWarnings("unused")
	private float direction;
	private Vector2f coordonnee = null;

	public Balle(float centreX, float centreY, float rayon, String nom) 
	{
		super(nom, false, ConstantesElements.ELEMENT_BALLE_TYPE);
		this.setElement(new Circle(centreX,centreY,rayon));
		this.setVitesse(ConstantesElements.ELEMENT_BALLE_VITESSE);
		this.setCoordonnee(new Vector2f(centreX, centreY));
		this.setDirection((float) this.getCoordonnee().getTheta());
		this.setDirection((float) this.getCoordonnee().getTheta());
	}
	
	public Balle(float centreX, float centreY, float rayon, String nom, String camp) 
	{
		super(nom, false, ConstantesElements.ELEMENT_BALLE_TYPE, camp);
		this.setElement(new Circle(centreX,centreY,rayon));
		this.setVitesse(ConstantesElements.ELEMENT_BALLE_VITESSE);
		this.setCoordonnee(new Vector2f(centreX, centreY));
		this.setDirection((float) this.getCoordonnee().getTheta());
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
		this.getCoordonnee().set(x, this.getCentreY());
	}
	
	public void setCentreY(float y)
	{
		this.getElement().setCenterY(y);
		this.getCoordonnee().set(this.getCentreX(), y);
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

	public int getSens()
	{
		return sens;
	}

	public void setSens(int sens) 
	{
		this.sens = sens;
	}
	
	public float getDirection() 
	{
		return (float) this.getCoordonnee().getTheta();
	}

	private void setDirection(float direction) 
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
		this.setDirection((float) coordonnee.getTheta());
	}

	public void reinitialiserPosition()
	{
		this.setCentreX(ConstantesElements.ELEMENT_BALLE_CENTRE_X);
		this.setCentreY(ConstantesElements.ELEMENT_BALLE_CENTRE_Y);
		this.getCoordonnee().set(ConstantesElements.ELEMENT_BALLE_CENTRE_X, ConstantesElements.ELEMENT_BALLE_CENTRE_Y);
	}

}
