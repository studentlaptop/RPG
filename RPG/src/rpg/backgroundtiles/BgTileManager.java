package rpg.backgroundtiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;

import javax.imageio.ImageIO;

import rpg.swing.GamePanel;

public class BgTileManager {
	public GamePanel gamePanel;
	public ConcurrentHashMap<BgTile, BufferedImage> tile;
	public BgTile desertBgTile = new BgTile();
	public BgTile waterBgTile = new BgTile();
	public BgTile nullBgTile = new BgTile();
	public int mapTileNum[][];

	public BgTileManager(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		tile = new ConcurrentHashMap<>();
		mapTileNum = new int[gamePanel.maxScreenCol][gamePanel.maxScreenRow];
		getTileImage();
		loadMap("/rpg/res/maps/desertBgMap.txt");
	}

	public void getTileImage() {
		try {
			tile.put(desertBgTile,
					ImageIO.read(getClass().getResourceAsStream("/rpg/res/backgroundtiles/desertBgTile.png")));
			tile.put(waterBgTile,
					ImageIO.read(getClass().getResourceAsStream("/rpg/res/backgroundtiles/waterBgTile.png")));
			tile.put(nullBgTile,
					ImageIO.read(getClass().getResourceAsStream("/rpg/res/backgroundtiles/nullBgTile.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadMap(String filePath) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int col = 0;
			int row = 0;

			while (col < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow) {
				String line = br.readLine();

				while (col < gamePanel.maxScreenCol) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					mapTileNum[col][row] = num;
					col++;
				}
				if (col == gamePanel.maxScreenCol) {
					col = 0;
					row++;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics2D g2) {
		int row = 0;
		int col = 0;
		int x = 0;
		int y = 0;

		while (col < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow) {
			int tileNum = mapTileNum[col][row];
			BgTile bgTileKey = getKeyByTileNum(tileNum);
			g2.drawImage(tile.get(bgTileKey), x, y, gamePanel.tileSize, gamePanel.tileSize, null);
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

	public BgTile getKeyByTileNum(int tileNum) {
		switch (tileNum) {
		case 0:
			if (tile.containsKey(desertBgTile)) {
				return desertBgTile;
			} else {
				return nullBgTile;
			}
		case 1:
			if (tile.containsKey(waterBgTile)) {
				return waterBgTile;
			} else {
				return nullBgTile;
			}
		default:
			return nullBgTile;
		}
	}
}
