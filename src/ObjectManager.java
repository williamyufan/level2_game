import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	static ArrayList<ObstacleforRaceCar> obstacles = new ArrayList<ObstacleforRaceCar>();
	RaceCar car = new RaceCar(260, 200, 100, 100);
	static ArrayList<Powerups> p = new ArrayList<Powerups>();
	static ArrayList<Powerdowns> d=new ArrayList<Powerdowns>();

	ObjectManager() {

		createObstacles(0);

	}

	public static void createObstacles(int count) {
		obstacles.clear();
		for (int i = 0; i < count; i++) {
			int[] position = getnewobstacleposition();
			obstacles.add(new ObstacleforRaceCar(position[0], position[1]));

		}
	}
	public void createpowerups(int cot) {
		for (int i = 0; i < cot; i++) {
			int[] position = getnewpowerupsposition();
			obstacles.add(new ObstacleforRaceCar(position[0], position[1]));

		}
	}

	private int[] getnewpowerupsposition() {
		// TODO Auto-generated method stub
		int[] position = new int[2];
		boolean yy = true;
		int u;
		int o;
		while (yy) {
			u = new Random().nextInt(1450) + 150;
			o = new Random().nextInt(660);
			for (int i = 0; i < obstacles.size(); i++) {
				ObstacleforRaceCar obs = obstacles.get(i);
				if (obs.x > u - 100 && u - 100 < obs.x + obs.width) {
					if (obs.y > o - 100 && o - 100 < obs.y + obs.height) {

						break;

					}
				}
			}
			whele = false;
			position[0] = u;
			position[1] = o;
		}

		return position;
	}

	public void update() {
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).update();
		}
		for (int i = 0; i < p.size(); i++) {
			p.get(i).update();
		}
		for (int i = 0; i < d.size(); i++) {
			d.get(i).update();
		}
		car.update();
		checkCollision();
		purgeObjects();
	}

	public void draw(Graphics g) {
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).draw(g);
		}
		car.draw(g);
		for (int i = 0; i < p.size(); i++) {
			p.get(i).draw(g);
		}
		for (int i = 0; i < d.size(); i++) {
			d.get(i).draw(g);
		}
	}

	public static int[] getnewobstacleposition() {
		int[] position = new int[2];
		boolean whele = true;
		int u;
		int o;
		while (whele) {
			u = new Random().nextInt(1450) + 150;
			o = new Random().nextInt(660);
			for (int i = 0; i < obstacles.size(); i++) {
				ObstacleforRaceCar obs = obstacles.get(i);
				if (obs.x > u - 100 && u - 100 < obs.x + obs.width) {
					if (obs.y > o - 100 && o - 100 < obs.y + obs.height) {

						break;

					}
				}
			}
			whele = false;
			position[0] = u;
			position[1] = o;
		}

		return position;
	}

	void purgeObjects() {
		for (int i = 0; i < p.size(); i++) {
			if (!p.get(i).isActive) {
				p.remove(i);

			}

		}
		for (int i = 0; i < d.size(); i++) {
			if (!d.get(i).isActive) {
				d.remove(i);

			}

		}

	}

	void checkCollision() {
		for (ObstacleforRaceCar obstacles : obstacles) {
			for (int i = 0; i < obstacles.collisionboxes.size(); i++) {

				if (car.collisionBox.intersects(obstacles.collisionboxes.get(i))) {
					car.isActive = false;

					break;
				}
			}
		}
		for(Powerups p : p) {
			for (int i = 0; i < p.powerups.size(); i++) {
			if(car.collisionBox.intersects(p.powerups.get(i))) {
				p.isActive=false;
				car.speed-=2;
			}
			}
		
				}
		for(Powerdowns d : d) {
			for (int i = 0; i < d.powerd.size(); i++) {
			if(car.collisionBox.intersects(d.powerd.get(i))) {
				d.isActive=false;
				car.speed+=5;
			}
				}
		}
	}

}
