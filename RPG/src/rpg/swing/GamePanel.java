package rpg.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import rpg.entities.EntityParams;
import rpg.entities.Player;

public class GamePanel extends JPanel implements Runnable {
	final int originalTileSize = 16;
	final int scale = 3;
	final int tileSize = originalTileSize * scale;
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow;
	
	KeyHandler playerMovementDirection = new KeyHandler();
	Thread gameThread;
	Player player = new Player(new EntityParams()
			.name("Wojak")
			.speed(5)
			.attack(1)
			.hp(10)
			.gamePanel(this)
			.playerMovementDirection(playerMovementDirection)
			);
	
	int playerX = 100;
	int playerY = 100;
	public static final int PLAYERMOVEMENTSPEED = 2;
	public static final int FPS = 60;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(playerMovementDirection);
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
		int diagonalX = 0;
		int diagonalY = 0;
		
		if (playerMovementDirection.upPressed) {
			playerY -= PLAYERMOVEMENTSPEED;
			diagonalY -= 1;
		}
		if (playerMovementDirection.downPressed) {
			playerY += PLAYERMOVEMENTSPEED;
			diagonalY += 1;
		}
		if (playerMovementDirection.leftPressed) {
			playerX -= PLAYERMOVEMENTSPEED;
			diagonalX -= 1;
		}
		if (playerMovementDirection.rightPressed) {
			playerX += PLAYERMOVEMENTSPEED;
			diagonalX += 1;
		}
		
		if (diagonalX != 0 || diagonalY != 0) {
			double length = Math.sqrt(diagonalX * diagonalX + diagonalY * diagonalY);
			playerX += (int) (PLAYERMOVEMENTSPEED * diagonalX / length);
			playerY += (int) (PLAYERMOVEMENTSPEED * diagonalY / length);
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.white);
		g2.fillRect(playerX, playerY, tileSize, tileSize);
		g2.dispose();
	}
}
