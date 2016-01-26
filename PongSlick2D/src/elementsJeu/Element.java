package elementsJeu;

import constantes.ConstantesElements;

public class Element 
{
	private int idElement;
	private String nomElement;
	private String type;
	private boolean enCollision;
	private String camp;
	private int sens;
	private int etat;
	
	public Element(String nom, boolean enCollision, String type, String camp)
	{
		this.setCamp(camp);
		this.setNomElement(nom);
		this.setType(type);
		this.setEnCollision(enCollision);
		this.setEtat(ConstantesElements.ELEMENT_ETAT_NEUTRE);
		this.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
	}
	
	public Element(String nom, boolean enCollision, String type)
	{
		this.setNomElement(nom);
		this.setType(type);
		this.setEnCollision(enCollision);
		this.setEtat(ConstantesElements.ELEMENT_ETAT_NEUTRE);
		this.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
	}

	public int getIdElement() 
	{
		return idElement;
	}

	public void setIdElement(int idElement) 
	{
		this.idElement = idElement;
	}

	public String getNomElement() 
	{
		return nomElement;
	}

	public void setNomElement(String nomElement) 
	{
		this.nomElement = nomElement;
	}

	public String getType() 
	{
		return type;
	}

	protected void setType(String type) 
	{
		this.type = type;
	}

	public boolean isEnCollision() {
		return enCollision;
	}

	public void setEnCollision(boolean enCollision) {
		this.enCollision = enCollision;
	}

	public String getCamp() {
		return camp;
	}

	public void setCamp(String camp) {
		this.camp = camp;
	}

	public int getSens() {
		return sens;
	}

	public void setSens(int sens) {
		this.sens = sens;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}
	
}
