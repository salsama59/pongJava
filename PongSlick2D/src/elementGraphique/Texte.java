package elementGraphique;

import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.TrueTypeFont;

import constantes.ConstantesElements;
import constantes.ConstantesGraphismes;
import elementsJeu.Element;

public class Texte extends Element
{
	
	private Conteneur conteneur;
	private TrueTypeFont element;
	private String message;
	private float x;
	private float y;
	private boolean texteVariable = false;
	
	public Texte(String message, float x, float y, Conteneur conteneur, GameContainer gameContainer, boolean texteVariable)
	{
		super(message, false, ConstantesElements.ELEMENT_TEXTE_TYPE, null);
		this.setCoordonneesX(x);
		this.setCoordonneesY(y);
		this.setTexteVariable(texteVariable);
		this.setMessage(message);
		this.setConteneur(conteneur);
		element = new TrueTypeFont(new java.awt.Font(java.awt.Font.SERIF, java.awt.Font.PLAIN , 12), false);
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Conteneur getConteneur() {
		return conteneur;
	}

	public void setConteneur(Conteneur conteneur) 
	{
		this.conteneur = conteneur;
		
		if(this.getConteneur() != null)
		{
			this.setCoordonneesX(this.calculerPositionX());
			this.setCoordonneesY(this.calculerPositionY());
		}
		
	}

	public TrueTypeFont getElement() {
		return element;
	}

	public void setElement(TrueTypeFont element) 
	{
		this.element = element;
		
		if(this.getConteneur() != null)
		{
			this.setCoordonneesX(this.calculerPositionX());
			this.setCoordonneesY(this.calculerPositionY());
		}
	}
	
	public float getCoordonneesX()
	{
		return this.x;
	}
	
	public float getCoordonneesY()
	{
		return this.y;
	}
	
	public void setCoordonneesX(float x)
	{
		this.x = x;
	}
	
	public void setCoordonneesY(float y)
	{
		this.y = y;
	}
	
	public float getLargeur()
	{
		return this.getElement().getWidth(this.getMessage());
	}
	
	public float getLargeur(String nouveauMessage)
	{
		return this.getElement().getWidth(nouveauMessage);
	}
	
	public float getHauteur()
	{
		return this.getElement().getHeight(this.getMessage());
	}
	
	public float getHauteur(String nouveauMessage)
	{
		return this.getElement().getHeight(nouveauMessage);
	}
	
	public int calculerPositionX()
	{
		int positionXelement = 0;
		
		int positionXconteneurExcentree = 0;
		
		positionXconteneurExcentree = (int) (this.getConteneur().getCentreX() - (this.getConteneur().getLargeur()/2));
		
		if(positionXconteneurExcentree < 0)
		{
			positionXconteneurExcentree = positionXconteneurExcentree * -1;
		}
		
		positionXelement = (int) (positionXconteneurExcentree + ConstantesGraphismes.GRAPHISME_MARGE);
		
		return positionXelement;
		
		
	}
	
	public int calculerPositionY()
	{
		
		int positionYelement = 0;
		
		int positionYconteneurExcentree = 0;
		
		int index = this.recupererRangElementTextuel();
		
		positionYconteneurExcentree = (int) (this.getConteneur().getCentreY() - (this.getConteneur().getHauteur()/2));
		
		if(positionYconteneurExcentree < 0)
		{
			positionYconteneurExcentree = positionYconteneurExcentree * -1;
		}
		
		positionYelement = (int) (positionYconteneurExcentree + ConstantesGraphismes.GRAPHISME_RETRAIT * (index + 1));
		
		return positionYelement;
		
	}
	
	public void afficher()
	{
		this.getElement().drawString(this.getCoordonneesX(), this.getCoordonneesY(), this.getMessage());
	}
	
	public void afficher(String complementMessage)
	{
		this.getElement().drawString(this.getCoordonneesX(), this.getCoordonneesY(), this.getMessage() + " " + complementMessage);
	}
	
	public int recupererRangElementTextuel()
	{
		
		if(this.getConteneur() != null)
		{
			
			List<Texte> groupTextuel = this.getConteneur().getElementsTextuel();
			
			for(int i = 0; i < groupTextuel.size(); i++)
			{
				Texte texte = groupTextuel.get(i);
				
				if(this.getIdElement() == texte.getIdElement())
				{
					return i;
				}
			}
			
		}
		
		return -1;
		
	}

	public boolean isTexteVariable() {
		return texteVariable;
	}

	public void setTexteVariable(boolean texteVariable) {
		this.texteVariable = texteVariable;
	}

}
