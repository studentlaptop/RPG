package rpg.backgroundtiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import rpg.swing.GamePanel;

public class BgTileManager {
	GamePanel gamePanel;
	HashMap<BgTile, BufferedImage> tile;
	BgTile desertBgTile;
	BgTile waterBgTile;
	
	public BgTileManager(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		tile = new HashMap<>();
		BgTile desertBgTile = new BgTile();
		BgTile waterBgTile = new BgTile();
		getTileImage();
	}
	
	public void getTileImage() {
		try {
			tile.put(desertBgTile, ImageIO.read(getClass().getResourceAsStream("/rpg/res/backgroundtiles/desertBgTile.png")));
			tile.put(waterBgTile, ImageIO.read(getClass().getResourceAsStream("/rpg/res/backgroundtiles/waterBgTile.png")));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(tile.get(desertBgTile), 0, 0, gamePanel.tileSize, gamePanel.tileSize, null);
	}
}
