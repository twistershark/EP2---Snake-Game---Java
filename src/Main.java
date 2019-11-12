import javax.swing.JFrame;

public class Main {
	static JFrame frame = new JFrame();
	
	public static void main(String[] args) {
		 new Main();
	}
	
	public Main() {	
		Inicializador inic = new Inicializador();
	
		frame.add(inic);
	
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Snake Game");
	
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		}

}
