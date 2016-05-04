<<<<<<< .mine
package mecanismes.implementations;

import java.util.Collections;
import java.util.Hashtable;

import managers.etat.GestionnaireChoixModeJeu;
import managers.joueur.GestionnaireJoueurs;
import mecanismes.interfaces.LogicDeplacementsElements;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import Joueur.Joueur;
import constantes.ConstantesElements;
import constantes.ConstantesJoueurs;
import elementGraphique.Avatar;
import etatsJeu.EtatMatch;

public class LogicDeplacementsElementsAvatarImpl implements LogicDeplacementsElements 
{
	
	private Avatar element;
	private boolean bloqueDeplacement = false;
	private boolean transitionMiseEnJeu = false;
	
	public LogicDeplacementsElementsAvatarImpl(Avatar avatar)
	{
		this.setElement(avatar);
	}

	@Override
	public void gererDeplacements(int delta, String phase, GameContainer gameContainer)
	{
		
		int pas = gameContainer.getWidth()/3;
		
		if(element.isEnDeplacement())
		{
			
			if(!this.isBloqueDeplacement())
			{
				
				if(element.getSens() == ConstantesElements.ELEMENT_SENS_GAUCHE)
				{
					element.setCoordonneeX(element.getCoordonneeX() - pas);
				}
				
				if(element.getSens() == ConstantesElements.ELEMENT_SENS_DROITE)
				{
					element.setCoordonneeX(element.getCoordonneeX() + pas);
				}
				
			}
			
			this.setBloqueDeplacement(true);
			
		}
		
	}

