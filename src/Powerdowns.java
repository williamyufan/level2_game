import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class Powerdowns extends GameObjectforRaceGame {

	

	Powerdowns(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) {

	
					g.setColor(Color.BLUE);
					g.fillRect(x,y, 15, 15);

	
		

	}
}
