package rpg.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import rpg.backgroundtiles.BgTileManager;
import rpg.entities.EntityParams;
import rpg.entities.Player;
import rpg.entities.PlayerParams;

public class GamePanel extends JPanel implements Runnable {
	public final int originalTileSize = 16;
	public final int scale = 3;
	public final int tileSize = originalTileSize * scale;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	public static final int FPS = 60;
	
	BgTileManager bgTileManager = new BgTileManager(this);
	KeyHandler playerMovementHandler = new KeyHandler();
	Thread gameThread;
	Player player = new Player(new PlayerParams().name("Wojak").speed(5).attack(1).hp(10).gamePanel(this)
			.playerMovementHandler(playerMovementHandler));

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(playerMovementHandler);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		int oneBillionNanoSeconds = 1000000000;
		int oneMillionMilliSeconds = 1000000;
		double drawInterval = oneBillionNanoSeconds / FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;

		while (gameThread != null) {

			update();

			repaint();

			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / oneMillionMilliSeconds;

				if (remainingTime < 0) {
					remainingTime = 0;
				}

				Thread.sleep((long) remainingTime);

				nextDrawTime += drawInterval;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void update() {
		player.update();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		bgTileManager.draw(g2);
		player.draw(g2);
		g2.dispose();
	}
}
