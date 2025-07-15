package rpg.entities;

public class EntityParams {
	private String name;
	private int speed;
	private int attack;
	private int hp;
	
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
}