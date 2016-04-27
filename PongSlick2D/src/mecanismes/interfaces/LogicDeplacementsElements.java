package mecanismes.interfaces;

import org.newdawn.slick.GameContainer;

public interface LogicDeplacementsElements
{
	public abstract void gererDeplacements(int delta,String phase, GameContainer gameContainer);
	public abstract void gererEtats(int key, char c, GameContainer gameContainer);
	public abstract void reinitialisationEtat(int key, char c);
}
