package mecanismes.implementations;

import mecanismes.interfaces.LogicDeplacementsEtatsElementsJeu;

import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;

import constantes.ConstantesElements;
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
			
		if(this.getElement().isEnCollision())
		{
			this.accelererBalle();
		}
		
		if(element.isEnDeplacement())
		{
			
			float angle = (float) new Vector2f(element.getCentreX(), element.getCentreY()).getTheta();
			
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
			
				Vector2f test = calculTrajectoire(angle, element.getVitesse(), element.getCentreX(), element.getCentreY() * -1, delta);
				element.setCentreX(test.x);
				element.setCentreY(test.y);
				
			}
			
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_HAUT_GAUCHE)
			{
				
				Vector2f test = calculTrajectoire(angle, element.getVitesse(), element.getCentreX() * -1, element.getCentreY() * -1, delta);
				element.setCentreX(test.x);
				element.setCentreY(test.y);
				
			}
			
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS_DROITE)
			{
				
				Vector2f test = calculTrajectoire(angle, element.getVitesse(), element.getCentreX(), element.getCentreY(), delta);
				element.setCentreX(test.x);
				element.setCentreY(test.y);
				
			}
			
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS_GAUCHE)
			{
				
				Vector2f test = calculTrajectoire(angle, element.getVitesse(), element.getCentreX() * -1, element.getCentreY(), delta);
				element.setCentreX(test.x);
				element.setCentreY(test.y);
				
			}
			
		}
	}

	@Override
	public void gererEtats(int key, char c) 
	{
		
		element.setEnDeplacement(true);
		
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

	public Balle getElement() 
	{
		return element;
	}

	public void setElement(Balle element) 
	{
		this.element = element;
	}
	
	private void accelererBalle()
	{
		Balle element = this.getElement();
		
		if(element.getVitesse() < ConstantesElements.ELEMENT_BALLE_VITESSE_MAX)
		{
			element.setVitesse(element.getVitesse() + 0.01f);
		}
		
	}
	
	public Vector2f calculTrajectoire(float angle, float vitesse, float x, float y, float delta)
	{
		
		/*attention l'angle renvoyé par l'élément circle de slick2d est en degrée 
		 * et ne tient pas compte du repère de l'écran,
		 *  pour obtenir l'angle par rapport à l'écran faire 180 - angleSlick*/
		
		//x2 = x1 + cos(direction) * vitesse
		//y2 = x2 + sin(direction) * vitesse
		
		//180 ° = π radians ;
		//donc 1 ° = π / 180 radians.
		
		// direction (radiant) = (π / 180) * direction (degré)
		
		return new Vector2f((float) (x + Math.cos(convertionDegreRadiant(angle)) * vitesse * delta), (float) (y + Math.sin(convertionDegreRadiant(angle)) * vitesse * delta));
		
	}
	
	private float convertionDegreRadiant(float angle)
	{
		return (float) ((Math.PI/180) * angle);
	}
	
}
