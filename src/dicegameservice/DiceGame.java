package dicegameservice;

import diceDAO.ScoreDAO;
import dicegame.Dice;
import dicegame.Scores;
import dicegame.WinningStatus;
import mapDAO.MapDAO;

public class DiceGame {
	private Dice r1;
	private Dice r2;
	private int faceValue1;
	private int faceValue2;
	private int [] cell;
	
	private int curCell1;
	private int curCell2;
	private MapDAO map;
	final private int Goal = 29;
	
	public DiceGame() throws Exception {
		r1 = new Dice();
		r2 = new Dice();
		faceValue1 = faceValue2 = curCell1 = curCell2 = 0;
		cell = new int [30];
		
		
		for (int i=0;i<30;i++)
			cell[i] = i;
		make_trap_cells();
		make_bonus_cells();
		map.Mapsave(cell);
		// 저장 된 cell의 내용을 생성하면서 불러오고 셋팅하는 역할
	}
	
	public WinningStatus roll() {
		faceValue1 = r1.roll();
		faceValue2 = r2.roll();
		
		curCell1 += faceValue1;
		curCell2 += faceValue2;
		
		if (curCell1 >= Goal && curCell2 >= Goal)
			return WinningStatus.Draw;
		else if (curCell1 >= Goal && curCell2 < Goal)
			return WinningStatus.Player;
		else if (curCell1 < Goal && curCell2 >= Goal)
			return WinningStatus.AlphaDice;
		else {
			if (curCell1 != cell[curCell1])
				curCell1 = cell[curCell1];
			if (curCell2 != cell[curCell2])
				curCell2 = cell[curCell2];
			return WinningStatus.NotYet;
		}
	}
	
	public int getFaceValue1() {
		return faceValue1;
	}
	
	public int getFaceValue2() {
		return faceValue2;
	}
	
	public int getCurCellPos1() {
		return curCell1;
	}
	
	public int getCurCellPos2() {
		return curCell2;
	}
	
	// dicegame의 cell을 다른 곳에서 사용하도록 하게끔 해줌
	public int[] getCell() {
		return cell;
	}
	
	// 바뀐 cell의 내용을 가져오는 함수
	public void setCell(int [] cell) {
		this.cell = cell;
	}
	
	private void make_trap_cells() {
		cell[10] = 0;
		cell[28] = 0;
		cell[8] = 3;
		cell[15] = 5;
		cell[21] = 12;
		cell[25] = 17;
	}
	
	private void make_bonus_cells() {
		cell[11] = 20;
		cell[26] = 27;
		cell[9] = 14;
		cell[16] = 22;
	}
	
	public Scores load() {
		try {
			return ScoreDAO.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void save(Scores scores) {
		try {
			ScoreDAO.save(scores);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}