package constantes;

public class ConstantesElements 
{
	
	//Parametres raquette 1
	public final static float ELEMENT_RAQUETTE1_LARGEUR = 30;
	public final static float ELEMENT_RAQUETTE1_HAUTEUR = 80;
	public final static float ELEMENT_RAQUETTE1_COORDONEE_X = 200;
	public final static float ELEMENT_RAQUETTE1_COORDONEE_Y= 200;
	public final static float ELEMENT_RAQUETTE1_VITESSE= 0.1f;
	public final static String ELEMENT_RAQUETTE1_NOM = "raquette1";
	
	//Parametres raquette 2
	public final static float ELEMENT_RAQUETTE2_LARGEUR = 30;
	public final static float ELEMENT_RAQUETTE2_HAUTEUR = 80;
	public final static float ELEMENT_RAQUETTE2_COORDONEE_X = 800;
	public final static float ELEMENT_RAQUETTE2_COORDONEE_Y= 400;
	public final static float ELEMENT_RAQUETTE2_VITESSE= 0.1f;
	public final static String ELEMENT_RAQUETTE2_NOM = "raquette2";
	
	//Directions pour tout elements de jeu
	public final static int ELEMENT_DIRECTION_NEUTRE =0;
	public final static int ELEMENT_DIRECTION_HAUT =1;
	public final static int ELEMENT_DIRECTION_HAUT_DROITE =2;
	public final static int ELEMENT_DIRECTION_DROITE =3;
	public final static int ELEMENT_DIRECTION_BAS_DROITE =4;
	public final static int ELEMENT_DIRECTION_BAS =5;
	public final static int ELEMENT_DIRECTION_BAS_GAUCHE =6;
	public final static int ELEMENT_DIRECTION_GAUCHE =7;
	public final static int ELEMENT_DIRECTION_HAUT_GAUCHE =8;
	
	//Parametre balle
	public final static float ELEMENT_BALLE_RAYON = 15;
	public final static float ELEMENT_BALLE_CENTRE_X = 650;
	public final static float ELEMENT_BALLE_CENTRE_Y= 200;
	public final static float ELEMENT_BALLE_VITESSE= 0.1f;
	public final static int ELEMENT_BALLE_COEF_ALEATOIRE_MAX= 2;
	public final static int ELEMENT_BALLE_COEF_ALEATOIRE_MIN= 1;
	public final static String ELEMENT_BALLE_NOM = "balle";
	
	//Parametres Mur1
	//TODO metre largeur fillet dans les calcul de dimmention
	public final static float ELEMENT_MUR1_LARGEUR = ContantesJeu.ECRAN_LARGEUR - 100;
	public final static float ELEMENT_MUR1_HAUTEUR = 30;
	public final static float ELEMENT_MUR1_COORDONEE_X = 50;
	public final static float ELEMENT_MUR1_COORDONEE_Y= 0;
	public final static String ELEMENT_MUR1_NOM = "mur1";
	
	//parametre Mur2
	//TODO metre largeur fillet dans les calcul de dimmention
	public final static float ELEMENT_MUR2_LARGEUR = ContantesJeu.ECRAN_LARGEUR - 100;
	public final static float ELEMENT_MUR2_HAUTEUR = 30;
	public final static float ELEMENT_MUR2_COORDONEE_X = 50;
	public final static float ELEMENT_MUR2_COORDONEE_Y = ContantesJeu.ECRAN_HAUTEUR - 30;
	public final static String ELEMENT_MUR2_NOM = "mur2";
	
	
}
