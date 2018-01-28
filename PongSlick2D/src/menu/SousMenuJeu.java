package menu;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import managers.elements.GestionnaireElements;

import org.newdawn.slick.GameContainer;

import constantes.ConstantesElements;
import constantes.ConstantesJeu;
import donnees.affichage.AffichageResolution;
import donnees.affichage.InformationsEcran;
import elementGraphique.Conteneur;
import elementGraphique.Texte;

public class SousMenuJeu extends MenuJeu
{
	
	private Locale localeMenu;
	private String id;
	private ResourceBundle contenu;
	private Conteneur conteneur;
	private List<String> libellesSousMenu;
	private MenuJeu MenuAssocie = null; 
	
	public SousMenuJeu(Locale locale, String idMenu, MenuJeu menuParent)
	{
		
		super(locale, idMenu, ConstantesElements.ELEMENT_SOUS_MENU_TYPE);
		this.setMenuAssocie(menuParent);
		libellesSousMenu = new ArrayList<String>();
		
	}
	
	public void initialiserSousMenu(GameContainer gameContainer, boolean sansCurseur, String titreMenu, boolean texteVariable, String type)
	{
		
		if(this.getId() != null)
		{
			this.initialiserMenu(gameContainer, sansCurseur, titreMenu, texteVariable);
		}
		else
		{
			
			if(type.equals("SousMenuOptions1"))
			{
				
				conteneur = new Conteneur((gameContainer.getWidth()/2), (gameContainer.getHeight()/2), null);
				//X=130 - 30  Y=40
				
				InformationsEcran infoEcran = new InformationsEcran();
				List<AffichageResolution> listResolution = infoEcran.getListResolutionsDisponible();
				
				//System.out.println(listResolution);
				
				for(int i = 0; i < listResolution.size(); i++)
				{
					
					AffichageResolution resolution = listResolution.get(i);
					
					int hauteur = resolution.getHauteurResolution();
					int largeur = resolution.getLargeurResolution();
					
					if((hauteur >= ConstantesJeu.ECRAN_HAUTEUR_MIN) && (largeur >= ConstantesJeu.ECRAN_LARGEUR_MIN))
					{
						String valeurAffichee =  "" + resolution.getLargeurResolution() + "x" + resolution.getHauteurResolution();
						Texte texte = new Texte(valeurAffichee, 0, 0, conteneur, gameContainer, texteVariable);
						GestionnaireElements.getInstance().ajouterElement(texte);
						conteneur.ajouterElementTextuel(texte);
						this.libellesSousMenu.add(valeurAffichee);
						
						//System.out.println(valeurAffichee + " F = " + resolution.getFrequenceAffichage());
					}
					
					
				}
				
				conteneur.calculerTailleZone();
				
				conteneur.setCentreX(this.getMenuAssocie().getConteneur().getCentreX() + this.getConteneur().getLargeur() + this.getConteneur().getLargeur()/2);
				
				conteneur.ajusterPositionTextes();
				
			}
			
		}
		
	}
	
	public String recupererLibelle(int index)
	{
		return this.RecupererLibellesMenu().get(index);
	}
	
	public List<String> RecupererLibellesMenu()
	{
		return this.libellesSousMenu;
	}
	
	public void genererSousMenu()
	{
		
		Properties configuration = new Properties();
		OutputStream fichierDeSortie = null;
		
		try 
		{
			fichierDeSortie = new FileOutputStream("source/config.properties");
			
			// set the properties value
			configuration.setProperty("db.database", "localhost");
			configuration.setProperty("db.buser", "rafik");
			configuration.setProperty("db.password", "boug");
			
			// save properties to project root folder
			configuration.store(fichierDeSortie, null);
			
		}
		catch (final IOException io) 
		{
			io.printStackTrace();
		}
		finally 
		{
			if (fichierDeSortie != null) 
			{
				try 
				{
					
					fichierDeSortie.close();
					
				} 
				catch (final IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
		
	}

	public Locale getLocaleMenu() {
		return localeMenu;
	}

	public void setLocaleMenu(Locale localeMenu) {
		this.localeMenu = localeMenu;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ResourceBundle getContenu() {
		return contenu;
	}

	public void setContenu(ResourceBundle contenu) {
		this.contenu = contenu;
	}

	public Conteneur getConteneur() {
		return conteneur;
	}

	public void setConteneur(Conteneur conteneur) {
		this.conteneur = conteneur;
	}

	public MenuJeu getMenuAssocie() {
		return MenuAssocie;
	}

	public void setMenuAssocie(MenuJeu menuAssocie) {
		MenuAssocie = menuAssocie;
	}
}
