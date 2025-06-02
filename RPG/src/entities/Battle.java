package entities;
import java.util.concurrent.ThreadLocalRandom;

public class Battle {
	protected Player player;
	protected Enemy enemy;
	// protected boolean battleStart;
	protected boolean playerFirst;

	public Battle(Player player, Enemy enemy) {
		this.player = player;
		this.enemy = enemy;
	}

	public boolean goesFirst() {
		int roll;
		int playerSpeed = player.getSpeed();
		int enemySpeed = enemy.getSpeed();

		if (playerSpeed > enemySpeed) {
			return playerFirst = true; // player goes first
		}

		if (playerSpeed == enemySpeed) {
			roll = diceRoll(1, 10);
			if (roll > 5) {
				return playerFirst = true; // player goes first
			}
		}
		return playerFirst = false; // enemy goes first
	} // end of goesFirst()

	public boolean turnChange() {
		if (playerFirst) {
			return playerFirst = false;
		} else {
			return playerFirst = true;
		}
	} // end of turnChange()

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

		System.out.println("Player: " + player.getName());
		System.out.println("Speed: " + player.getSpeed());
		System.out.println("Enemy: " + enemy.getName());
		System.out.println("Speed: " + enemy.getSpeed() + "\n");

		while (player.getHp() > 0 && enemy.getHp() > 0) {
			goesFirst();

			if (player.getHp() > 0 && enemy.getHp() > 0) {
				if (playerFirst) {
					System.out.print(player.getName() + " attacks! ");
					attack();
					System.out.print(enemy.getName() + " lost " + player.getAttack() + " HP! ");
				} else {
					System.out.print(enemy.getName() + " attacks! ");
					attack();
					System.out.print(player.getName() + " lost " + enemy.getAttack() + " HP! ");
				}
				
				System.out.println("\n" + player.getName() + "'s HP: " + player.getHp());
				System.out.println(enemy.getName() + "'s HP: " + enemy.getHp());
			}

			turnChange();
			
			if (player.getHp() > 0 && enemy.getHp() > 0) {
				if (playerFirst) {
					System.out.print(player.getName() + " attacks! ");
					attack();
					System.out.print(enemy.getName() + " lost " + player.getAttack() + " HP! ");
				} else {
					System.out.print(enemy.getName() + " attacks! ");
					attack();
					System.out.print(player.getName() + " lost " + enemy.getAttack() + " HP! ");
				}

				System.out.println("\n" + player.getName() + "'s HP: " + player.getHp());
				System.out.println(enemy.getName() + "'s HP: " + enemy.getHp());
			}
		}
		return victor();
	} // end of battleSequence()

	public int attack() {
		int playerAttack = player.getAttack();
		int enemyAttack = enemy.getAttack();
		int playerHealth = player.getHp();
		int enemyHealth = enemy.getHp();

		if (playerFirst) {
			enemy.setHp(enemyHealth - playerAttack); // player attacks; enemy loses hp
			return enemyHealth;
		} else {
			player.setHp(playerHealth - enemyAttack); // enemy attacks; player loses hp
			return playerHealth;
		}
	} // end of attack()
}