	@Override
	public void gererEtats(int key, char c, GameContainer gameContainer) 
	{
		
		int zoneCampGauche = gameContainer.getWidth()/3/2;
		int zoneCampDroit = gameContainer.getWidth()/3 * 2 + gameContainer.getWidth()/3/2;
		int zoneNeutre = (gameContainer.getWidth()/3/2) * 3;
		
		
		if(element.getCoordonneeX() == zoneCampDroit)
        {
			element.setCamp(ConstantesJoueurs.JOUEUR_CAMP_DROITE);
        }
    	else if(element.getCoordonneeX() == zoneCampGauche)
    	{
    		element.setCamp(ConstantesJoueurs.JOUEUR_CAMP_GAUCHE);
    	}
    	else if(element.getCoordonneeX() == zoneNeutre)
    	{
    		element.setCamp(ConstantesJoueurs.JOUEUR_CAMP_NEUTRE);
    	}
		
		switch (key) 
	    {
		 	
	        case Input.KEY_LEFT:
	        
	        if((element.getIdjoueurRepresente() == ConstantesJoueurs.JOUEUR_ID_1) && !element.isValide())
	        {
	        	
	        	if(element.getCoordonneeX() == zoneCampGauche)
		        {
		        	element.setEnDeplacement(false);
			        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
		        }
		        else
		        {
		        	element.setEnDeplacement(true);
			        element.setSens(ConstantesElements.ELEMENT_SENS_GAUCHE);
		        }
	        	
	        }
	        
	        break;
	        
	        
	        case Input.KEY_RIGHT:
	        
        	if((element.getIdjoueurRepresente() == ConstantesJoueurs.JOUEUR_ID_1) && !element.isValide())
	        {
        		
        		if(element.getCoordonneeX() == zoneCampDroit)
    	        {
    	        	element.setEnDeplacement(false);
    		        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
    	        }
            	else
            	{
            		element.setEnDeplacement(true);
        	        element.setSens(ConstantesElements.ELEMENT_SENS_DROITE);
            	}
        		
	        }
        	
	        break;
	        
	        case Input.KEY_Q:
	        
        	if((element.getIdjoueurRepresente() == ConstantesJoueurs.JOUEUR_ID_2) && !element.isValide())
	        {
        		
	        	if(element.getCoordonneeX() == zoneCampGauche)
		        {
		        	element.setEnDeplacement(false);
			        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
		        }
		        else
		        {
		        	element.setEnDeplacement(true);
			        element.setSens(ConstantesElements.ELEMENT_SENS_GAUCHE);
		        }
	        	
	        }
        	
        	break;
        	
	        case Input.KEY_S:
		        
        	if((element.getIdjoueurRepresente() == ConstantesJoueurs.JOUEUR_ID_2) && !element.isValide())
	        {
        		
        		if(element.getCoordonneeX() == zoneCampDroit)
    	        {
    	        	element.setEnDeplacement(false);
    		        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
    	        }
            	else
            	{
            		element.setEnDeplacement(true);
        	        element.setSens(ConstantesElements.ELEMENT_SENS_DROITE);
            	}
        		
	        }
        	
        	break;
        	
	        case Input.KEY_RETURN:
	        
        	if(element.getIdjoueurRepresente() == ConstantesJoueurs.JOUEUR_ID_1)
	        {
        		
        		String camp = element.getCamp();
        		
        		if(selectionCampPossible(camp))
        		{
        			int idJoueur = element.getIdjoueurRepresente();
            		
            		Joueur joueur = GestionnaireJoueurs.getInstance().getListJoueursParId().get(idJoueur);
            		
            		if(joueur != null)
            		{
            			joueur.setCamp(camp);
            		}
            		
            		element.setEnDeplacement(false);
    		        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
    		        element.setValide(true);
        		}
        		
	        }
        	
	        break;
	        
	        case Input.KEY_SPACE:
		    
    		if(element.getIdjoueurRepresente() == ConstantesJoueurs.JOUEUR_ID_2)
	        {
        		
        		String camp = element.getCamp();
        		
        		if(selectionCampPossible(camp))
        		{
        			
        			int idJoueur = element.getIdjoueurRepresente();
            		Joueur joueur = GestionnaireJoueurs.getInstance().getListJoueursParId().get(idJoueur);
            		
            		if(joueur != null)
            		{
            			joueur.setCamp(camp);
            		}
            		
            		element.setEnDeplacement(false);
    		        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
    		        element.setValide(true);
    		        
        		}
		        
	        }
        	
	        break;
	        
	        case Input.KEY_ESCAPE:
		        
        	if((element.getIdjoueurRepresente() == ConstantesJoueurs.JOUEUR_ID_1) && element.isValide())
	        {
        		
        		int idJoueur = element.getIdjoueurRepresente();
        		Joueur joueur = GestionnaireJoueurs.getInstance().getListJoueursParId().get(idJoueur);
        		
        		if(joueur != null)
        		{
        			joueur.setCamp(null);
        		}
        		
        		element.setEnDeplacement(false);
		        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
		        element.setValide(false);
		        
	        }
		    
		    break;
		    
	        case Input.KEY_R:
		        
        	if((element.getIdjoueurRepresente() == ConstantesJoueurs.JOUEUR_ID_2) && element.isValide())
	        {
        		
        		int idJoueur = element.getIdjoueurRepresente();
        		Joueur joueur = GestionnaireJoueurs.getInstance().getListJoueursParId().get(idJoueur);
        		
        		if(joueur != null)
        		{
        			joueur.setCamp(null);
        		}
        		
        		element.setEnDeplacement(false);
		        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
		        element.setValide(false);
		        
	        }
		    
		    break;
        	
	    }
		
	}

	@Override
	public void reinitialisationEtat(int key, char c) 
	{
		switch (key) 
	    {
	        
	        case Input.KEY_LEFT:
	        element.setEnDeplacement(false);
		    element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
	        break;
	        
	        case Input.KEY_RIGHT:
	        element.setEnDeplacement(false);
		    element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
	        break;
	        
	        case Input.KEY_Q:
	        element.setEnDeplacement(false);
		    element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
	        break;
	        
	        case Input.KEY_S:
	        element.setEnDeplacement(false);
		    element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
	        break;
	        
	    }
		
		this.setBloqueDeplacement(false);
		
		if(this.selectionsTerminees())
		{
			
			GestionnaireChoixModeJeu.getInstance().getJeu().enterState(EtatMatch.ID);
			
		}
		
		
	}

