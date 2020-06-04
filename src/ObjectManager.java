import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	static ArrayList<ObstacleforRaceCar> obstacles = new ArrayList<ObstacleforRaceCar>();
	RaceCar car = new RaceCar(10, 300, 50, 23);
	static ArrayList<Powerups> p = new ArrayList<Powerups>();
	static ArrayList<Powerdowns> d = new ArrayList<Powerdowns>();

	ObjectManager() {

		createObstacles(0);
		createpowerups(0);
		createpowerdowns(0);

	}

	public static void createObstacles(int count) {
		obstacles.clear();
		for (int i = 0; i < count; i++) {
			int[] position = getnewobstacleposition();
			obstacles.add(new ObstacleforRaceCar(position[0], position[1]));

		}
	}

	public static void createpowerups(int cot) {
		p.clear();
		for (int i = 0; i < cot; i++) {
			int[] position = getnewpowerupsposition();
			p.add(new Powerups(position[0], position[1], 15, 15));

		}
	}
	public static void createpowerdowns(int co) {
		d.clear();
		for (int i = 0; i < co; i++) {
			int[] position = getnewpowerdowns();
			d.add(new Powerdowns(position[0], position[1], 15, 15));

		}
	}

	public static int[] getnewpowerupsposition() {
		// TODO Auto-generated method stub
		int[] position = new int[2];
		boolean yy = true;
		int u;
		int o;
		while (yy) {
			u = new Random().nextInt(1450) + 150;
			o = new Random().nextInt(660);
			for (int i = 0; i < p.size(); i++) {
				Powerups obs = p.get(i);
				if (obs.x > u - 100 && u - 100 < obs.x + obs.width) {
					if (obs.y > o - 100 && o - 100 < obs.y + obs.height) {

						break;

					}
				}
			}
			yy = false;
			position[0] = u;
			position[1] = o;
		}

		return position;
	}
	public static int[] getnewpowerdowns() {
		// TODO Auto-generated method stub
		int[] position = new int[2];
		boolean f = true;
		int u;
		int o;
		while (f) {
			u = new Random().nextInt(1450) + 150;
			o = new Random().nextInt(660);
			for (int i = 0; i < d.size(); i++) {
				Powerdowns obs = d.get(i);
				if (obs.x > u - 100 && u - 100 < obs.x + obs.width) {
					if (obs.y > o - 100 && o - 100 < obs.y + obs.height) {

						break;

					}
				}
			}
			f = false;
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
		for (Powerups p : p) {
				if (car.collisionBox.intersects(p.collisionBox)) {
					p.isActive = false;
					car.speed -= 1;
				}
			}

		
		for (Powerdowns d : d) {
			
				if (car.collisionBox.intersects(d.collisionBox)) {
					d.isActive = false;
					car.speed += 3;
				}
			}
		}
	}


