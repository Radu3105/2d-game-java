package game.managers;

import java.awt.Graphics;

import game.Game;
import game.sprites.Sprite;
import game.sprites.SpriteSheet;
import game.tiles.GrassTile;

public class TilesManager {
	private SpriteSheet spriteSheet;
	private GameObjectsManager gameObjectsManager;
	
	public TilesManager(SpriteSheet spriteSheet, GameObjectsManager gameObjectsManager) {
		this.spriteSheet = spriteSheet;
		this.gameObjectsManager = gameObjectsManager;
		
		generateTiles();
	}
	
	public void generateTiles() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				gameObjectsManager.add(new GrassTile(new Sprite(spriteSheet, 16, 16, 16, 16), j * 16 * Game.ZOOM_SCALE, i * 16 * Game.ZOOM_SCALE, 1f, 1f));
			}
		}
	}
	
	public void render(Graphics g) {
		
	}
}
