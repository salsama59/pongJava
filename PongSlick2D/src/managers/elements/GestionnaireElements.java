package managers.elements;

import java.util.Hashtable;

import elementsJeu.Element;

public class GestionnaireElements 
{
	
	private Hashtable<Integer, Element> ListElements;
	private int prochainID;
	private int iDprecedent;
	
	public GestionnaireElements()
	{
		ListElements = new Hashtable<Integer, Element>();
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

	public Hashtable<Integer, Element> getListElements() 
	{
		return ListElements;
	}

	public void setListElements(Hashtable<Integer, Element> listElements) 
	{
		ListElements = listElements;
	}
	
	private int attribuerIdElement(Element element)
	{
		//mise à jour id element
		element.setIdElement(this.getProchainID());
		//stocker l'id précédent
		this.setIdPrecedent(this.getProchainID());
		//Préparer le prochaine id
		this.setProchainID(this.getProchainID() + 1);
		
		return this.getIdPrecedent();
	}
	
	public void ajouterElement(Element element)
	{
		this.getListElements().put(attribuerIdElement(element), element);
	}

}
