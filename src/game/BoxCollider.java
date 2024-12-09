package game;

import java.awt.Color;
import java.awt.Graphics;

import game.entities.GameObject;

public class BoxCollider {
	private int posX, posY;
	private float scaleX, scaleY;
	private int spriteWidth, spriteHeight;
	
	public BoxCollider(GameObject gameObject) {
		posX = gameObject.getPosX();
		posY = gameObject.getPosY();
		scaleX = gameObject.getScaleX();
		scaleY = gameObject.getScaleY();
		spriteWidth = gameObject.getSprite().getWidth();
		spriteHeight = gameObject.getSprite().getHeight();
		update(gameObject);
	}
	
	public void update(GameObject gameObject) {
		posX = gameObject.getPosX();
		posY = gameObject.getPosY();
		scaleX = gameObject.getScaleX();
		scaleY = gameObject.getScaleY();
	}
	
	public void render(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.drawRect(posX, posY, (int)(spriteWidth * scaleX * Game.ZOOM_SCALE), (int)(spriteHeight * scaleY * Game.ZOOM_SCALE));
	}
	
	public boolean intersects(BoxCollider other) {
	    int thisWidth = (int) (spriteWidth * scaleX * Game.ZOOM_SCALE);
	    int thisHeight = (int) (spriteHeight * scaleY * Game.ZOOM_SCALE);
	    int otherWidth = (int) (other.spriteWidth * other.scaleX * Game.ZOOM_SCALE);
	    int otherHeight = (int) (other.spriteHeight * other.scaleY * Game.ZOOM_SCALE);

	    return posX < other.posX + otherWidth &&
	           posX + thisWidth > other.posX &&
	           posY < other.posY + otherHeight &&
	           posY + thisHeight > other.posY;
	}
	
	public void set(int posX, int posY, float scaleX, float scaleY) {
		this.posX = posX;
		this.posY = posY;
		this.scaleX = scaleX;
		this.scaleY = scaleY;
	}
}
