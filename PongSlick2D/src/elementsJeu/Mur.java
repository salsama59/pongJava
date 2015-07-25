package elementsJeu;

import org.newdawn.slick.geom.Rectangle;

public class Mur extends Arene 
{
	public Mur(float x, float y, float largeur, float longeur, String nom)
	{
		super(nom);
		
		this.setElement(new Rectangle(x, y, largeur, longeur));
	}

}
