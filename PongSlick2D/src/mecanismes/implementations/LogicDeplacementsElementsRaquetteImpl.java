package mecanismes.implementations;

import managers.elements.GestionnaireElements;
import mecanismes.interfaces.LogicDeplacementsElements;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import constantes.ConstantesElements;
import constantes.ConstantesJoueurs;
import elementsJeu.Balle;
import elementsJeu.Raquette;

public class LogicDeplacementsElementsRaquetteImpl implements LogicDeplacementsElements
{
	
	private Raquette element = null;
	
	public LogicDeplacementsElementsRaquetteImpl(Raquette raquette)
	{
		this.setElement(raquette);
	}
	
	@Override
	public void gererDeplacements(int delta, String phase, GameContainer gameContainer)
	{
		if(element.isEnDeplacement())
		{
			
			if(element.getSens() == ConstantesElements.ELEMENT_SENS_HAUT)
			{
				element.setCoordonneeY(element.getCoordonneeY() - (element.getVitesse() * delta));
			}
			
			if(element.getSens() == ConstantesElements.ELEMENT_SENS_BAS)
			{
				element.setCoordonneeY(element.getCoordonneeY() + (element.getVitesse() * delta));
			}
			
			if(element.getEtat() == ConstantesElements.ELEMENT_ETAT_LANCEMENT)
			{
				Balle balle = (Balle) GestionnaireElements.recupererElementParNom(ConstantesElements.ELEMENT_BALLE_NOM);
				
				this.ajusterPositionLancementBalle(balle);
				
			}
			
		}
	}

	@Override
	public void gererEtats(int key, char c, GameContainer gameContainer) 
	{
		Input entree = new Input(key);
		
		if(element.getNomElement().equals(ConstantesElements.ELEMENT_RAQUETTE1_NOM))
		{
			switch (key) 
		    {
			
			    case Input.KEY_SPACE:
	        	if(element.getEtat() == ConstantesElements.ELEMENT_ETAT_LANCEMENT)
		        {
	        		
	        		if(entree.isKeyDown(Input.KEY_UP))
	        		{
	        			Balle balle = (Balle) GestionnaireElements.recupererElementParNom(ConstantesElements.ELEMENT_BALLE_NOM);
			        	balle.setEnCollision(false);
			        	balle.setSens(ConstantesElements.ELEMENT_SENS_HAUT_DROITE);
			        	element.setEtat(ConstantesElements.ELEMENT_ETAT_NEUTRE);
			        	balle.setEnDeplacement(true);
	        		}
	        		else if(entree.isKeyDown(Input.KEY_DOWN))
	        		{
	        			Balle balle = (Balle) GestionnaireElements.recupererElementParNom(ConstantesElements.ELEMENT_BALLE_NOM);
			        	balle.setEnCollision(false);
			        	balle.setSens(ConstantesElements.ELEMENT_SENS_BAS_DROITE);
			        	element.setEtat(ConstantesElements.ELEMENT_ETAT_NEUTRE);
			        	balle.setEnDeplacement(true);
	        		}
		        	
		        }
		        break;
			
		        case Input.KEY_UP:
		        element.setEnDeplacement(true);
		        element.setSens(ConstantesElements.ELEMENT_SENS_HAUT);	
		        break;
		        
		        case Input.KEY_LEFT:
		        //raquette1.setCoordonneeX(raquette1.getCoordonneeX()-1);
		        break;
		        
		        case Input.KEY_DOWN:
		        element.setEnDeplacement(true);
		        element.setSens(ConstantesElements.ELEMENT_SENS_BAS);
		        break;
		        
		        case Input.KEY_RIGHT:
		        //raquette1.setCoordonneeX(raquette1.getCoordonneeX()+1);
		        break;
		    }
		}
		else if(element.getNomElement().equals(ConstantesElements.ELEMENT_RAQUETTE2_NOM))
		{
			switch (key) 
		    {
				
		    	case Input.KEY_RETURN:
	        	if(element.getEtat() == ConstantesElements.ELEMENT_ETAT_LANCEMENT)
		        {
	        		
	        		if(entree.isKeyDown(Input.KEY_Z))
	        		{
	        			Balle balle = (Balle) GestionnaireElements.recupererElementParNom(ConstantesElements.ELEMENT_BALLE_NOM);
			        	balle.setEnCollision(false);
			        	balle.setSens(ConstantesElements.ELEMENT_SENS_HAUT_GAUCHE);
			        	element.setEtat(ConstantesElements.ELEMENT_ETAT_NEUTRE);
			        	balle.setEnDeplacement(true);
	        		}
	        		else if(entree.isKeyDown(Input.KEY_W))
	        		{
	        			Balle balle = (Balle) GestionnaireElements.recupererElementParNom(ConstantesElements.ELEMENT_BALLE_NOM);
			        	balle.setEnCollision(false);
			        	balle.setSens(ConstantesElements.ELEMENT_SENS_BAS_GAUCHE);
			        	element.setEtat(ConstantesElements.ELEMENT_ETAT_NEUTRE);
			        	balle.setEnDeplacement(true);
	        		}
		        	
		        }
		        break;
				
		        case Input.KEY_Z:
		        element.setEnDeplacement(true);
		        element.setSens(ConstantesElements.ELEMENT_SENS_HAUT);
		        break;
		        
		        case Input.KEY_Q:
		        //raquette1.setCoordonneeX(raquette1.getCoordonneeX()-1);
		        break;
		        
		        case Input.KEY_W:
		        element.setEnDeplacement(true);
		        element.setSens(ConstantesElements.ELEMENT_SENS_BAS);
		        break;
		        
		        case Input.KEY_S:
		        //raquette1.setCoordonneeX(raquette1.getCoordonneeX()+1);
		        break;
		    }
		}
		
	}

