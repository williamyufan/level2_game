import java.awt.Rectangle;

public class GameObjectforRaceGame {
	int x;
	int y;
	int width;
	int height;
	int speed=1;
	boolean isActive=true;
	Rectangle collisionBox;
	GameObjectforRaceGame(int x, int y, int width, int height){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		collisionBox=new Rectangle(x, y, width, height);
	}
	public void update() {
		// TODO Auto-generated method stub
		collisionBox.setBounds(x, y, width, height);
	}

}
