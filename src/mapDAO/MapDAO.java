package mapDAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MapDAO {
	static String filename = "map.txt";

	public static void Mapsave(int[] cell) throws Exception {
		FileOutputStream output = new FileOutputStream("E:/app/조성권/DiceGame/bin/map.txt");
		for (int i = 0; i < 30; i++) {
			String data = cell[i] + "\r\n";
			output.write(data.getBytes());
		}
		output.close();
	}

	public static int[] Mapload() throws IOException {
		int[] cell;
		try {
			BufferedReader br = new BufferedReader(new FileReader("E:/app/조성권/DiceGame/bin/map.txt"));
			cell = new int[30];
			while (true) {
				int i = 0;
				String line = br.readLine();
				if (line == null)
					break;
				cell[i++] = Integer.valueOf(line);
			}
			br.close();
			return cell;
		} catch (FileNotFoundException e) {
			File mapFile = new File("map.txt");
			return null;
		}

	}
}
