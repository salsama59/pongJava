package mecanismes.implementations;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import managers.etat.GestionnaireChoixModeJeu;
import managers.etat.GestionnaireMatch;
import managers.etat.GestionnaireOptions;
import mecanismes.interfaces.LogicDeplacementsElements;
import constantes.ConstantesElements;
import constantes.ConstantesEtat;
import constantes.ConstantesJoueurs;
import elementGraphique.Texte;
import elementsJeu.Curseur;

public class LogicDeplacementsElementsCurseurImpl implements LogicDeplacementsElements 
{
	
	private Curseur element = null;
	
	private boolean bloqueDeplacement = false;
	
	public LogicDeplacementsElementsCurseurImpl(Curseur curseur)
	{
		this.setElement(curseur);
	}

	@Override
	public void gererDeplacements(int delta, String phase, GameContainer gameContainer)
	{
		
		if(element.isEnDeplacement())
		{
			
			if(!this.isBloqueDeplacement())
			{
				this.deplacerCuseur(element.getSens(), phase);
			}
			
			this.setBloqueDeplacement(true);
			
		}

	}

	@Override
	public void gererEtats(int key, char c, GameContainer gameContainer) 
	{
		
		switch (key) 
	    {
			
		 	case Input.KEY_UP:
		 	
		 	if(GestionnaireMatch.getInstance().getIdJoueurAvantage() == ConstantesJoueurs.JOUEUR_ID_1)
		 	{
		 		element.setEnDeplacement(true);
		        element.setSens(ConstantesElements.ELEMENT_SENS_HAUT);
		 	}
		 	
	        break;
	        
	        case Input.KEY_LEFT:
	        
        	if(GestionnaireMatch.getInstance().getIdJoueurAvantage() == ConstantesJoueurs.JOUEUR_ID_1)
		 	{
        		element.setEnDeplacement(true);
    	        element.setSens(ConstantesElements.ELEMENT_SENS_GAUCHE);
		 	}
        	
	        break;
	        
	        case Input.KEY_DOWN:
	        	
        	if(GestionnaireMatch.getInstance().getIdJoueurAvantage() == ConstantesJoueurs.JOUEUR_ID_1)
		 	{
        		element.setEnDeplacement(true);
    	        element.setSens(ConstantesElements.ELEMENT_SENS_BAS);
		 	}
        	
	        break;
	        
	        case Input.KEY_RIGHT:
	        
        	if(GestionnaireMatch.getInstance().getIdJoueurAvantage() == ConstantesJoueurs.JOUEUR_ID_1)
		 	{
        		element.setEnDeplacement(true);
    	        element.setSens(ConstantesElements.ELEMENT_SENS_DROITE);
		 	}
        	
	        break;
	        
	        case Input.KEY_Z:
	        
        	if(GestionnaireMatch.getInstance().getIdJoueurAvantage() == ConstantesJoueurs.JOUEUR_ID_2)
		 	{
        		element.setEnDeplacement(true);
    	        element.setSens(ConstantesElements.ELEMENT_SENS_HAUT);
		 	}
	        
	        break;
	        
	        case Input.KEY_Q:
	        
        	if(GestionnaireMatch.getInstance().getIdJoueurAvantage() == ConstantesJoueurs.JOUEUR_ID_2)
		 	{
        		element.setEnDeplacement(true);
    	        element.setSens(ConstantesElements.ELEMENT_SENS_GAUCHE);
		 	}
        	
	        break;
	        
	        case Input.KEY_W:
        	
        	if(GestionnaireMatch.getInstance().getIdJoueurAvantage() == ConstantesJoueurs.JOUEUR_ID_2)
		 	{
        		element.setEnDeplacement(true);
    	        element.setSens(ConstantesElements.ELEMENT_SENS_BAS);
		 	}
	        
	        break;
	        
	        case Input.KEY_S:
        	
        	if(GestionnaireMatch.getInstance().getIdJoueurAvantage() == ConstantesJoueurs.JOUEUR_ID_2)
		 	{
        		element.setEnDeplacement(true);
    	        element.setSens(ConstantesElements.ELEMENT_SENS_DROITE);
		 	}
        	
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
	        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
	        break;
	        
	        case Input.KEY_LEFT:
        	element.setEnDeplacement(false);
	        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
	        break;
	        
	        case Input.KEY_DOWN:
	        element.setEnDeplacement(false);
		    element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
	        break;
	        
	        case Input.KEY_RIGHT:
        	element.setEnDeplacement(false);
	        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
	        break;
	        
	        case Input.KEY_Z:
        	element.setEnDeplacement(false);
	        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
	        break;
	        
	        case Input.KEY_Q:
        	element.setEnDeplacement(false);
	        element.setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
	        break;
	        
	        case Input.KEY_W:
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
	
	private void deplacerCuseur(int sens, String phase)
	{
		
		Texte elementTextuelSuivant = null;
		
		Texte elementTextuelCourant = element.getConteneurAffectation().getElementsTextuel().get(element.getIndexCourant());
		
		int nombreElements = element.getConteneurAffectation().getElementsTextuel().size();
		
		int nouvelIndex = 0;
		
		
		switch(sens)
		{
		
			case ConstantesElements.ELEMENT_SENS_HAUT :
				
				if(element.getIndexCourant() == 0)
				{
					nouvelIndex = nombreElements - 1;
					elementTextuelSuivant = element.getConteneurAffectation().getElementsTextuel().get(nombreElements - 1);
				}
				else
				{
					nouvelIndex = element.getIndexCourant() - 1;
					elementTextuelSuivant = element.getConteneurAffectation().getElementsTextuel().get(nouvelIndex);
				}
				
			break;
				
			case ConstantesElements.ELEMENT_SENS_BAS :
				
				if(element.getIndexCourant() == nombreElements - 1)
				{
					nouvelIndex = 0;
					elementTextuelSuivant = element.getConteneurAffectation().getElementsTextuel().get(nouvelIndex);
				}
				else
				{
					nouvelIndex = element.getIndexCourant() + 1;
					elementTextuelSuivant = element.getConteneurAffectation().getElementsTextuel().get(nouvelIndex);
				}
				
			break;
				
			default :
				
				elementTextuelSuivant = elementTextuelCourant;
				nouvelIndex = element.getIndexCourant();
			break;
				
		}
		
		element.setCoordonneeY(elementTextuelSuivant.getCoordonneesY());
		element.setIndexCourant(nouvelIndex);
		
		this.miseAjourChoixJoueur(phase);
		
	}
	
	private void miseAjourChoixJoueur(String phase)
	{
		
		if(phase.equals(ConstantesEtat.ETAT_MATCH_PHASE_MISE_EN_JEU))
		{
			GestionnaireMatch.getInstance().miseAjourChoixMiseEnJeuJoueur(element.getIndexCourant());
		}
		else if(phase.equals(ConstantesEtat.ETAT_CHOIX_MODE_PHASE_SELECTION))
		{
			GestionnaireChoixModeJeu.getInstance().selectionnerMode(element.getIndexCourant());
		}
		else if(phase.equals(ConstantesEtat.ETAT_OPTIONS_PHASE_AFFICHAGE_GENERAL))
		{
			GestionnaireOptions.getInstance().selectionnerOption(element.getIndexCourant());
		}
		
	}

	public Curseur getElement() {
		return element;
	}

	public void setElement(Curseur element) {
		this.element = element;
	}

	public boolean isBloqueDeplacement() {
		return bloqueDeplacement;
	}

	public void setBloqueDeplacement(boolean bloqueDeplacement) {
		this.bloqueDeplacement = bloqueDeplacement;
	}

}
