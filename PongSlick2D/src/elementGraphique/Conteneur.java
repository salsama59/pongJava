package elementGraphique;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.geom.RoundedRectangle;


import constantes.ConstantesElements;
import elementsJeu.Element;

public class Conteneur extends Element
{
	
	private RoundedRectangle element;
	
	private List<Texte> elementsTextuel = new ArrayList<Texte>();

	public Conteneur(float x, float y, float largeur, float hauteur)
	{
		super("Cadre", false, ConstantesElements.ELEMENT_CADRE_TYPE, null);
		
		this.setCentreX(x);
		this.setCentreY(y);
		
		this.setLargeur(largeur);
		this.setHauteur(hauteur);
	}

	public List<Texte> getElementsTextuel() {
		return elementsTextuel;
	}

	public void setElementsTextuel(List<Texte> elementsTextuel) 
	{
		this.elementsTextuel = elementsTextuel;
	}
	
	public void ajouterElementTextuel(Texte texte)
	{
		this.getElementsTextuel().add(texte);
	}

	public RoundedRectangle getElement() {
		return element;
	}

	public void setElement(RoundedRectangle element) {
		this.element = element;
	}
	
	public float getCentreX()
	{
		return this.getElement().getCenterX();
	}
	
	public float getCentreY()
	{
		return this.getElement().getCenterY();
	}
	
	public void setCentreX(float x)
	{
		this.getElement().setCenterX(x);
	}
	
	public void setCentreY(float y)
	{
		this.getElement().setCenterY(y);
	}
	
	public float getLargeur()
	{
		return this.getElement().getWidth();
	}
	
	public float getHauteur()
	{
		return this.getElement().getHeight();
	}
	
	public void setLargeur(float largeur)
	{
		this.getElement().setWidth(largeur);
	}
	
	public void setHauteur(float hauteur)
	{
		this.getElement().setHeight(hauteur);
	}

}
