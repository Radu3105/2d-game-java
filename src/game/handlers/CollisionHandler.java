package game.handlers;

import game.entities.Apple;
import game.entities.GameObject;
import game.entities.Player;
import game.managers.GameObjectsManager;

public class CollisionHandler {
	private GameObjectsManager gameObjectManager;
	
	public CollisionHandler(GameObjectsManager gameObjectManager) {
		this.gameObjectManager = gameObjectManager;
	}
	
	public void handleCollision(GameObject first, GameObject second) {
		if (first instanceof Player && second instanceof Apple) {
			handlePlayerAppleCollision((Player) first, (Apple) second);
        } else if (second instanceof Player && first instanceof Apple) {
        	handlePlayerAppleCollision((Player) second, (Apple) first);
        }
	}
	
	public void handlePlayerAppleCollision(Player player, Apple apple) {
//		gameObjectManager.remove(apple);
//		gameObjectManager.spawn();
	}
	
//	public void handlePlayerCollectableCollision(Player player, ICollectable collectable) {
//		
//	}
}
