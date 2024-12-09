package game.managers;
import java.util.Random;

import game.Game;
import game.PlayerController;
import game.entities.Apple;
import game.entities.GameObject;
import game.entities.Player;
import game.sprites.Sprite;
import game.sprites.SpriteSheet;

public class SpawnManager {
	private GameObjectsManager gameObjectsManager;
	private SpriteSheet spriteSheet;

    public SpawnManager(GameObjectsManager gameObjectsManager, SpriteSheet spriteSheet) {
    	this.gameObjectsManager = gameObjectsManager;
    	this.spriteSheet = spriteSheet;
    }

    protected static <T extends GameObject> T spawn(Class<T> clazz, int x, int y) {
        try {
            T instance = clazz.getConstructor(int.class, int.class).newInstance(x, y);
            return instance;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Player spawnPlayer() {
	    GameObject player = new Player(gameObjectsManager, this, new Sprite[] {new Sprite(spriteSheet, 0, 0, 16, 16), new Sprite(spriteSheet, 16, 0, 16, 16), new Sprite(spriteSheet, 32, 0, 16, 16), new Sprite(spriteSheet, 48, 0, 16, 16)}, 0, 0, 1, 1);
	    player.addBoxCollider();
	    gameObjectsManager.add(player);
	    return (Player) player;
    }
    
    public Apple spawnApple() {
	    GameObject apple = new Apple(new Sprite(spriteSheet, 0, 16, 16, 16), new Random().nextInt(Game.WIDTH - 16 * Game.ZOOM_SCALE), new Random().nextInt(Game.HEIGHT - 16 * Game.ZOOM_SCALE), .75f, .75f);
	    apple.addBoxCollider();
	    gameObjectsManager.add(apple);
	    return (Apple) apple;
    }
}
