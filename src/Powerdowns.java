import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class Powerdowns extends GameObjectforRaceGame{
	
		
		Random ran=new Random();
		Random rand=new Random(800);
		ArrayList<Rectangle> powerd=new ArrayList<Rectangle>();
		
		Powerdowns(int x, int y, int width, int height) {
			super(x, y, width, height);
			// TODO Auto-generated constructor stub
		}
		
		public void draw(Graphics g) {
			
			
			for (int i = 0; i < powerd.size(); i++) {
				g.setColor(Color.GRAY);
				g.fillRect(powerd.get(i).x, powerd.get(i).y, 15, 15);
				
			}
		
	}
	}



