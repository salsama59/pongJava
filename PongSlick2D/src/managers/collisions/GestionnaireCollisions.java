package managers.collisions;

import java.util.Hashtable;

import elementsJeu.Element;

public abstract class GestionnaireCollisions
{
	
	private int idElementEnCollision;
	private boolean enCollision = false;
	private Hashtable<String, Element> elementsExistant;
	
	public GestionnaireCollisions(Hashtable<String, Element> elements)
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
	

	public Hashtable<String, Element> getElementsExistant() {
		return elementsExistant;
	}

	public void setElementsExistant(Hashtable<String, Element> elementsExistant) {
		this.elementsExistant = elementsExistant;
	}
	
}
