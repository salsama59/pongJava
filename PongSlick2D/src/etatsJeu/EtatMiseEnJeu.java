package etatsJeu;

import java.util.ArrayList;
import java.util.List;

import mecanismes.implementations.LogicDeplacementsEtatsElementsJeuCurseurImpl;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import constantes.ConstantesElements;
import constantes.ConstantesEtat;
import elementGraphique.Conteneur;
import elementGraphique.Texte;
import elementsJeu.Curseur;

public class EtatMiseEnJeu extends BasicGameState 
{
	
	public static final int ID = ConstantesEtat.ETAT_MISE_EN_JEU;
	private StateBasedGame jeu;
	//private Rectangle r;
	private Curseur curseur;
	private Conteneur conteneur;
	private Texte texte1;
	private Texte texte2;
	private LogicDeplacementsEtatsElementsJeuCurseurImpl logicDeplacementCurseur;

	@Override
	public void init(GameContainer gameContainer, StateBasedGame jeu) throws SlickException 
	{
		this.setJeu(jeu);
		//r = new Rectangle((gameContainer.getWidth()/2) - 150, (gameContainer.getHeight()/2) - 40, 300, 100);
		conteneur = new Conteneur((gameContainer.getWidth()/2) - 150, (gameContainer.getHeight()/2) - 40);
		curseur = new Curseur(ConstantesElements.ELEMENT_CURSEUR_NOM, false, ConstantesElements.ELEMENT_CURSEUR_TYPE, conteneur.getCentreX() + 130 - 30, conteneur.getCentreY() + 40);
		logicDeplacementCurseur = new LogicDeplacementsEtatsElementsJeuCurseurImpl(curseur);
		texte1 = new Texte("PILE", 0, 0, conteneur, gameContainer);
		texte2 = new Texte("FACE", 0, 0, conteneur, gameContainer);
		List<Texte> list = new ArrayList<Texte>();
		list.add(texte1);
		list.add(texte2);
		conteneur.setElementsTextuel(list);
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame jeu, Graphics graphisme) throws SlickException 
	{
		graphisme.draw(conteneur.getElement());
		texte1.getElement().render((GUIContext)gameContainer, graphisme);
		/*graphisme.draw(r);
		graphisme.draw(curseur.getElement());
		graphisme.drawString("Veuillez choisir!", r.getX() + 80, r.getY() + 20);
		graphisme.drawString("PILE", r.getX() + 130, r.getY() + 40);
		graphisme.drawString("FACE", r.getX() + 130, r.getY() + 60);*/
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
