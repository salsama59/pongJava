package managers.collisions;

import java.util.Collection;
import java.util.Hashtable;

import elementsJeu.Balle;
import elementsJeu.Element;
import elementsJeu.Filet;

public class GestionnaireCollisionsFilet extends GestionnaireCollisions 
{
	
	private Filet elementGere;

	public GestionnaireCollisionsFilet(Filet elementAgerer, Hashtable<Integer, Element> elements) 
	{
		super(elements);
		this.setElementGere(elementAgerer);
	}

	@Override
	public void gererCollision(int delta) 
	{
		
		boolean collisionDetectee = false;
		
		Collection<Element> listeElementEnJeu = this.getElementsExistant().values();
		
		for(Element element : listeElementEnJeu)
		{
			
			if(element instanceof Balle)
			{
				collisionDetectee = this.getElementGere().getElement().intersects(((Balle) element).getElement());
			}
			else
			{
				this.setEnCollision(collisionDetectee);
				continue;
			}
			
			if(!this.isEnCollision())
			{
				
				if(collisionDetectee)
				{
					
					this.setIdElementEnCollision(element.getIdElement());
					//TODO gerer l'appel au gestionnaire de points (permettant d'attribuer les point à un camp ou un autre)
					System.out.println("Goaaaallll!!! la balle est dans : " + this.getElementGere().getNomElement());
					
				}
			}
			
			this.setEnCollision(collisionDetectee);
		}
	}

	public Filet getElementGere() 
	{
		return elementGere;
	}

	public void setElementGere(Filet elementGere) 
	{
		this.elementGere = elementGere;
	}

}
