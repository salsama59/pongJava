package etatsJeu.interfaces;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public interface EtatJeu 
{
	public void creerMenu(GameContainer gameContainer);
	public void initialiserElements(GameContainer gameContainer) throws SlickException;
	public void initialiserGestionnaires();
	public void initialiserMecanisme();
}
