package Joueur;

public class Joueur 
{
	
	private int id;
	private String camp;
	private String nom;
	private boolean connecte;
	
	public Joueur(int id, String camp, String nom)
	{
		this.setId(id);
		this.setCamp(camp);
		this.setNom(nom);
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getCamp() 
	{
		return camp;
	}
	
	public void setCamp(String camp) 
	{
		this.camp = camp;
	}
	
	public String getNom() 
	{
		return nom;
	}
	
	public void setNom(String nom) 
	{
		this.nom = nom;
	}

	public boolean isConnecte() {
		return connecte;
	}

	public void setConnecte(boolean connecte) {
		this.connecte = connecte;
	}
	
}
