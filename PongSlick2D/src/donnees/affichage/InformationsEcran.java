package donnees.affichage;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class InformationsEcran 
{
	
	private List<AffichageResolution> listResolutionsDisponible = new ArrayList<AffichageResolution>();
	private Integer indexAffichagePrefere;
	
	public InformationsEcran()
	{
		this.recupererResolutionsDisponibles();
	}
	
	public List<AffichageResolution> getListResolutionsDisponible() 
	{
		return listResolutionsDisponible;
	}

	public void setListResolutionsDisponible(List<AffichageResolution> listResolutionsDisponible) 
	{
		this.listResolutionsDisponible = listResolutionsDisponible;
	}
	
	private void recupererResolutionsDisponibles()
	{
		
		DisplayMode[] modes;
		
		try 
		{
			//Récupérer la list des résolutions d'écran possibles
			modes = Display.getAvailableDisplayModes();
			
			for (int i= 0; i <modes.length; i++) 
			{
				
	            DisplayMode modeAffichage = modes[i];
	            
	            int largeur = modeAffichage.getWidth();
	            int hauteur = modeAffichage.getHeight();
	            int nombreBits = modeAffichage.getBitsPerPixel();
	            int frequence = modeAffichage.getFrequency();
	            
	            this.getListResolutionsDisponible().add(new AffichageResolution(largeur, hauteur, nombreBits, frequence));
	            
	        }
			
		} 
		catch (LWJGLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public AffichageResolution recupererAffichagePrefere()
	{
		if(this.getIndexAffichagePrefere() != null)
		{
			return this.getListResolutionsDisponible().get(this.getIndexAffichagePrefere());
		}
		
		return null;
		
	}

	public Integer getIndexAffichagePrefere() {
		return indexAffichagePrefere;
	}

	public void setIndexAffichagePrefere(Integer indexAffichagePrefere) {
		this.indexAffichagePrefere = indexAffichagePrefere;
	}
	
}

