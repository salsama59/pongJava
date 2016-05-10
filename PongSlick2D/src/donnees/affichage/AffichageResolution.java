package donnees.affichage;

public class AffichageResolution 
{
	
	private int largeurResolution;
	private int hauteurResolution;
	private int nombreBitsPixel;
	private int frequenceAffichage;
	
	public AffichageResolution(int largeur, int hauteur, int nombreBitsParPixel, int fréquence)
	{
		
		this.setFrequenceAffichage(fréquence);
		this.setHauteurResolution(hauteur);
		this.setLargeurResolution(largeur);
		this.setNombreBitsPixel(nombreBitsParPixel);
		
	}
	
	public int getLargeurResolution() 
	{
		return largeurResolution;
	}
	
	public void setLargeurResolution(int largeurResolution) 
	{
		this.largeurResolution = largeurResolution;
	}
	
	public int getHauteurResolution() 
	{
		return hauteurResolution;
	}
	
	public void setHauteurResolution(int hauteurResolution) 
	{
		this.hauteurResolution = hauteurResolution;
	}
	
	public int getNombreBitsPixel() 
	{
		return nombreBitsPixel;
	}
	
	public void setNombreBitsPixel(int nombreBitsPixel) 
	{
		this.nombreBitsPixel = nombreBitsPixel;
	}
	
	public int getFrequenceAffichage() 
	{
		return frequenceAffichage;
	}
	
	public void setFrequenceAffichage(int frequenceAffichage) 
	{
		this.frequenceAffichage = frequenceAffichage;
	}

}
