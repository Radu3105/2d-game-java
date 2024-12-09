package game.entities;

import java.awt.Graphics;

import game.BoxCollider;
import game.Game;
import game.sprites.Sprite;

public abstract class GameObject {
	protected int posX, posY;
	protected float scaleX, scaleY;
	protected Sprite sprite;
	protected BoxCollider boxCollider;
	
	public GameObject() {
		this.posX = 0;
		this.posY = 0;
	}
	
	public GameObject(int posX, int posY, float scaleX, float scaleY) {
		this();
		this.posX = posX;
		this.posY = posY;
		this.scaleX = scaleX;
		this.scaleY = scaleY;
	}
	
	public GameObject(Sprite sprite, int posX, int posY, float scaleX, float scaleY) {
		this(posX, posY, scaleX, scaleY);
		this.sprite = sprite;
	}
	
	public void render(Graphics g) {
		if (sprite != null) {
			sprite.render(g, posX, posY, scaleX * Game.ZOOM_SCALE, scaleY * Game.ZOOM_SCALE);
		}
	}
	
	public void renderBoxCollider(Graphics g) {
		boxCollider.render(g);
	}
	
	public void update() {
		if (boxCollider != null) {
			updateBoxCollider();
		}
	}
	
	public void updateBoxCollider() {
		boxCollider.update(this);
	}
	
	public void addBoxCollider() {
		if (boxCollider == null) {
			boxCollider = new BoxCollider(this);
		}
	}
	
	public abstract void handleCollision(GameObject other);
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public float getScaleX() {
		return scaleX;
	}
	
	public float getScaleY() {
		return scaleY;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public void setBoxCollider(int posX, int posY, int width, int height) {
		
	}
	
	public BoxCollider getBoxCollider() {
		return boxCollider;
	}
}
