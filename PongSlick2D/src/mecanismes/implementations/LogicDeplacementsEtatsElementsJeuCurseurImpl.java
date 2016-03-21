package mecanismes.implementations;

import org.newdawn.slick.Input;

import mecanismes.interfaces.LogicDeplacementsEtatsElementsJeu;
import constantes.ConstantesElements;
import elementsJeu.Curseur;

public class LogicDeplacementsEtatsElementsJeuCurseurImpl implements LogicDeplacementsEtatsElementsJeu 
{
	
	private Curseur element = null;
	
	private boolean bloqueDeplacement = false;
	
	public LogicDeplacementsEtatsElementsJeuCurseurImpl(Curseur curseur)
	{
		this.setElement(curseur);
	}

	@Override
	public void gererDeplacements(int delta) 
	{
		if(element.isEnDeplacement())
		{
			
			if(!this.isBloqueDeplacement())
			{
				element.deplacerCuseur(element.getSens());
			}
			
			this.setBloqueDeplacement(true);
			
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
	        this.setBloqueDeplacement(true);
	        break;
	        
	        case Input.KEY_DOWN:
	        element.setEnDeplacement(true);
	        element.setSens(ConstantesElements.ELEMENT_SENS_BAS);
	        break;
	        
	        case Input.KEY_RIGHT:
        	element.setEnDeplacement(true);
	        element.setSens(ConstantesElements.ELEMENT_SENS_DROITE);
	        this.setBloqueDeplacement(true);
	        break;
	        
	    }

	}

	@Override
	public void reinitialisationEtat(int key, char c) 
	{
		
		Input entree = new Input(key);
		
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
		
		this.setBloqueDeplacement(false);
		
	}

	public Curseur getElement() {
		return element;
	}

	public void setElement(Curseur element) {
		this.element = element;
	}

	public boolean isBloqueDeplacement() {
		return bloqueDeplacement;
	}

	public void setBloqueDeplacement(boolean bloqueDeplacement) {
		this.bloqueDeplacement = bloqueDeplacement;
	}

}
