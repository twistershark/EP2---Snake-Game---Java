import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Painel extends JPanel implements Runnable, KeyListener{

	private static final long serialVersionUID = 1L;
	private static final int LARGURA = 500, ALTURA = 500;
	
	private Thread thread;
	
	private boolean running;
	
	private boolean direita = true, esquerda = false, cima = false, baixo = false;
	
	private Corpo c;
	private ArrayList<Corpo> snake;
	
	private Fruta maca;
	private ArrayList<Fruta> macas;
	
	private Random r;
	
	private int xCoor = 10, yCoor = 10, size = 5;
	private int ticks = 0;
	
	public Painel() {
		setFocusable(true);
		
		
		setPreferredSize(new Dimension(LARGURA, ALTURA));
		addKeyListener(this);
		
		snake = new ArrayList<Corpo>();
		macas = new ArrayList<Fruta>();
		
		r = new Random();
		
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
		
		if(ticks > 300000) {
			if(direita) xCoor++;
			if(esquerda) xCoor--;
			if(cima) yCoor--;
			if(baixo) yCoor++;
			
			ticks = 0;
			
			c = new Corpo(xCoor, yCoor, 10);
			snake.add(c);
			
			if(snake.size() > size) {
				snake.remove(0);
			}
		}
		
		if(macas.size() == 0) {
			int xCoor = r.nextInt(49);
			int yCoor = r.nextInt(49);
			
			maca = new Fruta(xCoor, yCoor, 10);
			macas.add(maca);
		}
		
		for (int i = 0; i < macas.size(); i++) {
			if(xCoor == macas.get(i).getxCoor() && yCoor == macas.get(i).getyCoor()) {
				size++;
				macas.remove(i);
				i++; 
			}
		}
		for(int i = 0; i < snake.size(); i++) {
			if(xCoor == snake.get(i).getxCoor() && yCoor == snake.get(i).getyCoor()) {
				if(i != snake.size() - 1) {
					stop();
				}
			}
		}
		
		if(xCoor < 0 || xCoor > 49 || yCoor < 0 || yCoor > 49) {
			stop();
		}
		
		
	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, LARGURA, ALTURA);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LARGURA, ALTURA);
		
		for (int i =0; i < snake.size(); i++) {
			snake.get(i).draw(g);
		}
		for (int i = 0; i < macas.size(); i++) {
			macas.get(i).draw(g);
		}
	}

	@Override
	public void run() {
		while(running) {
			tick();
			repaint();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT && !esquerda) {
			direita = true;
			cima = false;
			baixo = false;
		}
		if(key == KeyEvent.VK_LEFT && !direita) {
			esquerda = true;
			cima = false;
			baixo = false;
		}
		if(key == KeyEvent.VK_UP && !baixo) {
			cima = true;
			esquerda = false;
			direita = false;
		}
		if(key == KeyEvent.VK_DOWN && !cima) {
			baixo = true;
			esquerda = false;
			direita = false;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
