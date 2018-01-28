package elementsJeu;

import org.newdawn.slick.geom.Rectangle;

public class Arene extends Element
{
	
	protected Rectangle element = null;
	
	public Arene(String nom, String type)
	{
		super(nom, false, type, null, null);
	}

	public Rectangle getElement() {
		return element;
	}

	public void setElement(Rectangle element) {
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

}
