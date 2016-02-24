package mecanismes.implementations;

import mecanismes.interfaces.LogicDeplacementsEtatsElementsJeu;
import constantes.ConstantesElements;
import elementsJeu.Curseur;

public class LogicDeplacementsEtatsElementsJeuCurseurImpl implements LogicDeplacementsEtatsElementsJeu 
{
	
	private Curseur element = null;
	
	public LogicDeplacementsEtatsElementsJeuCurseurImpl(Curseur curseur)
	{
		this.setElement(curseur);
	}

	@Override
	public void gererDeplacements(int delta) 
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
			
		}

	}

	@Override
	public void gererEtats(int key, char c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reinitialisationEtat(int key, char c) {
		// TODO Auto-generated method stub

	}

	public Curseur getElement() {
		return element;
	}

	public void setElement(Curseur element) {
		this.element = element;
	}

}
