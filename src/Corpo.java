import java.awt.Color;
import java.awt.Graphics;

public class Corpo {

	private int xCoor, yCoor, largura, altura, tipo = 1;
	
	public Corpo(int xCoor, int yCoor, int tileSize, int tipo) {
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		this.tipo = tipo;
		largura = tileSize;
		altura = tileSize;
	}
	
	public void tick() {
		
	}
	
	public void draw(Graphics g) {
		if(tipo == 1) {
			g.setColor(Color.pink);
			g.fillRect(xCoor * largura, yCoor * altura, largura, altura);	
		}
		else if (tipo == 2) {
			g.setColor(Color.green);
			g.fillRect(xCoor * largura, yCoor * altura, largura, altura);	
		}
		else if (tipo == 3) {
			g.setColor(Color.YELLOW);
			g.fillRect(xCoor * largura, yCoor * altura, largura, altura);	
		}
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
