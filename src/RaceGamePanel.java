import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

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
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	RaceGamePanel() {
		titlefont = new Font("Arial", Font.PLAIN, 38);
		startfont = new Font("Arial", Font.PLAIN, 28);
		instructionsfont = new Font("Arial", Font.PLAIN, 18);
		gameoverfont = new Font("Arial", Font.PLAIN, 100);
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
		if (needImage) {
		    loadImage ("");
		}
		
	}
	
	void updateMenuState() {
		
	}
	void updateGameState() {
		
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
		g.setColor(Color.WHITE);
		g.drawString("Ganster Training Auto V (aka GTA V)", 490, 438);
		g.setFont(startfont);
		g.setColor(Color.WHITE);
		g.drawString("Press ENTER to Start", 1200, 300);
		g.setFont(instructionsfont);
		g.setColor(Color.WHITE);
		g.drawString("Press SPACE (it is the longest key on a keboard) for Instructions", 80, 500);
		
	}
	void drawGameState(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, RaceGameRunner.WIDTH, RaceGameRunner.HEIGHT);
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, RaceGameRunner.WIDTH, RaceGameRunner.HEIGHT);
		g.setFont(gameoverfont);
		g.setColor(Color.WHITE);
		g.drawString("<[$]{GG}[$]>", 700, 300);
		
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
			} else {
				currentState++;
				if(currentState==GAME) {
					
				}
				else if(currentState==END) {
					
				}
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			if(currentState==MENU) {
				JOptionPane.showMessageDialog(this, "In this game,you will drive a car.\n You will have to avoid obstacles when you are in conrol of that car. \n You can potentially never have to quit the game because as long as you don't crash into one of the obstacles, you can keep going. \n However, if you do crash into one of the obstacles, whether its at 1 second or at 100 minutes, the game will stop and go to the end. \n Your goal is to try to stay on the road for as long as possible. \n i.e. Try to get to 10 minutes if your best is 9 minutes. \n \n Controls: You can only go left and right. \n Left is A \n Right is D \n \n Have fun!");
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
