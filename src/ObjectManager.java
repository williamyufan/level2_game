import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	static ArrayList<ObstacleforRaceCar> obstacles=new ArrayList<ObstacleforRaceCar>();
		ObjectManager() {

		createObstacles(0);
		
	}
		public static void createObstacles(int count) {
			obstacles.clear();
			for (int i = 0; i < count; i++) {
				obstacles.add(new ObstacleforRaceCar(new Random().nextInt(1499)+80, new Random().nextInt(599)));
				}
		}
	public void update() {
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).update();
		}
	}
	public void draw(Graphics g) {
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).draw(g);
		}
	}
}
