package configuregameview;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import configuregame.ConfigureGame;
import dicegame.Entry;
import dicegameservice.DiceGame;
import dicegameview.ScoreView;

public class ConfigureGameView extends Frame {
	private Label firstNumber;
	private Label secondNumber;
	
	private TextField firstText;
	private TextField secondText;
	
	private ConfigureGame configuregame;
	private DiceGame dicegame;
	private int[] cell;
	
	int num1=0,num2=0;
	
	Panel p1,p2;
	
	public ConfigureGameView(final DiceGame dicegame) throws Exception {
		super("ConfigureGameView");
		
		this.dicegame = dicegame;
		p1 = new Panel();
		Button changeBut = new Button("Change");
		Button cancelBut = new Button("Exit");
		firstNumber = new Label("ÀÌº¥Æ® Ä­");
		secondNumber = new Label("¸ñÇ¥ Ä­");
		
		firstText = new TextField(3);
		secondText = new TextField(3);
		
		setLayout(new FlowLayout());
		
		p1.add(firstNumber);
		p1.add(firstText);
		p1.add(secondNumber);
		p1.add(secondText);
		p1.add(changeBut);
		p1.add(cancelBut);

		setLayout(new BorderLayout());
		add(p1);
		configuregame = new ConfigureGame(dicegame);
		
		changeBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				num1 = Integer.parseInt(firstText.getText());
				num2 = Integer.parseInt(secondText.getText());
				configuregame.setCell(num1,num2);
				firstText.setText("");
				secondText.setText("");
				try {
					configuregame.mapDaoSave();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		cancelBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});

		setSize(500, 100);
		setVisible(true);
	}
}