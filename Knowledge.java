import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;

public class Knowledge extends JFrame {
	private static Knowledge frame;
	private static SignFrame signframe;
	private static PlayGame gamePanel;
	public Knowledge(){
		add(gamePanel);
		super.setResizable(false);
	}
	
	public static void main(String[] args) {
		signframe = new SignFrame();
		gamePanel = new PlayGame();
		frame = new Knowledge();
		frame.setBounds(100, 100, 688, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
	}
	
	public static Knowledge getFrame(){
		return frame;
	}
}
