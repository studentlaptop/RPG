package rpg.entities;

public class Enemy extends Entity {
	int recruitChance;
	boolean isRecruitable;

	public Enemy(EntityParams params) {
		super(params);
	}
}