package elementsJeu;

import org.newdawn.slick.geom.Rectangle;

import constantes.ConstantesElements;

public class Mur extends Arene 
{
	public Mur(float x, float y, float largeur, float longeur, String nom)
	{
		super(nom, ConstantesElements.ELEMENT_MUR_TYPE);
		
		this.setElement(new Rectangle(x, y, largeur, longeur));
	}

}
