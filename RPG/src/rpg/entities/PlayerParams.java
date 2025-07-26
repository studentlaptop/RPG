package rpg.entities;

import rpg.swing.GamePanel;
import rpg.swing.KeyHandler;

public class PlayerParams extends EntityParams{
	private GamePanel gamePanel;
	private KeyHandler playerMovementHandler;
	
	@Override
	public PlayerParams gamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		return this;
	}
	
	@Override
	public PlayerParams playerMovementHandler(KeyHandler playerMovementHandler) {
		this.playerMovementHandler = playerMovementHandler;
		return this;
	}
	
	public GamePanel getGamePanel() {
		return gamePanel;
	}
	
	public KeyHandler getPlayerMovementHandler() {
		return playerMovementHandler;
	}
}
