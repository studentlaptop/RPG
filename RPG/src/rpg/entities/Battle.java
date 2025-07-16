package rpg.entities;

import java.util.concurrent.ThreadLocalRandom;

import java.util.Queue;
import java.util.LinkedList;

public class Battle {
	private Player player;
	private Enemy enemy;
	private boolean backTurned = false;
	// protected boolean battleStart;
	private Queue<rpg.entities.Entity> combatantQueue = new LinkedList<>();

	public Battle(Player player, Enemy enemy) {
		this.player = player;
		this.enemy = enemy;
	}

	public boolean goesFirst() {
		int roll;
		int playerSpeed = player.getSpeed();
		int enemySpeed = enemy.getSpeed();

		if (playerSpeed > enemySpeed) {
			return true;
		}

		if (playerSpeed == enemySpeed) {
			roll = diceRoll(1, 10);
			if (roll > 5) {
				return true;
			}
		}
		return false; // enemy goes first
	} // end of goesFirst()

	public int diceRoll(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max);
	} // end of diceRoll()

	public void beginBattle() { // not called
		// battleStart = true;
	} // end of beginBattle()

	public void endBattle() { // not called
		// battleStart = false;
	} // end of endBattle()

	public String victor() {
		if (player.getHp() > 0) {
			return player.getName();
		}
		if (enemy.getHp() > 0) {
			return enemy.getName();
		}
		return null;
	} // end of victor()

	public String battleSequence() {
		// beginBattle();
		while (player.getHp() > 0 && enemy.getHp() > 0) {
			queueCombatants();

			while (!combatantQueue.isEmpty()) {
				if (player.getHp() > 0 && enemy.getHp() > 0) {
					System.out.println(combatantQueue.peek().getName() + " attacks!\n");
					attack();
					System.out.println(getStats(player, enemy) + "\n");
					combatantQueue.remove();
				} else {
					return victor();
				}
			}
		}
		return null;
	} // end of battleSequence()

	public String getStats(Player player, Enemy enemy) { // consider returning an array or other kind of list for GUI to
															// call and retrieve from
		String stats = (player.getName() + "'s HP: " + player.getHp() + "\n" + enemy.getName() + "'s HP: "
				+ enemy.getHp());
		return stats;
	}

	public int attack() {
		int playerAttack = player.getAttack();
		int enemyAttack = enemy.getAttack();
		int playerHealth = player.getHp();
		int enemyHealth = enemy.getHp();

		if (combatantQueue.peek() instanceof Player) {
			enemy.setHp(enemyHealth - playerAttack); // player attacks; enemy loses hp
			return enemyHealth;
		} else {
			player.setHp(playerHealth - enemyAttack); // enemy attacks; player loses hp
			return playerHealth;
		}
	} // end of attack()

	public void queueCombatants() {
		boolean playerFirst = goesFirst();

		if (backTurned) {
			combatantQueue.add(enemy);
			combatantQueue.add(player);
			backTurned = false;
			return;
		}

		if (playerFirst) {
			combatantQueue.add(player);
			combatantQueue.add(enemy);
		} else {
			combatantQueue.add(enemy);
			combatantQueue.add(player);
		}
	} // end of queueCombatants()

	public Queue<rpg.entities.Entity> getCombatantQueue() {
		return combatantQueue;
	}

	public boolean getBackTurned() {
		return backTurned;
	}

	public void setBackTurned(boolean backTurned) {
		this.backTurned = backTurned;
	}

	public void printCombatantQueue() {
		for (Entity combatant : combatantQueue) {
			System.out.println(combatant.getName());
		}
	}
}