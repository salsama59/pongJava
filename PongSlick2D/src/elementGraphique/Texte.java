package elementGraphique;

import org.newdawn.slick.gui.TextField;

import constantes.ConstantesElements;
import constantes.ConstantesGraphismes;
import elementsJeu.Element;

public class Texte extends Element
{
	private String message;
	private TextField element;
	private Conteneur conteneur;
	
	public Texte(String message, float x, float y, Conteneur conteneur)
	{
		super(message, false, ConstantesElements.ELEMENT_TEXTE_TYPE, null);
		this.setMessage(message);
		this.setConteneur(conteneur);
	}

	public String getMessage() {
		return message;
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

	public TextField getElement() {
		return element;
	}

	public void setElement(TextField element) 
	{
		this.element = element;
		this.setCoordonneesX(this.calculerPositionX());
		this.setCoordonneesY(this.calculerPositionY());
	}
	
	public int getCoordonneesX()
	{
		return this.getElement().getX();
	}
	
	public int getCoordonneesY()
	{
		return this.getElement().getY();
	}
	
	public void setCoordonneesX(int x)
	{
		this.getElement().setLocation(x, this.getCoordonneesY());
	}
	
	public void setCoordonneesY(int y)
	{
		this.getElement().setLocation(this.getCoordonneesX(), y);
	}
	
	public float getLargeur()
	{
		return this.getElement().getWidth();
	}
	
	public float getHauteur()
	{
		return this.getElement().getHeight();
	}
	
	private int calculerPositionX()
	{
		int positionXelement = 0;
		
		int positionXconteneurExcentree = 0;
		
		positionXconteneurExcentree = (int) (this.getConteneur().getCentreX() - this.getConteneur().getLargeur());
		
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
		
		positionYconteneurExcentree = (int) (this.getConteneur().getCentreY() - this.getConteneur().getHauteur());
		
		if(positionYconteneurExcentree < 0)
		{
			positionYconteneurExcentree = positionYconteneurExcentree * -1;
		}
		
		positionYelement = (int) (positionYconteneurExcentree + ConstantesGraphismes.GRAPHISME_RETRAIT);
		
		return positionYelement;
		
	}

}
