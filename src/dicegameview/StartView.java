package dicegameview;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import configuregame.ConfigureGame;
import configuregameview.ConfigureGameView;
import dicegameservice.DiceGame;

public class StartView extends Frame {
	TextField nametf;
	String name;
	DiceGame dicegame;
	ConfigureGame configuregame;
	
	Panel p1, p2;
	
	public StartView(String title) {
		super(title);
		Button configBut = new Button("Configure");
		Button playBut = new Button("Play");
		Button exitBut = new Button("Exit");
		
		p1 = new Panel();
		p2 = new Panel();
		
		nametf = new TextField(20);
		setLayout(new FlowLayout());
		
		p1.add(nametf);
		p1.add(playBut);
		add(p1);
		
		p2.add(configBut);
		p2.add(exitBut);
		add(p2);
		
		playBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (dicegame == null)
					try {
						dicegame = new DiceGame();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				name = nametf.getText();
				new DiceView(name, dicegame);
				setVisible(false);
				dispose();
			}
		});
		
		// configure를 하게 하는 이벤트 시작
		configBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (dicegame == null)
					try {
						dicegame = new DiceGame();
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				if(configuregame == null)
					try {
						configuregame = new ConfigureGame(dicegame);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				try {
					new ConfigureGameView(dicegame);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		exitBut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);	
			}
		});

		setSize(300, 150);
		setVisible(true);
	}
}
