package menu;

import java.util.List;
import java.util.ListResourceBundle;

import donnees.affichage.AffichageResolution;
import donnees.affichage.InformationsEcran;

public class SousMenuOptions_fr_FR extends ListResourceBundle 
{
	
	private Object[][] contents;/* = {{ "texte_suivant", new String(" suivant ")},{ "Numero", new Integer(4) }};*/
	
	public SousMenuOptions_fr_FR()
	{
		this.initialiserSousMenu();
	}
	
	private void initialiserSousMenu()
	{
		
		InformationsEcran infoEcran = new InformationsEcran();
		List<AffichageResolution> listResolution = infoEcran.getListResolutionsDisponible();
		
		for(int i = 0; i < listResolution.size(); i++)
		{
			AffichageResolution resolution = listResolution.get(i);
			this.getContents()[i][0] = "sous.menu.options." + i;
			this.getContents()[i][1] = "" + resolution.getLargeurResolution() + "x" + resolution.getHauteurResolution();
		}
		
	}

	public Object[][] getContents() 
	{
		return contents;
	}

	public void setContents(Object[][] contents) {
		this.contents = contents;
	}

}
