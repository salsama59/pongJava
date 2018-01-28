package elementGraphique;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import constantes.ConstantesElements;
import constantes.ConstantesJoueurs;
import elementsJeu.Element;

public class Avatar extends Element
{
	
	private Rectangle element;
	private int idjoueurRepresente;
	private boolean enDeplacement = false;
	private boolean valide;
	private Texte elementAvatar;
	
	public Avatar(int idjoueurRepresente, GameContainer gameContainer, float x, float y, float largeur, float hauteur, Image sprite)
	{
		super("", false, ConstantesElements.ELEMENT_AVATAR_TYPE, ConstantesJoueurs.JOUEUR_CAMP_NEUTRE, sprite);
		this.setIdjoueurRepresente(idjoueurRepresente);
		this.setElement(new Rectangle(x, y, largeur, hauteur));
		this.setValide(false);
	}

	public Rectangle getElement() {
		return element;
	}

	public void setElement(Rectangle element) {
		this.element = element;
	}

	public int getIdjoueurRepresente() {
		return idjoueurRepresente;
	}

	public void setIdjoueurRepresente(int idjoueurRepresente) {
		this.idjoueurRepresente = idjoueurRepresente;
	}

	public boolean isEnDeplacement() {
		return enDeplacement;
	}

	public void setEnDeplacement(boolean enDeplacement) {
		this.enDeplacement = enDeplacement;
	}
	
	public float getCoordonneeX()
	{
		return this.getElement().getX();
	}
	
	public float getCoordonneeY()
	{
		return this.getElement().getY();
	}
	
	public void setCoordonneeX(float x)
	{
		
		this.getElement().setX(x);
		
		this.getElementAvatar().setCoordonneesX(this.getCoordonneeX() + (this.getElement().getWidth()/2) - (this.getElementAvatar().getLargeur()/2));
		
	}
	
	public void setCoordonneeY(float y)
	{
		
		this.getElement().setY(y);
		
		this.getElementAvatar().setCoordonneesY(this.getCoordonneeY() + (this.getElement().getHeight()/2) - (this.getElementAvatar().getHauteur()/2));
		
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public Texte getElementAvatar() {
		return elementAvatar;
	}

	public void setElementAvatar(Texte elementAvatar) {
		this.elementAvatar = elementAvatar;
	}
	
}
