package core;
import java.util.ArrayList;
import java.util.HashMap;

public class GameField {
	
	/*
	private HashMap<Integer,UnitGroup> defGroup;
	private HashMap<Integer,UnitGroup> atkGroup;
	
	private UnitGroup aktiveDefGroup;
	private UnitGroup aktiveAtkGroup;
	
	private int unitCap = Utility.UNIT_CAP_FIELD;
	private int ownerGroup = -1;
	
	private int atkUnits = 0;
	private int defUnits = 0;
	
	private int x = -1;
	private int y = -1;
	*/
	
	private HashMap<Integer, UnitGroup> defGroups;
	private HashMap<Integer, UnitGroup> atkGroups;
	
	private UnitGroup activeDefGroup;
	private UnitGroup activeAtkGroup;
	
	private ArrayList<Building> buildings; 
	
	private int unitCap = Settings.UNIT_CAP_FIELD;
	private int unitAmountDef = 0;
	private int untiAmountAtk = 0;
	private Fraction ownerFraction = null;
	
	private int x = -1;
	private int y = -1;
	
	private boolean isAttacked = false;
	
	private int defLostArcher = 0;
	private int atkLostArcher = 0;
	private int defLostLancer = 0;
	private int atkLostLancer = 0;
	private int defLostHorseman = 0;
	private int atkLostHorseman = 0;
	
	public GameField(int x, int y) {
		
		this.x = x;
		this.y = y;
		
		defGroups = new HashMap<Integer ,UnitGroup>();
		atkGroups = new HashMap<Integer ,UnitGroup>();
		
		activeAtkGroup = null;
		activeDefGroup = null;
		
	}
	
	public boolean addUnits(Player p ,int archerAmount ,int horsemanAmount ,int lancerAmount) {
		
		if(ownerFraction != null){
			if(p.getFraction().equals(ownerFraction)){
				
				unitAmountDef = 0;
				for(Integer ug : defGroups.keySet()){
					unitAmountDef+=defGroups.get(ug).getUnitAmount();
				}
				
				if(Settings.UNIT_CAP_FIELD < archerAmount+horsemanAmount+lancerAmount+unitAmountDef){
					return false;
				}else{
					
				}
			}else{
				
				untiAmountAtk = 0;
				for(Integer ug : atkGroups.keySet()){
					untiAmountAtk+=atkGroups.get(ug).getUnitAmount();
				}
				
				if(Settings.UNIT_CAP_FIELD < archerAmount+horsemanAmount+lancerAmount+untiAmountAtk){
					return false;
				}else{
					untiAmountAtk += archerAmount+horsemanAmount+lancerAmount;
				}
			}
		}
		
		if(p.getUnits().getArcher().size() >= archerAmount && 
			p.getUnits().getHorseman().size() >= horsemanAmount &&
			p.getUnits().getLancer().size() >= lancerAmount){
			
			if(ownerFraction == null){
				ownerFraction = p.getFraction();
				p.getFraction().setOwning(p.getFraction().getOwning()+1);
				defGroups.put(p.getId(), p.getUnits().subGroup(archerAmount, horsemanAmount, lancerAmount));
				nextDefGroup();
			}
			
			if(p.getFraction().equals(ownerFraction)){
				if(defGroups.containsKey(p.getId())){
					defGroups.get(p.getId()).addUnitsFrom(p.getUnits(), archerAmount, horsemanAmount, lancerAmount);
				}else{
					defGroups.put(p.getId(), p.getUnits().subGroup(archerAmount, horsemanAmount, lancerAmount));
				}
			}else{
				
				if(atkGroups.containsKey(p.getId())){
					atkGroups.get(p.getId()).addUnitsFrom(p.getUnits(), archerAmount, horsemanAmount, lancerAmount);
				}else{
					atkGroups.put(p.getId(), p.getUnits().subGroup(archerAmount, horsemanAmount, lancerAmount));
				}
				if(activeAtkGroup == null){
					nextAtkGroup();
				}	
			}
			
			return true;
		}	
		return false;
	}
	
