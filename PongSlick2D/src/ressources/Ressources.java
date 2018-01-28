package ressources;

import java.util.HashMap;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;

public class Ressources 
{
	private HashMap<String, Sound>  sons;
	private HashMap<String, Image>  images;
	private static HashMap<String, SpriteSheet>  sprites;
	
	public Ressources()
	{
		sons = new HashMap<String, Sound>();
		images = new HashMap<String, Image>();
		sprites = new HashMap<String, SpriteSheet>();
		
		try 
		{
			sprites.put("test", chargerSprite("C:\\Users\\Rosemonde\\Desktop\\Balle.jpeg", 1024, 768));
		} 
		catch (SlickException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static Image chargerImage(String path) throws SlickException
	{
		return new Image(path, false, Image.FILTER_NEAREST);
	}
	
	public static SpriteSheet chargerSprite(String path, int largeur, int hauteur) throws SlickException
	{
		return new SpriteSheet(chargerImage(path), largeur, hauteur);
	}
	
	public static Image getSpriteImage(String cle, int x, int y)
	{
		return sprites.get(cle).getSubImage(x, y);
	}
	
	public SpriteSheet getSprite(String cle)
	{
		return sprites.get(cle);
	}
	
	public Image getImage(String cle)
	{
		return images.get(cle);
	}
	
	public Sound getSound(String cle)
	{
		return sons.get(cle);
	}

}
