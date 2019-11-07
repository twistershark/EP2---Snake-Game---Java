import java.awt.Color;
import java.awt.Graphics;

public class Fruta {

private int xCoor, yCoor, largura, altura;
	
	public Fruta(int xCoor, int yCoor, int tileSize) {
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		largura = tileSize;
		altura = tileSize;
	}
	
	public void tick() {
		
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

	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(xCoor * largura, yCoor * altura, largura, altura);
	}
	
}
