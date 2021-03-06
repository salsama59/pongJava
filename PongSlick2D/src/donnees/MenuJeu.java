package donnees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import managers.elements.GestionnaireElements;

import org.newdawn.slick.GameContainer;

import constantes.ConstantesElements;
import elementGraphique.Conteneur;
import elementGraphique.Texte;
import elementsJeu.Curseur;

public class MenuJeu 
{
	
	private Locale localeMenu;
	private String id;
	private ResourceBundle contenu;
	private Conteneur conteneur;
	private static String preffixe = "traduction.";
	
	public MenuJeu(Locale locale, String idMenu)
	{
		
		this.setId(idMenu);
		this.setLocaleMenu(locale);
		
		if(this.getLocaleMenu() == null)
		{
			this.setContenu(ResourceBundle.getBundle(preffixe + this.getId()));
		}
		else
		{
			this.setContenu(ResourceBundle.getBundle(preffixe + this.getId(), this.getLocaleMenu()));
		}
		
	}
	
	public List<String> RecupererLibellesMenu()
	{
		
		List<String> listLibelles = new ArrayList<String>();
		
		List<String> cles = Collections.list(this.getContenu().getKeys());
		Collections.sort(cles);
		
		for(String cle :  cles)
		{
			listLibelles.add(this.getContenu().getString(cle));
		}
		
		return listLibelles;
		
	}
	
	public void initialiserMenu(GameContainer gameContainer, boolean sansCurseur, String titreMenu, boolean texteVariable)
	{
		
		String nomCurseur = "";
		
		if(!sansCurseur)
		{
			
			ResourceBundle bundle = null;
			
			if(this.getLocaleMenu() == null)
			{
				bundle = ResourceBundle.getBundle(preffixe + "nomCurseurs");
			}
			else
			{
				bundle = ResourceBundle.getBundle(preffixe + "nomCurseurs", this.getLocaleMenu());
			}
			
			if(this.getId().equals("menuPrincipal_fr_FR"))
			{
				nomCurseur = bundle.getString("nom.curseur.choix.mode");
			}
			
		}
		
		List<String> libelles = this.RecupererLibellesMenu();
		
		conteneur = new Conteneur((gameContainer.getWidth()/2), (gameContainer.getHeight()/2), null);
		//X=130 - 30  Y=40
		
		for(String libelle : libelles)
		{
			
			Texte texte = new Texte(libelle, 0, 0, conteneur, gameContainer, texteVariable);
			GestionnaireElements.getInstance().ajouterElement(texte);
			conteneur.ajouterElementTextuel(texte);
			
		}
		
		if(titreMenu != null)
		{
			Texte texteTitre = new Texte(titreMenu, 0, 0, conteneur, gameContainer, texteVariable);
			GestionnaireElements.getInstance().ajouterElement(texteTitre);
			conteneur.setTitreMenu(texteTitre);
		}
		
		if(!sansCurseur)
		{
			Curseur curseur = new Curseur(nomCurseur, false, ConstantesElements.ELEMENT_CURSEUR_TYPE, conteneur.getCentreX(), conteneur.getCentreY(), null);
			conteneur.setCurseur(curseur);
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
}
