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

	private static final long serialVersionUID = 1L;

	// DECLARA��O DE ATRIBUTOS
	
	private int tipo_cobra;
	private int colisao_com_paredes;
	
	public Inicializador() {
		menu();
	}

	public void menu(){
		setPreferredSize(new Dimension(600, 600));
		
		setBackground(Color.WHITE);
		setLayout(null);
		
		
		//TITULO
		JLabel lblSnakeGame = new JLabel("Snake Game");
		lblSnakeGame.setFont(new Font("Lucida Handwriting", Font.PLAIN, 30));
		lblSnakeGame.setBounds(210, -18, 225, 76);
		add(lblSnakeGame);
		
		JLabel lblEscolhaOTipo = new JLabel("Escolha o tipo de cobra:");
		lblEscolhaOTipo.setFont(new Font("Helvetica", Font.PLAIN, 15));
		lblEscolhaOTipo.setBounds(220, 69, 158, 25);
		add(lblEscolhaOTipo);
		
		
		//IMAGENS DAS COBRAS
		JLabel kitty_label = new JLabel("New label");
		Image kitty = new ImageIcon(this.getClass().getResource("/kitty.png")).getImage();
		kitty_label.setIcon(new ImageIcon(kitty));
		kitty_label.setBounds(30, 113, 131, 135);
		add(kitty_label);
		
		JLabel comum_label = new JLabel("New label");
		Image comum = new ImageIcon(this.getClass().getResource("/comum.png")).getImage();
		comum_label.setIcon(new ImageIcon(comum));
		comum_label.setBounds(230, 113, 131, 135);
		add(comum_label);

		
		JLabel star_label = new JLabel("New label");
		Image star = new ImageIcon(this.getClass().getResource("/star.png")).getImage();
		star_label.setIcon(new ImageIcon(star));
		star_label.setBounds(430, 113, 131, 135);
		add(star_label);
		
		
		//NOMES E INFO SOBRE AS COBRAS
		JLabel txtpnKitty = new JLabel("Kitty - Fácil");
		txtpnKitty.setFont(new Font("Helvetica", Font.BOLD, 12));
		txtpnKitty.setBounds(63, 247, 86, 20);
		add(txtpnKitty);
		
		JLabel txtpnComum = new JLabel("Comum - Normal");
		txtpnComum.setFont(new Font("Helvetica", Font.BOLD, 12));
		txtpnComum.setBounds(245, 247, 107, 20);
		add(txtpnComum);
		
		JLabel txtpnStar = new JLabel("Star - Difícil");
		txtpnStar.setFont(new Font("Helvetica", Font.BOLD, 12));
		txtpnStar.setBounds(463, 247, 77, 20);
		add(txtpnStar);
		
		JLabel txtpnSemHabilidadesEspeciais = new JLabel("Sem habilidades especiais");
		txtpnSemHabilidadesEspeciais.setFont(new Font("Helvetica", Font.PLAIN, 12));
		txtpnSemHabilidadesEspeciais.setBounds(220, 270, 200, 20);
		add(txtpnSemHabilidadesEspeciais);
		
		JLabel txtpnAtravessaBarreiras = new JLabel("Atravessa barreiras");
		txtpnAtravessaBarreiras.setFont(new Font("Helvetica", Font.PLAIN, 12));
		txtpnAtravessaBarreiras.setBounds(40, 270, 150, 20);
		add(txtpnAtravessaBarreiras);
		
		JLabel txtpnDobroDePontos = new JLabel("Dobro de pontos");
		txtpnDobroDePontos.setFont(new Font("Helvetica", Font.PLAIN, 12));
		txtpnDobroDePontos.setBounds(450, 270, 120, 20);
		add(txtpnDobroDePontos);
		
		
		//RADIOBUTTON DE SELECAO DE COBRAS
		ButtonGroup grupobutton = new ButtonGroup();
		
		JRadioButton kitty_rb = new JRadioButton("");
		kitty_rb.setBackground(Color.WHITE);
		kitty_rb.setBounds(80, 297, 25, 23);
		add(kitty_rb);
		
		JRadioButton comum_rb = new JRadioButton("");
		comum_rb.setBackground(Color.WHITE);
		comum_rb.setSelected(true);
		comum_rb.setBounds(280, 297, 25, 23);
		add(comum_rb);
		
		JRadioButton star_rb = new JRadioButton("");
		star_rb.setBackground(Color.WHITE);
		star_rb.setBounds(480, 297, 25, 23);
		add(star_rb);
		
		grupobutton.add(kitty_rb);
		grupobutton.add(comum_rb);
		grupobutton.add(star_rb);
		
		
		//COLISOES
		JLabel colisoes_label = new JLabel("Colisão com as paredes?");
		colisoes_label.setFont(new Font("Helvetica", Font.BOLD, 12));
		colisoes_label.setBounds(32, 352, 158, 14);
		add(colisoes_label);
		
		ButtonGroup colisaogrupo = new ButtonGroup();
		
		JRadioButton sim_rb = new JRadioButton("Sim");
		sim_rb.setSelected(true);
		sim_rb.setBackground(Color.WHITE);
		sim_rb.setBounds(183, 348, 60, 23);
		add(sim_rb);
		
		JRadioButton nao_rb = new JRadioButton("Não");
		nao_rb.setBackground(Color.WHITE);
		nao_rb.setBounds(233, 348, 109, 23);
		add(nao_rb);
		
		colisaogrupo.add(sim_rb);
		colisaogrupo.add(nao_rb);
		
		
		
		//INFO SOBRE AS DIFERENTES FRUTAS
		JLabel lblTiposDeFrutas = new JLabel("Tipos de frutas");
		lblTiposDeFrutas.setFont(new Font("Helvetica", Font.BOLD, 18));
		lblTiposDeFrutas.setBounds(240, 390, 140, 42);
		add(lblTiposDeFrutas);
		
		JLabel lblVermelha = new JLabel("Vermelha");
		lblVermelha.setFont(new Font("Helvetica", Font.BOLD, 15));
		lblVermelha.setBounds(120, 457, 70, 14);
		add(lblVermelha);
		
		JLabel lblFrutaComum = new JLabel(" - Fruta comum");
		lblFrutaComum.setBounds(190, 457, 120, 14);
		lblFrutaComum.setFont(new Font("Helvetica", Font.PLAIN, 15));
		add(lblFrutaComum);
		
		JLabel lblAmarela = new JLabel("Amarela");
		lblAmarela.setFont(new Font("Helvetica", Font.BOLD, 15));
		lblAmarela.setBounds(120, 475, 80, 14);
		add(lblAmarela);
		
		JLabel lblDobroDe = new JLabel(" - Dobro de pontos");
		lblDobroDe.setBounds(180, 475, 140, 14);
		lblDobroDe.setFont(new Font("Helvetica", Font.PLAIN, 15));
		add(lblDobroDe);
		
		JLabel lblVerde = new JLabel("Verde");
		lblVerde.setFont(new Font("Helvetica", Font.BOLD, 15));
		lblVerde.setBounds(330, 457, 46, 14);
		add(lblVerde);
		
		JLabel lblReiniciaTamanho = new JLabel(" - Reinicia tamanho da cobra");
		lblReiniciaTamanho.setBounds(370, 457, 210, 14);
		lblReiniciaTamanho.setFont(new Font("Helvetica", Font.PLAIN, 15));
		add(lblReiniciaTamanho);
		
		JLabel lblPreta = new JLabel("Preta");
		lblPreta.setFont(new Font("Helvetica", Font.BOLD, 15));
		lblPreta.setBounds(330, 475, 46, 14);
		add(lblPreta);
		
		JLabel lblMataA = new JLabel(" - Mata a cobra");
		lblMataA.setBounds(370, 475, 160, 14);
		lblMataA.setFont(new Font("Helvetica", Font.PLAIN, 15));
		add(lblMataA);
		
		
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
		
		
		//VERIFICAR TIPO DE COBRA SELECIONADO
		if(kitty_rb.isSelected()) {
			tipo_cobra = 1;
		}
		else if(comum_rb.isSelected()) {
			tipo_cobra = 2;
		}
		else if(star_rb.isSelected()) {
			tipo_cobra = 2;
		}
		
		// VERIFICAR SE COLISÃO ESTÁ ATIVA
		if(sim_rb.isSelected()) {
			colisao_com_paredes = 1;
		}
		else if (nao_rb.isSelected()) {
			colisao_com_paredes = 0;
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

	