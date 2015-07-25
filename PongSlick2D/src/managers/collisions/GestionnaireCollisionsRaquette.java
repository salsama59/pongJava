package managers.collisions;

import java.util.Collection;
import java.util.Hashtable;

import constantes.ConstantesElements;
import elementsJeu.Element;
import elementsJeu.Mur;
import elementsJeu.Raquette;

public class GestionnaireCollisionsRaquette extends GestionnaireCollisions 
{
	
	private  Raquette elementGere;

	public GestionnaireCollisionsRaquette(Raquette elementAgerer, Hashtable<Integer, Element> elements) 
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
			
			if(element instanceof Mur)
			{
				collisionDetectee = this.getElementGere().getElement().intersects(((Mur) element).getElement());
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
					
					if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_HAUT)
					{
						this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_NEUTRE);
						this.getElementGere().setEnDeplacement(false);
						this.getElementGere().setCoordonneeY(this.getElementGere().getCoordonneeY() + (this.getElementGere().getVitesse() * delta));
					}
					else if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS)
					{
						this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_NEUTRE);
						this.getElementGere().setEnDeplacement(false);
						this.getElementGere().setCoordonneeY(this.getElementGere().getCoordonneeY() - (this.getElementGere().getVitesse() * delta));
					}
					
				}
			}
			
			this.setEnCollision(collisionDetectee);
		}
	}

	public Raquette getElementGere() 
	{
		return elementGere;
	}

	public void setElementGere(Raquette elementGere) 
	{
		this.elementGere = elementGere;
	}

}
