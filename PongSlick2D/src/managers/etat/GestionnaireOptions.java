package managers.etat;

import java.util.Hashtable;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import donnees.Options;

public class GestionnaireOptions 
{
	private static Hashtable<Integer, String> Options;
	private static String selection;
	
	private Graphics graphisme;
	
	public static final String OPTION1 = "Couleur affichage";
	public static final String OPTION2 = "Retour";
	public static final String OPTION3 = "Option 3";
	public static final String OPTION4 = "Option 4";
	public static final String OPTION5 = "Option 5";
	public static final String OPTION6 = "Option 6";
	public static final String OPTION7 = "Option 7";
	
	private StateBasedGame jeu;
	
	private Integer idEtatPrecedent;
	
	private Options donneesOption;
	
	private GestionnaireOptions()
	{
		setSelection(OPTION1);
		Options = new Hashtable<Integer, String>();
		
		this.setDonneesOption(new Options());
		
		this.initialiserListOptions();
		
	}
	
	private static class Detenteur
	{		
		/** Instance unique non préinitialisée */
		private final static GestionnaireOptions instance = new GestionnaireOptions();
	}
	
	/** Point d'accès pour l'instance unique du singleton */
	public static GestionnaireOptions getInstance()
	{
		return Detenteur.instance;
	}
	
	
	private void initialiserListOptions()
	{
		Options.put(0, OPTION1);
		Options.put(1, OPTION2);
		Options.put(2, OPTION3);
		Options.put(3, OPTION4);
		Options.put(4, OPTION5);
		Options.put(5, OPTION6);
		Options.put(6, OPTION7);
	}
	
	public void selectionnerOption(Integer choix)
	{
		setSelection(getOptions().get(choix));
	}


	public String getSelection() 
	{
		return selection;
	}


	public static void setSelection(String selection) 
	{
		GestionnaireOptions.selection = selection;
	}


	public static Hashtable<Integer, String> getOptions() 
	{
		return Options;
	}


	public static void setOptions(Hashtable<Integer, String> options) 
	{
		Options = options;
	}


	public StateBasedGame getJeu() {
		return jeu;
	}


	public void setJeu(StateBasedGame jeu) {
		this.jeu = jeu;
	}


	public Integer getIdEtatPrecedent() {
		return idEtatPrecedent;
	}


	public void setIdEtatPrecedent(Integer idEtatPrecedent) {
		this.idEtatPrecedent = idEtatPrecedent;
	}


	public Graphics getGraphisme() {
		return graphisme;
	}


	public void setGraphisme(Graphics graphisme) {
		this.graphisme = graphisme;
	}


	public Options getDonneesOption() {
		return donneesOption;
	}


	public void setDonneesOption(Options donneesOption) {
		this.donneesOption = donneesOption;
	}
}
