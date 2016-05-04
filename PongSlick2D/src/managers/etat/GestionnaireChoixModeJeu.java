package managers.etat;

import java.util.Hashtable;

import org.newdawn.slick.state.StateBasedGame;

public class GestionnaireChoixModeJeu 
{
	
	private static Hashtable<Integer, String> ModeDeJeu;
	private static String selection;
	
	public static final String EXIBITION = "Mode Exibition";
	public static final String OPTIONS = "Options";
	public static final String QUITTER_JEU = "Quitter le jeu";
	
	private StateBasedGame jeu;
	
	private GestionnaireChoixModeJeu()
	{
		setSelection(EXIBITION);
		ModeDeJeu = new Hashtable<Integer, String>();
		
		this.initialiserListModeJeu();
		
	}
	
	private static class Detenteur
	{		
		/** Instance unique non préinitialisée */
		private final static GestionnaireChoixModeJeu instance = new GestionnaireChoixModeJeu();
	}
	
	/** Point d'accès pour l'instance unique du singleton */
	public static GestionnaireChoixModeJeu getInstance()
	{
		return Detenteur.instance;
	}
	
	
	private void initialiserListModeJeu()
	{
		ModeDeJeu.put(0, EXIBITION);
		ModeDeJeu.put(1, OPTIONS);
		ModeDeJeu.put(2, QUITTER_JEU);
	}
	
	public void selectionnerMode(Integer choix)
	{
		setSelection(getModeDeJeu().get(choix));
	}


	public String getSelection() 
	{
		return selection;
	}


	public static void setSelection(String selection) 
	{
		GestionnaireChoixModeJeu.selection = selection;
	}


	public static Hashtable<Integer, String> getModeDeJeu() 
	{
		return ModeDeJeu;
	}


	public static void setModeDeJeu(Hashtable<Integer, String> modeDeJeu) 
	{
		ModeDeJeu = modeDeJeu;
	}


	public StateBasedGame getJeu() {
		return jeu;
	}


	public void setJeu(StateBasedGame jeu) {
		this.jeu = jeu;
	}

}
