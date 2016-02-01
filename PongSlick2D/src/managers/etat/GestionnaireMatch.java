package managers.etat;
import java.util.Hashtable;
import java.util.Random;

import constantes.ConstantesGestionnaires;

public class GestionnaireMatch 
{
	
	private int pointCampDroit;
	private int pointCampGauche;
	private int idLanceur;
	private Hashtable<Integer, Integer> choix = new Hashtable<Integer, Integer>();
	
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

	public int getIdLanceur() 
	{
		return idLanceur;
	}

	public void setIdLanceur(int idLanceur) 
	{
		this.idLanceur = idLanceur;
	}

	public Hashtable<Integer, Integer> getChoix() 
	{
		return choix;
	}

	public void setChoix(Hashtable<Integer, Integer> choix) 
	{
		this.choix = choix;
	}
	
	//Substitut à pile ou face
	public int genererChoix()
	{
		
		int intervale = ConstantesGestionnaires.INTERVALE_MAXIMAL - ConstantesGestionnaires.INTERVALE_MINIMAL;
		
		Random randomisateur = new Random();
		
		return ConstantesGestionnaires.INTERVALE_MINIMAL + randomisateur.nextInt(intervale);
		
	}
	
	public void attribuerLancementBalle()
	{
		this.setIdLanceur(choix.get(this.genererChoix()));
	}
	
}
