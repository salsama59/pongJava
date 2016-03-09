package elementGraphique;

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
	
	public Texte(String message, float x, float y, Conteneur conteneur, GameContainer gameContainer)
	{
		super(message, false, ConstantesElements.ELEMENT_TEXTE_TYPE, null);
		this.setMessage(message);
		this.setConteneur(conteneur);
		this.setCoordonneesX(this.calculerPositionX());
		this.setCoordonneesY(this.calculerPositionY());
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
		this.setCoordonneesX(this.calculerPositionX());
		this.setCoordonneesY(this.calculerPositionY());
	}

	public TrueTypeFont getElement() {
		return element;
	}

	public void setElement(TrueTypeFont element) 
	{
		this.element = element;
		this.setCoordonneesX(this.calculerPositionX());
		this.setCoordonneesY(this.calculerPositionY());
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
	
	public float getHauteur()
	{
		return this.getElement().getHeight(this.getMessage());
	}
	
	private int calculerPositionX()
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
	
	private int calculerPositionY()
	{
		
		int positionYelement = 0;
		
		int positionYconteneurExcentree = 0;
		
		int index = this.getConteneur().getElementsTextuel().indexOf(this);
		
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

}
