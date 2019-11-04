import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		 new Main();

	}
	
public Main() {
		JFrame frame = new JFrame();
		Launcher launcher = new Launcher();
		
		frame.add(launcher);

		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Snake Game");
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.pack();
	}

}
