package game;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import game.entities.GameObject;
import game.entities.Player;
import game.managers.GameManager;
import game.sprites.Sprite;
import game.sprites.SpriteSheet;
import game.tiles.GrassTile;
import game.tiles.Tile;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	public static final String TITLE = "Game Prototype";
	public static final int HEIGHT = 1024;
	public static final int WIDTH = HEIGHT * 4 / 3;
	public static int ZOOM_SCALE = 5;
	private boolean isRunning;
	private JFrame frame;
	private SpriteSheet spriteSheet;
	private GameManager gameManager;
	
	private Tile grassTile;
	
	public Game() {
		initFrame();
		initCanvas();
		
		spriteSheet = new SpriteSheet("/res/spritesheet1.png");    
	    gameManager = new GameManager(spriteSheet);

	    // draw tiles
	    grassTile = new GrassTile(new Sprite(spriteSheet, 16, 16, 16, 16), 100, 100, 1f, 1f);
	    gameManager.getGameObjectsManager().add(grassTile);
	    
	    // spawn player and an apple when the game starts
	    GameObject player = gameManager.getSpawnManager().spawnPlayer();
	    gameManager.getSpawnManager().spawnApple();
	    
	    
	    // this refers to Canvas, not JFrame
	    this.setFocusable(true);
		this.addKeyListener(((Player)player).getPlayerController());
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double unprocessed = 0.0;
		double timePerTick = 1000000000.0 / 60.0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		int ticks = 0;
		
		while(isRunning) {
			long currentTime = System.nanoTime();
			unprocessed += (currentTime - lastTime) / timePerTick;
			lastTime = currentTime;
			while(unprocessed >= 1) {
				update();
				ticks++;
				unprocessed--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer >= 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames + " | Ticks: " + ticks);
                frames = 0;
                ticks = 0;
            }
		}
		stop();
	}
	
	public void start() {
		isRunning = true;
		new Thread(this).start();
	}
	
	public void stop() {
		isRunning = false;
	}
	
	public void update() {
		gameManager.updateManagers();
	}
	
	public void render() {
		BufferStrategy bufferStrategy = getBufferStrategy();
		if (bufferStrategy == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bufferStrategy.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// render here
		// ===========
		gameManager.renderGameObjects(g);
		// ===========
		
		g.dispose();
		bufferStrategy.show();
	}
	
	public void initFrame() {
		frame = new JFrame(TITLE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.add(this);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void initCanvas() {
		this.setBackground(Color.BLACK);
		this.setSize(WIDTH, HEIGHT);
	}
}
