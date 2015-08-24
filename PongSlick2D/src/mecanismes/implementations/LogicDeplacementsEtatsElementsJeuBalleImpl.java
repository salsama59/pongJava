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
					element.setCentreX(element.getCentreX() + (element.getVitesse() * delta * this.getValeurAleatoireXY().x));
					element.setCentreY(element.getCentreY() - (element.getVitesse() * delta * this.getValeurAleatoireXY().y));
				}
				else
				{
					element.setCentreX(element.getCentreX() + (element.getVitesse() * delta));
					element.setCentreY(element.getCentreY() - (element.getVitesse() * delta));
				}
				
			}
			
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_HAUT_GAUCHE)
			{
				
				if(this.getValeurAleatoireXY() != null)
				{
					element.setCentreX(element.getCentreX() - (element.getVitesse() * delta * this.getValeurAleatoireXY().x));
					element.setCentreY(element.getCentreY() - (element.getVitesse() * delta * this.getValeurAleatoireXY().y));
				}
				else
				{
					element.setCentreX(element.getCentreX() - (element.getVitesse() * delta));
					element.setCentreY(element.getCentreY() - (element.getVitesse() * delta));
				}
				
			}
			
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS_DROITE)
			{
				
				if(this.getValeurAleatoireXY() != null)
				{
					element.setCentreX(element.getCentreX() + (element.getVitesse() * delta * this.getValeurAleatoireXY().x));
					element.setCentreY(element.getCentreY() + (element.getVitesse() * delta * this.getValeurAleatoireXY().y));
				}
				else
				{
					element.setCentreX(element.getCentreX() + (element.getVitesse() * delta));
					element.setCentreY(element.getCentreY() + (element.getVitesse() * delta));
				}
				
			}
			
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS_GAUCHE)
			{
				
				if(this.getValeurAleatoireXY() != null)
				{
					element.setCentreX(element.getCentreX() - (element.getVitesse() * delta * this.getValeurAleatoireXY().x));
					element.setCentreY(element.getCentreY() + (element.getVitesse() * delta * this.getValeurAleatoireXY().y));
				}
				else
				{
					element.setCentreX(element.getCentreX() - (element.getVitesse() * delta));
					element.setCentreY(element.getCentreY() + (element.getVitesse() * delta));
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
	
	//TODO tester cela imperativement et ajouter des commentaires d'explication
	private Vector2f determinerNormalePointImpact(Vector2f coordoneesElementMinA, Vector2f coordoneesElementMaxB)
	{
		
		Vector2f normale = null, u = null, ac = null, c = null;
		c = new Vector2f(this.getElement().getCentreX(), this.getElement().getCentreY());
		u = new Vector2f((coordoneesElementMaxB.x - coordoneesElementMinA.x), (coordoneesElementMaxB.y - coordoneesElementMinA.y));
		ac = new Vector2f((c.x - coordoneesElementMinA.x), (c.y - coordoneesElementMinA.y));
		
		float parentheses = u.x*ac.y-u.y*ac.x;
		
		float cordonneesX = (-1) * u.y * (parentheses);
		float cordonneesY = (-1) * u.x * (parentheses);
		
		float norme = (float) Math.sqrt(cordonneesX * cordonneesX + cordonneesY * cordonneesY);
		
		normale = new Vector2f((cordonneesX/norme), (cordonneesY/norme));
		
		return normale;
	}
	
	private Vector2f determinerPointInpact(Vector2f coordoneesElementMinA, Vector2f coordoneesElementMaxB)
	{
		Vector2f coodoneesImpact = null, u = null, ac = null, c = null;
		c = new Vector2f(this.getElement().getCentreX(), this.getElement().getCentreY());
		u = new Vector2f((coordoneesElementMaxB.x - coordoneesElementMinA.x), (coordoneesElementMaxB.y - coordoneesElementMinA.y));
		ac = new Vector2f((c.x - coordoneesElementMinA.x), (c.y - coordoneesElementMinA.y));
		float ti = (u.x * ac.x + u.y * ac.y)/(u.x * u.x + u.y * u.y);
		
		coodoneesImpact = new Vector2f((coordoneesElementMinA.x + ti * u.x), (coordoneesElementMinA.y + ti * u.y));
		
		return coodoneesImpact;
	}
	
	//Potentiellement errone a cause du sens dans lequel on se trouve (chager le calcul en fonction du sens et de l'objet rencontré
	private Vector2f calculerTrajectoireInitiale(Vector2f pointInpact)
	{
		Vector2f c = new Vector2f(this.getElement().getCentreX(), this.getElement().getCentreY());
		
		return new Vector2f((c.x - pointInpact.x), (c.y - pointInpact.y));
	}
	
	private Vector2f determinerDirectionRebond(Vector2f trajectoireInitiale, Vector2f normale)
	{
		
		float produitScalaire = (trajectoireInitiale.x * normale.x + trajectoireInitiale.y * normale.y);
		
		return new Vector2f((trajectoireInitiale.x - 2 * produitScalaire *normale.x), (trajectoireInitiale.y - 2 * produitScalaire *normale.y));
	}
	
}
