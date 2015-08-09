package elementsJeu;

public class Element 
{
	private int idElement;
	private String nomElement;
	private boolean enCollision;
	
	public Element(String nom, boolean enCollision)
	{
		this.setNomElement(nom);
		this.setEnCollision(enCollision);
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

	public boolean isEnCollision() {
		return enCollision;
	}

	public void setEnCollision(boolean enCollision) {
		this.enCollision = enCollision;
	}
	
}
