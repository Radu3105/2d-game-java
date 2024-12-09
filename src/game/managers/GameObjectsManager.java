package game.managers;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import game.entities.GameObject;

public class GameObjectsManager {
	private List<GameObject> gameObjects;
	
	public GameObjectsManager() {
		gameObjects = new ArrayList<GameObject>();
	}
	
	public GameObjectsManager(List<GameObject> gameObjects) {
		this.gameObjects = gameObjects;
	}
	
	public void updateAll() {
		for (GameObject go : gameObjects) {
			go.update();
		}
	}
	
	public void renderAll(Graphics g) {
		for (GameObject go : gameObjects) {
			go.render(g);
			
			// Uncomment to visualize collision boxes
//			go.renderBoxCollider(g); 
		}	
	}
	
	public void addList(List<GameObject> gameObjects) {	
		this.gameObjects = gameObjects;
	}
	
	public void add(GameObject go) {
		if (gameObjects == null) {
			gameObjects = new ArrayList<GameObject>();
		}
		gameObjects.add(go);
	}
	
	public void remove(GameObject go) {
		gameObjects.remove(go);
	}
	
	public void removeAt(int goIndex) {
		gameObjects.remove(goIndex);
	}
	
	public List<GameObject> getGameObjects() {
		return gameObjects;
	}
}
