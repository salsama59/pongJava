package donnees.generale;

import org.newdawn.slick.Color;

import donnees.affichage.InformationsEcran;

public class Options 
{
	
	private Color couleurFond = null;
	private Color CouleurLigne = null;
	private Boolean sonActive = false;
	private float volumeMusiques = 0f;
	private float volumeBruitages = 0f;
	private InformationsEcran informationAffichage = null;
	

	public Color getCouleurFond() 
	{
		return couleurFond;
	}

	public void setCouleurFond(Color couleurFond) 
	{
		this.couleurFond = couleurFond;
	}

	public Color getCouleurLigne() 
	{
		return CouleurLigne;
	}

	public void setCouleurLigne(Color couleurLigne) 
	{
		CouleurLigne = couleurLigne;
	}

	public Boolean getSonActive() {
		return sonActive;
	}

	public void setSonActive(Boolean musiqueActivee) {
		this.sonActive = musiqueActivee;
	}

	public InformationsEcran getInformationAffichage() {
		return informationAffichage;
	}

	public void setInformationAffichage(InformationsEcran informationAffichage) {
		this.informationAffichage = informationAffichage;
	}

	public float getVolumeMusiques() {
		return volumeMusiques;
	}

	public void setVolumeMusiques(float volumeMusiques) {
		this.volumeMusiques = volumeMusiques;
	}

	public float getVolumeBruitages() {
		return volumeBruitages;
	}

	public void setVolumeBruitages(float volumeBruitages) {
		this.volumeBruitages = volumeBruitages;
	}
	

}
