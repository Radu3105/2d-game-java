package game.managers;

import java.util.List;

import game.entities.GameObject;

public class CollisionDetectionManager {
	private GameObjectsManager gameObjectsManager;
	
	public CollisionDetectionManager(GameObjectsManager gameObjectsManager) {
		this.gameObjectsManager = gameObjectsManager;
	}
	
	public void update() {
		detectCollisions();
	}
	
	private void detectCollisions() {
		List<GameObject> gameObjects = gameObjectsManager.getGameObjects();
		for (int i = 0; i < gameObjects.size(); i++) {
			GameObject first = gameObjects.get(i);
			if (first.getBoxCollider() == null) {
				continue;
			}
			for (int j = i + 1; j < gameObjects.size(); j++) {
				GameObject second = gameObjects.get(j);
				if (second.getBoxCollider() == null) {
					continue;
				}
				if (first != second) {
					if (first.getBoxCollider().intersects(second.getBoxCollider())) {
						first.handleCollision(second);
						second.handleCollision(first);
					}
				}
			}
		}
	}
}
