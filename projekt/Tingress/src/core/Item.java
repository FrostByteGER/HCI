package core;

public class Item {
	
	private int uses = Settings.ITEM_USES;
	
	public Item() {
		
	}
	
	public void use(UnitGroup units){
		uses--;
		if(uses == 0){
			depleted(units);
		}
	}
	
	public void depleted(UnitGroup units){
		
	}
}
