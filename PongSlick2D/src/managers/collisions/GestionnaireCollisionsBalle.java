package managers.collisions;

import java.util.Collection;
import java.util.Hashtable;

import constantes.ConstantePosition;
import constantes.ConstantesElements;
import constantes.ConstantesJoueurs;
import elementsJeu.Balle;
import elementsJeu.Element;
import elementsJeu.Filet;
import elementsJeu.Mur;
import elementsJeu.Raquette;

public class GestionnaireCollisionsBalle extends GestionnaireCollisions 
{
	
	private  Balle elementGere;
	
	public GestionnaireCollisionsBalle(Balle elementAgerer, Hashtable<String, Element> elements) 
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
				this.getElementGere().setEnCollision(collisionDetectee);
				continue;
			}
			
			if(!this.isEnCollision())
			{
				
				if(collisionDetectee)
				{
					
					this.setIdElementEnCollision(element.getIdElement());
					
					gererCasGeneric();
					
					if(element instanceof Raquette)
					{
						gererCasCollisionsSpeciales(element);
					}
					else if(element instanceof Mur)
					{
						gererCasMur(element);
					}
					
					break;
				}
			}
			
		}
		
		this.setEnCollision(collisionDetectee);
		this.getElementGere().setEnCollision(collisionDetectee);
		
	}
	
	private void gererCasGeneric()
	{
		if(this.getElementGere().getSens() == ConstantesElements.ELEMENT_SENS_DROITE)
		{
			this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_GAUCHE);
		}
		else if(this.getElementGere().getSens() == ConstantesElements.ELEMENT_SENS_GAUCHE)
		{
			this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_DROITE);
		}
		else if(this.getElementGere().getSens() == ConstantesElements.ELEMENT_SENS_HAUT)
		{
			this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_BAS);
		}
		else if(this.getElementGere().getSens() == ConstantesElements.ELEMENT_SENS_BAS)
		{
			this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_HAUT);
		}
	}
	
	private void gererCasMur(Element element)
	{
		
		if(this.getElementGere().getSens() == ConstantesElements.ELEMENT_SENS_HAUT_GAUCHE)
		{
			this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_BAS_GAUCHE);
		}
		else if(this.getElementGere().getSens() == ConstantesElements.ELEMENT_SENS_HAUT_DROITE)
		{
			this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_BAS_DROITE);
		}
		else if(this.getElementGere().getSens() == ConstantesElements.ELEMENT_SENS_BAS_DROITE)
		{
			this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_HAUT_DROITE);
		}
		else if(this.getElementGere().getSens() == ConstantesElements.ELEMENT_SENS_BAS_GAUCHE)
		{
			this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_HAUT_GAUCHE);
		}
		
	}
	
	private void gererCasCollisionsSpeciales(Element element)
	{
		if((detecterCollisionSpecialePlate((Raquette) element)) && !(detecterCollisionSpecialeCoin((Raquette) element)))
		{
			//version mur pour raquette
			
			gererCasMur(element);
			
		}
		else if((detecterCollisionSpecialePlate((Raquette) element)) && (detecterCollisionSpecialeCoin((Raquette) element)))
		{
			//version coin pour les raquettes rebond particulier
			
			if(this.getElementGere().getSens() == ConstantesElements.ELEMENT_SENS_HAUT_GAUCHE)
			{
				
				if(detecterPositionBalleRelativeRaquette((Raquette) element) == ConstantePosition.POSITION_BAS_DROITE_RAQUETTE)
				{
					this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_BAS_DROITE);
				}
				else if (detecterPositionBalleRelativeRaquette((Raquette) element) == ConstantePosition.POSITION_HAUT_DROITE_RAQUETTE)
				{
					this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_HAUT_DROITE);
				}
				
			}
			else if(this.getElementGere().getSens() == ConstantesElements.ELEMENT_SENS_HAUT_DROITE)
			{
				
				if(detecterPositionBalleRelativeRaquette((Raquette) element) == ConstantePosition.POSITION_BAS_GAUCHE_RAQUETTE)
				{
					this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_BAS_GAUCHE);
				}
				else if (detecterPositionBalleRelativeRaquette((Raquette) element) == ConstantePosition.POSITION_HAUT_GAUCHE_RAQUETTE)
				{
					this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_HAUT_GAUCHE);
				}
				
			}
			else if(this.getElementGere().getSens() == ConstantesElements.ELEMENT_SENS_BAS_DROITE)
			{
				
				if(detecterPositionBalleRelativeRaquette((Raquette) element) == ConstantePosition.POSITION_BAS_GAUCHE_RAQUETTE)
				{
					this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_BAS_GAUCHE);
				}
				else if (detecterPositionBalleRelativeRaquette((Raquette) element) == ConstantePosition.POSITION_HAUT_GAUCHE_RAQUETTE)
				{
					this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_HAUT_GAUCHE);
				}
				
			}
			else if(this.getElementGere().getSens() == ConstantesElements.ELEMENT_SENS_BAS_GAUCHE)
			{
				
				if(detecterPositionBalleRelativeRaquette((Raquette) element) == ConstantePosition.POSITION_BAS_DROITE_RAQUETTE)
				{
					this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_BAS_DROITE);
				}
				else if (detecterPositionBalleRelativeRaquette((Raquette) element) == ConstantePosition.POSITION_HAUT_DROITE_RAQUETTE)
				{
					this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_HAUT_DROITE);
				}
				
			}
		}
		else
		{
			if(this.getElementGere().getSens() == ConstantesElements.ELEMENT_SENS_HAUT_GAUCHE)
			{
				this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_HAUT_DROITE);
			}
			else if(this.getElementGere().getSens() == ConstantesElements.ELEMENT_SENS_HAUT_DROITE)
			{
				this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_HAUT_GAUCHE);
			}
			else if(this.getElementGere().getSens() == ConstantesElements.ELEMENT_SENS_BAS_DROITE)
			{
				this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_BAS_GAUCHE);
			}
			else if(this.getElementGere().getSens() == ConstantesElements.ELEMENT_SENS_BAS_GAUCHE)
			{
				this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_BAS_DROITE);
			}
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
	
	private boolean detecterCollisionSpecialePlate(Raquette raquette)
	{
		
		float coordonneesBalleY = this.getElementGere().getCentreY();
		float coordonneesRaquetteY = raquette.getCoordonneeY();
		float hauteurRaquette = raquette.getHauteur();
		boolean casSpecial = false;
			
		if(coordonneesBalleY < coordonneesRaquetteY)
		{
			casSpecial = true;
		}
		else if(coordonneesBalleY > (coordonneesRaquetteY + hauteurRaquette))
		{
			casSpecial = true;
		}
			
		return casSpecial;
		
	}
	
	private boolean detecterCollisionSpecialeCoin(Raquette raquette)
	{
		
		float coordonneesBalleX = this.getElementGere().getCentreX();
		float coordonneesRaquetteX = raquette.getCoordonneeX();
		float largeurRaquette = raquette.getLargeur();
		boolean casSpecial = false;
		
		String camp = raquette.getCamp();
		
		if(camp.equals(ConstantesJoueurs.JOUEUR_CAMP_DROITE))
		{
			if(coordonneesBalleX < coordonneesRaquetteX)
			{
				casSpecial = true;
			}
		}
		else if(camp.equals(ConstantesJoueurs.JOUEUR_CAMP_GAUCHE))
		{
			
			if(coordonneesBalleX > coordonneesRaquetteX + largeurRaquette)
			{
				casSpecial = true;
			}
		}
		
		return casSpecial;
	}
	
	private String detecterPositionBalleRelativeRaquette(Raquette raquette)
	{
		
		String position = "";
		float coordonneesBalleY = this.getElementGere().getCentreY();
		float coordonneesBalleX = this.getElementGere().getCentreX();
		float coordonneesRaquetteY = raquette.getCoordonneeY();
		float coordonneesRaquetteX = raquette.getCoordonneeX();
		float hauteurRaquette = raquette.getHauteur();
		float largeurRaquette = raquette.getLargeur();
		
		if(coordonneesBalleY < (coordonneesRaquetteY + (hauteurRaquette/2)))
		{
			if(coordonneesBalleX > (coordonneesRaquetteX + largeurRaquette))
			{
				position = ConstantePosition.POSITION_HAUT_DROITE_RAQUETTE;
			}
			else if(coordonneesBalleX < coordonneesRaquetteX)
			{
				position = ConstantePosition.POSITION_HAUT_GAUCHE_RAQUETTE;
			}
			
		}
		
		else if(coordonneesBalleY > (coordonneesRaquetteY + (hauteurRaquette/2)))
		{
			if(coordonneesBalleX > (coordonneesRaquetteX + largeurRaquette))
			{
				position = ConstantePosition.POSITION_BAS_DROITE_RAQUETTE;
			}
			else if(coordonneesBalleX < coordonneesRaquetteX)
			{
				position = ConstantePosition.POSITION_BAS_GAUCHE_RAQUETTE;
			}
		}
		
		return position;
	}
	
}