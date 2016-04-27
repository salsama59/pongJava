package managers.joueur;

import java.util.Hashtable;

import elementGraphique.Avatar;
import Joueur.Joueur;


public class GestionnaireJoueurs
{
	
	private Hashtable<Integer, Joueur> listJoueursParId;
	private Hashtable<String, Joueur> listJoueursParNom;
	private Hashtable<Integer, Avatar> listAvatarsParIdJoueur;
	
	private GestionnaireJoueurs()
	{
		setListJoueursParNom(new Hashtable<String, Joueur>());
		setListJoueursParId(new Hashtable<Integer, Joueur>());
		setListAvatarsParIdJoueur(new Hashtable<Integer, Avatar>());
	}
	
	private static class Detenteur
	{		
		/** Instance unique non préinitialisée */
		private final static GestionnaireJoueurs instance = new GestionnaireJoueurs();
	}
	
	/** Point d'accès pour l'instance unique du singleton */
	public static GestionnaireJoueurs getInstance()
	{
		return Detenteur.instance;
	}

	public Hashtable<Integer, Joueur> getListJoueursParId() {
		return listJoueursParId;
	}

	public void setListJoueursParId(Hashtable<Integer, Joueur> listJoueursParId) {
		this.listJoueursParId = listJoueursParId;
	}

	public Hashtable<String, Joueur> getListJoueursParNom() {
		return listJoueursParNom;
	}

	public void setListJoueursParNom(Hashtable<String, Joueur> listJoueursParNom) {
		this.listJoueursParNom = listJoueursParNom;
	}
	
	public Joueur recupererJoueurParId(Integer id)
	{
		return getListJoueursParId().get(id);
	}
	
	public Joueur recupererJoueurParNom(String nom)
	{
		return getListJoueursParNom().get(nom);
	}
	
	public Avatar recupererAvatarParIdJoueur(Integer idJoueurRepresente)
	{
		return getListAvatarsParIdJoueur().get(idJoueurRepresente);
	}
	
	public void ajouterJoueur(Joueur joueur)
	{
		this.getListJoueursParId().put(joueur.getId(), joueur);
		this.getListJoueursParNom().put(joueur.getNom(), joueur);
	}
	
	public void ajouterAvatar(Avatar avatar)
	{
		this.getListAvatarsParIdJoueur().put(avatar.getIdjoueurRepresente(), avatar);
	}

	public Hashtable<Integer, Avatar> getListAvatarsParIdJoueur() {
		return listAvatarsParIdJoueur;
	}

	public void setListAvatarsParIdJoueur(Hashtable<Integer, Avatar> listAvatarsParIdJoueur) {
		this.listAvatarsParIdJoueur = listAvatarsParIdJoueur;
	}
	
	

}
