package mecanismes.implementations;

import org.newdawn.slick.Input;

import constantes.ConstantesElements;
import mecanismes.interfaces.LogicDeplacementsEtatsElementsJeu;
import elementsJeu.Balle;

public class LogicDeplacementsEtatsElementsJeuBalleImpl implements LogicDeplacementsEtatsElementsJeu 
{
	
	private Balle element = null;
	
	public LogicDeplacementsEtatsElementsJeuBalleImpl(Balle balle)
	{
		this.setElement(balle);
	}

	@Override
	public void gererDeplacements(int delta)
	{
		
		if(element.isEnDeplacement())
		{
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_HAUT)
			{
				element.setCentreY(element.getCentreY() - (element.getVitesse() * delta));
			}
			
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS)
			{
				element.setCentreY(element.getCentreY() + (element.getVitesse() * delta));
			}
			
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_GAUCHE)
			{
				element.setCentreX(element.getCentreX() - (element.getVitesse() * delta));
			}
			
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_DROITE)
			{
				element.setCentreX(element.getCentreX() + (element.getVitesse() * delta));
			}
			
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_HAUT_DROITE)
			{
				element.setCentreX(element.getCentreX() + (element.getVitesse() * delta));
				element.setCentreY(element.getCentreY() - (element.getVitesse() * delta));
			}
			
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_HAUT_GAUCHE)
			{
				element.setCentreX(element.getCentreX() - (element.getVitesse() * delta));
				element.setCentreY(element.getCentreY() - (element.getVitesse() * delta));
			}
			
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS_DROITE)
			{
				element.setCentreX(element.getCentreX() + (element.getVitesse() * delta));
				element.setCentreY(element.getCentreY() + (element.getVitesse() * delta));
			}
			
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS_GAUCHE)
			{
				element.setCentreX(element.getCentreX() - (element.getVitesse() * delta));
				element.setCentreY(element.getCentreY() + (element.getVitesse() * delta));
			}
			
		}
	}

	@Override
	public void gererEtats(int key, char c) 
	{
		
		element.setEnDeplacement(true);
	    //element.setDirection(ConstantesElements.ELEMENT_DIRECTION_GAUCHE);
		
		switch (key) 
	    {
	        case Input.KEY_UP:
	        break;
	        
	        case Input.KEY_LEFT:
	        break;
	        
	        case Input.KEY_DOWN:
	        break;
	        
	        case Input.KEY_RIGHT:
		    break;
	    }
		
	}

	@Override
	public void reinitialisationEtat(int key, char c) 
	{
	}

	public Balle getElement() {
		return element;
	}

	public void setElement(Balle element) {
		this.element = element;
	}
	
}
