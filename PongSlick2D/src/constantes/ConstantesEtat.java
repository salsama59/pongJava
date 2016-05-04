package constantes;

public class ConstantesEtat 
{
	
	//Match entre joueur
	public final static int ETAT_MATCH = 1;
	public final static String ETAT_MATCH_PHASE_MISE_EN_JEU = "MISE_EN_JEU";
	public final static String ETAT_MATCH_PHASE_PARTIE = "PARTIE";
	public final static String ETAT_MATCH_PHASE_RESULTAT = "RESULTAT";
	
	//Choix du mode de jeu
	public final static int ETAT_CHOIX_MODE = 2;
	public final static String ETAT_CHOIX_MODE_PHASE_SELECTION = "SELECTION_MODE";
	public final static String ETAT_CHOIX_MODE_PHASE_EXIBITION_LOBBY = "MODE_EXIBITION_LOBBY";
	public final static String ETAT_CHOIX_MODE_PHASE_OPTIONS = "MODE_OPTIONS";
	
	//Options du jeu
	public final static int ETAT_OPTION = 3;
	public final static String ETAT_OPTIONS_PHASE_AFFICHAGE_GENERAL = "AFFICHAGE_GENERAL";
}
