package mecanismes.implementations;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import managers.etat.GestionnaireChoixModeJeu;
import managers.etat.GestionnaireMatch;
import mecanismes.interfaces.LogicDeplacementsElements;
import constantes.ConstantesElements;
import constantes.ConstantesEtat;
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
		Input entree = new Input(key);
		
		switch (key) 
	    {
		 	case Input.KEY_UP:
	        element.setEnDeplacement(true);
	        element.setSens(ConstantesElements.ELEMENT_SENS_HAUT);
	        break;
	        
	        case Input.KEY_LEFT:
        	element.setEnDeplacement(true);
	        element.setSens(ConstantesElements.ELEMENT_SENS_GAUCHE);
	        this.setBloqueDeplacement(true);
	        break;
	        
	        case Input.KEY_DOWN:
	        element.setEnDeplacement(true);
	        element.setSens(ConstantesElements.ELEMENT_SENS_BAS);
	        break;
	        
	        case Input.KEY_RIGHT:
        	element.setEnDeplacement(true);
	        element.setSens(ConstantesElements.ELEMENT_SENS_DROITE);
	        this.setBloqueDeplacement(true);
	        break;
	        
	    }

	}

	@Override
	public void reinitialisationEtat(int key, char c) 
	{
		
		Input entree = new Input(key);
		
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
