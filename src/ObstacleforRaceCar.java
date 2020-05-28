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
			collisionboxes.add(new Rectangle(x+76, y+38, width-97, height-52));
			collisionboxes.add(new Rectangle(x+18, y+30, width-40, height-93));
		}
	
	if (level == 3) {

			loadImage("four.png");
			collisionboxes.add(new Rectangle(x+20, y+18, width-95, height-80));
			collisionboxes.add(new Rectangle(x+23, y+40, width-83, height-91));
			collisionboxes.add(new Rectangle(x+40, y+45, width-90, height-76));
		
	}
	if (level == 4) {
	
			loadImage("five.png");
			collisionboxes.add(new Rectangle(x+27, y+12, width-90, height-25));
		
	}
	if (level == 5) {
	
			loadImage("six.png");
			collisionboxes.add(new Rectangle(x+30, y+20, width-90, height-96));
			collisionboxes.add(new Rectangle(x+40, y+23, width-95, height-90));
	}

	if (level == 6) {

			loadImage("eight.png");
			collisionboxes.add(new Rectangle(x+121, y+68, width-488, height-320));

	}
	
	

	}
	if (level == 7) {

			loadImage("twelve.png");
			collisionboxes.add(new Rectangle(x+38, y+18, width-95, height-78));
			collisionboxes.add(new Rectangle(x+41, y+45, width-96, height-88));

	}

	if (level == 8) {

			loadImage("fourteen.png");
			collisionboxes.add(new Rectangle(x+53, y+29, width-95, height-86));
			

	}
	if (level == 9) {

			loadImage("fiveteen.png");
			collisionboxes.add(new Rectangle(x+54, y+35, width-94, height-91));

	}
	if (level == 10) {

			loadImage("sixteen.png");
			collisionboxes.add(new Rectangle(x+30, y+10, width-83, height-55));

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