	public Avatar getElement() {
		return element;
	}

	public void setElement(Avatar element) {
		this.element = element;
	}

	public boolean isBloqueDeplacement() {
		return bloqueDeplacement;
	}

	public void setBloqueDeplacement(boolean bloqueDeplacement) {
		this.bloqueDeplacement = bloqueDeplacement;
	}
	
	private boolean selectionCampPossible(String campSouhaite)
	{
		
		boolean selectionPossible = false;
		
		Hashtable<Integer, Joueur> listJoueurs = GestionnaireJoueurs.getInstance().getListJoueursParId();
		
		for(Integer id :  Collections.list(listJoueurs.keys()))
		{
			
			Avatar avatar = GestionnaireJoueurs.getInstance().recupererAvatarParIdJoueur(id);
			
			if((id.intValue() != this.getElement().getIdjoueurRepresente()) && avatar.getCamp() != null)
			{
				
				if(avatar.getCamp().equals(campSouhaite) && avatar.isValide())
				{
					selectionPossible = false;
				}
				else
				{
					selectionPossible = true;
				}
				
			}
			
		}
		
		return selectionPossible;
		
	}
	
	private boolean selectionsTerminees()
	{
		
		boolean selectionsTerminees = false;
		
		Hashtable<Integer, Joueur> listJoueurs = GestionnaireJoueurs.getInstance().getListJoueursParId();
		
		for(Integer id :  Collections.list(listJoueurs.keys()))
		{
			
			Avatar avatar = GestionnaireJoueurs.getInstance().recupererAvatarParIdJoueur(id);
			
			if(avatar.isValide())
			{
				
				selectionsTerminees = true;
				
			}
			else
			{
				
				selectionsTerminees = false;
				
				break;
				
			}
			
		}
		
		return selectionsTerminees;
		
	}

	public boolean isTransitionMiseEnJeu() {
		return transitionMiseEnJeu;
	}

	public void setTransitionMiseEnJeu(boolean transitionMiseEnJeu) {
		this.transitionMiseEnJeu = transitionMiseEnJeu;
	}

}
=======
package mecanismes.implementations;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import managers.etat.GestionnaireChoixModeJeu;
import managers.joueur.GestionnaireJoueurs;
import mecanismes.interfaces.LogicDeplacementsElements;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import Joueur.Joueur;
import constantes.ConstantesElements;
import constantes.ConstantesEtat;
import constantes.ConstantesJoueurs;
import elementGraphique.Avatar;
import etatsJeu.EtatChoixModeJeu;
import etatsJeu.EtatMatch;
import etatsJeu.EtatMiseEnJeu;

public class LogicDeplacementsElementsAvatarImpl implements LogicDeplacementsElements 
{
	
	private Avatar element;
	private boolean bloqueDeplacement = false;
	
	public LogicDeplacementsElementsAvatarImpl(Avatar avatar)
	{
		this.setElement(avatar);
	}

	@Override
	public void gererDeplacements(int delta, String phase, GameContainer gameContainer)
	{
		
		int pas = gameContainer.getWidth()/3;
		
		if(element.isEnDeplacement())
		{
			
			if(!this.isBloqueDeplacement())
			{
				
				if(element.getSens() == ConstantesElements.ELEMENT_SENS_GAUCHE)
				{
					element.setCoordonneeX(element.getCoordonneeX() - pas);
				}
				
				if(element.getSens() == ConstantesElements.ELEMENT_SENS_DROITE)
				{
					element.setCoordonneeX(element.getCoordonneeX() + pas);
				}
				
			}
			
			this.setBloqueDeplacement(true);
			
		}
		
	}

