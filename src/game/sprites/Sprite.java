package game.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Sprite {
	private SpriteSheet spriteSheet;
	private BufferedImage image;
	private int width;
	private int height;
	
	public Sprite(SpriteSheet spriteSheet, int spriteSheetposX, int spriteSheetposY, int width, int height) {
		this.width = width;
		this.height = height;
		this.spriteSheet = spriteSheet;
		image = this.spriteSheet.getSprite(spriteSheetposX, spriteSheetposY, width, height);
	}
	
	public void render(Graphics g, int posX, int posY, float scaleX, float scaleY) {
		g.drawImage(image, posX, posY, (int)(width * scaleX), (int)(height * scaleY), null);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
