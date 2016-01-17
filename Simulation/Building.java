import java.io.File;
import java.util.HashMap;

public class Building {

	private HashMap<Integer, UnitGroup> defGroups;
	private HashMap<Integer, UnitGroup> atkGroups;
	
	private UnitGroup activeDefGroup;
	private UnitGroup activeAtkGroup;
	
	private Field field;
	 
	private int unitCap;
	private int ownerFraction = -1;
	
	private int atkUnits = 0;
	private int defUnits = 0;
	
	public Building(Field field) {
		this.field = field;
	}

	public void fightTick(){
		
	}
	
	/**
	 * @return the field
	 */
	public Field getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(Field field) {
		this.field = field;
	}
	
	
	
}
