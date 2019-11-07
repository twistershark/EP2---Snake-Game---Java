import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Painel extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;
	private static final int LARGURA = 500, ALTURA = 500;
	
	private Thread thread;
	
	private boolean running;
	
	private boolean direita = true, esquerda = false, cima = false, baixo = false;
	
	private Corpo c;
	private ArrayList<Corpo> snake;
	
	private int xCoor = 10, yCoor = 10, size = 5;
	
	private int ticks = 0;
	
	public Painel() {
		
		setPreferredSize(new Dimension(LARGURA, ALTURA));
		
		snake = new ArrayList<Corpo>();
		
		start();
		
	}
	
	public void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void tick() {
		if (snake.size() == 0) {
			c = new Corpo(xCoor, yCoor, 10);
			snake.add(c);
		}
		ticks++;
		
	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, LARGURA, ALTURA);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LARGURA, ALTURA);
		
		for (int i =0; i < snake.size(); i++) {
			snake.get(i).draw(g);
		}
	}

	@Override
	public void run() {
		while(running) {
			tick();
			repaint();
		}
		
	}
	
	
}