	public void fightTick(){
		
		if(atkGroups.size() == 0){
			return;
		}

		if(buildings == null){
						
			if(activeAtkGroup.getUnitAmount() == 0){
				atkLostArcher += activeAtkGroup.getArcherDeathCounter();
				atkLostLancer += activeAtkGroup.getLancerDeathCounter();
				atkLostHorseman += activeAtkGroup.getHorsemanDeathcounter();
				atkGroups.remove(activeAtkGroup.getOwner().getId());
				if(!nextAtkGroup()){
					return; //TODO
				}
			}

			if(activeDefGroup != null){
				if(activeDefGroup.getUnitAmount() <= 0){	
					defLostArcher += activeDefGroup.getArcherDeathCounter();
					defLostLancer += activeDefGroup.getLancerDeathCounter();
					defLostHorseman += activeDefGroup.getHorsemanDeathcounter();
					defGroups.remove(activeDefGroup.getOwner().getId());
					if(!nextDefGroup()){
						changeOwner();
						return;
					}
				}
			}
			
			activeDefGroup.getOwner().getMoreEx(activeDefGroup.fightTick(activeAtkGroup ,activeDefGroup)*Settings.DEF_EP);
			activeAtkGroup.getOwner().getMoreEx(activeAtkGroup.fightTick(activeDefGroup ,activeAtkGroup)*Settings.ATK_EP);

		}else{
			//TODO implement Buildings
		}
	}
	
	public void changeOwner(){
		
		//System.out.println("change Field Owner");
		
		if(defGroups.size() <= 0){
						
			for(int i = 0 ; i < atkGroups.size() ; i++){
				defGroups.put(((Integer)atkGroups.keySet().toArray()[i]),atkGroups.get(atkGroups.keySet().toArray()[i]));
			}
			
			atkGroups.clear();
			
			ownerFraction.setOwning(ownerFraction.getOwning()-1);
			
			ownerFraction = activeAtkGroup.getOwner().getFraction();
			
			ownerFraction.setOwning(ownerFraction.getOwning()+1);
			
			nextDefGroup();
			
			activeAtkGroup = null;
			
		}
	}
	
	public boolean nextAtkGroup(){
		if(atkGroups.size() > 0){
			activeAtkGroup = atkGroups.get(atkGroups.keySet().toArray()[0]);
			return true;
		}
		activeAtkGroup = null;
		isAttacked = false;
		return false;
	}
	
	public boolean nextDefGroup(){
		if(defGroups.size() > 0){
			activeDefGroup = defGroups.get(defGroups.keySet().toArray()[0]);
			return true;
		}
		activeDefGroup = null;
		isAttacked = false;
		return false;
	}
	
	public void show() {
		if(ownerFraction != null){
			System.out.print("|"+ownerFraction.getNumber());
		}else{
			System.out.print("|n");
		}
	}
	
	public void showExt() {
		if(ownerFraction != null){
			System.out.print("|"+ownerFraction.getNumber()+" "+unitAmountDef+" "+untiAmountAtk);
		}else{
			System.out.print("|n");
		}
	}
	
	/**
	 * @return the unitAmountDef
	 */
	public int getUnitAmountDef() {
		return unitAmountDef;
	}

	/**
	 * @param unitAmountDef the unitAmountDef to set
	 */
	public void setUnitAmountDef(int unitAmountDef) {
		this.unitAmountDef = unitAmountDef;
	}

	/**
	 * @return the untiAmountAtk
	 */
	public int getUntiAmountAtk() {
		return untiAmountAtk;
	}

	/**
	 * @param untiAmountAtk the untiAmountAtk to set
	 */
	public void setUntiAmountAtk(int untiAmountAtk) {
		this.untiAmountAtk = untiAmountAtk;
	}

	/**
	 * @return the buildings
	 */
	public ArrayList<Building> getBuildings() {
		return buildings;
	}

	/**
	 * @param buildings the buildings to set
	 */
	public void setBuildings(ArrayList<Building> buildings) {
		this.buildings = buildings;
	}

	/**
	 * @return the ownerFraction
	 */
	public Fraction getOwnerFraction() {
		return ownerFraction;
	}

