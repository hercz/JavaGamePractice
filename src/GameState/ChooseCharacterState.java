package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Main.GamePanel;
import TileMap.Background;

public class ChooseCharacterState extends GameState {
	private Background bg;
	private BufferedImage[] characters;
	private Color titleColor;
	private Font titleFont;

	String title = "Choose a character";

	private Font font;

	public ChooseCharacterState(GameStateManager gsm) {
		this.gsm = gsm;
		try {

			bg = new Background("/img/grey_walp.jpg");

			titleColor = new Color(128, 0, 0);
			titleFont = new Font("Century Gothic", Font.PLAIN, 72);

			font = new Font("Arial", Font.PLAIN, 32);

		} catch (Exception e) {
			e.printStackTrace();
		}
		init();
	}

	@Override
	public void init() {

	}

	@Override
	public void update() {
		bg.update();

	}

	public void draw(Graphics2D g) {
		drawTitle(g);
	}

	public void drawTitle(Graphics2D g) {

		// Get the FontMetrics
		FontMetrics metrics = g.getFontMetrics(titleFont);
		// Determine the X coordinate for the text
		int x = (GamePanel.WIDTH - metrics.stringWidth(title)) / 2;
		// Determine the Y coordinate for the text (note we add the ascent, as
		// in java 2d 0 is top of the screen)
		int y = (GamePanel.HEIGHT - metrics.getHeight()) / 3;

		// draw bg
		bg.draw(g);

		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString(title, x, y);
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub

	}

}
