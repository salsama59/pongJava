package mecanismes.implementations;

import java.util.Random;

import mecanismes.interfaces.LogicDeplacementsEtatsElementsJeu;

import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;

import constantes.ConstantesElements;
import elementsJeu.Balle;

public class LogicDeplacementsEtatsElementsJeuBalleImpl implements LogicDeplacementsEtatsElementsJeu 
{
	
	private Balle element = null;
	private Vector2f valeurAleatoireXY = null;
	
	public LogicDeplacementsEtatsElementsJeuBalleImpl(Balle balle)
	{
		this.setElement(balle);
	}

	@Override
	public void gererDeplacements(int delta)
	{
		
		this.setValeurAleatoireXY(null);
			
		if(this.getElement().isEnCollision())
		{
			this.setValeurAleatoireXY(this.genererMouvementAleatoire());
			this.accelererBalle();
		}
		
		if(element.isEnDeplacement())
		{
			
			Vector2f origine = new Vector2f(element.getCentreX(), element.getCentreY());
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
				
				if(this.getValeurAleatoireXY() != null)
				{
					//arrivee.set(element.getCentreX() + (element.getVitesse() * delta * this.getValeurAleatoireXY().x), element.getCentreY() - (element.getVitesse() * delta * this.getValeurAleatoireXY().y));
					//Vector2f test = calculCordoneeSuivante(origine, element.getCentreX() + (element.getVitesse() * delta * this.getValeurAleatoireXY().x), element.getVitesse(), angle - 180);
					Vector2f test = calculTrajectoire(180 - angle, element.getVitesse(), element.getCentreX(), element.getCentreY());
					element.setCentreX(test.x);
					element.setCentreY(test.y);
				}
				else
				{
					//arrivee.set(element.getCentreX() + (element.getVitesse() * delta), element.getCentreY() - (element.getVitesse() * delta));
					//Vector2f test = calculCordoneeSuivante(origine, element.getCentreX() + (element.getVitesse() * delta), element.getVitesse(), angle);
					Vector2f test = calculTrajectoire(180 - angle, element.getVitesse(), element.getCentreX(), element.getCentreY());
					element.setCentreX(test.x);
					element.setCentreY(test.y);
				}
				
			}
			
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_HAUT_GAUCHE)
			{
				
				if(this.getValeurAleatoireXY() != null)
				{
					//arrivee.set(element.getCentreX() - (element.getVitesse() * delta * this.getValeurAleatoireXY().x), element.getCentreY() - (element.getVitesse() * delta * this.getValeurAleatoireXY().y));
					//Vector2f test = calculCordoneeSuivante(origine, element.getCentreX() - (element.getVitesse() * delta * this.getValeurAleatoireXY().x), element.getVitesse(), angle);
					Vector2f test = calculTrajectoire(180 - angle, element.getVitesse(), element.getCentreX(), element.getCentreY());
					element.setCentreX(test.x);
					element.setCentreY(test.y);
				}
				else
				{
					//arrivee.set(element.getCentreX() - (element.getVitesse() * delta), element.getCentreY() - (element.getVitesse() * delta));
					//Vector2f test = calculCordoneeSuivante(origine, element.getCentreX() - (element.getVitesse() * delta), element.getVitesse(), angle);
					Vector2f test = calculTrajectoire(180 - angle, element.getVitesse(), element.getCentreX(), element.getCentreY());
					element.setCentreX(test.x);
					element.setCentreY(test.y);
				}
				
			}
			
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS_DROITE)
			{
				
				if(this.getValeurAleatoireXY() != null)
				{
					//arrivee.set(element.getCentreX() + (element.getVitesse() * delta * this.getValeurAleatoireXY().x), element.getCentreY() + (element.getVitesse() * delta * this.getValeurAleatoireXY().y));
					//Vector2f test = calculCordoneeSuivante(origine, element.getCentreX() + (element.getVitesse() * delta * this.getValeurAleatoireXY().x), element.getVitesse(), angle);
					Vector2f test = calculTrajectoire(180 - angle, element.getVitesse(), element.getCentreX(), element.getCentreY());
					element.setCentreX(test.x);
					element.setCentreY(test.y);
				}
				else
				{
					//arrivee.set(element.getCentreX() + (element.getVitesse() * delta), element.getCentreY() + (element.getVitesse() * delta));
					//Vector2f test = calculCordoneeSuivante(origine, element.getCentreX() + (element.getVitesse() * delta), element.getVitesse(), angle);
					Vector2f test = calculTrajectoire(180 - angle, element.getVitesse(), element.getCentreX(), element.getCentreY());
					element.setCentreX(test.x);
					element.setCentreY(test.y);
				}
				
			}
			
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS_GAUCHE)
			{
				
				if(this.getValeurAleatoireXY() != null)
				{
					//arrivee.set(element.getCentreX() - (element.getVitesse() * delta * this.getValeurAleatoireXY().x), element.getCentreY() + (element.getVitesse() * delta * this.getValeurAleatoireXY().y));
					//Vector2f test = calculCordoneeSuivante(origine, element.getCentreX() - (element.getVitesse() * delta * this.getValeurAleatoireXY().x), element.getVitesse(), angle);
					Vector2f test = calculTrajectoire(180 - angle, element.getVitesse(), element.getCentreX(), element.getCentreY());
					element.setCentreX(test.x);
					element.setCentreY(test.y);
				}
				else
				{
					//arrivee.set(element.getCentreX() - (element.getVitesse() * delta), element.getCentreY() + (element.getVitesse() * delta));
					//Vector2f test = calculCordoneeSuivante(origine, element.getCentreX() - (element.getVitesse() * delta), element.getVitesse(), angle);
					Vector2f test = calculTrajectoire(180 - angle, element.getVitesse(), element.getCentreX(), element.getCentreY());
					element.setCentreX(test.x);
					element.setCentreY(test.y);
				}
				
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
	
	private Vector2f genererMouvementAleatoire()
	{
		Vector2f coupleVitesse = null;
		
		int intervale = ConstantesElements.ELEMENT_BALLE_COEF_ALEATOIRE_MAX - ConstantesElements.ELEMENT_BALLE_COEF_ALEATOIRE_MIN;
		
		Random r = new Random();
		
		int valeurX = ConstantesElements.ELEMENT_BALLE_COEF_ALEATOIRE_MIN + r.nextInt(intervale);
		int valeurY = ConstantesElements.ELEMENT_BALLE_COEF_ALEATOIRE_MIN + r.nextInt(intervale);
		
		coupleVitesse = new Vector2f(valeurX, valeurY);
		
		return coupleVitesse;
		
	}

	public Balle getElement() 
	{
		return element;
	}

	public void setElement(Balle element) 
	{
		this.element = element;
	}

	private Vector2f getValeurAleatoireXY() 
	{
		return valeurAleatoireXY;
	}

	private void setValeurAleatoireXY(Vector2f valeurAleatoireXY) 
	{
		this.valeurAleatoireXY = valeurAleatoireXY;
	}
	
	private void accelererBalle()
	{
		Balle element = this.getElement();
		
		if(element.getVitesse() < ConstantesElements.ELEMENT_BALLE_VITESSE_MAX)
		{
			element.setVitesse(element.getVitesse() + 0.01f);
		}
		
	}
	
	public Vector2f calculCordoneeSuivante(Vector2f origine, float coordonneeAbscise, float vitesseDeplacement, float direction)
	{
		//Détermination de l'équation de la droite de l'origine jusqu'à la destination
		//y=ax+b => x est connu et variera selon la trajectoire, on cherche à connaitre y.
		
		Vector2f arrivee = calculCordoneeArrivee(origine, vitesseDeplacement, direction);
		
		//calcul de a
		float a = (origine.y - arrivee.y)/(origine.x - arrivee.x);
		//calcul de b
		float b = origine.y - a * origine.x;
		//Calcul y
		float coordonneeOrdonnee = a * coordonneeAbscise + b;
		
		return new Vector2f(coordonneeAbscise, coordonneeOrdonnee);
		
	}
	
	private Vector2f calculCordoneeArrivee(Vector2f origine, float vitesse, float direction)
	{
		float xArrivee = (float)(origine.getX() + Math.cos(direction) * vitesse);
		float yArrivee = (float)(origine.getY() + Math.cos(direction) * vitesse);
		
		return new Vector2f(xArrivee, yArrivee);
	}
	
	public Vector2f calculTrajectoire(float angle, float vitesse, float x, float y)
	{
		//attenttion l'angle renvoyé par l'élément circle de slick1d est en degrée et ne tient pas compte du repère de l'écranc pour obtenir l'angle par rapport à l'écran faire 180 - angleSlick 
		//x2 = x1 + cos(direction) * vitesse
		//y2 = x2 + sin(direction) * vitesse
		
		//180 ° = π radians ;
		//donc 1 ° = π / 180 radians.
		
		// direction (radiant) = (π / 180) * direction (degré)
		
		
		return new Vector2f((float) (x + Math.cos(convertionDegreRadiant(angle)) * vitesse), (float) (y + Math.sin(convertionDegreRadiant(angle)) * vitesse));
	}
	
	private float convertionDegreRadiant(float angle)
	{
		return (float) ((Math.PI/180) * angle);
	}
	
}
