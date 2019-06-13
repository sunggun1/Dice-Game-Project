package dicegameview;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dicegame.Entry;

public class ResultView extends Frame {
	private Label message;
	
	public ResultView(final String msg, final Entry entry) {
		super("Result View");
		
		message = new Label(msg);
		Button scoreBut = new Button("Score");
		Button cancelBut = new Button("Exit");
		setLayout(new FlowLayout());
		add(message);
		add(scoreBut);
		add(cancelBut);
		
		message.setText(msg);
		
		scoreBut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new ScoreView();
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
