package managers.collisions;

import java.util.Collection;
import java.util.Hashtable;

import constantes.ConstantesElements;
import elementsJeu.Balle;
import elementsJeu.Element;
import elementsJeu.Mur;
import elementsJeu.Raquette;

public class GestionnaireCollisionsMur extends GestionnaireCollisions 
{
	
	private Mur elementGere;

	public GestionnaireCollisionsMur(Mur elementAgerer, Hashtable<String, Element> elements) 
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
			
			if(element instanceof Raquette)
			{
				collisionDetectee = this.getElementGere().getElement().intersects(((Raquette) element).getElement());
			}
			else if(element instanceof Balle)
			{
				collisionDetectee = this.getElementGere().getElement().intersects(((Balle) element).getElement());
			}
			else
			{
				this.setEnCollision(collisionDetectee);
				this.getElementGere().setEnCollision(collisionDetectee);
				continue;
			}
			
			if(!this.isEnCollision())
			{
				
				if(collisionDetectee)
				{
					
					this.setIdElementEnCollision(element.getIdElement());
					
					if(element instanceof Raquette)
					{
						((Raquette)element).setEnDeplacement(false);
					}
					else if(element instanceof Balle)
					{
						//Etant donné que le gestionnaire de collision de la balle est prioritaire on estime que la direction à changé déjà donc on inverse la perte ou le gain sur la position y de la balle
						if(((Balle)element).getSens() == ConstantesElements.ELEMENT_SENS_BAS_DROITE || ((Balle)element).getSens() == ConstantesElements.ELEMENT_SENS_BAS_GAUCHE)
						{
							((Balle)element).setCentreY(((Balle)element).getCentreY() + (((Balle)element).getVitesse() * delta));
						}
						else if(((Balle)element).getSens() == ConstantesElements.ELEMENT_SENS_HAUT_DROITE || ((Balle)element).getSens() == ConstantesElements.ELEMENT_SENS_HAUT_GAUCHE)
						{
							((Balle)element).setCentreY(((Balle)element).getCentreY() - (((Balle)element).getVitesse() * delta));
						}
						
					}
					
				}
			}
			
			this.setEnCollision(collisionDetectee);
			this.getElementGere().setEnCollision(collisionDetectee);
		}
		
	}

	public Mur getElementGere() 
	{
		return elementGere;
	}

	public void setElementGere(Mur elementGere) 
	{
		this.elementGere = elementGere;
	}

}
