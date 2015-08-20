package elementsJeu;

public class Element 
{
	private int idElement;
	private String nomElement;
	private String type;
	private boolean enCollision;
	private String camp;
	
	public Element(String nom, boolean enCollision, String type, String camp)
	{
		this.setCamp(camp);
		this.setNomElement(nom);
		this.setType(type);
		this.setEnCollision(enCollision);
	}
	
	public Element(String nom, boolean enCollision, String type)
	{
		this.setNomElement(nom);
		this.setType(type);
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
	
}