	@Override
	public void reinitialisationEtat(int key, char c) 
	{
		
		if(element.getNomElement().equals(ConstantesElements.ELEMENT_RAQUETTE1_NOM))
		{
			switch (key) 
		    {
		        case Input.KEY_UP:
		        element.setEnDeplacement(false);
		        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
		        break;
		        
		        case Input.KEY_LEFT:
		        //element1.setCoordonneeX(element1.getCoordonneeX()-1);
		        break;
		        
		        case Input.KEY_DOWN:
		        element.setEnDeplacement(false);
			    element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
		        break;
		        
		        case Input.KEY_RIGHT:
		        //element1.setCoordonneeX(element1.getCoordonneeX()+1);
		        break;
		    }
		}
		else if(element.getNomElement().equals(ConstantesElements.ELEMENT_RAQUETTE2_NOM))
		{
			switch (key) 
		    {
		        case Input.KEY_Z:
	        	element.setEnDeplacement(false);
		        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
		        break;
		        
		        case Input.KEY_Q:
		        //raquette1.setCoordonneeX(raquette1.getCoordonneeX()-1);
		        break;
		        
		        case Input.KEY_W:
	        	element.setEnDeplacement(false);
			    element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
		        break;
		        
		        case Input.KEY_S:
		        //raquette1.setCoordonneeX(raquette1.getCoordonneeX()+1);
		        break;
		    }
		}
			
	}

	public Raquette getElement() {
		return element;
	}

	public void setElement(Raquette element) {
		this.element = element;
	}
	
	private void ajusterPositionLancementBalle(Balle balle)
	{
		
		float x = 0;
		float y = 0;
		
		if(this.getElement().getCamp() == ConstantesJoueurs.JOUEUR_CAMP_GAUCHE)
		{
			x = this.getElement().getCoordonneeX() + balle.getRayon() + this.getElement().getLargeur();
		}	
		else if(this.getElement().getCamp() == ConstantesJoueurs.JOUEUR_CAMP_DROITE)
		{
			x = this.getElement().getCoordonneeX() - balle.getRayon();
		}
		
		y = (this.getElement().getHauteur()/2) + this.getElement().getCoordonneeY();
		
		balle.setCentreX(x);
		balle.setCentreY(y);
		
	}

}
