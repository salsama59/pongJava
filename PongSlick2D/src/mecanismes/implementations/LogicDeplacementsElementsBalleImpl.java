package mecanismes.implementations;

import mecanismes.interfaces.LogicDeplacementsElements;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;

import constantes.ConstantesElements;
import elementsJeu.Balle;

public class LogicDeplacementsElementsBalleImpl implements LogicDeplacementsElements 
{
	
	private Balle element = null;
	
	public LogicDeplacementsElementsBalleImpl(Balle balle)
	{
		this.setElement(balle);
	}

	@Override
	public void gererDeplacements(int delta, String phase, GameContainer gameContainer)
	{
		
		Vector2f trajectoire;
			
		if(this.getElement().isEnCollision())
		{
			this.accelererBalle();
		}
		
		if(element.isEnDeplacement())
		{
			
			float angle = element.getDirection();
			
			if(element.getSens() == ConstantesElements.ELEMENT_SENS_HAUT)
			{
				element.setCentreY(element.getCentreY() - (element.getVitesse() * delta));
			}
			
			if(element.getSens() == ConstantesElements.ELEMENT_SENS_BAS)
			{
				element.setCentreY(element.getCentreY() + (element.getVitesse() * delta));
			}
			
			if(element.getSens() == ConstantesElements.ELEMENT_SENS_GAUCHE)
			{
				element.setCentreX(element.getCentreX() - (element.getVitesse() * delta));
			}
			
			if(element.getSens() == ConstantesElements.ELEMENT_SENS_DROITE)
			{
				element.setCentreX(element.getCentreX() + (element.getVitesse() * delta));
			}
			
			if(element.getSens() == ConstantesElements.ELEMENT_SENS_HAUT_DROITE)
			{
				
				trajectoire = calculTrajectoire(angle, element.getVitesse(), element.getCentreX(), element.getCentreY(), delta);
				element.setCentreX(trajectoire.x);
				element.setCentreY(trajectoire.y);
				
			}
			
			if(element.getSens() == ConstantesElements.ELEMENT_SENS_HAUT_GAUCHE)
			{
				
				trajectoire = calculTrajectoire(angle, element.getVitesse(), element.getCentreX() * -1, element.getCentreY(), delta);
				element.setCentreX(trajectoire.x);
				element.setCentreY(trajectoire.y);
				
			}
			
			if(element.getSens() == ConstantesElements.ELEMENT_SENS_BAS_DROITE)
			{
				
				trajectoire = calculTrajectoire(angle, element.getVitesse(), element.getCentreX(), element.getCentreY() * -1, delta);
				element.setCentreX(trajectoire.x);
				element.setCentreY(trajectoire.y);
				
			}
			
			if(element.getSens() == ConstantesElements.ELEMENT_SENS_BAS_GAUCHE)
			{
				
				trajectoire = calculTrajectoire(angle, element.getVitesse(), element.getCentreX() * -1, element.getCentreY() * -1, delta);
				element.setCentreX(trajectoire.x);
				element.setCentreY(trajectoire.y);
				
			}
			
		}
	}

	@Override
	public void gererEtats(int key, char c, GameContainer gameContainer) 
	{
		
		//element.setEnDeplacement(true);
		
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
			element.setVitesse(element.getVitesse() + ConstantesElements.ELEMENT_BALLE_INCREMENT_VITESSE);
		}
		
	}
	
	public Vector2f calculTrajectoire(float angle, float vitesse, float x_initiale, float y_initiale, float delta)
	{
		
		/*attention l'angle renvoyé par l'élément circle de slick2d est en degrée 
		 * et ne tient pas compte du repère de l'écran,
		 *  pour obtenir l'angle par rapport à l'écran faire 180 - angleSlick*/
		
		//x2 = x1 + cos(direction) * vitesse
		//y2 = x2 + sin(direction) * vitesse
		
		//180 ° = π radians ;
		//donc 1 ° = π / 180 radians.
		
		// direction (radiant) = (π / 180) * direction (degré)
		float x_finale = (float) (x_initiale + Math.cos(convertionDegreRadiant(angle)) * vitesse * delta);
		float y_finale = (float) (y_initiale - Math.sin(convertionDegreRadiant(angle)) * vitesse * delta);
		
		return new Vector2f(ajusterTrajectoireNegative(x_finale), ajusterTrajectoireNegative(y_finale));
		
	}
	
	private float convertionDegreRadiant(float angle)
	{
		return (float) ((Math.PI/180) * angle);
	}
	
	//Correction effet de scintillement de certains calculs de coordonnes
	private float ajusterTrajectoireNegative(float coordonne)
	{
		return coordonne > 0 ? coordonne : coordonne * -1;
		
	}
	
}
