package game.entities;

import game.sprites.Sprite;

public class Apple extends GameObject {
	public Apple() {
		super();
	}
	
	public Apple(Sprite sprite, int posX, int posY, float scaleX, float scaleY) {
		super(sprite, posX, posY, scaleX, scaleY);
	}
	
	@Override
	public void update() {
		
	}
	
	@Override
	public void handleCollision(GameObject other) {
		
	}
}
