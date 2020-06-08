import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class RaceGamePanel extends JPanel implements KeyListener, ActionListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titlefont;
	Font startfont;
	Font instructionsfont;  
	Font gameoverfont;
	Timer frameDraw;
	Timer gametimer;
	long timeCounter;
	ObjectManager ob=new ObjectManager();
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	RaceGamePanel() {
		titlefont = new Font("Arial", Font.PLAIN, 28);
		startfont = new Font("Arial", Font.PLAIN, 28);
		instructionsfont = new Font("Arial", Font.PLAIN, 18);
		gameoverfont = new Font("Arial", Font.PLAIN, 100);
		frameDraw = new Timer(1000/50, this);
		frameDraw.start();
		gametimer=new Timer(1000, this);
		
		if (needImage) {
		    loadImage ("GTAV.jpg");
		}
		
	}
	
	void updateMenuState() {
		
	}
	void updateGameState() {
		ob.update();
		if(ob.car.isActive==false) {
			currentState=END;
		}
		ob.car.update();
	
		
	}
	void updateEndState() {
	
	}
	void drawMenuState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, RaceGameRunner.WIDTH, RaceGameRunner.HEIGHT, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, RaceGameRunner.WIDTH, RaceGameRunner.HEIGHT);
		}
		
		g.setFont(titlefont);
		g.setColor(Color.YELLOW);
		g.drawString("Nothing like GTA except you can race", 390, 600);
		g.setFont(startfont);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to Start", 1200, 300);
		g.setFont(instructionsfont);
		g.setColor(Color.YELLOW);
		g.drawString("Press SPACE (it is the longest key on a keboard) for Instructions", 80, 550);
	}
	void drawGameState(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, RaceGameRunner.WIDTH, RaceGameRunner.HEIGHT);
		g.setColor(Color.BLUE);
		g.drawString("timer:"+timeCounter, 100, 100);
		ob.draw(g);
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, RaceGameRunner.WIDTH, RaceGameRunner.HEIGHT);
		g.setFont(gameoverfont);
		g.setColor(Color.WHITE);
		g.drawString("<[$]{GG}[$]>", 500, 200);
		g.setFont(instructionsfont);
		g.setColor(Color.WHITE);
		g.drawString("Your Time is:" + " " +timeCounter + " " + "seconds" + "    \n  "+"Be better next time", 10, 300); 
}
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
				ob.car=new RaceCar(0, 300, 50, 23);
				timeCounter=0;
				RaceCar.counter=0;
				RaceCar.f=0;
				RaceCar.a=0;
				ObjectManager.createObstacles(0);
				ObjectManager.createpowerdowns(0);
				ObjectManager.createpowerups(0);
				
			} else {
				currentState++;
				if(currentState==GAME) {
					gametimer.start();
				}
				else if(currentState==END) {
					
					
				}
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			if(currentState==MENU) {
				JOptionPane.showMessageDialog(this, "In this game,you will drive a car.\n You will have to avoid obstacles when you are in conrol of that car. \n You will see blue and yellow rectangles beside the obstaceles, the green ones boost you, the red ones slow you down. \n The obstacles will increase everytime you get to the right side of the game and gets teleported back to the left. \n You can potentially never have to quit the game because as long as you don't crash into one of the obstacles, you can keep going. \n However, if you do crash into one of the obstacles, whether its at 1 second or at 100 minutes, the game will stop and go to the end. \n Your goal is to try to stay on the road for as long as possible. \n i.e. Try to get to 10 minutes if your best is 9 minutes. \n If you wish to stop the game at anytime, press enter.\n \n Controls: You can only go left and right (But on the screen, it is actually up or down). \n Left is W or the up arrow key (You can use either) \n Right is S or the down arraw key (You can use either) \n \n Have fun!");
			}
		}		
		
		else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_W) {
			ob.car.up();
			if(ob.car.y<=0) {
				ob.car.y=0;
			}
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode()==KeyEvent.VK_S){
			ob.car.down();
			if(ob.car.y>=780-23) {
				ob.car.y=780-23;
				
			}
		}
	}
		
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==gametimer) {
		if(currentState==GAME) {
			timeCounter++;
		}
		}
		else {
			
		}
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		repaint();
		
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
