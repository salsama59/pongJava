package elementGraphique;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.gui.TextField;

import constantes.ConstantesElements;
import constantes.ConstantesGraphismes;
import elementsJeu.Element;

public class Texte extends Element implements Font
{
	private TextField element;
	private Conteneur conteneur;
	
	public Texte(String message, float x, float y, Conteneur conteneur, GameContainer gameContainer)
	{
		super(message, false, ConstantesElements.ELEMENT_TEXTE_TYPE, null);
		element = new TextField(gameContainer, null, (int)x, (int) y, 0, 0);
		element.setText(message);
		this.setMessage(message);
		this.setConteneur(conteneur);
	}

	public String getMessage() {
		return this.getElement().getText();
	}

	public void setMessage(String message) {
		this.getElement().setText(message);
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

	@Override
	public void drawString(float arg0, float arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawString(float arg0, float arg1, String arg2, Color arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawString(float arg0, float arg1, String arg2, Color arg3,
			int arg4, int arg5) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getHeight(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLineHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