	@Override
	public void gererEtats(int key, char c, GameContainer gameContainer) 
	{
		
		int zoneCampGauche = gameContainer.getWidth()/3/2;
		int zoneCampDroit = gameContainer.getWidth()/3 * 2 + gameContainer.getWidth()/3/2;
		int zoneNeutre = (gameContainer.getWidth()/3/2) * 3;
		
		
		if(element.getCoordonneeX() == zoneCampDroit)
        {
			element.setCamp(ConstantesJoueurs.JOUEUR_CAMP_DROITE);
        }
    	else if(element.getCoordonneeX() == zoneCampGauche)
    	{
    		element.setCamp(ConstantesJoueurs.JOUEUR_CAMP_GAUCHE);
    	}
    	else if(element.getCoordonneeX() == zoneNeutre)
    	{
    		element.setCamp(ConstantesJoueurs.JOUEUR_CAMP_NEUTRE);
    	}
		
		switch (key) 
	    {
		 	
	        case Input.KEY_LEFT:
	        
	        if((element.getIdjoueurRepresente() == ConstantesJoueurs.JOUEUR_ID_1) && !element.isValide())
	        {
	        	
	        	if(element.getCoordonneeX() == zoneCampGauche)
		        {
		        	element.setEnDeplacement(false);
			        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
		        }
		        else
		        {
		        	element.setEnDeplacement(true);
			        element.setSens(ConstantesElements.ELEMENT_SENS_GAUCHE);
		        }
	        	
	        }
	        
	        break;
	        
	        
	        case Input.KEY_RIGHT:
	        
        	if((element.getIdjoueurRepresente() == ConstantesJoueurs.JOUEUR_ID_1) && !element.isValide())
	        {
        		
        		if(element.getCoordonneeX() == zoneCampDroit)
    	        {
    	        	element.setEnDeplacement(false);
    		        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
    	        }
            	else
            	{
            		element.setEnDeplacement(true);
        	        element.setSens(ConstantesElements.ELEMENT_SENS_DROITE);
            	}
        		
	        }
        	
	        break;
	        
	        case Input.KEY_Q:
	        
        	if((element.getIdjoueurRepresente() == ConstantesJoueurs.JOUEUR_ID_2) && !element.isValide())
	        {
        		
	        	if(element.getCoordonneeX() == zoneCampGauche)
		        {
		        	element.setEnDeplacement(false);
			        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
		        }
		        else
		        {
		        	element.setEnDeplacement(true);
			        element.setSens(ConstantesElements.ELEMENT_SENS_GAUCHE);
		        }
	        	
	        }
        	
        	break;
        	
	        case Input.KEY_S:
		        
        	if((element.getIdjoueurRepresente() == ConstantesJoueurs.JOUEUR_ID_2) && !element.isValide())
	        {
        		
        		if(element.getCoordonneeX() == zoneCampDroit)
    	        {
    	        	element.setEnDeplacement(false);
    		        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
    	        }
            	else
            	{
            		element.setEnDeplacement(true);
        	        element.setSens(ConstantesElements.ELEMENT_SENS_DROITE);
            	}
        		
	        }
        	
        	break;
        	
	        case Input.KEY_RETURN:
	        
        	if(element.getIdjoueurRepresente() == ConstantesJoueurs.JOUEUR_ID_1)
	        {
        		
        		String camp = element.getCamp();
        		
        		if(selectionCampPossible(camp))
        		{
        			int idJoueur = element.getIdjoueurRepresente();
            		
            		Joueur joueur = GestionnaireJoueurs.getInstance().getListJoueursParId().get(idJoueur);
            		
            		if(joueur != null)
            		{
            			joueur.setCamp(camp);
            		}
            		
            		element.setEnDeplacement(false);
    		        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
    		        element.setValide(true);
        		}
        		
	        }
	        
	        break;
	        
	        case Input.KEY_SPACE:
		        
        	if(element.getIdjoueurRepresente() == ConstantesJoueurs.JOUEUR_ID_2)
	        {
        		
        		String camp = element.getCamp();
        		
        		if(selectionCampPossible(camp))
        		{
        			
        			int idJoueur = element.getIdjoueurRepresente();
            		Joueur joueur = GestionnaireJoueurs.getInstance().getListJoueursParId().get(idJoueur);
            		
            		if(joueur != null)
            		{
            			joueur.setCamp(camp);
            		}
            		
            		element.setEnDeplacement(false);
    		        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
    		        element.setValide(true);
    		        
        		}
		        
	        }
	        
	        break;
	        
	        case Input.KEY_ESCAPE:
		        
        	if((element.getIdjoueurRepresente() == ConstantesJoueurs.JOUEUR_ID_1) && element.isValide())
	        {
        		
        		int idJoueur = element.getIdjoueurRepresente();
        		Joueur joueur = GestionnaireJoueurs.getInstance().getListJoueursParId().get(idJoueur);
        		
        		if(joueur != null)
        		{
        			joueur.setCamp(null);
        		}
        		
        		element.setEnDeplacement(false);
		        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
		        element.setValide(false);
		        
	        }
		    
		    break;
		    
	        case Input.KEY_R:
		        
        	if((element.getIdjoueurRepresente() == ConstantesJoueurs.JOUEUR_ID_2) && element.isValide())
	        {
        		
        		int idJoueur = element.getIdjoueurRepresente();
        		Joueur joueur = GestionnaireJoueurs.getInstance().getListJoueursParId().get(idJoueur);
        		
        		if(joueur != null)
        		{
        			joueur.setCamp(null);
        		}
        		
        		element.setEnDeplacement(false);
		        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
		        element.setValide(false);
		        
	        }
		    
		    break;
        	
	    }
		
		if(this.selectionsTerminees())
		{
			
			GestionnaireChoixModeJeu.getInstance().getJeu().enterState(EtatMiseEnJeu.ID);
			//EtatChoixModeJeu.setPhase(ConstantesEtat);
		}
		
	}

