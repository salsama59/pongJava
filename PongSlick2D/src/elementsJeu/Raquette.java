package elementsJeu;

import org.newdawn.slick.geom.Rectangle;

import constantes.ConstantesElements;

public class Raquette extends Element
{
	private Rectangle element = null;
	private float vitesse;
	private boolean enDeplacement = false;
	private int endurance;
	private int energie;
	private int idJoueurProprietaire;

	public Raquette(float x, float y, float largeur, float longueur, float v, String nom, String camp, int idJoueur)
	{
		super(nom, false, ConstantesElements.ELEMENT_RAQUETTE_TYPE, camp);
		this.setElement(new Rectangle(x,y,largeur,longueur));
		this.setVitesse(v);
		this.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
		this.setIdJoueurProprietaire(idJoueur);
	}

	public float getVitesse() {
		return vitesse;
	}

	public void setVitesse(float vitesse) {
		this.vitesse = vitesse;
	}

	public Rectangle getElement() {
		return element;
	}

	private void setElement(Rectangle element) {
		this.element = element;
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
	}
	
	public void setCoordonneeY(float y)
	{
		this.getElement().setY(y);
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

	public boolean isEnDeplacement() {
		return enDeplacement;
	}

	public void setEnDeplacement(boolean enDeplacement) {
		this.enDeplacement = enDeplacement;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int energie) {
		this.energie = energie;
	}
	
	public void appliquerSmash(Balle balle, int delta)
	{
		balle.setVitesse(balle.getVitesse() * ConstantesElements.ELEMENT_RAQUETTE1_VALEUR_SMASH * delta);
	}
	
	public void appliquerSpin(Balle balle, int delta)
	{
		balle.setVitesse((balle.getVitesse() * delta) / ConstantesElements.ELEMENT_RAQUETTE1_REDUCTION_SPIN);
	}

	public int getIdJoueurProprietaire() {
		return idJoueurProprietaire;
	}

	public void setIdJoueurProprietaire(int idJoueurProprietaire) {
		this.idJoueurProprietaire = idJoueurProprietaire;
	}


}
