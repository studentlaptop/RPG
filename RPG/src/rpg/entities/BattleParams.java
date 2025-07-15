package rpg.entities;

public class BattleParams {
	private Player player;
	private Enemy enemy;
	private boolean backTurned;
	
	public BattleParams player(Player player) {
		this.player = player;
		return this;
	}
	
	public BattleParams enemy(Enemy enemy) {
		this.enemy = enemy;
		return this;
	}
	
	public BattleParams backTurned(boolean backTurned) {
		this.backTurned = backTurned;
		return this;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Enemy getEnemy() {
		return enemy;
	}
	
	public boolean getBackTurned() {
		return backTurned;
	}
}
