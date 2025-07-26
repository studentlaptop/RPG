package rpg.entities;

import rpg.swing.*;

/**
 * Driver.java Testing environment for RPG Project, a simple turn-based
 * simulator with the goal of the player or enemy lowering the other's HP to 0.
 * 
 * @author studentlaptop, 26 May 2025
 */
public class Driver {
	// TODO Add support for teams of players and enemies
	public static void main(String[] args) {
		GamePanel temp = new GamePanel();
		Player player = new Player(
				new PlayerParams().name("Wojak").speed(6).attack(1).hp(10).gamePanel(temp).playerMovementHandler(null));

		Enemy enemy = new Enemy(new EntityParams().name("Gigachad").speed(5).attack(1).hp(10));
		Battle test = new Battle(player, enemy);
		test.backTurned = true;
		test.battleSequence();
		// test.queueCombatants();
		// test.printCombatantQueue();

		System.out.println(test.victor() + " won!");
		System.out.println(player.xPos);
	}
}
