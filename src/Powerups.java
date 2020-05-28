import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class Powerups extends GameObjectforRaceGame{
	Random ran=new Random();
	Random rand=new Random();
	Random Rand=new Random();
	ArrayList<Rectangle> powerups=new ArrayList<Rectangle>();
	
	Powerups(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	public void randomforpowerups() {
		int u=ran.nextInt(3);

		if(u==0) {
			
		}
		
		
	}
	public void draw(Graphics g) {
		
				
				
		for (int i = 0; i < powerups.size(); i++) {
			g.setColor(Color.GRAY);
			g.fillRect(powerups.get(i).x, powerups.get(i).y, 15, 15);
		}
}
}
