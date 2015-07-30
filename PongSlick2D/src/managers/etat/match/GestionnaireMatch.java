package managers.etat.match;

public class GestionnaireMatch 
{
	
	private int pointCampDroit;
	private int pointCampGauche;
	
	public int getPointCampDroit() 
	{
		return pointCampDroit;
	}
	
	public void setPointCampDroit(int point_camp_droit) 
	{
		this.pointCampDroit = point_camp_droit;
	}
	
	public int getPointCampGauche() 
	{
		return pointCampGauche;
	}
	
	public void setPointCampGauche(int point_camp_gauche) 
	{
		this.pointCampGauche = point_camp_gauche;
	}
	
	public void reinitialiserPointsMatch()
	{
		this.setPointCampDroit(0);
		this.setPointCampGauche(0);
	}
	
	
}
