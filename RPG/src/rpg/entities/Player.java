package rpg.entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import rpg.swing.GamePanel;
import rpg.swing.KeyHandler;

public class Player extends Entity {
	private GamePanel gamePanel;
	private KeyHandler playerMovementHandler;
	int playerX = getXPos();
	int playerY = getYPos();
	int playerMovementSpeed = getMovementSpeed();

	public Player(EntityParams params) {
		super(params);
		this.gamePanel = params.getGamePanel();
		this.playerMovementHandler = params.getPlayerMovementHandler();
		setDefaultValues();
		getPlayerImage();
	}

	public void setDefaultValues() {
		playerX = 100;
		playerY = 100;
		playerMovementSpeed = 2;
		direction = "down";
	}

	public void update() { // playerSprite sometimes resets to "move" when no more key presses are inputed
		int diagonalX = 0;
		int diagonalY = 0;

		if (playerMovementHandler.getUpPressed() == true || playerMovementHandler.getDownPressed() == true ||
				playerMovementHandler.getLeftPressed() == true || playerMovementHandler.getRightPressed() == true) {
			
			if (playerMovementHandler.getUpPressed()) {
				direction = "up";
				playerY -= playerMovementSpeed;
				diagonalY -= 1;
			}
			if (playerMovementHandler.getDownPressed()) {
				direction = "down";
				playerY += playerMovementSpeed;
				diagonalY += 1;
			}
			if (playerMovementHandler.getLeftPressed()) {
				direction = "left";
				playerX -= playerMovementSpeed;
				diagonalX -= 1;
			}
			if (playerMovementHandler.getRightPressed()) {
				direction = "right";
				playerX += playerMovementSpeed;
				diagonalX += 1;
			}

			if (diagonalX != 0 || diagonalY != 0) {
				double length = Math.sqrt(diagonalX * diagonalX + diagonalY * diagonalY);
				playerX += (int) (playerMovementSpeed * diagonalX / length);
				playerY += (int) (playerMovementSpeed * diagonalY / length);
			}

			spriteCounter++;
			if (spriteCounter > 10) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}

	}

	public void draw(Graphics2D g2) {
		BufferedImage playerSprite = null;

		switch (direction) {
		case "up":
			if (spriteNum == 1) {
				playerSprite = upIdle;
			}
			if (spriteNum == 2) {
				playerSprite = upMove;
			}
			break;
		case "down":
			if (spriteNum == 1) {
				playerSprite = downIdle;
			}
			if (spriteNum == 2) {
				playerSprite = downMove;
			}
			break;
		case "left":
			if (spriteNum == 1) {
				playerSprite = leftIdle;
			}
			if (spriteNum == 2) {
				playerSprite = leftMove;
			}
			break;
		case "right":
			if (spriteNum == 1) {
				playerSprite = rightIdle;
			}
			if (spriteNum == 2) {
				playerSprite = rightMove;
			}
			break;
		}
		g2.drawImage(playerSprite, playerX, playerY, gamePanel.tileSize, gamePanel.tileSize, null);
	}

	public void getPlayerImage() {
		try {
			upIdle = ImageIO.read(getClass().getResourceAsStream("/rpg/res/player/blobberUpIdle.png"));
			upMove = ImageIO.read(getClass().getResourceAsStream("/rpg/res/player/blobberUpMove.png"));
			downIdle = ImageIO.read(getClass().getResourceAsStream("/rpg/res/player/blobberLeftIdle.png"));
			downMove = ImageIO.read(getClass().getResourceAsStream("/rpg/res/player/blobberLeftMove.png"));
			leftIdle = ImageIO.read(getClass().getResourceAsStream("/rpg/res/player/blobberLeftIdle.png"));
			leftMove = ImageIO.read(getClass().getResourceAsStream("/rpg/res/player/blobberLeftMove.png"));
			rightIdle = ImageIO.read(getClass().getResourceAsStream("/rpg/res/player/blobberRightIdle.png"));
			rightMove = ImageIO.read(getClass().getResourceAsStream("/rpg/res/player/blobberRightMove.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}