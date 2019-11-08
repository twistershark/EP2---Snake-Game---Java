import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

public class Inicializador extends JPanel implements KeyListener {

	private static final long serialVersionUID = 1L;

	// DECLARAÇÃO DE ATRIBUTOS
	
	private int tipo_cobra;
	private int colisao_com_paredes;
	
	public Inicializador() {
		menu();
	}

	public void menu(){
		setPreferredSize(new Dimension(537, 582));
		
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel kitty_label = new JLabel("New label");
		Image kitty = new ImageIcon(this.getClass().getResource("/kitty.png")).getImage();
		kitty_label.setIcon(new ImageIcon(kitty));
		kitty_label.setBounds(10, 113, 131, 135);
		add(kitty_label);
		
		JLabel comum_label = new JLabel("New label");
		Image comum = new ImageIcon(this.getClass().getResource("/comum.png")).getImage();
		comum_label.setIcon(new ImageIcon(comum));
		comum_label.setBounds(203, 113, 131, 135);
		add(comum_label);

		
		JLabel star_label = new JLabel("New label");
		Image star = new ImageIcon(this.getClass().getResource("/star.png")).getImage();
		star_label.setIcon(new ImageIcon(star));
		star_label.setBounds(396, 113, 131, 135);
		add(star_label);
		
		JLabel txtpnKitty = new JLabel("Kitty - Fácil");
		txtpnKitty.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtpnKitty.setBounds(32, 247, 86, 20);
		add(txtpnKitty);
		
		JLabel txtpnComum = new JLabel("Comum - Normal");
		txtpnComum.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtpnComum.setBounds(215, 247, 107, 20);
		add(txtpnComum);
		
		JLabel txtpnStar = new JLabel("Star - Difícil");
		txtpnStar.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtpnStar.setBounds(423, 247, 77, 20);
		add(txtpnStar);
		
		JLabel txtpnSemHabilidadesEspeciais = new JLabel("Sem habilidades especiais");
		txtpnSemHabilidadesEspeciais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnSemHabilidadesEspeciais.setBounds(200, 270, 200, 20);
		add(txtpnSemHabilidadesEspeciais);
		
		JLabel txtpnAtravessaBarreiras = new JLabel("Atravessa barreiras");
		txtpnAtravessaBarreiras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnAtravessaBarreiras.setBounds(15, 270, 150, 20);
		add(txtpnAtravessaBarreiras);
		
		JLabel txtpnDobroDePontos = new JLabel("Dobro de pontos");
		txtpnDobroDePontos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnDobroDePontos.setBounds(418, 270, 120, 20);
		add(txtpnDobroDePontos);
		
		ButtonGroup grupobutton = new ButtonGroup();
		
		JRadioButton kitty_rb = new JRadioButton("");
		kitty_rb.setBackground(Color.WHITE);
		kitty_rb.setBounds(55, 297, 21, 23);
		add(kitty_rb);
		
		JRadioButton comum_rb = new JRadioButton("");
		comum_rb.setBackground(Color.WHITE);
		comum_rb.setSelected(true);
		comum_rb.setBounds(258, 297, 21, 23);
		add(comum_rb);
		
		JRadioButton star_rb = new JRadioButton("");
		star_rb.setBackground(Color.WHITE);
		star_rb.setBounds(451, 297, 21, 23);
		add(star_rb);
		
		grupobutton.add(kitty_rb);
		grupobutton.add(comum_rb);
		grupobutton.add(star_rb);
		
		JLabel colisoes_label = new JLabel("Colisão com as paredes?");
		colisoes_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		colisoes_label.setBounds(32, 352, 158, 14);
		add(colisoes_label);
		
		ButtonGroup colisaogrupo = new ButtonGroup();
		
		JRadioButton sim_rb = new JRadioButton("Sim");
		sim_rb.setSelected(true);
		sim_rb.setBackground(Color.WHITE);
		sim_rb.setBounds(183, 349, 50, 23);
		add(sim_rb);
		
		JRadioButton nao_rb = new JRadioButton("Não");
		nao_rb.setBackground(Color.WHITE);
		nao_rb.setBounds(233, 349, 109, 23);
		add(nao_rb);
		
		colisaogrupo.add(sim_rb);
		colisaogrupo.add(nao_rb);
		
		JLabel lblSnakeGame = new JLabel("Snake Game");
		lblSnakeGame.setFont(new Font("Lucida Handwriting", Font.PLAIN, 30));
		lblSnakeGame.setBounds(156, -18, 225, 76);
		add(lblSnakeGame);
		
		JLabel lblEscolhaOTipo = new JLabel("Escolha o tipo de cobra:");
		lblEscolhaOTipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEscolhaOTipo.setBounds(189, 69, 158, 25);
		add(lblEscolhaOTipo);
		
		JLabel lblTiposDeFrutas = new JLabel("Tipos de frutas");
		lblTiposDeFrutas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTiposDeFrutas.setBounds(208, 404, 121, 42);
		add(lblTiposDeFrutas);
		
		JLabel lblVermelha = new JLabel("Vermelha");
		lblVermelha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVermelha.setBounds(78, 457, 54, 14);
		add(lblVermelha);
		
		JLabel lblFrutaComum = new JLabel(" - Fruta comum");
		lblFrutaComum.setBounds(130, 457, 90, 14);
		lblFrutaComum.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblFrutaComum);
		
		JLabel lblAmarela = new JLabel("Amarela");
		lblAmarela.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAmarela.setBounds(83, 471, 54, 14);
		add(lblAmarela);
		
		JLabel lblDobroDe = new JLabel(" - Dobro de pontos");
		lblDobroDe.setBounds(130, 471, 120, 14);
		lblDobroDe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblDobroDe);
		
		JLabel lblVerde = new JLabel("Verde");
		lblVerde.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVerde.setBounds(265, 457, 46, 14);
		add(lblVerde);
		
		JLabel lblReiniciaTamanho = new JLabel(" - Reinicia tamanho da cobra");
		lblReiniciaTamanho.setBounds(296, 457, 180, 14);
		lblReiniciaTamanho.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblReiniciaTamanho);
		
		JLabel lblPreta = new JLabel("Preta");
		lblPreta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPreta.setBounds(265, 471, 46, 14);
		add(lblPreta);
		
		JLabel lblMataA = new JLabel(" - Mata a cobra");
		lblMataA.setBounds(296, 471, 144, 14);
		lblMataA.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblMataA);
		
		JLabel lblPressioneSpacePara = new JLabel("Pressione SPACE para come\u00E7ar...");
		lblPressioneSpacePara.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblPressioneSpacePara.setBounds(120, 519, 297, 44);
		add(lblPressioneSpacePara);
				
		setFocusable(true);
		addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
						
			JFrame jogo = new JFrame();
			Painel painel =  new Painel();
			
			
			jogo.add(painel);
			
			jogo.setResizable(false);
			jogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jogo.setTitle("Snake Game");
			
			jogo.setVisible(true);
			jogo.pack();
			jogo.setLocationRelativeTo(null);

		}
		
	}

	@Override
	public void keyReleased(KeyEvent k) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}

	