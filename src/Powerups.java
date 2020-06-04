import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class Powerups extends GameObjectforRaceGame {


	Powerups(int x, int y, int width, int height) {
		super(x, y, 15, 15);
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) {




			
					g.setColor(Color.GREEN);
					g.fillRect(x, y, 15, 15);
				}

	
	}	
