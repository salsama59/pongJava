package constantes;

public class ConstantesElements 
{
	//Types d'�l�ments
	public final static String ELEMENT_RAQUETTE_TYPE = "RAQUETTE";
	public final static String ELEMENT_BALLE_TYPE = "BALLE";
	public final static String ELEMENT_FILET_TYPE = "FILET";
	public final static String ELEMENT_MUR_TYPE = "MUR";
	public final static String ELEMENT_CURSEUR_TYPE = "CURSEUR";
	public final static String ELEMENT_TEXTE_TYPE = "TEXTE";
	public final static String ELEMENT_CADRE_TYPE = "CADRE";
	public final static String ELEMENT_AVATAR_TYPE = "AVATAR";
	public final static String ELEMENT_MENU_TYPE = "MENU";
	public final static String ELEMENT_SOUS_MENU_TYPE = "SOUS_MENU";
	
	//Etat �l�ments
	public final static int ELEMENT_ETAT_NEUTRE = 0;
	public final static int ELEMENT_ETAT_LANCEMENT = 1;
	
	//Parametre balle
	public final static float ELEMENT_BALLE_RAYON = ConstantesJeu.ECRAN_LARGEUR * ConstantesRatios.RATIO_RAYON_BALLE;
	public final static float ELEMENT_BALLE_CENTRE_X = ConstantesJeu.ECRAN_LARGEUR * ConstantesRatios.RATIO_POSITION_X_BALLE;
	public final static float ELEMENT_BALLE_CENTRE_Y = ConstantesJeu.ECRAN_LARGEUR * ConstantesRatios.RATIO_POSITION_Y_BALLE;
	public final static float ELEMENT_BALLE_VITESSE = 0.1f;
	public final static float ELEMENT_BALLE_VITESSE_MAX = 0.6f;
	public final static float ELEMENT_BALLE_INCREMENT_VITESSE = 0.01f;
	public final static int ELEMENT_BALLE_COEF_ALEATOIRE_MAX = 3;
	public final static int ELEMENT_BALLE_COEF_ALEATOIRE_MIN = 2;
	public final static String ELEMENT_BALLE_NOM = "balle";
	
	//Parametres raquette 1
	public final static float ELEMENT_RAQUETTE1_LARGEUR = ConstantesJeu.ECRAN_LARGEUR * ConstantesRatios.RATIO_LARGEUR_RAQUETTE;
	public final static float ELEMENT_RAQUETTE1_HAUTEUR = ConstantesJeu.ECRAN_HAUTEUR * ConstantesRatios.RATIO_HAUTEUR_RAQUETTE;
	public final static float ELEMENT_RAQUETTE1_COORDONEE_X = ConstantesJeu.ECRAN_LARGEUR * ConstantesRatios.RATIO_POSITION_X_RAQUETTE1;
	public final static float ELEMENT_RAQUETTE1_COORDONEE_Y = ConstantesJeu.ECRAN_HAUTEUR * ConstantesRatios.RATIO_POSITION_Y_RAQUETTE1;
	public final static float ELEMENT_RAQUETTE1_VITESSE= 0.1f;
	public final static String ELEMENT_RAQUETTE1_NOM = "raquette1";
	public final static float ELEMENT_RAQUETTE1_VALEUR_SMASH= 0.5f;
	public final static float ELEMENT_RAQUETTE1_REDUCTION_SPIN= 0.3f;
	public final static float ELEMENT_RAQUETTE1_ZONE_LANCEMENT_X = ELEMENT_RAQUETTE1_COORDONEE_X + ELEMENT_BALLE_RAYON + ELEMENT_RAQUETTE1_LARGEUR;
	public final static float ELEMENT_RAQUETTE1_ZONE_LANCEMENT_Y = (ELEMENT_RAQUETTE1_HAUTEUR/2) + ELEMENT_RAQUETTE1_COORDONEE_Y;
	
	//Parametres raquette 2
	public final static float ELEMENT_RAQUETTE2_LARGEUR = ELEMENT_RAQUETTE1_LARGEUR;
	public final static float ELEMENT_RAQUETTE2_HAUTEUR = ELEMENT_RAQUETTE1_HAUTEUR;
	public final static float ELEMENT_RAQUETTE2_COORDONEE_X = ConstantesJeu.ECRAN_LARGEUR * ConstantesRatios.RATIO_POSITION_X_RAQUETTE2;
	public final static float ELEMENT_RAQUETTE2_COORDONEE_Y = ConstantesJeu.ECRAN_HAUTEUR * ConstantesRatios.RATIO_POSITION_Y_RAQUETTE2;
	public final static float ELEMENT_RAQUETTE2_VITESSE= 0.1f;
	public final static String ELEMENT_RAQUETTE2_NOM = "raquette2";
	public final static float ELEMENT_RAQUETTE2_VALEUR_SMASH= 0.5f;
	public final static float ELEMENT_RAQUETTE2_REDUCTION_SPIN= 0.3f;
	public final static float ELEMENT_RAQUETTE2_ZONE_LANCEMENT_X = ELEMENT_RAQUETTE2_COORDONEE_X - ELEMENT_BALLE_RAYON;
	public final static float ELEMENT_RAQUETTE2_ZONE_LANCEMENT_Y = (ELEMENT_RAQUETTE2_HAUTEUR/2) + ELEMENT_RAQUETTE2_COORDONEE_Y;
	
