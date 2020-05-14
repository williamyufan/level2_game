import javax.swing.JFrame;

public class RaceGamePanel {
	JFrame frame;
	public static final int WIDTH = 2000;
	public static final int HEIGHT = 500;
	GamePanel panel;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RaceGamePanel racegame=new RaceGamePanel();
		racegame.setup();
	}

	public RaceGamePanel() {
		frame = new JFrame();
		panel = new GamePanel();
		frame.addKeyListener(panel);
	}

	void setup() {
		frame.add(panel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
