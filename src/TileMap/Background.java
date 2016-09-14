package TileMap;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class Background {

	private BufferedImage image;

	private double x;
	private double y;

	public Background(String s) {

		try {
			image = ImageIO.read(getClass().getResourceAsStream(s));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setPosition(double x, double y) {
		this.x = GamePanel.WIDTH;
		this.y = GamePanel.HEIGHT;
	}

	public void update() {
	}

	public void draw(Graphics2D g) {

		g.drawImage(image, (int) 0, 0, null);

		// if (x < 0) {
		// g.drawImage(image, (int) x + GamePanel.WIDTH, (int) y, null);
		// }
		// if (x > 0) {
		// g.drawImage(image, (int) x - GamePanel.WIDTH, (int) y, null);
		// }
	}

}
