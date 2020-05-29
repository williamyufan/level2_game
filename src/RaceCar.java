import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class RaceCar extends GameObjectforRaceGame {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	int counter = 0;
	Random ran = new Random();
	Random r=new Random();
	int f=0;
	int p=0;
	int q=0;
	int a=0;
	RaceCar(int x, int y, int width, int height) {
		super(x, y, width, height);

		if (needImage) {
			loadImage("i.png");

		}

	}

	public void update() {
		int u = ran.nextInt(2);
		int h=r.nextInt(2);
		
		x += speed;
		super.update();

		if (x >= 1597) {
			x = 0;
			if (counter < 91) {

				counter += 5;
				ObjectManager.createObstacles(counter);
				speed += 1;
				
			}
			else if (counter > 90) {
				x = 0;
				speed += 2;

			}
			 if (u == 0) {
					f += 2;
					ObjectManager.createpowerups(f);
				
				}
				else if (u == 1) {
					p += 3;
					ObjectManager.createpowerups(p);
				
				}
			 if(h==0) {
				 a+=2;
				 ObjectManager.createpowerdowns(a);
			 }
			 else if(h==1) {
				 q+=3;
				 ObjectManager.createpowerdowns(q);
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
