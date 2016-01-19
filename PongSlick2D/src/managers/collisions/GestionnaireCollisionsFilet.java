package managers.collisions;

import java.util.Collection;
import java.util.Hashtable;

import constantes.ConstantesElements;
import managers.etat.match.GestionnaireMatch;
import elementsJeu.Balle;
import elementsJeu.Element;
import elementsJeu.Filet;

public class GestionnaireCollisionsFilet extends GestionnaireCollisions 
{
	
	private Filet elementGere;
	private GestionnaireMatch gestionnaireMatch;

	public GestionnaireCollisionsFilet(Filet elementAgerer, GestionnaireMatch gestionnaire, Hashtable<String, Element> elements) 
	{
		super(elements);
		this.setElementGere(elementAgerer);
		this.setGestionnaireMatch(gestionnaire);
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
				this.getElementGere().setEnCollision(collisionDetectee);
				continue;
			}
			
			if(!this.isEnCollision())
			{
				
				if(collisionDetectee)
				{
					
					this.setIdElementEnCollision(element.getIdElement());
					
					if(this.getElementGere().getNomElement().equals(ConstantesElements.ELEMENT_FILET1_NOM))
					{
						
						this.getGestionnaireMatch().setPointCampDroit(this.getGestionnaireMatch().getPointCampDroit() + 1);
						
						if(element instanceof Balle)
						{
							((Balle) element).reinitialiserPosition();
							((Balle) element).setSens(ConstantesElements.ELEMENT_SENS_GAUCHE);
						}
						
					}
					else if(this.getElementGere().getNomElement().equals(ConstantesElements.ELEMENT_FILET2_NOM))
					{
						
						this.getGestionnaireMatch().setPointCampGauche(this.getGestionnaireMatch().getPointCampGauche() + 1);
						
						if(element instanceof Balle)
						{
							((Balle) element).reinitialiserPosition();
							((Balle) element).setSens(ConstantesElements.ELEMENT_SENS_DROITE);
						}
						
					}
					
				}
				
			}
			
			this.setEnCollision(collisionDetectee);
			this.getElementGere().setEnCollision(collisionDetectee);
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

	public GestionnaireMatch getGestionnaireMatch() 
	{
		return gestionnaireMatch;
	}

	private void setGestionnaireMatch(GestionnaireMatch gestionnaireMatch) 
	{
		this.gestionnaireMatch = gestionnaireMatch;
	}

}
