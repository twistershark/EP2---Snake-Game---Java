import javax.swing.JFrame;

public class Launcher {
	
	public static void main(String[] args) {
		 new Launcher();

	}
	
public Launcher() {
		JFrame frame = new JFrame();

		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Snake Game");
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.pack();
	}

}
