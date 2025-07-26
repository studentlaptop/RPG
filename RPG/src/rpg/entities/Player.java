package rpg.entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import rpg.swing.GamePanel;
import rpg.swing.KeyHandler;

public class Player extends Entity {
	protected GamePanel gamePanel;
	protected KeyHandler playerMovementHandler;

	public Player(PlayerParams params) {
		super(params);
		this.gamePanel = params.getGamePanel();
		this.playerMovementHandler = params.getPlayerMovementHandler();
		setDefaultValues();
		getPlayerImage();
	}

	public void setDefaultValues() {
		xPos = 100;
		yPos = 100;
		movementSpeed = 2;
		direction = "down";
	}

	public void update() { // playerSprite sometimes resets to "move" when no more key presses are inputed
		int diagonalX = 0;
		int diagonalY = 0;

		if (playerMovementHandler.upPressed == true || playerMovementHandler.downPressed == true ||
				playerMovementHandler.leftPressed == true || playerMovementHandler.rightPressed == true) {
			
			if (playerMovementHandler.upPressed) {
				direction = "up";
				yPos -= movementSpeed;
				diagonalY -= 1;
			}
			if (playerMovementHandler.downPressed) {
				direction = "down";
				yPos += movementSpeed;
				diagonalY += 1;
			}
			if (playerMovementHandler.leftPressed) {
				direction = "left";
				xPos -= movementSpeed;
				diagonalX -= 1;
			}
			if (playerMovementHandler.rightPressed) {
				direction = "right";
				xPos += movementSpeed;
				diagonalX += 1;
			}

			if (diagonalX != 0 || diagonalY != 0) {
				double length = Math.sqrt(diagonalX * diagonalX + diagonalY * diagonalY);
				xPos += (int) (movementSpeed * diagonalX / length);
				yPos += (int) (movementSpeed * diagonalY / length);
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
		g2.drawImage(playerSprite, xPos, yPos, gamePanel.tileSize, gamePanel.tileSize, null);
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
	
	public GamePanel getGamePanel() {
		return gamePanel;
	}
	
	public KeyHandler getPlayerMovementHandler() {
		return playerMovementHandler;
	}
}