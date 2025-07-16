package rpg.swing;

import javax.swing.JFrame;

public class GameMain {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("2D Adventure");

		GamePanel gamePanel = new GamePanel();

		window.add(gamePanel);
		window.pack();

		gamePanel.startGameThread();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}
