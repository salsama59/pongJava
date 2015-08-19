package managers.elements;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

import elementsJeu.Element;

public class GestionnaireElements 
{
	
	private Hashtable<String, Element> ListElements;
	private int prochainID;
	private int iDprecedent;
	
	public GestionnaireElements()
	{
		ListElements = new Hashtable<String, Element>();
		this.setProchainID(0);
	}

	private int getProchainID() 
	{
		return prochainID;
	}

	private void setProchainID(int prochainID) 
	{
		this.prochainID = prochainID;
	}

	private int getIdPrecedent() {
		return iDprecedent;
	}

	private void setIdPrecedent(int iDprecedent) {
		this.iDprecedent = iDprecedent;
	}

	public Hashtable<String, Element> getListElements() 
	{
		return ListElements;
	}

	public void setListElements(Hashtable<String, Element> listElements) 
	{
		ListElements = listElements;
	}
	
	private int attribuerIdElement()
	{
		//stocker l'id précédent
		this.setIdPrecedent(this.getProchainID());
		//Préparer le prochaine id
		this.setProchainID(this.getProchainID() + 1);
		
		return this.getIdPrecedent();
	}
	
	public void ajouterElement(Element element)
	{
		element.setIdElement(this.attribuerIdElement());
		this.getListElements().put(element.getNomElement(), element);
	}
	
	public Hashtable<String, Element> getListeElementsFiltrees(String filtre)
	{
		
		Hashtable<String, Element> listeTriee = new Hashtable<String, Element>();
		
		Collection<Element> valeurs = ListElements.values();
		Iterator<Element> iterateurElements = valeurs.iterator();
		
		while(iterateurElements.hasNext())
		{
			Element element = iterateurElements.next();
			
			if(filtre.contains(element.getType()))
			{
				listeTriee.put(element.getNomElement(), element);
			}
		}
		
		return listeTriee;
		
	}

}
