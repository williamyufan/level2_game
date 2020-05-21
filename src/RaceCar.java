import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class RaceCar extends GameObjectforRaceGame{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	int counter=0;
	
	RaceCar(int x, int y, int width, int height) {
		super(x, y, width, height);
			speed=10;
			if (needImage) {
			    loadImage ("i.png");
			

		}
		
	}
	public void update() {
		x+=3;
		super.update();
		
		if(x>=1500) {
		if(counter<91) {
			x=0;
			counter+=5;
			ObjectManager.createObstacles(counter);
		}
		else if(counter>90) {
			x=0;
			counter+=0;
			ObjectManager.createObstacles(counter);
			
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
	        y-=speed;
	    }
	 public void down() {
	        y+=speed;
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
