package configuregame;

import java.io.IOException;

import dicegameservice.DiceGame;
import mapDAO.MapDAO;


public class ConfigureGame {
	private DiceGame dicegame;
	MapDAO mapdao;
	int[] cell;
	
	public ConfigureGame(DiceGame dicegame) throws IOException{
		this.dicegame = dicegame;
		cell = mapdao.Mapload();
		
	}
	public int[] getCell(){
		return dicegame.getCell();
	}
	public void setCell(int i, int j){
		cell = getCell();
		cell[i] = j;
		dicegame.setCell(cell);
	}
	public void mapDaoSave() throws Exception{
		mapdao.Mapsave(cell);
	}
	
}
