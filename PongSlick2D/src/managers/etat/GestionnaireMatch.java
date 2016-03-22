package managers.etat;
import java.util.Hashtable;
import java.util.Random;

import constantes.ConstantesGestionnaires;

public class GestionnaireMatch 
{
	
	private static int pointCampDroit;
	private static int pointCampGauche;
	private static int idLanceur;
	private static Hashtable<Integer, Integer> choix;
	
	private GestionnaireMatch ()
	{
		choix = new Hashtable<Integer, Integer>();
	}
	
	private static class Detenteur
	{		
		/** Instance unique non préinitialisée */
		private final static GestionnaireMatch instance = new GestionnaireMatch();
	}
	
	/** Point d'accès pour l'instance unique du singleton */
	public static GestionnaireMatch getInstance()
	{
		return Detenteur.instance;
	}
	
	
	public static int getPointCampDroit() 
	{
		return pointCampDroit;
	}
	
	public static void setPointCampDroit(int point_camp_droit) 
	{
		GestionnaireMatch.pointCampDroit = point_camp_droit;
	}
	
	public static int getPointCampGauche() 
	{
		return pointCampGauche;
	}
	
	public static void setPointCampGauche(int point_camp_gauche) 
	{
		GestionnaireMatch.pointCampGauche = point_camp_gauche;
	}
	
	public void reinitialiserPointsMatch()
	{
		this.setPointCampDroit(0);
		this.setPointCampGauche(0);
	}

	public static int getIdLanceur() 
	{
		return idLanceur;
	}

	public static void setIdLanceur(int idLanceur) 
	{
		GestionnaireMatch.idLanceur = idLanceur;
	}

	public Hashtable<Integer, Integer> getChoix() 
	{
		return choix;
	}

	public static void setChoix(Hashtable<Integer, Integer> choix) 
	{
		GestionnaireMatch.choix = choix;
	}
	
	//Substitut à pile ou face
	public static int genererChoix()
	{
		
		int intervale = ConstantesGestionnaires.INTERVALE_MAXIMAL - ConstantesGestionnaires.INTERVALE_MINIMAL;
		
		Random randomisateur = new Random();
		
		return ConstantesGestionnaires.INTERVALE_MINIMAL + randomisateur.nextInt(intervale);
		
	}
	
	public static void attribuerLancementBalle()
	{
		GestionnaireMatch.setIdLanceur(choix.get(GestionnaireMatch.genererChoix()));
	}
	
}
