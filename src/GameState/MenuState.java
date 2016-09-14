package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Main.GamePanel;
import TileMap.Background;

public class MenuState extends GameState {

	private Background bg;
	private BufferedImage logo;

	private int currentChoice = 0;
	private String[] options = { "Start", "Help", "Quit" };

	private Color titleColor;
	private Font titleFont;

	private Font font;

	public MenuState(GameStateManager gsm) {

		this.gsm = gsm;

		try {

			bg = new Background("/img/grey_walp.jpg");
			logo = ImageIO.read(getClass().getResourceAsStream("/img/codecool_transparent_smaller.png"));

			titleColor = new Color(128, 0, 0);
			titleFont = new Font("Century Gothic", Font.PLAIN, 72);

			font = new Font("Arial", Font.PLAIN, 32);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void init() {
	}

	public void update() {
		bg.update();
	}

	public void draw(Graphics2D g) {
		drawTitle(g);
		drawMenu(g);
		drawLogo(g);
	}

	public void drawTitle(Graphics2D g) {
		// Get the FontMetrics
		FontMetrics metrics = g.getFontMetrics(titleFont);
		// Determine the X coordinate for the text
		int x = (GamePanel.WIDTH - metrics.stringWidth("CodeCoolKombat")) / 2;
		// Determine the Y coordinate for the text (note we add the ascent, as
		// in java 2d 0 is top of the screen)
		int y = (GamePanel.HEIGHT - metrics.getHeight()) / 3;

		// draw bg
		bg.draw(g);

		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("CodeCool Kombat", x, y);
	}

	public void drawMenu(Graphics2D g) {
		// Get the FontMetrics
		FontMetrics metrics = g.getFontMetrics(font);
		// Determine the X coordinate for the text
		int x = (GamePanel.WIDTH - metrics.stringWidth(options[0])) / 2;
		// Determine the Y coordinate for the text (note we add the ascent, as
		// in java 2d 0 is top of the screen)
		int y = (GamePanel.HEIGHT - metrics.getHeight()) / 2;

		// draw menu options
		g.setFont(font);
		for (int i = 0; i < options.length; i++) {
			if (i == currentChoice) {
				g.setColor(Color.RED);
			} else {
				g.setColor(Color.BLACK);
			}
			g.drawString(options[i], x, y + i * 35);
		}
	}

	public void drawLogo(Graphics2D g) {

		// Determine the X coordinate for the text
		int x = (GamePanel.WIDTH - logo.getWidth()) / 2;
		// Determine the Y coordinate for the text (note we add the ascent, as
		// in java 2d 0 is top of the screen)
		int y = GamePanel.HEIGHT - logo.getHeight() - 80;

		g.drawImage(logo, x, y, null);
	}

	private void select() {
		if (currentChoice == 0) {
			gsm.setState(GameStateManager.CHOOSECHARACTERSTATE);
		}
		if (currentChoice == 1) {
			// help
		}
		if (currentChoice == 2) {
			System.exit(0);
		}
	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER) {
			select();
		}
		if (k == KeyEvent.VK_UP) {
			currentChoice--;
			if (currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		}
		if (k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if (currentChoice == options.length) {
				currentChoice = 0;
			}
		}
	}

	public void keyReleased(int k) {
	}

}
