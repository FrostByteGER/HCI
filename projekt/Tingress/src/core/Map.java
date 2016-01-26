package core;
import java.util.ArrayList;

public class Map {

	private ArrayList<ArrayList<GameField>> fiels;
	
	public Map() {
		
		fiels = new ArrayList<ArrayList<GameField>>();
		
		for(int i =  0 ; i < Settings.MAP_SIZE ; i++){
			fiels.add(new ArrayList<GameField>());
			for(int j = 0 ; j < Settings.MAP_SIZE ; j++){
				fiels.get(i).add(new GameField(i, j));
			}
		}
	}
	
	public void fightTick(){
		for(int i = 0 ; i < Settings.MAP_SIZE ; i++){
			for(int j = 0 ; j < Settings.MAP_SIZE ; j++){
				fiels.get(i).get(j).fightTick();
			}
		}
	}
	
	public GameField getField(int x ,int y){
		return fiels.get(x).get(y);
	}

	public void show() {
		for(ArrayList<GameField> af : fiels){
			for(GameField f : af){
				f.show();
			}
			System.out.println();
		}
	}
	
	public void showExt() {
		for(ArrayList<GameField> af : fiels){
			for(GameField f : af){
				f.showExt();
			}
			System.out.println();
		}	
	}
}