	/**
	 * @param ownerFraction the ownerFraction to set
	 */
	public void setOwnerFraction(Fraction ownerFraction) {
		this.ownerFraction = ownerFraction;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the isAttacked
	 */
	public boolean isAttacked() {
		
		return (activeAtkGroup != null);
	}

	/**
	 * @param isAttacked the isAttacked to set
	 */
	public void setAttacked(boolean isAttacked) {
		this.isAttacked = isAttacked;
	}
	
	public int getArcherDefAmount(){
		int end = 0;
		
		for(int ug : defGroups.keySet()){
		 	end += defGroups.get(ug).getArcher().size();
		}
		
		return end;
	}
	
	public int getArcherAtkAmount(){
		int end = 0;
		if(atkGroups != null){
			for(int ug : atkGroups.keySet()){
			 	end += atkGroups.get(ug).getArcher().size();
			}
		}
		return end;
	}
	
	public int getLancerDefAmount(){
		int end = 0;
		
		for(int ug : defGroups.keySet()){
		 	end += defGroups.get(ug).getLancer().size();
		}
		
		return end;
	}
	
	public int getLancerAtkAmount(){
		int end = 0;
		if(atkGroups != null){
			for(int ug : atkGroups.keySet()){
			 	end += atkGroups.get(ug).getLancer().size();
			}
		}
		return end;
	}
	
	public int getHorsemanDefAmount(){
		int end = 0;
		
		for(int ug : defGroups.keySet()){
		 	end += defGroups.get(ug).getHorseman().size();
		}
		
		return end;
	}
	
	public int getHorsemanAtkAmount(){
		int end = 0;
		if(atkGroups != null){
			for(int ug : atkGroups.keySet()){
			 	end += atkGroups.get(ug).getHorseman().size();
			}
		}
		return end;
	}

	/**
	 * @return the defGroups
	 */
	public HashMap<Integer, UnitGroup> getDefGroups() {
		return defGroups;
	}

	/**
	 * @param defGroups the defGroups to set
	 */
	public void setDefGroups(HashMap<Integer, UnitGroup> defGroups) {
		this.defGroups = defGroups;
	}

	/**
	 * @return the atkGroups
	 */
	public HashMap<Integer, UnitGroup> getAtkGroups() {
		return atkGroups;
	}

	/**
	 * @param atkGroups the atkGroups to set
	 */
	public void setAtkGroups(HashMap<Integer, UnitGroup> atkGroups) {
		this.atkGroups = atkGroups;
	}

	/**
	 * @return the activeDefGroup
	 */
	public UnitGroup getActiveDefGroup() {
		return activeDefGroup;
	}

	/**
	 * @param activeDefGroup the activeDefGroup to set
	 */
	public void setActiveDefGroup(UnitGroup activeDefGroup) {
		this.activeDefGroup = activeDefGroup;
	}

	/**
	 * @return the activeAtkGroup
	 */
	public UnitGroup getActiveAtkGroup() {
		return activeAtkGroup;
	}

	/**
	 * @param activeAtkGroup the activeAtkGroup to set
	 */
	public void setActiveAtkGroup(UnitGroup activeAtkGroup) {
		this.activeAtkGroup = activeAtkGroup;
	}

	/**
	 * @return the defLostArcher
	 */
	public int getDefLostArcher() {
		return defLostArcher;
	}

	/**
	 * @param defLostArcher the defLostArcher to set
	 */
	public void setDefLostArcher(int defLostArcher) {
		this.defLostArcher = defLostArcher;
	}

	/**
	 * @return the atkLostArcher
	 */
	public int getAtkLostArcher() {
		return atkLostArcher;
	}

	/**
	 * @param atkLostArcher the atkLostArcher to set
	 */
	public void setAtkLostArcher(int atkLostArcher) {
		this.atkLostArcher = atkLostArcher;
	}

	/**
	 * @return the defLostLancer
	 */
	public int getDefLostLancer() {
		return defLostLancer;
	}

	/**
	 * @param defLostLancer the defLostLancer to set
	 */
	public void setDefLostLancer(int defLostLancer) {
		this.defLostLancer = defLostLancer;
	}

	/**
	 * @return the atkLostLancer
	 */
	public int getAtkLostLancer() {
		return atkLostLancer;
	}

	/**
	 * @param atkLostLancer the atkLostLancer to set
	 */
	public void setAtkLostLancer(int atkLostLancer) {
		this.atkLostLancer = atkLostLancer;
	}

	/**
	 * @return the defLostHorseman
	 */
	public int getDefLostHorseman() {
		return defLostHorseman;
	}

	/**
	 * @param defLostHorseman the defLostHorseman to set
	 */
	public void setDefLostHorseman(int defLostHorseman) {
		this.defLostHorseman = defLostHorseman;
	}

	/**
	 * @return the atkLostHorseman
	 */
	public int getAtkLostHorseman() {
		return atkLostHorseman;
	}

	/**
	 * @param atkLostHorseman the atkLostHorseman to set
	 */
	public void setAtkLostHorseman(int atkLostHorseman) {
		this.atkLostHorseman = atkLostHorseman;
	}
	
	private void sendBattelReport(){
		
	}
	
}
