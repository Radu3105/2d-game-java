package game.managers;

import java.awt.Graphics;
import game.sprites.SpriteSheet;

public class GameManager {
	private GameObjectsManager gameObjectsManager;
	private CollisionDetectionManager collisionDetectionManager;
	private SpawnManager spawnManager;
	private SpriteSheet spriteSheet;
	private TilesManager tilesManager;
	
	public GameManager(SpriteSheet spriteSheet) {
		this.spriteSheet = spriteSheet;
		gameObjectsManager = new GameObjectsManager();
		collisionDetectionManager = new CollisionDetectionManager(gameObjectsManager);
		spawnManager = new SpawnManager(gameObjectsManager, spriteSheet);
		tilesManager = new TilesManager(spriteSheet, gameObjectsManager);
	}
	
	public GameManager(SpriteSheet spriteSheet, GameObjectsManager gameObjectsManager, CollisionDetectionManager collisionDetectionManager, SpawnManager spawnManager, TilesManager tilesManager) {
		this.spriteSheet = spriteSheet;
		this.gameObjectsManager = gameObjectsManager;
		this.collisionDetectionManager = collisionDetectionManager;
		this.spawnManager = spawnManager;
		this.tilesManager = tilesManager;
		
		// spawn player here?
	}
	
	public void updateManagers() {
		gameObjectsManager.updateAll();
		collisionDetectionManager.update();
	}
	
	public void renderGameObjects(Graphics g) {
		gameObjectsManager.renderAll(g);
//		tilesManager.render(g);
	}
	
	public GameObjectsManager getGameObjectsManager() {
		return gameObjectsManager;
	}
	
	public CollisionDetectionManager getCollisionDetectionManager() {
		return collisionDetectionManager;
	}
	
	public SpawnManager getSpawnManager() {
		return spawnManager;
	}
	
	public SpriteSheet getSpriteSheet() {
		return spriteSheet;
	}
}
