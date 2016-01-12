import java.util.ArrayList;

public class Map {

	private ArrayList<ArrayList<Field>> fiels;
	
	public Map() {
		
		fiels = new ArrayList<ArrayList<Field>>();
		
		for(int i =  0 ; i < Utility.MAP_SIZE ; i++){
			fiels.add(new ArrayList<Field>());
			for(int j = 0 ; j < Utility.MAP_SIZE ; j++){
				fiels.get(i).add(new Field(i, j));
			}
		}
	}
	
	public void fightTick(){
		for(int i = 0 ; i < Utility.MAP_SIZE ; i++){
			for(int j = 0 ; j < Utility.MAP_SIZE ; j++){
				fiels.get(i).get(j).fightTick();
			}
		}
	}
	
	public Field getField(int x ,int y){
		return fiels.get(x).get(y);
	}

	public void show() {
		for(ArrayList<Field> af : fiels){
			for(Field f : af){
				f.show();
			}
			System.out.println();
		}
	}
	
	public void showExt() {
		for(ArrayList<Field> af : fiels){
			for(Field f : af){
				f.showExt();
			}
			System.out.println();
		}	
	}
}
