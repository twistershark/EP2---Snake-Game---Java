import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Painel extends JPanel implements Runnable, KeyListener{

	private static final long serialVersionUID = 1L;
	private static final int LARGURA = 600, ALTURA = 600;
	
	private Thread thread;
	
	private boolean running;
	
	private boolean direita = true, esquerda = false, cima = false, baixo = false;
	
	private Corpo c;
	private ArrayList<Corpo> snake;
	
	private Fruta maca;
	private ArrayList<Fruta> macas;
	private Fruta especial;
	private ArrayList<Fruta> powerup;
	
	private Random r;
	private Random tipoPower;
	private Random p;

	
	private int xCoor = 10, yCoor = 10, size = 5;
	private int tipoCobra, colisaoComParedes;
	
	private int score = 0;
	
	public Painel(int tipo_cobra, int colisao_com_paredes) {
		this.tipoCobra = tipo_cobra;
		this.colisaoComParedes = colisao_com_paredes;
		
		setFocusable(true);
		
		setPreferredSize(new Dimension(LARGURA, ALTURA));
		addKeyListener(this);
		
		snake = new ArrayList<Corpo>();
		macas = new ArrayList<Fruta>();
		powerup = new ArrayList<Fruta>();
		
		r = new Random();
		p = new Random();	
		tipoPower = new Random();
		
		start();	
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();

	}
	
	public void stop() {
			JFrame resultadoFrame = new JFrame();
			JPanel resultado = new JPanel();
			
			resultadoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			resultadoFrame.add(resultado);
			resultadoFrame.setTitle("GAME OVER");

			resultado.setPreferredSize(new Dimension(250,133));
			resultadoFrame.setVisible(true);
			resultado.setLayout(null);
			
			JLabel score_label = new JLabel("Score:  " + String.valueOf(score));
			score_label.setFont(new Font("Tahoma", Font.BOLD, 18));
			score_label.setBounds(80, 30, 200, 53);
			resultado.add(score_label);

			resultadoFrame.pack();
			resultadoFrame.setLocationRelativeTo(null);
			
			running = false;
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void tick() {
		
		//GERADOR DE SNAKE
		if (snake.size() == 0) {
			c = new Corpo(xCoor, yCoor, 10, tipoCobra);
			snake.add(c);
		}		
		//MOVIMENTAÇÃO
			if(direita) xCoor++;
			if(esquerda) xCoor--;
			if(cima) yCoor--;
			if(baixo) yCoor++;
			
			
			c = new Corpo(xCoor, yCoor, 10, tipoCobra);
			snake.add(c);
			
			if(snake.size() > size) {
				snake.remove(0);
			}		
	
		
		// GERADOR DE FRUTAS NORMAIS
	
		if(macas.size() == 0) {
			int xCoor = r.nextInt(59);
			int yCoor = r.nextInt(59);

			maca = new Fruta(xCoor, yCoor, 10, 1);
			macas.add(maca);
		}

		// GERADOR DE FRUTAS ESPECIAIS
		if(powerup.size() == 0) {
			int tipo_Power = tipoPower.nextInt(4 - 2 + 1) + 2;

			int xCoor2 = p.nextInt(59);
			int yCoor2 = p.nextInt(59);

			especial = new Fruta(xCoor2, yCoor2, 10, tipo_Power);
			powerup.add(especial);
		}
		
		// COLISÃO COM FRUTAS NORMAIS
		for (int i = 0; i < macas.size(); i++) {
			if(xCoor == macas.get(i).getxCoor() && yCoor == macas.get(i).getyCoor()) {
				size++;
				score = score + 10;
				macas.remove(i);
				i++; 
			}
		}
		
		// COLISÕES COM FRUTAS ESPECIAIS
		for (int i = 0; i < powerup.size(); i++) {
			if(xCoor == powerup.get(i).getxCoor() && yCoor == powerup.get(i).getyCoor()) {
				if(powerup.get(i).getTipoFruta() == 2) {
					size++;
					score = score + 20;
					powerup.remove(i);
					i++; 	
				}
				else if(powerup.get(i).getTipoFruta() == 3) {
					snake.clear();
					size = 5;
					c = new Corpo(xCoor, yCoor, 10, tipoCobra);
					snake.add(c);
					powerup.remove(i);
					i++;	
				}
				else if(powerup.get(i).getTipoFruta() == 4) {
					stop();
				}	
			}
		}
		
		//COLIÃO COM O CORPO
		for(int i = 0; i < snake.size(); i++) {
			if(xCoor == snake.get(i).getxCoor() && yCoor == snake.get(i).getyCoor()) {
				if(i != snake.size() - 1) {
					stop();
				}
			}
		}
		
		//COLISAO COM BARREIRAS
		if(tipoCobra == 2 || tipoCobra == 3) {
			for(int i = 0; i < snake.size(); i++) {
				for(int j = 0; j < 10; j++) {
					if(snake.get(i).getxCoor() == 30 && snake.get(i).getyCoor() == j + 10 || snake.get(i).getxCoor() == 30 && snake.get(i).getyCoor() == j + 35
							|| snake.get(i).getxCoor() == 31 && snake.get(i).getyCoor() == j + 10 || snake.get(i).getxCoor() == 31 && snake.get(i).getyCoor() == j + 35) {
						stop();
					}
				}	
			}
		}
		
		// COLISÃO COM AS BORDAS DO JOGO
		if(colisaoComParedes == 1) {
			if(xCoor < 0 || xCoor > 59 || yCoor < 0 || yCoor > 59) {
				stop();
			}
		}
		else if(colisaoComParedes == 0) {
			if(xCoor < 0 || xCoor > 59 || yCoor < 0 || yCoor > 59) {
				if(xCoor < 0) {
					xCoor = 59;
				}
				if(xCoor > 59) {
					xCoor = 0;
				}
				if(yCoor < 0) {
					yCoor = 59;
				}
				if(yCoor > 59) {
					yCoor = 0;
				}
			}
		}
		
}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, LARGURA, ALTURA);
		
		g.setColor(Color.gray);
		g.fillRect(0, 0, LARGURA, ALTURA);
		
		for (int i =0; i < snake.size(); i++) {
			snake.get(i).draw(g);
		}
		for (int i = 0; i < macas.size(); i++) {
			macas.get(i).draw(g);
		}
		for (int i = 0; i < powerup.size(); i++) {
			powerup.get(i).draw(g);
		}
		//BARREIRAS
		g.setColor(Color.blue);
		for(int i = 0; i < 10; i++) {
			g.fillRect(300, i + 100, 20, 120);
			g.fillRect(300, i + 350, 20, 120);
		}
	}

	// CONTROLE DE FPS -- 20FPS = NORMAL / 30FPS = Difícil
	

	private long FPS;
	private long startTime;
	private long URDTimeMillis;
	private long waitTime;
	private long targetTime;
	
	@Override
	public void run() {
		if(tipoCobra == 1 || tipoCobra == 2) {
			FPS = 20;
		}
		else if(tipoCobra == 3) {
			FPS = 30;
		}
		targetTime = 1000/ FPS;
		
		while(running) {
			startTime = System.nanoTime();
			
			tick();
			repaint();   
				
			URDTimeMillis = (System.nanoTime() - startTime) / 1000000;
			waitTime = targetTime - URDTimeMillis;
			
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
