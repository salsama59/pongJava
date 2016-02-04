package etatsJeu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import constantes.ConstantesEtat;

public class EtatMiseEnJeu extends BasicGameState 
{
	
	public static final int ID = ConstantesEtat.ETAT_MISE_EN_JEU;
	private StateBasedGame jeu;
	private Rectangle r;
	private Polygon p;

	@Override
	public void init(GameContainer gameContainer, StateBasedGame jeu) throws SlickException 
	{
		// TODO Auto-generated method stub
		this.setJeu(jeu);
		r = new Rectangle((gameContainer.getWidth()/2) - 150, (gameContainer.getHeight()/2) - 40, 300, 100);
		p = new Polygon(new float[]{0f,0f,0f,15f,15f,7.5f});
		p.setX(r.getX() + 130 - 30);
		p.setY(r.getY() + 40);
		
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame jeu, Graphics graphisme) throws SlickException 
	{
		graphisme.draw(r);
		graphisme.draw(p);
		graphisme.drawString("Veuillez choisir!", r.getX() + 80, r.getY() + 20);
		graphisme.drawString("PILE", r.getX() + 130, r.getY() + 40);
		graphisme.drawString("FACE", r.getX() + 130, r.getY() + 60);
		// TODO Auto-generated method stub
	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame jeu, int delta) throws SlickException 
	{
		// TODO Auto-generated method stub
	}
	
	@Override
	public void keyReleased(int key, char c) 
	{
	    this.getJeu().enterState(EtatMatch.ID);
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
