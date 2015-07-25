package mecanismes.implementations;

import mecanismes.interfaces.LogicDeplacementsEtatsElementsJeu;

import org.newdawn.slick.Input;

import constantes.ConstantesElements;
import elementsJeu.Raquette;

public class LogicDeplacementsEtatsElementsJeuRaquetteImpl implements LogicDeplacementsEtatsElementsJeu
{
	
	private Raquette element = null;
	
	public LogicDeplacementsEtatsElementsJeuRaquetteImpl(Raquette raquette)
	{
		this.setElement(raquette);
	}
	
	@Override
	public void gererDeplacements(int delta) 
	{
		if(element.isEnDeplacement())
		{
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_HAUT)
			{
				element.setCoordonneeY(element.getCoordonneeY() - (element.getVitesse() * delta));
			}
			
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS)
			{
				element.setCoordonneeY(element.getCoordonneeY() + (element.getVitesse() * delta));
			}
			
		}
	}

	@Override
	public void gererEtats(int key, char c) 
	{
		switch (key) 
	    {
	        case Input.KEY_UP:
	        element.setEnDeplacement(true);
	        element.setDirection(ConstantesElements.ELEMENT_DIRECTION_HAUT);
	        break;
	        
	        case Input.KEY_LEFT:
	        //raquette1.setCoordonneeX(raquette1.getCoordonneeX()-1);
	        break;
	        
	        case Input.KEY_DOWN:
	        element.setEnDeplacement(true);
	        element.setDirection(ConstantesElements.ELEMENT_DIRECTION_BAS);
	        break;
	        
	        case Input.KEY_RIGHT:
	        //raquette1.setCoordonneeX(raquette1.getCoordonneeX()+1);
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
	        element.setDirection(ConstantesElements.ELEMENT_DIRECTION_NEUTRE);
	        break;
	        
	        case Input.KEY_LEFT:
	        //element1.setCoordonneeX(element1.getCoordonneeX()-1);
	        break;
	        
	        case Input.KEY_DOWN:
	        element.setEnDeplacement(false);
		    element.setDirection(ConstantesElements.ELEMENT_DIRECTION_NEUTRE);
	        break;
	        
	        case Input.KEY_RIGHT:
	        //element1.setCoordonneeX(element1.getCoordonneeX()+1);
	        break;
	    }
		
	}

	public Raquette getElement() {
		return element;
	}

	public void setElement(Raquette element) {
		this.element = element;
	}

}
