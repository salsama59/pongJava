package elementGraphique;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import constantes.ConstantesElements;
import constantes.ConstantesGraphismes;
import elementsJeu.Curseur;
import elementsJeu.Element;

public class Conteneur extends Element
{
	
	private Rectangle element;
	
	private List<Texte> elementsTextuel = new ArrayList<Texte>();
	
	private Curseur curseur = null;
	
	private Texte titreMenu;

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
		
		if(this.getTitreMenu() != null)
		{
			hauteur += this.getTitreMenu().getHauteur();
			
			if(this.getTitreMenu().getLargeur() > largeur)
			{
				largeur = this.getTitreMenu().getLargeur();
			}
		}
		
		float largeurCurseur = 0.f;
		
		if(this.getCurseur() != null)
		{
			largeurCurseur = this.getCurseur().getElement().getWidth();
		}
		
		largeur = largeur + (2 * ConstantesGraphismes.GRAPHISME_MARGE) + (largeurCurseur * 2);
		hauteur = hauteur + (2 * ConstantesGraphismes.GRAPHISME_RETRAIT);
		
		this.setHauteur(hauteur);
		this.setLargeur(largeur);
	}
	
	public void afficher(Graphics graphisme)
	{
		
		graphisme.draw(this.getElement());
		
		if(this.getTitreMenu() != null)
		{
			this.getTitreMenu().afficher();
			this.tracerLigneTitre(graphisme);
		}
		
		for(Texte ligne : this.getElementsTextuel())
		{
			ligne.afficher();
		}
		
		if(this.getCurseur() != null)
		{
			this.getCurseur().afficher(graphisme);
		}
		
	}
	
	public void afficher(Graphics graphisme, String nouveauMessage)
	{
		
		graphisme.draw(this.getElement());
		
		if(this.getTitreMenu() != null)
		{
			this.getTitreMenu().afficher();
			this.tracerLigneTitre(graphisme);
		}
		
		for(Texte ligne : this.getElementsTextuel())
		{
			
			if(ligne.isTexteVariable())
			{
				ligne.setMessage(nouveauMessage);
			}
			
				ligne.afficher();
				
		}
		
		this.calculerTailleZone();
		
		if(this.getCurseur() != null)
		{
			this.getCurseur().afficher(graphisme);
		}
		
	}
	
	public Curseur getCurseur() 
	{
		return curseur;
	}

	public void setCurseur(Curseur curseur) 
	{
		
		this.curseur = curseur;
		
		this.curseur.setConteneurAffectation(this);
		
		this.ajusterPositionTextes();
		
		this.curseur.initialiserEnplacement();
		
		this.calculerTailleZone();
		
	}

	public Texte getTitreMenu() {
		return titreMenu;
	}

	public void setTitreMenu(Texte titreMenu) 
	{
		this.titreMenu = titreMenu;
		this.calculerTailleZone();
	}
	
	private void tracerLigneTitre(Graphics graphisme)
	{
		graphisme.drawLine(this.getElement().getX(), this.getElement().getY() + this.getTitreMenu().getHauteur(), this.getElement().getX() + this.getLargeur() - 1, this.getElement().getY() + this.getTitreMenu().getHauteur());
	}
	
	private void ajusterPositionTextes()
	{
		
		for(Texte texte : this.getElementsTextuel())
		{
			texte.setCoordonneesX(texte.calculerPositionX());
			texte.setCoordonneesY(texte.calculerPositionY());
		}
		
		if(this.getTitreMenu() != null)
		{
			
			this.getTitreMenu().setCoordonneesX(this.getTitreMenu().calculerPositionX());
			this.getTitreMenu().setCoordonneesY(this.getTitreMenu().calculerPositionY());
			
		}
	}

}
