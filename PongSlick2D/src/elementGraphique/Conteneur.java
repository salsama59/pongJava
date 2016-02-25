package elementGraphique;

import java.util.ArrayList;
import java.util.List;

import constantes.ConstantesElements;
import elementsJeu.Element;

public class Conteneur extends Element 
{
	
	private float coordoneeX;
	private float coordoneeY;
	
	private List<Texte> elementsTextuel = new ArrayList<>();

	public Conteneur(float x, float y)
	{
		super("Cadre", false, ConstantesElements.ELEMENT_CADRE_TYPE, null);
		
		this.setCoordoneeX(x);
		this.setCoordoneeY(y);
	}

	public float getCoordoneeX() 
	{
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

}
