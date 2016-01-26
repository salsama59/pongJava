package managers.elements;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

import elementsJeu.Element;

public class GestionnaireElements 
{
	
	private static Hashtable<String, Element> listElementsParNom;
	private static Hashtable<Integer, Element> listElementsParID;
	private int prochainID;
	private int iDprecedent;
	
	public GestionnaireElements()
	{
		setListElementsParNom(new Hashtable<String, Element>());
		setListElementsParID(new Hashtable<Integer, Element>());
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

	public static Hashtable<String, Element> getListElementsParNom() 
	{
		return listElementsParNom;
	}

	public void setListElementsParNom(Hashtable<String, Element> listElements) 
	{
		listElementsParNom = listElements;
	}
	
	public static Hashtable<Integer, Element> getListElementsParID() {
		return listElementsParID;
	}

	private void setListElementsParID(Hashtable<Integer, Element> listElementsParID) {
		GestionnaireElements.listElementsParID = listElementsParID;
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
		GestionnaireElements.getListElementsParNom().put(element.getNomElement(), element);
		GestionnaireElements.getListElementsParID().put(element.getIdElement(), element);
	}
	
	public Hashtable<String, Element> getListeElementsFiltrees(String filtre)
	{
		
		Hashtable<String, Element> listeTriee = new Hashtable<String, Element>();
		
		Collection<Element> valeurs = listElementsParNom.values();
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
	
	public static Element recupererElementParId(int id)
	{
		return getListElementsParID().get(id);
		
	}
	
	public static Element recupererElementParNom(String nom)
	{
		return getListElementsParNom().get(nom);
		
	}

}
