import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titlefont;
	Font startfont;
	Font instructionsfont;  
	Font gameoverfont;
	Timer frameDraw;
	GamePanel() {
		titlefont = new Font("Arial", Font.PLAIN, 18);
		startfont = new Font("Arial", Font.PLAIN, 18);
		instructionsfont = new Font("Arial", Font.PLAIN, 8);
		gameoverfont = new Font("Arial", Font.PLAIN, 48);
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
		
	}
	void updateMenuState() {
		
	}
	void updateGameState() {
		
	}
	void updateEndState() {
		
	}
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, RaceGamePanel.WIDTH, RaceGamePanel.HEIGHT);
		g.setFont(titlefont);
		g.setColor(Color.YELLOW);
		g.drawString("GTA VI (nothing like GTA beside its a racing game)", 10, 10);
		g.setFont(startfont);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to Start", 10, 300);
		g.setFont(instructionsfont);
		g.setColor(Color.YELLOW);
		g.drawString("Press SPACE (it is the longest key on a keboard) for Instructions", 10, 600);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
	
}
