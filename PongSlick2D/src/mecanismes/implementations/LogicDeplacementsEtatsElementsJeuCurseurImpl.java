package mecanismes.implementations;

import org.newdawn.slick.Input;

import mecanismes.interfaces.LogicDeplacementsEtatsElementsJeu;
import constantes.ConstantesElements;
import elementsJeu.Curseur;

public class LogicDeplacementsEtatsElementsJeuCurseurImpl implements LogicDeplacementsEtatsElementsJeu 
{
	
	private Curseur element = null;
	
	public LogicDeplacementsEtatsElementsJeuCurseurImpl(Curseur curseur)
	{
		this.setElement(curseur);
	}

	@Override
	public void gererDeplacements(int delta) 
	{
		if(element.isEnDeplacement())
		{
			
			element.deplacerCuseur(element.getSens());
			
			
			/*if(element.getSens() == ConstantesElements.ELEMENT_SENS_HAUT)
			{
				element.deplacerCuseur(ConstantesElements.ELEMENT_SENS_HAUT);
				//element.setCoordonneeY(element.getCoordonneeY() - (element.getVitesse() * delta));
			}
			
			if(element.getSens() == ConstantesElements.ELEMENT_SENS_BAS)
			{
				//element.setCoordonneeY(element.getCoordonneeY() + (element.getVitesse() * delta));
				element.deplacerCuseur(ConstantesElements.ELEMENT_SENS_BAS);
			}
			
			if(element.getSens() == ConstantesElements.ELEMENT_SENS_DROITE)
			{
				//element.setCoordonneeX(element.getCoordonneeX() + (element.getVitesse() * delta));
			}
			
			if(element.getSens() == ConstantesElements.ELEMENT_SENS_GAUCHE)
			{
				//element.setCoordonneeX(element.getCoordonneeX() - (element.getVitesse() * delta));
			}
			*/
			
		}

	}

	@Override
	public void gererEtats(int key, char c) 
	{	
		Input entree = new Input(key);
		
		switch (key) 
	    {
		 	case Input.KEY_UP:
	        element.setEnDeplacement(true);
	        element.setSens(ConstantesElements.ELEMENT_SENS_HAUT);
	        break;
	        
	        case Input.KEY_LEFT:
        	element.setEnDeplacement(true);
	        element.setSens(ConstantesElements.ELEMENT_SENS_GAUCHE);
	        break;
	        
	        case Input.KEY_DOWN:
	        element.setEnDeplacement(true);
	        element.setSens(ConstantesElements.ELEMENT_SENS_BAS);
	        break;
	        
	        case Input.KEY_RIGHT:
        	element.setEnDeplacement(true);
	        element.setSens(ConstantesElements.ELEMENT_SENS_DROITE);
	        break;
	        
	    }

	}

	@Override
	public void reinitialisationEtat(int key, char c) 
	{
		switch (key) 
	    {
	        case Input.KEY_UP:
	        element.setEnDeplacement(false);
	        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
	        break;
	        
	        case Input.KEY_LEFT:
        	element.setEnDeplacement(false);
	        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
	        break;
	        
	        case Input.KEY_DOWN:
	        element.setEnDeplacement(false);
		    element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
	        break;
	        
	        case Input.KEY_RIGHT:
        	element.setEnDeplacement(false);
	        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
	        break;
	    }

	}

	public Curseur getElement() {
		return element;
	}

	public void setElement(Curseur element) {
		this.element = element;
	}

}
