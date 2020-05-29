import javax.swing.JFrame;

public class RaceGameRunner {
	JFrame frame;
	public static final int WIDTH = 1605;
	public static final int HEIGHT = 800;
	RaceGamePanel panel;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RaceGameRunner racegame=new RaceGameRunner();
		racegame.setup();
	}

	public RaceGameRunner() {
		frame = new JFrame();
		panel = new RaceGamePanel();
		frame.addKeyListener(panel);
	}

	void setup() {
		frame.add(panel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
