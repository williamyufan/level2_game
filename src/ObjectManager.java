import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	static ArrayList<ObstacleforRaceCar> obstacles = new ArrayList<ObstacleforRaceCar>();
	RaceCar car=new RaceCar(260, 200, 100, 100);

	ObjectManager() {

		createObstacles(0);

	}

	public static void createObstacles(int count) {
		obstacles.clear();
		for (int i = 0; i < count; i++) {
			int[] position=getnewobstacleposition();
			obstacles.add(new ObstacleforRaceCar(position[0], position[1]));
			
		}
	}

	public void update() {
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).update();
		}
		car.update();
		checkCollision();
	}

	public void draw(Graphics g) {
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).draw(g);
		}
	}

	public static int[] getnewobstacleposition(){
			int[] position = new int[2];
			boolean whele=true;
			int u;
			int o;
			while(whele) {
				u=new Random().nextInt(1450)+80;
				o=new Random().nextInt(660);
			for (int i = 0; i < obstacles.size(); i++) {
				ObstacleforRaceCar obs=obstacles.get(i);
				if(obs.x>u-100&&u-100<obs.x+obs.width) {
					if(obs.y>o-100&&o-100<obs.y+obs.height) {
					
						break;
				
					}
				}
			}
			whele=false;
			position[0]=u;
			position[1]=o;
			}
			
			return position;
	}

	void checkCollision() {
		for (ObstacleforRaceCar obstacles : obstacles) {
			if (car.collisionBox.intersects(obstacles.collisionBox)) {
				car.isActive = false;
				
				break;
			}
		}
	}

}
