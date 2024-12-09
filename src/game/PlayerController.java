package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.entities.Player;

public class PlayerController implements KeyListener {
	private Player player;
	
	public PlayerController(Player player) {
		this.player = player;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_W:
				player.setUpPressed(true);
				break;
			case KeyEvent.VK_S:
				player.setDownPressed(true);
				break;
			case KeyEvent.VK_D:
				player.setRightPressed(true);
				break;
			case KeyEvent.VK_A:
				player.setLeftPressed(true);
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_W:
				player.setUpPressed(false);
				break;
			case KeyEvent.VK_S:
				player.setDownPressed(false);
				break;
			case KeyEvent.VK_D:
				player.setRightPressed(false);
				break;
			case KeyEvent.VK_A:
				player.setLeftPressed(false);
				break;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) { }
}
