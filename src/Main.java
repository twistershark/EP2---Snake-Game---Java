import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		 new Main();

	}
	
public Main() {
		JFrame frame = new JFrame();
		Painel painel = new Painel();
		
		frame.add(painel);

		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Snake Game");
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.pack();
	}

}
