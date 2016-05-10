package managers.etat;

import java.util.Hashtable;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import donnees.generale.Options;

public class GestionnaireOptions 
{
	private static Hashtable<Integer, String> options;
	private static String selection;
	
	private Graphics graphisme;
	
	public static final String OPTION1 = "Pleine écran";
	public static final String OPTION2 = "Activer le son";
	public static final String OPTION3 = "Augmenter le volume de la musique";
	public static final String OPTION4 = "Augmenter le volume des bruitages";
	public static final String OPTION5 = "Retour";
	public static final String OPTION6 = "Option 6";
	public static final String OPTION7 = "Retour";
	
	private StateBasedGame jeu;
	
	private Integer idEtatPrecedent;
	
	private Options donneesOption;
	
	private GestionnaireOptions()
	{
		setSelection(OPTION1);
		options = new Hashtable<Integer, String>();
		
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
		options.put(0, OPTION1);
		options.put(1, OPTION2);
		options.put(2, OPTION3);
		options.put(3, OPTION4);
		options.put(4, OPTION5);
		options.put(5, OPTION6);
		options.put(6, OPTION7);
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
		return options;
	}


	public static void setOptions(Hashtable<Integer, String> listOptions) 
	{
		options = listOptions;
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
