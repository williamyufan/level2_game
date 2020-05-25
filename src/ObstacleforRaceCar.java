import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class ObstacleforRaceCar extends GameObjectforRaceGame {
	Random random = new Random();
	public BufferedImage image;
	public boolean needImage = true;
	public boolean gotImage = false;
	ArrayList<Rectangle> collisionboxes=new ArrayList<Rectangle>();

	ObstacleforRaceCar(int x, int y) {
		super(x, y, 500, 500);
		// TODO Auto-generated constructor stub
		createobstacle(null);
			}
	public void createobstacle(Graphics g) {
		int level = random.nextInt(11);
		
		if (needImage) {
			if (level == 0) {
		
			loadImage("one.png");
			collisionboxes.add(new Rectangle(x+30, y+18, width-90, height-83));
			}
		
		
	if (level == 1) {
	
			loadImage("two.png");
			collisionboxes.add(new Rectangle(x+28, y+15, width-95, height-80));
		}
	
	if (level == 2) {
		
			loadImage("three.png");
			collisionboxes.add(new Rectangle(x+30, y+10, width-95, height-80));
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

			loadImage("eight.png");


	}
	
	

	}
	if (level == 7) {

			loadImage("twelve.png");


	}

	if (level == 8) {

			loadImage("fourteen.png");
			collisionboxes.add(new Rectangle(x+50, y+30, width-115, height-50));


	}
	if (level == 9) {

			loadImage("fiveteen.png");
	

	}
	if (level == 10) {

			loadImage("sixteen.png");
	

	}
	
		}

	void draw(Graphics g) {
		for (int i = 0; i < collisionboxes.size(); i++) {
			g.setColor(Color.GRAY);
			g.fillRect(collisionboxes.get(i).x, collisionboxes.get(i).y, collisionboxes.get(i).width, collisionboxes.get(i).height);
			
		}
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
				width = image.getWidth();
				height = image.getHeight();
			} catch (Exception e) {

			}
			needImage = false;
		}
	}
}