	@Override
	public void reinitialisationEtat(int key, char c) 
	{
		switch (key) 
	    {
	        
	        case Input.KEY_LEFT:
	        element.setEnDeplacement(false);
		    element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
	        break;
	        
	        case Input.KEY_RIGHT:
	        element.setEnDeplacement(false);
		    element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
	        break;
	        
	        case Input.KEY_Q:
	        element.setEnDeplacement(false);
		    element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
	        break;
	        
	        case Input.KEY_S:
	        element.setEnDeplacement(false);
		    element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
	        break;
	        
	    }
		
		this.setBloqueDeplacement(false);
		
	}

	public Avatar getElement() {
		return element;
	}

	public void setElement(Avatar element) {
		this.element = element;
	}

	public boolean isBloqueDeplacement() {
		return bloqueDeplacement;
	}

	public void setBloqueDeplacement(boolean bloqueDeplacement) {
		this.bloqueDeplacement = bloqueDeplacement;
	}
	
	private boolean selectionCampPossible(String campSouhaite)
	{
		
		boolean selectionPossible = false;
		
		Hashtable<Integer, Joueur> listJoueurs = GestionnaireJoueurs.getInstance().getListJoueursParId();
		
		for(Integer id :  Collections.list(listJoueurs.keys()))
		{
			
			Avatar avatar = GestionnaireJoueurs.getInstance().recupererAvatarParIdJoueur(id);
			
			if((id.intValue() != this.getElement().getIdjoueurRepresente()) && avatar.getCamp() != null)
			{
				
				if(avatar.getCamp().equals(campSouhaite) && avatar.isValide())
				{
					selectionPossible = false;
				}
				else
				{
					selectionPossible = true;
				}
				
			}
			
		}
		
		return selectionPossible;
		
	}
	
	private boolean selectionsTerminees()
	{
		
		boolean selectionsTerminees = false;
		
		Hashtable<Integer, Joueur> listJoueurs = GestionnaireJoueurs.getInstance().getListJoueursParId();
		
		for(Integer id :  Collections.list(listJoueurs.keys()))
		{
			
			Avatar avatar = GestionnaireJoueurs.getInstance().recupererAvatarParIdJoueur(id);
			
			if(avatar.isValide())
			{
				
				selectionsTerminees = true;
				
			}
			else
			{
				
				selectionsTerminees = false;
				
				break;
				
			}
			
		}
		
		return selectionsTerminees;
		
	}

}
>>>>>>> .r59