	//Sens pour tous les elements de jeu
	public final static int ELEMENT_SENS_NEUTRE =0;
	public final static int ELEMENT_SENS_HAUT =1;
	public final static int ELEMENT_SENS_HAUT_DROITE =2;
	public final static int ELEMENT_SENS_DROITE =3;
	public final static int ELEMENT_SENS_BAS_DROITE =4;
	public final static int ELEMENT_SENS_BAS =5;
	public final static int ELEMENT_SENS_BAS_GAUCHE =6;
	public final static int ELEMENT_SENS_GAUCHE =7;
	public final static int ELEMENT_SENS_HAUT_GAUCHE =8;
	
	//Parametre filet gauche
	public final static float ELEMENT_FILET1_LARGEUR = (ConstantesJeu.ECRAN_LARGEUR * 5)/100;
	public final static float ELEMENT_FILET1_HAUTEUR = ConstantesJeu.ECRAN_HAUTEUR;
	public final static float ELEMENT_FILET1_COORDONEE_X = 0;
	public final static float ELEMENT_FILET1_COORDONEE_Y= 0;
	public final static String ELEMENT_FILET1_NOM = "filet1";
	
	//Parametre filet droit
	public final static float ELEMENT_FILET2_LARGEUR = ELEMENT_FILET1_LARGEUR;
	public final static float ELEMENT_FILET2_HAUTEUR = ConstantesJeu.ECRAN_HAUTEUR;
	public final static float ELEMENT_FILET2_COORDONEE_X = ConstantesJeu.ECRAN_LARGEUR - ELEMENT_FILET1_LARGEUR;
	public final static float ELEMENT_FILET2_COORDONEE_Y= 0;
	public final static String ELEMENT_FILET2_NOM = "filet2";
	
	
	//Parametres Mur1
	public final static float ELEMENT_MUR1_LARGEUR = (ConstantesJeu.ECRAN_LARGEUR * 90)/100;
	public final static float ELEMENT_MUR1_HAUTEUR = (ConstantesJeu.ECRAN_HAUTEUR * 5)/100;
	public final static float ELEMENT_MUR1_COORDONEE_X = ELEMENT_FILET1_LARGEUR;
	public final static float ELEMENT_MUR1_COORDONEE_Y = 0;
	public final static String ELEMENT_MUR1_NOM = "mur1";
	
	//parametre Mur2
	public final static float ELEMENT_MUR2_LARGEUR = ELEMENT_MUR1_LARGEUR;
	public final static float ELEMENT_MUR2_HAUTEUR = ELEMENT_MUR1_HAUTEUR;
	public final static float ELEMENT_MUR2_COORDONEE_X = ELEMENT_MUR1_COORDONEE_X;
	public final static float ELEMENT_MUR2_COORDONEE_Y = ConstantesJeu.ECRAN_HAUTEUR - ELEMENT_MUR1_HAUTEUR;
	public final static String ELEMENT_MUR2_NOM = "mur2";
	
	//Parametre curseur
	public final static float ELEMENT_CURSEUR_LARGEUR = (ConstantesJeu.ECRAN_LARGEUR * 1.4648f)/100;
	public final static float ELEMENT_CURSEUR_HAUTEUR = (ConstantesJeu.ECRAN_HAUTEUR * 2.4193f)/100;
	//public final static float ELEMENT_CURSEUR_CENTRE_X = ConstantesJeu.ECRAN_LARGEUR * ConstantesRatios.RATIO_POSITION_X_CURSEUR;
	//public final static float ELEMENT_CURSEUR_CENTRE_Y = ConstantesJeu.ECRAN_HAUTEUR * ConstantesRatios.RATIO_POSITION_Y_CURSEUR;
	public final static float ELEMENT_CURSEUR_VITESSE = 0.2f;
	public final static String ELEMENT_CURSEUR_NOM_MISE_EN_JEU = "curseur mise en jeu";
	public final static String ELEMENT_CURSEUR_NOM_CHOIX_MODE = "curseur choix mode";
	public final static String ELEMENT_CURSEUR_NOM_OPTIONS = "curseur options";
	
	
}
