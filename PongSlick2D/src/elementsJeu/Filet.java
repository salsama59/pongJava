package elementsJeu;

import org.newdawn.slick.geom.Rectangle;

import constantes.ConstantesElements;

public class Filet extends Arene 
{
	public Filet(float x, float y, float largeur, float longeur, String nom)
	{
		super(nom, ConstantesElements.ELEMENT_FILET_TYPE);
		
		this.setElement(new Rectangle(x, y, largeur, longeur));
	}
}
