package managers.etat;

import java.util.LinkedHashMap;
import java.util.List;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import donnees.generale.Options;

public class GestionnaireOptions 
{
	private static LinkedHashMap<Integer, String> options;
	private static LinkedHashMap<Integer, String> sousOptions1;
	private static String selectionMenu;
	private static int indexSelectionMenu;
	
	private static String selectionSousMenu;
	private static int indexSelectionSousMenu;
	
	private Graphics graphisme;
	
	public static final String OPTION1 = "Affichage/Resolution";
	public static final String OPTION2 = "Volume musique";
	public static final String OPTION3 = "Volume bruitage";
	public static final String OPTION4 = "Retour";
	//public static final String OPTION5 = "Retour";
	
	private StateBasedGame jeu;
	
	private Integer idEtatPrecedent;
	
	private Options donneesOption;
	
	private GestionnaireOptions()
	{
		
		setSelectionMenu(OPTION1);
		setSelectionSousMenu(null);
		options = new LinkedHashMap<Integer, String>();
		sousOptions1 = new LinkedHashMap<Integer, String>();
		
		this.setDonneesOption(new Options());
		
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
	
	
	public void initialiserListOptions(List<String> libelles)
	{
		for(int i = 0; i < libelles.size(); i++)
		{
			options.put(i, libelles.get(i));
		}
	}
	
	public void initialiserListSousOptions1(List<String> libelles)
	{
		for(int i = 0; i < libelles.size(); i++)
		{
			sousOptions1.put(i, libelles.get(i));
		}
	}
	
	public void selectionnerOption(Integer choix)
	{
		setSelectionMenu(getOptions().get(choix));
		setIndexSelectionMenu(choix);
	}
	
	public void selectionnerSousOption(Integer choix)
	{
		setSelectionSousMenu(getSousOptions1().get(choix));
	}

	public String getSelectionMenu() 
	{
		return selectionMenu;
	}


	public static void setSelectionMenu(String selection) 
	{
		GestionnaireOptions.selectionMenu = selection;
	}


	public static String getSelectionSousMenu() {
		return selectionSousMenu;
	}


	public static void setSelectionSousMenu(String selectionSousMenu) {
		GestionnaireOptions.selectionSousMenu = selectionSousMenu;
	}


	public static int getIndexSelectionMenu() {
		return indexSelectionMenu;
	}


	public static void setIndexSelectionMenu(int indexSelectionMenu) {
		GestionnaireOptions.indexSelectionMenu = indexSelectionMenu;
	}


	public static int getIndexSelectionSousMenu() {
		return indexSelectionSousMenu;
	}


	public static void setIndexSelectionSousMenu(int indexSelectionSousMenu) {
		GestionnaireOptions.indexSelectionSousMenu = indexSelectionSousMenu;
	}


	public static LinkedHashMap<Integer,String> getOptions() 
	{
		return options;
	}


	public static void setOptions(LinkedHashMap<Integer, String> listOptions) 
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


	public static LinkedHashMap<Integer, String> getSousOptions1() {
		return sousOptions1;
	}


	public static void setSousOptions1(LinkedHashMap<Integer, String> sousOptions1) {
		GestionnaireOptions.sousOptions1 = sousOptions1;
	}
}
