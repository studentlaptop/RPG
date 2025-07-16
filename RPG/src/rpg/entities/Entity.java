package rpg.entities;

import java.awt.image.BufferedImage;

/**
 * Entity.java Constructor and methods for Player.java and Enemy.java
 */
public abstract class Entity {
	private String name;
	private int speed;
	private int attack;
	private int hp;
	private int xPos, yPos;
	private int movementSpeed;
	protected BufferedImage upIdle, upMove, downIdle, downMove, leftIdle, leftMove, rightIdle, rightMove;
	protected String direction;
	protected int spriteCounter = 0;
	protected int spriteNum = 1;

	public Entity(EntityParams params) {
		this.name = params.getName();
		this.speed = params.getSpeed();
		this.attack = params.getAttack();
		this.hp = params.getHp();
	}
	

	public String getName() {
		return name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getXPos() {
		return xPos;
	}

	public void setXPos(int xPos) {
		this.xPos = xPos;
	}

	public int getYPos() {
		return yPos;
	}

	public void setYPos(int yPos) {
		this.yPos = yPos;
	}

	public int getMovementSpeed() {
		return movementSpeed;
	}

	public void setMovementSpeed(int entityMovementSpeed) {
		this.movementSpeed = entityMovementSpeed;
	}
}