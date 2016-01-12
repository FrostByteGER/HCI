

public class Player {
	
	private Integer id = -1;
	
	private int x = -1;
	private int y = -1;
	
	private int money = 0;
	private int moneyPerTime = Utility.MONEY_PER_TICK;
	private int maxMoney = Utility.MONEY_CAP;
	private int plusLevel = Utility.MORE_MONEY_PER_LEVEL;
	
	private int ep = 0;
	private int level = 0;
	private int levelup = Utility.EP_START;
	private int levelNext = Utility.EP_FOR_NEXT_LEVEL_MUL;
	private Fraction fraction;
	private Clan clan;
	
	private UnitGroup units;
	private int unitCost = Utility.UNIT_COST;
	private int unitCap = Utility.UNIT_CAP_PLAYER;
	private int unitLevel = Utility.MORE_UNITS_PER_LEVEL;
	
	public Player(int id, Fraction fraction) {
		this.id = id;
		this.fraction = fraction;
		this.clan = null;
		this.units = new UnitGroup(this);
		
		
	}
	
	public void levelUp(){
		level++;
		maxMoney+=plusLevel;
		unitCap+=unitLevel;
		levelup*=levelNext;
	}
	
	public void getMoreEx(int value){
		ep += value;
		if(ep <= levelup){
			levelUp();
		}
	}
	
	public boolean buyArcher(int amount){
		
		if(units.getUnitAmount() + amount < unitCap){
			if(unitCost * amount <= money){
				money -= unitCost*amount;
				units.addArcher(amount);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean buyHorseman(int amount){
		
		if(units.getUnitAmount() + amount < unitCap){
			if(unitCost * amount <= money){
				money -= unitCost*amount;
				units.addHorseman(amount);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean buyLancer(int amount){
		
		if(units.getUnitAmount() + amount < unitCap){
			if(unitCost * amount <= money){
				money -= unitCost*amount;
				units.addLancer(amount);
				return true;
			}
		}
		
		return false;
	}
	
	public void buyUnitsUntil(){
		
		if(money >= Utility.UNIT_COST*3){
			int temp = 0;
						
			temp = (money/unitCost)/3;
			
			if(units.getUnitAmount() + temp*3 > Utility.UNIT_CAP_PLAYER){
				temp = (Utility.UNIT_CAP_FIELD-units.getUnitAmount())/3-1;
			}
			
			buyArcher(temp);
			buyHorseman(temp);
			buyLancer(temp);
		}
	}
	
	// für Benutzer
	public void addUnitsToField(Field f ,int archerAmount ,int horsemanAmount ,int lancerAmount){
		f.addUnits(this, archerAmount, horsemanAmount, lancerAmount);
	}
	
	// Für KI
	public int addAllUnitsToField(Field f){
		
		int archerAmount = units.getArcher().size();
		int horsemanAmount = units.getHorseman().size();
		int lancerAmount = units.getLancer().size();
		
		double temp = Utility.UNIT_CAP_FIELD;
				
		// rechnet die Anzahl an einheiten aus die Plaziert werden können für
		// jeden Slot Archer ,Horseman und Lancer ( /3)
		if(f.getOwnerFraction() != null && getFraction() != null){
			if(f.getOwnerFraction().equals(getFraction())){
				temp = ((1D-(f.getUnitAmountDef()/Utility.UNIT_CAP_FIELD))*Utility.UNIT_CAP_FIELD)/3;
			}else{
				temp = ((1D-(f.getUntiAmountAtk()/Utility.UNIT_CAP_FIELD))*Utility.UNIT_CAP_FIELD)/3;
			}
		}
			
		if(temp <= archerAmount){
			archerAmount = (int)temp-1;
		}
		
		if(temp <= horsemanAmount){
			horsemanAmount = (int)temp-1;
		}
		
		if(temp <= lancerAmount){
			lancerAmount = (int)temp-1;
		}	
		
		addUnitsToField(f, archerAmount, horsemanAmount, lancerAmount);
		
		return 0;
	}
	
	public void earnMoney(){
		if((money+moneyPerTime)+((fraction.getOwning()/(Utility.MAP_SIZE*Utility.MAP_SIZE))*Utility.MONEY_PER_FIELD) < Utility.MONEY_CAP){
			this.money += moneyPerTime+((fraction.getOwning()/(Utility.MAP_SIZE*Utility.MAP_SIZE))*Utility.MONEY_PER_FIELD);
		}
		
	}
	
	public void show(){
		System.out.println("ID: "+id+" Fraction: "+fraction.getNumber()+" Money: "+money+" Level: "+level+" Units: "+units.getUnitAmount()+" "+ep);
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void earnMoney(double owning){
		if((money+moneyPerTime)+(owning*Utility.MONEY_PER_FIELD) < maxMoney){
			this.money += moneyPerTime+(owning*Utility.MONEY_PER_FIELD);
		}
		
	}
	
	/**
	 * @return the ep
	 */
	public int getEp() {
		return ep;
	}

	/**
	 * @param ep the ep to set
	 */
	public void setEp(int ep) {
		this.ep = ep;
	}

	public void addEp(int amount){
		
		ep += amount;
		
		if(ep >= levelup){
			levelUp();
		}
	}
	
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the fraction
	 */
	public Fraction getFraction() {
		return fraction;
	}

	/**
	 * @param fraction the fraction to set
	 */
	public void setFraction(Fraction fraction) {
		this.fraction = fraction;
	}

	/**
	 * @return the clan
	 */
	public Clan getClan() {
		return clan;
	}

	/**
	 * @param clan the clan to set
	 */
	public void setClan(Clan clan) {
		this.clan = clan;
	}

	/**
	 * @return the units
	 */
	public UnitGroup getUnits() {
		return units;
	}

	/**
	 * @param units the units to set
	 */
	public void setUnits(UnitGroup units) {
		this.units = units;
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
		if(Utility.MAP_SIZE > x && 0 <= x ){
			this.x = x;
		}		
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
		
		if(Utility.MAP_SIZE > y && 0 <= y ){
			this.y = y;
		}
	}
	
	public void setXY(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
}

