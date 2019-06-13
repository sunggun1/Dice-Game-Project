package diceDAO;

import java.io.*;
import dicegame.Scores;

public class ScoreDAO {
	static String filename = "score.dat";
	
	public static void save(Scores scores) throws Exception {
		FileOutputStream ostream = new FileOutputStream(filename);
		ObjectOutputStream p = new ObjectOutputStream(ostream);
		p.writeObject(scores);
		p.flush();
		ostream.close();
	}
	
	public static Scores load() throws Exception {
		FileInputStream istream;
		
		try {
			istream = new FileInputStream(filename);
			ObjectInputStream q = new ObjectInputStream(istream);
			Scores scr = (Scores)q.readObject();
			istream.close();
			return scr;
		} catch (FileNotFoundException e) {
			File scoreFile = new File("score.dat");
		}
		return null;
	}
}
