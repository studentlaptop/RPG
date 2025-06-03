package entities;

/**
 * Driver.java Testing environment for RPG Project, a simple turn-based
 * simulator with the goal of the player or enemy lowering the other's HP to 0.
 * 
 * @author studentlaptop, 26 May 2025
 */
public class Driver {
	// TODO Add support for teams of players and enemies
	public static void main(String[] args) {
		Player protag = new Player("Wojak", 5, 1, 10);
		Enemy enemy = new Enemy("Gigachad", 5, 1, 10);
		Battle test = new Battle(protag, enemy);

		test.battleSequence();
	}
}
