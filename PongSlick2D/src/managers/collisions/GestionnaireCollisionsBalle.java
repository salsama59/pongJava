package managers.collisions;

import java.util.Collection;
import java.util.Hashtable;

import constantes.ConstantesElements;
import constantes.ContantesJoueurs;
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
					
					gererCasGeneric();
					
					if(element instanceof Raquette)
					{
						gererCasCollisionsSpeciales(element);
					}
					else if(element instanceof Mur)
					{
						gererCasMur();
					}
				}
			}
			
			this.setEnCollision(collisionDetectee);
		}
		
	}
	
	private void gererCasGeneric()
	{
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
	}
	
	private void gererCasMur()
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
	
	private void gererCasCollisionsSpeciales(Element element)
	{
		if((detecterCollisionSpecialePlate((Raquette) element)) && !(detecterCollisionSpecialeCoin((Raquette) element)))
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
		else if((detecterCollisionSpecialePlate((Raquette) element)) && (detecterCollisionSpecialeCoin((Raquette) element)))
		{
			//version coin pour les raquettes rebond particulier
			
			if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_HAUT_GAUCHE)
			{
				this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_BAS_DROITE);
			}
			else if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_HAUT_DROITE)
			{
				this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_BAS_GAUCHE);
			}
			else if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS_DROITE)
			{
				this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_HAUT_GAUCHE);
			}
			else if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS_GAUCHE)
			{
				this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_HAUT_DROITE);
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
	
	public Balle getElementGere() 
	{
		return elementGere;
	}

	public void setElementGere(Balle elementGere) 
	{
		this.elementGere = elementGere;
	}
	
	public boolean detecterCollisionSpecialePlate(Raquette raquette)
	{
		
		this.getElementGere().getCentreX();
		float coordonneesBalleY = this.getElementGere().getCentreY();
		this.getElementGere().getRayon();
		raquette.getCoordonneeX();
		float coordonneesRaquetteY = raquette.getCoordonneeY();
		raquette.getLargeur();
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
	
	
	private int detecterRaquette(float x, float y)
	{
		
		if(x == ConstantesElements.ELEMENT_RAQUETTE1_COORDONEE_X)
		{
			return ContantesJoueurs.JOUEUR_ID_1;
		}
		else if(x == ConstantesElements.ELEMENT_RAQUETTE2_COORDONEE_X)
		{
			return ContantesJoueurs.JOUEUR_ID_2;
		}
		
		return -1;
	}
	
	public boolean detecterCollisionSpecialeCoin(Raquette raquette)
	{
		
		float coordonneesBalleX = this.getElementGere().getCentreX();
		this.getElementGere().getCentreY();
		this.getElementGere().getRayon();
		float coordonneesRaquetteX = raquette.getCoordonneeX();
		float coordonneesRaquetteY = raquette.getCoordonneeY();
		float largeurRaquette = raquette.getLargeur();
		raquette.getHauteur();
		boolean casSpecial = false;
		
		String camp = "";
		
		switch(detecterRaquette(coordonneesRaquetteX, coordonneesRaquetteY))
		{
			
			case ContantesJoueurs.JOUEUR_ID_1: 
				
			camp = ContantesJoueurs.JOUEUR_CAMP_GAUCHE;
				
			break;
			
			case ContantesJoueurs.JOUEUR_ID_2:
			
			camp = ContantesJoueurs.JOUEUR_CAMP_DROITE;
			
			break;
		
		}
		
		if(camp.equals(ContantesJoueurs.JOUEUR_CAMP_DROITE))
		{
			if(coordonneesBalleX < coordonneesRaquetteX)
			{
				casSpecial = true;
			}
		}
		else if(camp.equals(ContantesJoueurs.JOUEUR_CAMP_GAUCHE))
		{
			
			if(coordonneesBalleX > coordonneesRaquetteX + largeurRaquette)
			{
				casSpecial = true;
			}
		}
		
		return casSpecial;
	}
}

