package menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import managers.elements.GestionnaireElements;

import org.newdawn.slick.GameContainer;

import constantes.ConstantesElements;
import constantes.ConstantesJeu;
import donnees.affichage.AffichageResolution;
import donnees.affichage.InformationsEcran;
import elementGraphique.Conteneur;
import elementGraphique.Texte;
import elementsJeu.Curseur;

public class MenuJeu 
{
	
	private Locale localeMenu;
	private String id;
	private ResourceBundle contenu;
	private Conteneur conteneur;
	private String type;
	private static String preffixeMenu = "traductions.";
	private static String preffixeSousMenu = "menu.";
	
	public MenuJeu(Locale locale, String idMenu, String typeMenu)
	{
		
		this.setId(idMenu);
		this.setLocaleMenu(locale);
		this.setType(typeMenu);
		
		if(this.getLocaleMenu() == null)
		{
			
			if(this.isSousMenu())
			{
				
				if(this.getId() != null)
				{
					this.setContenu(ResourceBundle.getBundle(preffixeSousMenu + this.getId()));
				}
				
			}
			else
			{
				this.setContenu(ResourceBundle.getBundle(preffixeMenu + this.getId()));
			}
			
		}
		else
		{
			
			if(this.isSousMenu())
			{
				
				if(this.getId() != null)
				{
					this.setContenu(ResourceBundle.getBundle(preffixeSousMenu + this.getId(), this.getLocaleMenu()));
				}
				
			}
			else
			{
				this.setContenu(ResourceBundle.getBundle(preffixeMenu + this.getId(), this.getLocaleMenu()));
			}
			
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
	
	public String recupererLibelle(String cle)
	{
		return this.getContenu().getString(cle);
	}
	
	public void initialiserMenu(GameContainer gameContainer, boolean sansCurseur, String titreMenu, boolean texteVariable)
	{
		
		String nomCurseur = "";
		
		if(!sansCurseur)
		{
			
			ResourceBundle bundle = null;
			
			if(this.getLocaleMenu() == null)
			{
				bundle = ResourceBundle.getBundle(preffixeMenu + "nomCurseurs");
			}
			else
			{
				bundle = ResourceBundle.getBundle(preffixeMenu + "nomCurseurs", this.getLocaleMenu());
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
			
			texte = miseAjourFils(texte, gameContainer, texteVariable);
			
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
	
	Texte miseAjourFils(Texte pere, GameContainer gameContainer, boolean texteVariable)
	{
		
		if(this.getId().equals("menuOptions_fr_FR"))
		{
			
			if(pere.getMessage().equals("Affichage/Resolution"))
			{
				
				InformationsEcran infoEcran = new InformationsEcran();
				List<AffichageResolution> listResolution = infoEcran.getListResolutionsDisponible();
				
				for(int i = 0; i < listResolution.size(); i++)
				{
					
					AffichageResolution resolution = listResolution.get(i);
					
					int hauteur = resolution.getHauteurResolution();
					int largeur = resolution.getLargeurResolution();
					
					if((hauteur >= ConstantesJeu.ECRAN_HAUTEUR_MIN) && (largeur >= ConstantesJeu.ECRAN_LARGEUR_MIN))
					{
						
						String valeurAffichee =  "" + resolution.getLargeurResolution() + "x" + resolution.getHauteurResolution();
						Texte texteFils = new Texte(valeurAffichee, 0, 0, conteneur, gameContainer, texteVariable);
						pere.setFils(texteFils);
						GestionnaireElements.getInstance().ajouterElement(texteFils);
						
						break;
						
					}
					
				}
				
			}
			
		}
		
		return pere;
		
	}
	
	public boolean isSousMenu()
	{
		return this.getType().equals(ConstantesElements.ELEMENT_SOUS_MENU_TYPE);
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
