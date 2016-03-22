package managers.collisions;

import java.util.Collection;
import java.util.Hashtable;

import constantes.ConstantesElements;
import constantes.ConstantesJoueurs;
import managers.elements.GestionnaireElements;
import managers.etat.GestionnaireMatch;
import elementsJeu.Balle;
import elementsJeu.Element;
import elementsJeu.Filet;
import elementsJeu.Raquette;

public class GestionnaireCollisionsFilet extends GestionnaireCollisions 
{
	
	private Filet elementGere;

	public GestionnaireCollisionsFilet(Filet elementAgerer, Hashtable<String, Element> elements) 
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
						
						GestionnaireMatch.setPointCampDroit(GestionnaireMatch.getPointCampDroit() + 1);
						
						if(element instanceof Balle)
						{
							Raquette raquette = (Raquette)GestionnaireElements.recupererElementParNom(ConstantesElements.ELEMENT_RAQUETTE1_NOM);
							ajusterPositionLancementBalle((Balle) element, raquette);
							//((Balle) element).reinitialiserPosition();
							//((Balle) element).setSens(ConstantesElements.ELEMENT_SENS_GAUCHE);
						}
						
					}
					else if(this.getElementGere().getNomElement().equals(ConstantesElements.ELEMENT_FILET2_NOM))
					{
						
						GestionnaireMatch.setPointCampGauche(GestionnaireMatch.getPointCampGauche() + 1);
						
						if(element instanceof Balle)
						{
							Raquette raquette = (Raquette)GestionnaireElements.recupererElementParNom(ConstantesElements.ELEMENT_RAQUETTE2_NOM);
							ajusterPositionLancementBalle((Balle) element, raquette);
							//((Balle) element).reinitialiserPosition();
							//((Balle) element).setSens(ConstantesElements.ELEMENT_SENS_DROITE);
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
	
	private void ajusterPositionLancementBalle(Balle balle, Raquette raquette)
	{
		
		float x = 0;
		float y = 0;
		
		if(raquette.getCamp() == ConstantesJoueurs.JOUEUR_CAMP_GAUCHE)
		{
			x = raquette.getCoordonneeX() + balle.getRayon() + raquette.getLargeur();
		}	
		else if(raquette.getCamp() == ConstantesJoueurs.JOUEUR_CAMP_DROITE)
		{
			x = raquette.getCoordonneeX() - balle.getRayon();
		}
		
		y = (raquette.getHauteur()/2) + raquette.getCoordonneeY();
		
		balle.setCentreX(x);
		balle.setCentreY(y);
		
		balle.setEnDeplacement(false);
		raquette.setEtat(ConstantesElements.ELEMENT_ETAT_LANCEMENT);
		
	}

}
