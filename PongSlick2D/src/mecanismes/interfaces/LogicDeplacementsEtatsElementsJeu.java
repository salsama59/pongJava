package mecanismes.interfaces;

public interface LogicDeplacementsEtatsElementsJeu
{
	public abstract void gererDeplacements(int delta);
	public abstract void gererEtats(int key, char c);
	public abstract void reinitialisationEtat(int key, char c);
}
