import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class Sign extends JFrame {
	private static JLabel name = new JLabel("NAME ");
	private static JLabel Student = new JLabel("STUDENT ID ");
	private static JTextField Inputa = new JTextField();
	private static JTextField Inputb = new JTextField();
	private static JButton Sign = new JButton("OK");
	
	Sign(){
		
		setTitle("Sign");
		setBounds(130, 130, 300, 220);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		name.setBounds(30,40,80,20);
		add(name);
		
		Inputa.setBounds(95,40,120,20);
		Inputa.setColumns(10);
		add(Inputa);
		
		Student.setBounds(28,80,80,20);
		add(Student);
		
		Inputb.setBounds(95,80,120,20);
		Inputb.setColumns(9);
		add(Inputb);
		
		Sign.setBounds(180, 120, 60, 20);
		Sign.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Knowledge.getFrame().setVisible(true);
				Knowledge.getFrame().setTitle(Inputb.getText());
				SwingUtilities.windowForComponent(Sign).dispose();
			}
		});
		add(Sign);
	}
	public static String getID_And_Name(){
		return Inputb.getText() + " " + Inputa.getText();
	}
}
