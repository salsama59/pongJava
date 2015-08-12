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
		float nombreAleatoireX = 0;
		float nombreAleatoireY = 0;
		
		int intervale = ConstantesElements.ELEMENT_BALLE_COEF_ALEATOIRE_MAX - ConstantesElements.ELEMENT_BALLE_COEF_ALEATOIRE_MIN;
		
		Random r = new Random();
		
		int valeurX = ConstantesElements.ELEMENT_BALLE_COEF_ALEATOIRE_MIN + r.nextInt(intervale);
		int valeurY = ConstantesElements.ELEMENT_BALLE_COEF_ALEATOIRE_MIN + r.nextInt(intervale);

		//nombreAleatoireX = valeurX * 0.1f;
		//nombreAleatoireY = valeurY * 0.1f;
		
		nombreAleatoireX = valeurX;
		nombreAleatoireY = valeurY;
		
		coupleVitesse = new Vector2f(nombreAleatoireX, nombreAleatoireY);
		
		return coupleVitesse;
		
	}

	public Balle getElement() {
		return element;
	}

	public void setElement(Balle element) {
		this.element = element;
	}

	private Vector2f getValeurAleatoireXY() {
		return valeurAleatoireXY;
	}

	private void setValeurAleatoireXY(Vector2f valeurAleatoireXY) {
		this.valeurAleatoireXY = valeurAleatoireXY;
	}
	
}
