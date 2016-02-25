package elementGraphique;

import constantes.ConstantesElements;
import elementsJeu.Element;

public class Texte extends Element
{
	private String message;
	
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

}
