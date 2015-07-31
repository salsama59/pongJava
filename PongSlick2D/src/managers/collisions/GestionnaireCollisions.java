package managers.collisions;

import java.util.Hashtable;

import constantes.ConstantePosition;
import elementsJeu.Balle;
import elementsJeu.Element;
import elementsJeu.Filet;
import elementsJeu.Mur;
import elementsJeu.Raquette;

public abstract class GestionnaireCollisions
{
	
	private int idElementEnCollision;
	private boolean enCollision = false;
	private Hashtable<Integer, Element> elementsExistant;
	
	public GestionnaireCollisions(Hashtable<Integer, Element> elements)
	{
		this.setElementsExistant(elements);
	}

	public int getIdElementEnCollision() 
	{
		return idElementEnCollision;
	}

	public void setIdElementEnCollision(int idElementEnCollision) 
	{
		this.idElementEnCollision = idElementEnCollision;
	}

	public boolean isEnCollision() 
	{
		return enCollision;
	}

	public void setEnCollision(boolean enCollision) 
	{
		this.enCollision = enCollision;
	}

	public abstract void gererCollision(int delta);
	

	public Hashtable<Integer, Element> getElementsExistant() {
		return elementsExistant;
	}

	public void setElementsExistant(Hashtable<Integer, Element> elementsExistant) {
		this.elementsExistant = elementsExistant;
	}
	
	//TODO cr�er exception sp�ciale pour le type d'�l�ment inconnu en cas d'oublie d'enregistrement via la classe du gestionnaire d'�l�ment
	
	public String detecterPositionElementRelativeAutreElement(Element elementCible, Element elementRelatif)
	{
		//TODO faire le calcul des composants des �l�ments selon leur nature pour cr�er une fonction g�n�rique
		
		if(elementCible instanceof Mur)
		{
			Mur elementCibleCaste = (Mur)elementCible;
		}
		else if (elementCible instanceof Balle)
		{
			Balle elementCibleCaste = (Balle)elementCible;
		}
		else if (elementCible instanceof Filet)
		{
			Filet elementCibleCaste = (Filet)elementCible;
		}
		else if (elementCible instanceof Raquette)
		{
			Raquette elementCibleCaste = (Raquette)elementCible;
		}
		else
		{
			//TODO balancer l'exception ici
		}
		
		
		if(elementRelatif instanceof Mur)
		{
			Mur elementRelatifCaste = (Mur)elementCible;
		}
		else if (elementRelatif instanceof Balle)
		{
			Balle elementRelatifCaste = (Balle)elementCible;
		}
		else if (elementRelatif instanceof Filet)
		{
			Filet elementRelatifCaste = (Filet)elementCible;
		}
		else if (elementRelatif instanceof Raquette)
		{
			Raquette elementRelatifCaste = (Raquette)elementCible;
		}
		else
		{
			//TODO balancer l'exception ici
		}
		
		/*String position = "";
		float coordonneesBalleY = this.getElementGere().getCentreY();
		float coordonneesRaquetteY = raquette.getCoordonneeY();
		float hauteurRaquette = raquette.getHauteur();
		
		if(coordonneesBalleY < (coordonneesRaquetteY + (hauteurRaquette/2)))
		{
			position = ConstantePosition.POSITION_HAUT_RAQUETTE;
		}
		else if(coordonneesBalleY > (coordonneesRaquetteY + (hauteurRaquette/2)))
		{
			position = ConstantePosition.POSITION_BAS_RAQUETTE;
		}*/
		
		String Position = "";
		
		return Position;
	}
	
}
