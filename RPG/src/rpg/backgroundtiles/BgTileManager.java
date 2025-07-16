package rpg.backgroundtiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.imageio.ImageIO;

import rpg.swing.GamePanel;

public class BgTileManager {
	GamePanel gamePanel;
	ConcurrentHashMap<BgTile, BufferedImage> tile;
	BgTile desertBgTile = new BgTile();
	BgTile waterBgTile = new BgTile();

	public BgTileManager(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		tile = new ConcurrentHashMap<>();
		getTileImage();
	}

	public void getTileImage() {
		try {
			tile.put(desertBgTile,
					ImageIO.read(getClass().getResourceAsStream("/rpg/res/backgroundtiles/desertBgTile.png")));
			tile.put(waterBgTile,
					ImageIO.read(getClass().getResourceAsStream("/rpg/res/backgroundtiles/waterBgTile.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics2D g2) {
		// g2.drawImage(tile.get(desertBgTile), 0, 0, gamePanel.tileSize,
		// gamePanel.tileSize, null);
		// g2.drawImage(tile.get(waterBgTile), 48, 0, gamePanel.tileSize,
		// gamePanel.tileSize, null);
		int row = 0;
		int col = 0;
		int x = 0;
		int y = 0;

		while (col < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow) {
			g2.drawImage(tile.get(desertBgTile), x, y, gamePanel.tileSize, gamePanel.tileSize, null);
			col++;
			x += gamePanel.tileSize;

			if (col == gamePanel.maxScreenCol) {
				col = 0;
				x = 0;
				row++;
				y += gamePanel.tileSize;
			}
		}
	}
}
