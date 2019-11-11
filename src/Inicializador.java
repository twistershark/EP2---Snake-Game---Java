import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

public class Inicializador extends JPanel implements ActionListener {


	public int getTipo_cobra() {
		return tipo_cobra;
	}

	public void setTipo_cobra(int tipo_cobra) {
		this.tipo_cobra = tipo_cobra;
	}

	public int getColisao_com_paredes() {
		return colisao_com_paredes;
	}

	public void setColisao_com_paredes(int colisao_com_paredes) {
		this.colisao_com_paredes = colisao_com_paredes;
	}

	private static final long serialVersionUID = 1L;

	// DECLARACAO DE ATRIBUTOS
	
	private int tipo_cobra = 2;
	private int colisao_com_paredes = 1;

	
	public Inicializador() {
		menu();
	}

	public void menu(){
		setPreferredSize(new Dimension(600, 600));
		
		setBackground(Color.WHITE);
		setLayout(null);

		
		//TITULO
		JLabel titulo_jogo = new JLabel("Snake Game");
		titulo_jogo.setFont(new Font("Lucida Handwriting", Font.PLAIN, 30));
		titulo_jogo.setBounds(210, -18, 225, 76);
		add(titulo_jogo);
		
		JLabel FraseTipoCobra = new JLabel("Escolha o tipo de cobra:");
		FraseTipoCobra.setFont(new Font("Helvetica", Font.PLAIN, 15));
		FraseTipoCobra.setBounds(220, 69, 158, 25);
		add(FraseTipoCobra);
		
		
		//IMAGENS DAS COBRAS
		JLabel imagemKitty = new JLabel("New label");
		Image kitty = new ImageIcon(this.getClass().getResource("/kitty.png")).getImage();
		imagemKitty.setIcon(new ImageIcon(kitty));
		imagemKitty.setBounds(30, 113, 131, 135);
		add(imagemKitty);
		
		JLabel imagemComum = new JLabel("New label");
		Image comum = new ImageIcon(this.getClass().getResource("/comum.png")).getImage();
		imagemComum.setIcon(new ImageIcon(comum));
		imagemComum.setBounds(230, 113, 131, 135);
		add(imagemComum);

		
		JLabel imagemStar = new JLabel("New label");
		Image star = new ImageIcon(this.getClass().getResource("/star.png")).getImage();
		imagemStar.setIcon(new ImageIcon(star));
		imagemStar.setBounds(430, 113, 131, 135);
		add(imagemStar);
		
		
		//NOMES E INFO SOBRE AS COBRAS
		JLabel infoKitty = new JLabel("Kitty - Easy");
		infoKitty.setFont(new Font("Helvetica", Font.BOLD, 12));
		infoKitty.setBounds(63, 247, 86, 20);
		add(infoKitty);
		
		JLabel infoComum = new JLabel("Comum - Normal");
		infoComum.setFont(new Font("Helvetica", Font.BOLD, 12));
		infoComum.setBounds(245, 247, 107, 20);
		add(infoComum);
		
		JLabel infoStar = new JLabel("Star - Hard");
		infoStar.setFont(new Font("Helvetica", Font.BOLD, 12));
		infoStar.setBounds(463, 247, 77, 20);
		add(infoStar);
		
		JLabel powerNormal = new JLabel("Sem habilidades especiais");
		powerNormal.setFont(new Font("Helvetica", Font.PLAIN, 12));
		powerNormal.setBounds(220, 270, 200, 20);
		add(powerNormal);
		
		JLabel powerKitty = new JLabel("Atravessa barreiras");
		powerKitty.setFont(new Font("Helvetica", Font.PLAIN, 12));
		powerKitty.setBounds(40, 270, 150, 20);
		add(powerKitty);
		
		JLabel powerStar = new JLabel("Dobro de pontos");
		powerStar.setFont(new Font("Helvetica", Font.PLAIN, 12));
		powerStar.setBounds(450, 270, 120, 20);
		add(powerStar);
		
		
		//RADIOBUTTON DE SELECAO DE COBRAS
		ButtonGroup grupobutton = new ButtonGroup();
		
		JRadioButton kitty_botao = new JRadioButton("");
		kitty_botao.setBackground(Color.WHITE);
		kitty_botao.setBounds(80, 297, 25, 23);
		kitty_botao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setTipo_cobra(1);
				kitty_botao.setSelected(true);	
			}
		});
		add(kitty_botao);
		
		JRadioButton comum_botao = new JRadioButton("");
		comum_botao.setBackground(Color.WHITE);
		comum_botao.setSelected(true);
		comum_botao.setBounds(280, 297, 25, 23);
		comum_botao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setTipo_cobra(2);
				comum_botao.setSelected(true);	
			}
		});
		add(comum_botao);
		
		JRadioButton star_botao = new JRadioButton("");
		star_botao.setBackground(Color.WHITE);
		star_botao.setBounds(480, 297, 25, 23);
		star_botao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setTipo_cobra(3);
				star_botao.setSelected(true);	
			}	
		});
		add(star_botao);
		
		grupobutton.add(kitty_botao);
		grupobutton.add(comum_botao);
		grupobutton.add(star_botao);
		
		
		//COLISOES
		JLabel fraseColisoes = new JLabel("Colisao com as paredes?");
		fraseColisoes.setFont(new Font("Helvetica", Font.BOLD, 12));
		fraseColisoes.setBounds(32, 352, 158, 14);
		add(fraseColisoes);
		
		ButtonGroup grupo_colisao = new ButtonGroup();
		
		JRadioButton sim_botao = new JRadioButton("Sim");
		sim_botao.setSelected(true);
		sim_botao.setBackground(Color.WHITE);
		sim_botao.setBounds(183, 348, 50, 23);
		sim_botao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setColisao_com_paredes(1);
				sim_botao.setSelected(true);				
			}	
		});
		add(sim_botao);
		
		JRadioButton nao_botao = new JRadioButton("Nao");
		nao_botao.setBackground(Color.WHITE);
		nao_botao.setBounds(236, 348, 109, 23);
		nao_botao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setColisao_com_paredes(0);
				nao_botao.setSelected(true);				
			}	
		});
		add(nao_botao);
		
		grupo_colisao.add(sim_botao);
		grupo_colisao.add(nao_botao);
		
		
		//INFO SOBRE AS DIFERENTES FRUTAS
		JLabel fraseFrutas = new JLabel("Tipos de frutas");
		fraseFrutas.setFont(new Font("Helvetica", Font.BOLD, 18));
		fraseFrutas.setBounds(240, 390, 140, 42);
		add(fraseFrutas);
		
		JLabel frutaVermelha = new JLabel("Vermelha");
		frutaVermelha.setFont(new Font("Helvetica", Font.BOLD, 15));
		frutaVermelha.setBounds(120, 457, 70, 14);
		add(frutaVermelha);
		
		JLabel infoVermelha = new JLabel(" - Fruta comum");
		infoVermelha.setBounds(190, 457, 120, 14);
		infoVermelha.setFont(new Font("Helvetica", Font.PLAIN, 15));
		add(infoVermelha);
		
		JLabel frutaAmarela = new JLabel("Amarela");
		frutaAmarela.setFont(new Font("Helvetica", Font.BOLD, 15));
		frutaAmarela.setBounds(120, 475, 80, 14);
		add(frutaAmarela);
		
		JLabel infoAmarela = new JLabel(" - Dobro de pontos");
		infoAmarela.setBounds(180, 475, 140, 14);
		infoAmarela.setFont(new Font("Helvetica", Font.PLAIN, 15));
		add(infoAmarela);
		
		JLabel frutaVerde = new JLabel("Verde");
		frutaVerde.setFont(new Font("Helvetica", Font.BOLD, 15));
		frutaVerde.setBounds(330, 457, 46, 14);
		add(frutaVerde);
		
		JLabel infoVerde = new JLabel(" - Reinicia tamanho da cobra");
		infoVerde.setBounds(370, 457, 210, 14);
		infoVerde.setFont(new Font("Helvetica", Font.PLAIN, 15));
		add(infoVerde);
		
		JLabel frutaPreta = new JLabel("Preta");
		frutaPreta.setFont(new Font("Helvetica", Font.BOLD, 15));
		frutaPreta.setBounds(330, 475, 46, 14);
		add(frutaPreta);
		
		JLabel infoPreta = new JLabel(" - Mata a cobra");
		infoPreta.setBounds(370, 475, 160, 14);
		infoPreta.setFont(new Font("Helvetica", Font.PLAIN, 15));
		add(infoPreta);
		
		
		//JBUTTON PARA INICIAR O JOGO
		JButton start = new JButton();
		start.setText("START");
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
	      

				JFrame jogo = new JFrame();
				Painel painel =  new Painel(tipo_cobra, colisao_com_paredes);
				
				jogo.add(painel);	
				jogo.setResizable(false);
				jogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jogo.setTitle("Snake Game");
				jogo.setVisible(true);
				jogo.pack();
				jogo.setLocationRelativeTo(null);		
			}
		});		
		start.setFont(new Font("Helvetica", Font.ITALIC, 20));
		start.setBounds(150, 519, 297, 44);
		add(start);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}
}

	