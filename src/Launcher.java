import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Launcher extends JPanel {

	private int escolha;
	private int dificuldade;
	
	private ImageIcon comum;
	private ImageIcon kitty;
	private ImageIcon star;
	
	Font fonte = new Font("arial", Font.BOLD, 25);
	
	private int LARGURA = 800, ALTURA = 800;
	
	public Launcher() {
		setPreferredSize(new Dimension(LARGURA, ALTURA));
	}
	
	public void paint(Graphics g) {
		g.setFont(new Font("arial", Font.BOLD, 30)); 
		g.drawString("Selecione um tipo de cobra:", 210, 80);
		
		g.setFont(new Font("arial", Font.PLAIN, 15)); 
		
		comum = new ImageIcon("./res/comum.png");
		comum.paintIcon(this, g, 120, 120);
		g.setFont(new Font("arial", Font.BOLD, 20)); 
		g.drawString("Comum", 145, 260);
		g.setFont(new Font("arial", Font.PLAIN, 15)); 
		g.drawString("Sem habilidades especiais", 100, 280);
		g.drawString("*Normal*", 145, 300);
		
		kitty = new ImageIcon("./res/kitty.png");
		kitty.paintIcon(this, g, 320, 120);
		g.setFont(new Font("arial", Font.BOLD, 20)); 
		g.drawString("Kitty", 360, 260);
		g.setFont(new Font("arial", Font.PLAIN, 15)); 
		g.drawString("Atravessa as barreiras do jogo", 290, 280);
		g.drawString("*Fácil*", 360, 300);
		
		
		star = new ImageIcon("./res/star.png");
		star.paintIcon(this, g, 520, 120);
		g.setFont(new Font("arial", Font.BOLD, 20)); 
		g.drawString("Star", 570, 260);
		g.setFont(new Font("arial", Font.PLAIN, 15)); 
		g.drawString("Recebe o dobro de pontos", 510, 280);
		g.drawString("*Difícil*", 560, 300);
		
		
		
	}
	
}
