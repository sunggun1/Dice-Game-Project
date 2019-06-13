package dicegameview;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dicegame.Scores;
import dicegameservice.DiceGame;

public class ScoreView extends Frame {
	ScrollPane scoll;
	DiceGame dicegame;
	Panel p1, p2;
	Button exitBut;
	
	public ScoreView() throws Exception {
		super("Score View");
		dicegame = new DiceGame();
		p1 = new Panel();
		p2 = new Panel();
		ScrollPane scroll = new ScrollPane();
		exitBut = new Button("Exit");
		
		Scores scores = dicegame.load();
		final List list = scores.getList();
		scroll.add(list);
		p1.add(scroll);
		p2.add(exitBut);
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		scroll.setSize(250, 100);
		setSize(300, 200);
		setVisible(true);
		
		exitBut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}			
		});
	}
	
}
