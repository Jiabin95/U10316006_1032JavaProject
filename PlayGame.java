import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Date;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;


public class PlayGame extends JPanel {
	private JButton start = new JButton("Start");
	private JButton[] choice = new JButton[4];
	private JButton next;
	private boolean isStart = false;
	private boolean right = false;
	private JLabel question = new JLabel();
	private JLabel Remaintime;
	private int score = 0;
	private int count = 1;
	private boolean isAnswer, finish;
	private boolean[] isAppear = new boolean[50];
	private Date date = new Date();
	private long startime;
	private long end;
	long l;
	
	private JTextField zongjie = new JTextField();
	PlayGame(){
		setLayout(null);
		setBounds(0, 0, 688, 600);
		setVisible(true);
		readyPlay();
		
	}
	
	private void readyPlay(){ 
		start.setBounds(500,450,120,60);
		start.setFont(new Font("Microsoft YaHei",Font.BOLD,17));
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isStart = true;
				SetQuestion();
				repaint();
				startime = System.currentTimeMillis();
			}			
		});
		add(start);
		
		Remaintime = new JLabel();
		Remaintime.setBounds(400,10,250,100);
		Remaintime.setFont(new Font("Microsoft YaHei",Font.BOLD,17));
		Timer timer = new Timer(1000, new ActionListener(){
			public void actionPerformed(ActionEvent e){
					if(count <= 10)
						SetQuestion();
					}
	    });
	}
	
	private void SetQuestion(){
		int randomQue = (int)(Math.random()*50);
		//Do count++;   
		while(isAppear[randomQue] && count<=10){
			randomQue = (int)(Math.random()*50);
		}
		isAppear[randomQue] = true;
		Question.question(randomQue);
		question = new JLabel(Question.Que, JLabel.LEFT);
		question.setFont(new Font("Microsoft YaHei",Font.BOLD,Question.Que.length()<15?35:20));
		question.setBounds(120,60,400,100);
		add(question);
		for(int i=0; i<4; i++){
			choice[i] = new JButton(Question.C[i]);
			choice[i].setFont(new Font("Microsoft YaHei",Font.BOLD, Question.C[i].length()<10?35:25));
			choice[i].setBounds(130, 170 + 70*i, 400, 50);
			add(choice[i]);	
			Judge(i);
		}
		
		next = new JButton(count == 10? "Finish": "Next question");
		next.setFont(new Font("Microsoft YaHei",Font.BOLD,15));
		next.setBounds(450, 500, 200, 50);
		add(next);
		
		add(Remaintime);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isAnswer){
					count++;
					finish = (count > 10);
					if(right)
						score += 10;
					else
						JOptionPane.showMessageDialog(null, "Your answer is not correct! The answer is " + Question.C[Question.ANS]);
				
					isAnswer = false;
					right = false;

					removeAll();
					repaint();
					if(!finish){
						SetQuestion();
					}
					else{
						l = System.currentTimeMillis() - startime;
						zongjie.setText("Use Time"+l/1000+"Seconds" );
						}
					}
				else
					JOptionPane.showMessageDialog(null, "Please choose!");
			}
		});
	}
	
	private void Judge(int c){
		choice[c].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				isAnswer = true;
				if(Question.ANS == c){
					right = true;
				}
			}
	    });
	}
	
	@Override 
	protected void paintComponent(Graphics d) {
		
		if(isStart){
			
			if(count <= 10){
			d.setColor(Color.blue);
			d.fillRect(0, 0, 688, 600);
			remove(start);
			d.setColor(Color.BLACK);
			d.setFont(new Font("Microsoft YaHei",Font.BOLD,35));
			d.drawString("A.", 80, 210);
			d.drawString("B.", 80, 280);
			d.drawString("C.", 80, 350);
			d.drawString("D.", 80, 420);
			d.setFont(new Font("Microsoft YaHei",Font.BOLD,20));
			d.drawString("Question "+count+"/10", 10, 30);
			d.drawString("Score: " + score, 20, 525);
				
			
			}
			else{
				d.setColor(Color.BLACK);
				d.fillRect(0, 0, 688, 600);
				d.setColor(Color.WHITE);
				d.setFont(new Font("Microsoft YaHei",Font.BOLD,35));
				d.drawString("你得了:" + score, 80, 210);
				d.drawString("你用了:" + l/1000 +"秒,"+"谢谢你来玩我的小游戏",90, 310);
		
			}
			
		}
		else{
			d.setColor(Color.RED);
			d.setFont(new Font("Welcome",Font.BOLD,30));
			d.drawString("歡迎來玩知識王", 280, 75);
		
			d.setColor(Color.BLUE);
			d.setFont(new Font(SignFrame.getID_And_Name(),Font.BOLD,24));
			d.drawString(SignFrame.getID_And_Name(), 240, 150);
		}
	}
	
	
	
}
