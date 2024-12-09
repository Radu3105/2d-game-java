package game.tiles;

import game.entities.GameObject;
import game.sprites.Sprite;

public class GrassTile extends Tile {
	public GrassTile(Sprite sprite, int posX, int posY, float scaleX, float scaleY) {
		super(sprite, posX, posY, scaleX, scaleY);
	}
	
	@Override
	public void handleCollision(GameObject other) {
		// TODO Auto-generated method stub
		
	}

}
