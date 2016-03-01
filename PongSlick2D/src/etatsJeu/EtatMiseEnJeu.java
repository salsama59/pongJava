package etatsJeu;

import mecanismes.implementations.LogicDeplacementsEtatsElementsJeuCurseurImpl;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import constantes.ConstantesElements;
import constantes.ConstantesEtat;
import elementGraphique.Conteneur;
import elementsJeu.Curseur;

public class EtatMiseEnJeu extends BasicGameState 
{
	
	public static final int ID = ConstantesEtat.ETAT_MISE_EN_JEU;
	private StateBasedGame jeu;
	private Rectangle r;
	private Curseur curseur;
	private Conteneur conteneur;
	private LogicDeplacementsEtatsElementsJeuCurseurImpl logicDeplacementCurseur;

	@Override
	public void init(GameContainer gameContainer, StateBasedGame jeu) throws SlickException 
	{
		this.setJeu(jeu);
		r = new Rectangle((gameContainer.getWidth()/2) - 150, (gameContainer.getHeight()/2) - 40, 300, 100);
		curseur = new Curseur(ConstantesElements.ELEMENT_CURSEUR_NOM, false, ConstantesElements.ELEMENT_CURSEUR_TYPE, r.getX() + 130 - 30, r.getY() + 40);
		logicDeplacementCurseur = new LogicDeplacementsEtatsElementsJeuCurseurImpl(curseur);
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame jeu, Graphics graphisme) throws SlickException 
	{
		graphisme.draw(r);
		graphisme.draw(curseur.getElement());
		graphisme.drawString("Veuillez choisir!", r.getX() + 80, r.getY() + 20);
		graphisme.drawString("PILE", r.getX() + 130, r.getY() + 40);
		graphisme.drawString("FACE", r.getX() + 130, r.getY() + 60);
	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame jeu, int delta) throws SlickException 
	{
		logicDeplacementCurseur.gererDeplacements(delta);
	}
	
	@Override
	public void keyPressed(int key, char c) 
	{
		logicDeplacementCurseur.gererEtats(key, c);
	}
	
	@Override
	public void keyReleased(int key, char c) 
	{
		Input entree = new Input(key);
		
		switch (key) 
	    {
		 	case Input.KEY_RETURN:
		 	this.getJeu().enterState(EtatMatch.ID);
	        break;
	    }
		
		logicDeplacementCurseur.reinitialisationEtat(key, c);
	    
	}

	@Override
	public int getID() 
	{
		// TODO Auto-generated method stub
		return ID;
	}

	public StateBasedGame getJeu() {
		return jeu;
	}

	public void setJeu(StateBasedGame jeu) {
		this.jeu = jeu;
	}

}
