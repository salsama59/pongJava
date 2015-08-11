package elementsJeu;

public class Element 
{
	private int idElement;
	private String nomElement;
	private String type;
	private boolean enCollision;
	
	public Element(String nom, boolean enCollision, String type)
	{
		this.setNomElement(nom);
		this.setType(type);
		this.setEnCollision(enCollision);
	}
	
	public Element(String nom, String type)
	{
		this.setNomElement(nom);
		this.setType(type);
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
	
}
