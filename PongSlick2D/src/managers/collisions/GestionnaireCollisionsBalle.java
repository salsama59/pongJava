package managers.collisions;

import java.util.Collection;
import java.util.Hashtable;

import org.newdawn.slick.geom.Vector2f;

import constantes.ConstantePosition;
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
	
	private void gererCasMur(Element element)
	{
		Vector2f valeurRebond =null;
		
		if(element.getNomElement() == "mur1")
		{
			valeurRebond = CalculerTrajectoireRebond(extraireCoordonneesMax(element), extraireCoordonneesMin(element));
		}
		else if(element.getNomElement() == "mur2")
		{
			valeurRebond = CalculerTrajectoireRebond(extraireCoordonneesMin(element), extraireCoordonneesMax(element));
		}
		
		this.getElementGere().setCentreX(valeurRebond.x);
		this.getElementGere().setCentreY(valeurRebond.y);
		
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
			
			gererCasMur(element);
			
		}
		else if((detecterCollisionSpecialePlate((Raquette) element)) && (detecterCollisionSpecialeCoin((Raquette) element)))
		{
			//version coin pour les raquettes rebond particulier
			
			if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_HAUT_GAUCHE)
			{
				
				if(detecterPositionBalleRelativeRaquette((Raquette) element) == ConstantePosition.POSITION_BAS_DROITE_RAQUETTE)
				{
					this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_BAS_DROITE);
				}
				else if (detecterPositionBalleRelativeRaquette((Raquette) element) == ConstantePosition.POSITION_HAUT_DROITE_RAQUETTE)
				{
					this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_HAUT_DROITE);
				}
				
			}
			else if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_HAUT_DROITE)
			{
				
				if(detecterPositionBalleRelativeRaquette((Raquette) element) == ConstantePosition.POSITION_BAS_GAUCHE_RAQUETTE)
				{
					this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_BAS_GAUCHE);
				}
				else if (detecterPositionBalleRelativeRaquette((Raquette) element) == ConstantePosition.POSITION_HAUT_GAUCHE_RAQUETTE)
				{
					this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_HAUT_GAUCHE);
				}
				
			}
			else if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS_DROITE)
			{
				
				if(detecterPositionBalleRelativeRaquette((Raquette) element) == ConstantePosition.POSITION_BAS_GAUCHE_RAQUETTE)
				{
					this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_BAS_GAUCHE);
				}
				else if (detecterPositionBalleRelativeRaquette((Raquette) element) == ConstantePosition.POSITION_HAUT_GAUCHE_RAQUETTE)
				{
					this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_HAUT_GAUCHE);
				}
				
			}
			else if(this.getElementGere().getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS_GAUCHE)
			{
				
				if(detecterPositionBalleRelativeRaquette((Raquette) element) == ConstantePosition.POSITION_BAS_DROITE_RAQUETTE)
				{
					this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_BAS_DROITE);
				}
				else if (detecterPositionBalleRelativeRaquette((Raquette) element) == ConstantePosition.POSITION_HAUT_DROITE_RAQUETTE)
				{
					this.getElementGere().setDirection(ConstantesElements.ELEMENT_DIRECTION_HAUT_DROITE);
				}
				
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
	
		//TODO tester cela imperativement et ajouter des commentaires d'explication
		private Vector2f determinerPointInpact(Vector2f coordoneesElementMinA, Vector2f coordoneesElementMaxB)
		{
			Vector2f coodoneesImpact = null, u = null, ac = null, c = null;
			c = new Vector2f(this.getElementGere().getCentreX(), this.getElementGere().getCentreY());
			u = new Vector2f((coordoneesElementMaxB.x - coordoneesElementMinA.x), (coordoneesElementMaxB.y - coordoneesElementMinA.y));
			ac = new Vector2f((c.x - coordoneesElementMinA.x), (c.y - coordoneesElementMinA.y));
			float ti = (u.x * ac.x + u.y * ac.y)/(u.x * u.x + u.y * u.y);
			
			coodoneesImpact = new Vector2f((coordoneesElementMinA.x + ti * u.x), (coordoneesElementMinA.y + ti * u.y));
			
			return coodoneesImpact;
		}
		
		private Vector2f determinerNormalePointImpact(Vector2f coordoneesElementMinA, Vector2f coordoneesElementMaxB)
		{
			
			Vector2f normale = null, u = null, ac = null, c = null;
			c = new Vector2f(this.getElementGere().getCentreX(), this.getElementGere().getCentreY());
			u = new Vector2f((coordoneesElementMaxB.x - coordoneesElementMinA.x), (coordoneesElementMaxB.y - coordoneesElementMinA.y));
			//calcul ac foireux
			ac = new Vector2f((c.x - coordoneesElementMinA.x), (c.y - coordoneesElementMinA.y));
			
			float parentheses = u.x*ac.y-u.y*ac.x;
			
			float cordonneesX = (-1) * u.y * (parentheses);
			float cordonneesY = (-1) * u.x * (parentheses);
			
			float norme = (float) Math.sqrt(cordonneesX * cordonneesX + cordonneesY * cordonneesY);
			
			normale = new Vector2f((cordonneesX/norme), (cordonneesY/norme));
			
			return normale;
		}
		
		//Potentiellement errone a cause du sens dans lequel on se trouve (chager le calcul en fonction du sens et de l'objet rencontré
		private Vector2f calculerTrajectoireInitiale(Vector2f pointInpact)
		{
			Vector2f c = new Vector2f(this.getElementGere().getCentreX(), this.getElementGere().getCentreY());
			
			return new Vector2f((c.x - pointInpact.x), (c.y - pointInpact.y));
		}
		
		private Vector2f determinerDirectionRebond(Vector2f trajectoireInitiale, Vector2f normale)
		{
			
			float produitScalaire = (trajectoireInitiale.x * normale.x + trajectoireInitiale.y * normale.y);
			
			return new Vector2f((trajectoireInitiale.x - 2 * produitScalaire *normale.x), (trajectoireInitiale.y - 2 * produitScalaire *normale.y));
		}
		
		private Vector2f CalculerTrajectoireRebond(Vector2f coordoneesElementMinA, Vector2f coordoneesElementMaxB)
		{
			Vector2f pointInpact = determinerPointInpact(coordoneesElementMinA, coordoneesElementMaxB);
			Vector2f normale = determinerNormalePointImpact(coordoneesElementMinA, coordoneesElementMaxB);
			Vector2f trajectoireInitiale = calculerTrajectoireInitiale(pointInpact);
			return determinerDirectionRebond(trajectoireInitiale, normale);
		}
		
		private Vector2f extraireCoordonneesMin(Element element)
		{
			Vector2f valeurMin = null;
			
			if(element instanceof Raquette)
			{
				Raquette raquette = (Raquette)element;
				
				valeurMin = new Vector2f(raquette.getCoordonneeX(), raquette.getCoordonneeY());
			}
			else if(element instanceof Mur)
			{
				Mur mur = (Mur)element;
				valeurMin = new Vector2f(mur.getCoordonneeX(), mur.getCoordonneeY());
			}
			
			return valeurMin;
		}
		
		private Vector2f extraireCoordonneesMax(Element element)
		{
			Vector2f valeurMax = null;
			
			if(element instanceof Raquette)
			{
				Raquette raquette = (Raquette)element;
				
				valeurMax = new Vector2f(raquette.getCoordonneeX() + raquette.getLargeur(), raquette.getCoordonneeY());
			}
			else if(element instanceof Mur)
			{
				Mur mur = (Mur)element;
				
				valeurMax = new Vector2f(mur.getCoordonneeX() + mur.getLargeur(), mur.getCoordonneeY());
			}
			
			return valeurMax;
		}
}