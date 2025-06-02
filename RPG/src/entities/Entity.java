package entities;
/**
 * Entity.java
 * Constructor and methods for Player.java and Enemy.java
 */
public abstract class Entity {
	protected String name;
	protected int speed;
	protected int attack;
	protected int hp;
	
	public Entity(String name, int speed, int attack, int hp) {
		this.name = name;
		this.speed = speed;
		this.attack = attack;
		this.hp = hp;
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
}