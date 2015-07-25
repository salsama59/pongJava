package elementsJeu;

import org.newdawn.slick.geom.Rectangle;

public class Filet extends Arene 
{
	public Filet(float x, float y, float largeur, float longeur)
	{
		super();
		
		this.setElement(new Rectangle(x, y, largeur, longeur));
	}
}
