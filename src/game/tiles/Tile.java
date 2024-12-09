package game.tiles;

import game.entities.GameObject;
import game.sprites.Sprite;

public abstract class Tile extends GameObject {
	
	public Tile() {
		super();
	}
	
	public Tile(Sprite sprite, int posX, int posY, float scaleX, float scaleY) {
		super(sprite, posX, posY, scaleX, scaleY);
	}
	
	
}
