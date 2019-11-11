import java.awt.Color;
import java.awt.Graphics;

public class Fruta {

private int xCoor, yCoor, largura, altura, tipoFruta;
	
	public Fruta(int xCoor, int yCoor, int tileSize, int tipoFruta) {
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		this.tipoFruta = tipoFruta;
		largura = tileSize;
		altura = tileSize;
	}
	
	public int getTipoFruta() {
		return tipoFruta;
	}

	public void setTipoFruta(int tipoFruta) {
		this.tipoFruta = tipoFruta;
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
		if(tipoFruta == 1) {
			g.setColor(Color.RED);
			g.fillRect(xCoor * largura, yCoor * altura, largura, altura);
		}
		else if(tipoFruta == 2) {
			g.setColor(Color.YELLOW);
			g.fillRect(xCoor * largura, yCoor * altura, largura, altura);
		}
		else if(tipoFruta == 3) {
			g.setColor(Color.GREEN);
			g.fillRect(xCoor * largura, yCoor * altura, largura, altura);
		}
		else if(tipoFruta == 4) {
			g.setColor(Color.BLACK);
			g.fillRect(xCoor * largura, yCoor * altura, largura, altura);
		}
		else if(tipoFruta == 0){
			g.setColor(Color.RED);
			g.fillRect(xCoor * largura, yCoor * altura, largura, altura);
		}
		
	}
	
}
