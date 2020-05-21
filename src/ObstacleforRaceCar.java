import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class ObstacleforRaceCar extends GameObjectforRaceGame {
	Random random = new Random();
	public BufferedImage image;
	public boolean needImage = true;
	public boolean gotImage = false;

	ObstacleforRaceCar(int x, int y) {
		super(x, y, 500, 500);
		// TODO Auto-generated constructor stub
		createobstacle();
			}
	public void createobstacle() {
		int level = random.nextInt(15);
		
		if (needImage) {
			if (level == 0) {
		
			loadImage("one.png");
			}
		
		
	if (level == 1) {
	
			loadImage("two.png");

		}
	
	if (level == 2) {
		
			loadImage("three.png");

		}
	
	if (level == 3) {

			loadImage("four.png");
	
		
	}
	if (level == 4) {
	
			loadImage("five.png");

		
	}
	if (level == 5) {
	
			loadImage("six.png");

		
	}
	if (level == 6) {
		
			loadImage("seven.png");
	
		
	}
	if (level == 7) {

			loadImage("eight.png");


	}
	if (level == 8) {

			loadImage("nine.png");
	
	
	}
	if (level == 9) {

			loadImage("ten.png");
	

	}
	if (level == 10) {

			loadImage("twelve.png");


	}
	if (level == 11) {
	
			loadImage("thirteen.png");

	}
	if (level == 12) {

			loadImage("fourteen.png");


	}
	if (level == 13) {

			loadImage("fiveteen.png");
	

	}
	if (level == 14) {

			loadImage("sixteen.png");
	

	}
	width = image.getWidth();
	height = image.getHeight();
		}
}
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, image.getWidth(), image.getHeight(), null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(x, y, width, height);
		}
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
