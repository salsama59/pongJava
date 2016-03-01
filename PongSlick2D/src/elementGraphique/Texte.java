package elementGraphique;

import org.newdawn.slick.gui.TextField;

import constantes.ConstantesElements;
import elementsJeu.Element;

public class Texte extends Element
{
	private String message;
	private TextField element;
	private float coordoneeX;
	private float coordoneeY;
	private Conteneur conteneur;
	
	public Texte(String message, float x, float y, Conteneur conteneur)
	{
		super(message, false, ConstantesElements.ELEMENT_TEXTE_TYPE, null);
		this.setMessage(message);
		this.setConteneur(conteneur);
		this.setCoordoneeX(x);
		this.setCoordoneeY(y);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public float getCoordoneeX() {
		return coordoneeX;
	}

	public void setCoordoneeX(float coordoneeX) {
		this.coordoneeX = coordoneeX;
	}

	public float getCoordoneeY() {
		return coordoneeY;
	}

	public void setCoordoneeY(float coordoneeY) {
		this.coordoneeY = coordoneeY;
	}

	public Conteneur getConteneur() {
		return conteneur;
	}

	public void setConteneur(Conteneur conteneur) {
		this.conteneur = conteneur;
	}

	public TextField getElement() {
		return element;
	}

	public void setElement(TextField element) {
		this.element = element;
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

}
