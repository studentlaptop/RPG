package rpg.entities;

import rpg.swing.GamePanel;
import rpg.swing.KeyHandler;

public class EntityParams {
	private String name;
	private int speed;
	private int attack;
	private int hp;
	private GamePanel gamePanel;
	private KeyHandler playerMovementHandler;
	
	public EntityParams name(String name) {
		this.name = name;
		return this;
	}
	
	public EntityParams speed(int speed) {
		this.speed = speed;
		return this;
	}
	
	public EntityParams attack(int attack) {
		this.attack = attack;
		return this;
	}
	
	public EntityParams hp(int hp) {
		this.hp = hp;
		return this;
	}
	
	public EntityParams gamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		return this;
	}
	
	public EntityParams playerMovementHandler(KeyHandler playerMovementHandler) {
		this.playerMovementHandler = playerMovementHandler;
		return this;
	}
	
	
	public String getName() {
		return name;
	}

	public int getSpeed() {
		return speed;
	}

	public int getAttack() {
		return attack;
	}
	
	public int getHp() {
		return hp;
	}
	
	public GamePanel getGamePanel() {
		return gamePanel;
	}
	
	public KeyHandler getPlayerMovementHandler() {
		return playerMovementHandler;
	}
}