package managers.collisions;

import java.util.Collection;
import java.util.Hashtable;

import constantes.ConstantesElements;
import elementsJeu.Balle;
import elementsJeu.Element;
import elementsJeu.Filet;
import elementsJeu.Mur;
import elementsJeu.Raquette;

public class GestionnaireCollisionsBalle extends GestionnaireCollisions 
{
	
	private  Balle elementGere;
	
	public GestionnaireCollisionsBalle(Balle elementAgerer, Hashtable<Integer, Element> elements) 
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
			else if(element instanceof Mur)
			{
				collisionDetectee = this.getElementGere().getElement().intersects(((Mur) element).getElement());
			}
			else if(element instanceof Filet)
			{
				//collisionDetectee = this.getElementGere().getElement().intersects(((Arene) element).getElement());
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
					
					if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_DROITE)
					{
						this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_GAUCHE);
					}
					else if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_GAUCHE)
					{
						this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_DROITE);
					}
					else if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_HAUT)
					{
						this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_BAS);
					}
					else if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS)
					{
						this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_HAUT);
					}
					
					
					if(element instanceof Raquette)
					{
						//TODO gerer collision sur le haut de la raquette pour corriger le  bug (calcul de la position du centre du cercle par rapport à celle de la raquette
						
						if(detecterCollisionSpeciale((Raquette) element))
						{
							//version mur pour raquette
							if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_HAUT_GAUCHE)
							{
								this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_BAS_GAUCHE);
							}
							else if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_HAUT_DROITE)
							{
								this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_BAS_DROITE);
							}
							else if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS_DROITE)
							{
								this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_HAUT_DROITE);
							}
							else if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS_GAUCHE)
							{
								this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_HAUT_GAUCHE);
							}
						}
						else
						{
							if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_HAUT_GAUCHE)
							{
								this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_HAUT_DROITE);
							}
							else if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_HAUT_DROITE)
							{
								this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_HAUT_GAUCHE);
							}
							else if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS_DROITE)
							{
								this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_BAS_GAUCHE);
							}
							else if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS_GAUCHE)
							{
								this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_BAS_DROITE);
							}
						}
							
					}
					else if(element instanceof Mur)
					{
						
						if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_HAUT_GAUCHE)
						{
							this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_BAS_GAUCHE);
						}
						else if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_HAUT_DROITE)
						{
							this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_BAS_DROITE);
						}
						else if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS_DROITE)
						{
							this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_HAUT_DROITE);
						}
						else if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS_GAUCHE)
						{
							this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_HAUT_GAUCHE);
						}
						
					}
					
				}
			}
			
			this.setEnCollision(collisionDetectee);
		}
		
	}
	
	public Balle getElementGere() 
	{
		return elementGere;
	}

	public void setElementGere(Balle elementGere) 
	{
		this.elementGere = elementGere;
	}
	
	public boolean detecterCollisionSpeciale(Raquette raquette)
	{
		
		float coordonneesBalleX = this.getElementGere().getCentreX();
		float coordonneesBalleY = this.getElementGere().getCentreY();
		float rayonBalle = this.getElementGere().getRayon();
		float coordonneesZoneDroite = coordonneesBalleX + rayonBalle;
		float coordonneesZoneGauche = coordonneesBalleX - rayonBalle;
		float coordonneesZoneHaute = coordonneesBalleY - rayonBalle;
		float coordonneesZoneBasse = coordonneesBalleY + rayonBalle;
		float coordonneesRaquetteX = raquette.getCoordonneeX();
		float coordonneesRaquetteY = raquette.getCoordonneeY();
		float largeurRaquette = raquette.getLargeur();
		float hauteurRaquette = raquette.getHauteur();
		boolean casSpecial = false;
		
		
		if((coordonneesZoneDroite > coordonneesRaquetteX) && (coordonneesZoneDroite < (coordonneesRaquetteX + largeurRaquette)))
		{
			if(coordonneesZoneBasse == coordonneesRaquetteY)
			{
				casSpecial = true;
			}
			else if(coordonneesZoneHaute == (coordonneesRaquetteY + hauteurRaquette))
			{
				casSpecial = true;
			}
		}
		else if((coordonneesZoneGauche > coordonneesRaquetteX) && (coordonneesZoneGauche < (coordonneesRaquetteX + largeurRaquette)))
		{
			if(coordonneesZoneBasse == coordonneesRaquetteY)
			{
				casSpecial = true;
			}
			else if(coordonneesZoneHaute == (coordonneesRaquetteY + hauteurRaquette))
			{
				casSpecial = true;
			}
		}
		
		return casSpecial;
		
	}

}
