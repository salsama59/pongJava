package managers.collisions;

import java.util.Collection;
import java.util.Hashtable;

import constantes.ConstantesElements;
import elementsJeu.Balle;
import elementsJeu.Element;
import elementsJeu.Mur;
import elementsJeu.Raquette;

public class GestionnaireCollisionsRaquette extends GestionnaireCollisions 
{
	
	private  Raquette elementGere;

	public GestionnaireCollisionsRaquette(Raquette elementAgerer, Hashtable<String, Element> elements) 
	{
		super(elements);
		this.setElementGere(elementAgerer);
	}

	@Override
	public void gererCollision(int delta) 
	{
		
		boolean collisionDetectee = false;
		
		Collection<Element> listeElementEnJeu = this.getElementsExistant().values();
		
		for(Element element : listeElementEnJeu)
		{
			
			if(element instanceof Mur)
			{
				collisionDetectee = this.getElementGere().getElement().intersects(((Mur) element).getElement());
			}
			else if(element instanceof Balle)
			{
				collisionDetectee = this.getElementGere().getElement().intersects(((Balle) element).getElement());
			}
			else
			{
				this.setEnCollision(collisionDetectee);
				this.getElementGere().setEnCollision(collisionDetectee);
				continue;
			}
			
			if(!this.isEnCollision())
			{
				
				if(collisionDetectee)
				{
					
					this.setIdElementEnCollision(element.getIdElement());
					
					if(element instanceof Mur)
					{
						
						if(this.getElementGere().getSens() == ConstantesElements.ELEMENT_SENS_HAUT)
						{
							
							if(((Mur)element).getNomElement() == ConstantesElements.ELEMENT_MUR1_NOM)
							{
								this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
								this.getElementGere().setEnDeplacement(false);
								this.getElementGere().setCoordonneeY(this.getElementGere().getCoordonneeY() + (this.getElementGere().getVitesse() * delta));
							}
							
						}
						else if(this.getElementGere().getSens() == ConstantesElements.ELEMENT_SENS_BAS)
						{
							
							if(((Mur)element).getNomElement() == ConstantesElements.ELEMENT_MUR2_NOM)
							{
								this.getElementGere().setSens(ConstantesElements.ELEMENT_SENS_NEUTRE);
								this.getElementGere().setEnDeplacement(false);
								this.getElementGere().setCoordonneeY(this.getElementGere().getCoordonneeY() - (this.getElementGere().getVitesse() * delta));
							}
							
						}
						
					}
					else if(element instanceof Balle)
					{
						
						if(this.getElementGere().getSens() == ConstantesElements.ELEMENT_SENS_HAUT)
						{
							if(detecterCollisionSpecialeBallePlat((Balle)element))
							{
								this.getElementGere().setCoordonneeY(this.getElementGere().getCoordonneeY() + (this.getElementGere().getVitesse() * delta));
								((Balle) element).setCentreY(((Balle) element).getCentreY() - (((Balle) element).getVitesse() * delta));
							}
							
						}
						else if(this.getElementGere().getSens() == ConstantesElements.ELEMENT_SENS_BAS)
						{
							if(detecterCollisionSpecialeBallePlat((Balle)element))
							{
								this.getElementGere().setCoordonneeY(this.getElementGere().getCoordonneeY() - (this.getElementGere().getVitesse() * delta));
								((Balle) element).setCentreY(((Balle) element).getCentreY() + (((Balle) element).getVitesse() * delta));
							}
							
						}
						
					}
				}
			}
			
			this.setEnCollision(collisionDetectee);
			this.getElementGere().setEnCollision(collisionDetectee);
		}
	}

	public Raquette getElementGere() 
	{
		return elementGere;
	}

	public void setElementGere(Raquette elementGere) 
	{
		this.elementGere = elementGere;
	}
	
	private boolean detecterCollisionSpecialeBallePlat(Balle balle)
	{
		
		float coordonneesBalleY = balle.getCentreY();
		float coordonneesRaquetteY = this.getElementGere().getCoordonneeY();
		float hauteurRaquette = this.getElementGere().getHauteur();
		boolean casSpecial = false;
			
		if(coordonneesBalleY < coordonneesRaquetteY)
		{
			casSpecial = true;
		}
		else if(coordonneesBalleY > (coordonneesRaquetteY + hauteurRaquette))
		{
			casSpecial = true;
		}
			
		return casSpecial;
		
	}

}
