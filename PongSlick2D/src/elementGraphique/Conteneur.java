package elementGraphique;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import constantes.ConstantesElements;
import constantes.ConstantesGraphismes;
import elementsJeu.Element;

public class Conteneur extends Element
{
	
	private Rectangle element;
	
	private List<Texte> elementsTextuel = new ArrayList<Texte>();

	public Conteneur(float x, float y)
	{
		super("Cadre", false, ConstantesElements.ELEMENT_CADRE_TYPE, null);
		
		element = new Rectangle(x, y, 0, 0);
		
		this.setCentreX(x);
		this.setCentreY(y);
		
		this.calculerTailleZone();
	}

	public List<Texte> getElementsTextuel() {
		return elementsTextuel;
	}

	public void setElementsTextuel(List<Texte> elementsTextuel) 
	{
		this.elementsTextuel = elementsTextuel;
		
		this.calculerTailleZone();
		
	}
	
	public void ajouterElementTextuel(Texte texte)
	{
		this.getElementsTextuel().add(texte);
		
		this.calculerTailleZone();
	}
	
	public void supprimerElementTextuel(Texte texte)
	{
		this.getElementsTextuel().remove(texte);
		
		this.calculerTailleZone();
	}

	public Rectangle getElement() {
		return element;
	}

	public void setElement(Rectangle element) {
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
	
	private void calculerTailleZone()
	{
		
		float largeur = 0f;
		float hauteur = 0f;
		
		for(Texte ligne : this.getElementsTextuel())
		{
			hauteur += ligne.getHauteur();
			
			if(ligne.getLargeur() > largeur)
			{
				largeur = ligne.getLargeur();
			}
		}
		
		largeur = largeur + (2 * ConstantesGraphismes.GRAPHISME_MARGE);
		hauteur = hauteur + (2 * ConstantesGraphismes.GRAPHISME_RETRAIT);
		
		this.setHauteur(hauteur);
		this.setLargeur(largeur);
	}
	
	public void afficher(Graphics graphisme)
	{
		graphisme.draw(this.getElement());
		
		for(Texte ligne : this.getElementsTextuel())
		{
			ligne.afficher();
		}
	}

}
