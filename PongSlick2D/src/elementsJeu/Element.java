package elementsJeu;

public class Element 
{
	private int idElement;
	private String nomElement;
	
	public Element(String nom)
	{
		this.setNomElement(nom);
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
	
}
