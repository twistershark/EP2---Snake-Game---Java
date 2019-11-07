import java.awt.Color;
import java.awt.Graphics;

public class Corpo {

	private int xCoor, yCoor, largura, altura;
	
	public Corpo(int xCoor, int yCoor, int tileSize) {
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		largura = tileSize;
		altura = tileSize;
	}
	
	public void tick() {
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(xCoor * largura, yCoor * altura, largura, altura);
	}

	public int getxCoor() {
		return xCoor;
	}

	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}

	public int getyCoor() {
		return yCoor;
	}

	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}
	
	
}
