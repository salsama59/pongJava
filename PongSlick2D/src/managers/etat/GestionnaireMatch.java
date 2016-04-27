package managers.etat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import constantes.ConstantesAffichageInfos;
import constantes.ConstantesGestionnaires;
import constantes.ConstantesJoueurs;

public class GestionnaireMatch 
{
	
	private static int pointCampDroit;
	private static int pointCampGauche;
	private static int idLanceur;
	private static Hashtable<Integer, Integer> choix;
	private List<Integer> listIdJoueurs = new ArrayList<Integer>();
	private int idJoueurAvantage;
	private int limitePointsVictoire = ConstantesJoueurs.JOUEUR_LIMITE_POINT_VICTOIRE;
	
	private GestionnaireMatch ()
	{
		choix = new Hashtable<Integer, Integer>();
		listIdJoueurs.add(ConstantesJoueurs.JOUEUR_ID_1);
		listIdJoueurs.add(ConstantesJoueurs.JOUEUR_ID_2);
		listIdJoueurs.add(ConstantesJoueurs.JOUEUR_ID_3);
		listIdJoueurs.add(ConstantesJoueurs.JOUEUR_ID_4);
		
		this.setIdJoueurAvantage(ConstantesJoueurs.JOUEUR_ID_1);
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
	
	public int getPointCampDroit() 
	{
		return pointCampDroit;
	}
	
	public void setPointCampDroit(int point_camp_droit) 
	{
		GestionnaireMatch.pointCampDroit = point_camp_droit;
	}
	
	public int getPointCampGauche() 
	{
		return pointCampGauche;
	}
	
	public void setPointCampGauche(int point_camp_gauche) 
	{
		GestionnaireMatch.pointCampGauche = point_camp_gauche;
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
		GestionnaireMatch.idLanceur = idLanceur;
	}

	public Hashtable<Integer, Integer> getChoix() 
	{
		return choix;
	}

	public void setChoix(Hashtable<Integer, Integer> choix) 
	{
		GestionnaireMatch.choix = choix;
	}
	
	//Substitut à pile ou face
	public int genererDecision()
	{
		
		int intervale = ConstantesGestionnaires.INTERVALE_MAXIMAL - ConstantesGestionnaires.INTERVALE_MINIMAL;
		
		Random randomisateur = new Random();
		
		return ConstantesGestionnaires.INTERVALE_MINIMAL + randomisateur.nextInt(intervale);
		
	}
	
	public void attribuerLancementBalle()
	{
		
		int decisionAleatoire = GestionnaireMatch.getInstance().genererDecision();
		
		for(Integer idJoueur : this.getListIdJoueurs())
		{
			
			Integer choixJoueur = choix.get(idJoueur);
			
			if(choixJoueur != null)
			{
				if(decisionAleatoire == choixJoueur.intValue())
				{
					GestionnaireMatch.getInstance().setIdLanceur(idJoueur.intValue());
					break;
				}
			}
			
		}
		
	}


	public List<Integer> getListIdJoueurs() 
	{
		return listIdJoueurs;
	}


	public void setListIdJoueurs(List<Integer> listIdJoueurs) 
	{
		this.listIdJoueurs = listIdJoueurs;
	}
	
	public void miseAjourChoixMiseEnJeuJoueur(Integer choix)
	{
		
		this.getChoix().put(this.getIdJoueurAvantage(), choix);
		
		for(Integer idjoueur : this.getListIdJoueurs())
		{
			
			if(idjoueur.intValue() != this.getIdJoueurAvantage())
			{
				
				if(choix == ConstantesAffichageInfos.CHOIX_LANCEMENT_FACE)
				{
					this.getChoix().put(idjoueur.intValue(), ConstantesAffichageInfos.CHOIX_LANCEMENT_PILE);
				}
				else if(choix == ConstantesAffichageInfos.CHOIX_LANCEMENT_PILE)
				{
					this.getChoix().put(idjoueur.intValue(), ConstantesAffichageInfos.CHOIX_LANCEMENT_FACE);
				}
				
			}
		}
		
	}


	public int getIdJoueurAvantage() 
	{
		return idJoueurAvantage;
	}


	public void setIdJoueurAvantage(int idJoueurAvantage) 
	{
		this.idJoueurAvantage = idJoueurAvantage;
	}

	public int getLimitePointsVictoire() 
	{
		return limitePointsVictoire;
	}

	public void setLimitePointsVictoire(int limitePointsVictoire) 
	{
		this.limitePointsVictoire = limitePointsVictoire;
	}
	
	public boolean isFinMatch()
	{
		
		boolean fin = false;
		
		if(this.getPointCampDroit() == ConstantesJoueurs.JOUEUR_LIMITE_POINT_VICTOIRE || this.getPointCampGauche() == ConstantesJoueurs.JOUEUR_LIMITE_POINT_VICTOIRE)
		{
			fin = true;
		}
		
		return fin;
		
	}
	
	public String getCampVainqueur()
	{
		String camp = ConstantesJoueurs.JOUEUR_CAMP_NEUTRE;
		
		if(this.getPointCampDroit() == ConstantesJoueurs.JOUEUR_LIMITE_POINT_VICTOIRE)
		{
			camp = ConstantesJoueurs.JOUEUR_CAMP_DROITE;
		}
		
		if(this.getPointCampGauche() == ConstantesJoueurs.JOUEUR_LIMITE_POINT_VICTOIRE)
		{
			camp = ConstantesJoueurs.JOUEUR_CAMP_GAUCHE;
		}
		
		return camp;
		
	}
	
}
