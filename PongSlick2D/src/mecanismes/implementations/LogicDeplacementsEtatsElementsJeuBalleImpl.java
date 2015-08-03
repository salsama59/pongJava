package mecanismes.implementations;

import java.util.Random;

import org.newdawn.slick.Input;

import constantes.ConstantesElements;
import mecanismes.interfaces.LogicDeplacementsEtatsElementsJeu;
import elementsJeu.Balle;

public class LogicDeplacementsEtatsElementsJeuBalleImpl implements LogicDeplacementsEtatsElementsJeu 
{
	
	private Balle element = null;
	private float valeurAleatoire = 0;
	private boolean encollision = false;
	
	public LogicDeplacementsEtatsElementsJeuBalleImpl(Balle balle)
	{
		this.setElement(balle);
	}

	@Override
	public void gererDeplacements(int delta)
	{
		
		if(!isEncollision())
		{
			this.setEncollision(this.getElement().isEnDeplacement());
			
			if(isEncollision())
			{
				this.setValeurAleatoire(this.genererMouvementAleatoire());
			}
			
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
				
				if(this.getValeurAleatoire() != 0)
				{
					element.setCentreX(element.getCentreX() + (element.getVitesse() * delta));
					element.setCentreY(element.getCentreY() - (element.getVitesse() * delta * this.getValeurAleatoire()));
				}
				else
				{
					element.setCentreX(element.getCentreX() + (element.getVitesse() * delta));
					element.setCentreY(element.getCentreY() - (element.getVitesse() * delta));
				}
				
			}
			
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_HAUT_GAUCHE)
			{
				
				if(this.getValeurAleatoire() != 0)
				{
					element.setCentreX(element.getCentreX() - (element.getVitesse() * delta));
					element.setCentreY(element.getCentreY() - (element.getVitesse() * delta * this.getValeurAleatoire()));
				}
				else
				{
					element.setCentreX(element.getCentreX() - (element.getVitesse() * delta));
					element.setCentreY(element.getCentreY() - (element.getVitesse() * delta));
				}
				
			}
			
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS_DROITE)
			{
				
				if(this.getValeurAleatoire() != 0)
				{
					element.setCentreX(element.getCentreX() + (element.getVitesse() * delta));
					element.setCentreY(element.getCentreY() + (element.getVitesse() * delta * this.getValeurAleatoire()));
				}
				else
				{
					element.setCentreX(element.getCentreX() + (element.getVitesse() * delta));
					element.setCentreY(element.getCentreY() + (element.getVitesse() * delta));
				}
				
			}
			
			if(element.getDirection() == ConstantesElements.ELEMENT_DIRECTION_BAS_GAUCHE)
			{
				
				if(this.getValeurAleatoire() != 0)
				{
					element.setCentreX(element.getCentreX() - (element.getVitesse() * delta));
					element.setCentreY(element.getCentreY() + (element.getVitesse() * delta * this.getValeurAleatoire()));
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
	
	private float genererMouvementAleatoire()
	{
		float nombreAleatoire = 0;
		int intervale = ConstantesElements.ELEMENT_BALLE_COEF_ALEATOIRE_MAX - ConstantesElements.ELEMENT_BALLE_COEF_ALEATOIRE_MIN;
		
		Random r = new Random();
		int valeur = ConstantesElements.ELEMENT_BALLE_COEF_ALEATOIRE_MIN + r.nextInt(intervale);

		nombreAleatoire = valeur * 0.1f;
		
		return nombreAleatoire;
		
	}

	public Balle getElement() {
		return element;
	}

	public void setElement(Balle element) {
		this.element = element;
	}

	public float getValeurAleatoire() {
		return valeurAleatoire;
	}

	public void setValeurAleatoire(float valeurAleatoire) {
		this.valeurAleatoire = valeurAleatoire;
	}

	public boolean isEncollision() {
		return encollision;
	}

	public void setEncollision(boolean encollision) {
		this.encollision = encollision;
	}
	
}
