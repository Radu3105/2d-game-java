package game.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game.PlayerController;
import game.managers.GameObjectsManager;
import game.managers.SpawnManager;
import game.sprites.Sprite;

public class Player extends GameObject {
	public enum PlayerDirection {
		UP,
		RIGHT,
		DOWN,
		LEFT
	}
	
	private int speed = 10;
	private PlayerController playerController;	
	private PlayerDirection playerDirection;
	private GameObjectsManager gameObjectsManager;
	private SpawnManager spawnManager;
	private boolean upPressed, downPressed, leftPressed, rightPressed;
	private Sprite[] directionalSprites;
	private Map<PlayerDirection, Sprite> spritePlayerDirectionMap;
	
	public Player() {
		super();
	
		playerController = new PlayerController(this);
		playerDirection = PlayerDirection.DOWN;
	}
	
	public Player(GameObjectsManager gameObjectsManager, SpawnManager spawnManager, Sprite[] directionalSprites, int posX, int posY, int scaleX, int scaleY) {
		super(posX, posY, scaleX, scaleY);
		
		this.gameObjectsManager = gameObjectsManager;
		this.spawnManager = spawnManager;
		playerController = new PlayerController(this);
		initDirectionalSprites(directionalSprites);
		sprite = spritePlayerDirectionMap.get(PlayerDirection.DOWN);
	}
	
	@Override
	public void update() {
		super.update();
		
		if (upPressed) {
			moveUp();
		}
		if (downPressed) {
			moveDown();
		}
		if (rightPressed) {
			moveRight();
		}
		if (leftPressed) {
			moveLeft();
		}
	}
	
	@Override
	public void handleCollision(GameObject other) {
		if (other instanceof Apple) {
			System.out.println("Player collided with apple");
			gameObjectsManager.remove(other);
			spawnManager.spawnApple();
		}
	}
	
	private void initDirectionalSprites(Sprite[] directionalSprites) {
		if (directionalSprites == null || directionalSprites.length != 4) {
			throw new Error("Error with directional sprites!");
		}
		this.directionalSprites = directionalSprites;
		spritePlayerDirectionMap = new HashMap<PlayerDirection, Sprite>() {{
			put(PlayerDirection.UP, directionalSprites[0]);
			put(PlayerDirection.RIGHT, directionalSprites[1]);
			put(PlayerDirection.DOWN, directionalSprites[2]);
			put(PlayerDirection.LEFT, directionalSprites[3]);
		}};
	}
	
	public void moveUp() {
		playerDirection = PlayerDirection.UP;
		posY -= speed;
		sprite = spritePlayerDirectionMap.get(playerDirection);
	}
	
	public void moveDown() {
		playerDirection = PlayerDirection.DOWN;
		posY += speed;
		sprite = spritePlayerDirectionMap.get(playerDirection);
	}
	
	public void moveLeft() {
		playerDirection = PlayerDirection.LEFT;
		posX -= speed;
		sprite = spritePlayerDirectionMap.get(playerDirection);
	}
	
	public void moveRight() {
		playerDirection = PlayerDirection.RIGHT;
		posX += speed;
		sprite = spritePlayerDirectionMap.get(playerDirection);
	}
	
	public PlayerController getPlayerController() {
		return playerController;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setDirection(PlayerDirection direction) {
		playerDirection = direction;
	}
	
	public void setUpPressed(boolean upPressed) {
		this.upPressed = upPressed;
	}
	
	public boolean getUpPressed() {
		return upPressed;
	}
	
	public void setDownPressed(boolean downPressed) {
		this.downPressed = downPressed;
	}
	
	public boolean getDownPressed() {
		return downPressed;
	}
	
	public void setRightPressed(boolean rightPressed) {
		this.rightPressed = rightPressed;
	}
	
	public boolean getRightPressed() {
		return rightPressed;
	}
	
	public void setLeftPressed(boolean leftPressed) {
		this.leftPressed = leftPressed;
	}
	
	public boolean getLeftPressed() {
		return leftPressed;
	}
}
