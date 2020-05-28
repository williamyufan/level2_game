import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class RaceCar extends GameObjectforRaceGame {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	int counter = 0;


	RaceCar(int x, int y, int width, int height) {
		super(x, y, width, height);

		if (needImage) {
			loadImage("i.png");

		}

	}

	public void update() {
		x += speed;
		super.update();

		if (x >= 1600) {
			if (counter < 91) {
				x = 0;
				counter += 5;
				ObjectManager.createObstacles(counter);
				speed += 1;
			} else if (counter > 90) {
				x = 0;
				speed += 2;

			}
		}

	}

	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}

	public void up() {
		y -= 8;
	}

	public void down() {
		y += 8;
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

}
