package rpg.entities;

/**
 * Driver.java Testing environment for RPG Project, a simple turn-based
 * simulator with the goal of the player or enemy lowering the other's HP to 0.
 * 
 * @author studentlaptop, 26 May 2025
 */
public class Driver {
	// TODO Add support for teams of players and enemies
	public static void main(String[] args) {
		Player player = new Player(new EntityParams()
				.name("Wojak")
				.speed(5)
				.attack(1)
				.hp(10)
				);
		Enemy enemy = new Enemy(new EntityParams()
				.name("Gigachad")
				.speed(5)
				.attack(1)
				.hp(10)
				);
		Battle test = new Battle(player, enemy);
		//test.setBackTurned(false);
		test.battleSequence();
		//test.queueCombatants();
		//test.printCombatantQueue();

		System.out.println(test.victor() + " won!");
	}
}
