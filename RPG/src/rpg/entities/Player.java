package rpg.entities;

import rpg.swing.GamePanel;
import rpg.swing.KeyHandler;

public class Player extends Entity {
	private GamePanel gamePanel;
	private KeyHandler playerMovementDirection;
	
	public Player(EntityParams params) {
		super(params);
		this.gamePanel = params.getGamePanel();
		this.playerMovementDirection = params.getPlayerMovementDirection();
	}
	
	public void setDefaultValues() {
		int playerX = getXPos();
		int playerY = getYPos();
		int playerMovementSpeed = getMovementSpeed();
		
		playerX = 100;
		playerY = 100;
		playerMovementSpeed = 2;
	}
	
	
}