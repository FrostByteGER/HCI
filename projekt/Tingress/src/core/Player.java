package core;

import java.util.ArrayList;

public class Player {
	
	//CORE
	private Integer id = -1;
	
	private boolean isBot = true;

	private int x = -1;
	private int y = -1;
	
	private int money = 0;
	private int moneyPerTime = Settings.MONEY_PER_TICK;
	private int maxMoney = Settings.MONEY_CAP;
	private int plusLevel = Settings.MORE_MONEY_PER_LEVEL;
	
	private int ep = 0;
	private int level = 0;
	private int levelup = Settings.EP_START;
	private int levelNext = Settings.EP_FOR_NEXT_LEVEL_MUL;
	private Fraction fraction;
	private Clan clan;
	private ArrayList<BattelReport> reports;
	
	private UnitGroup units;
	private int unitCost = Settings.UNIT_COST;
	private int unitCap = Settings.UNIT_CAP_PLAYER;
	private int unitLevel = Settings.MORE_UNITS_PER_LEVEL;
	
	//GUI
	
	private int xPosition = 0;
	private int yPosition = 0;
	
	public Player(int id, Fraction fraction) {
		this.id = id;
		this.fraction = fraction;
		this.clan = null;
		this.units = new UnitGroup(this);
		this.reports = new ArrayList<BattelReport>();
		
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
		
		if(money >= Settings.UNIT_COST*3){
			int temp = 0;
						
			temp = (money/unitCost)/3;
			
			if(units.getUnitAmount() + temp*3 > Settings.UNIT_CAP_PLAYER){
				temp = (Settings.UNIT_CAP_FIELD-units.getUnitAmount())/3-1;
			}
			
			buyArcher(temp);
			buyHorseman(temp);
			buyLancer(temp);
		}
	}
	
	// für Benutzer
	public void addUnitsToField(GameField f ,int archerAmount ,int horsemanAmount ,int lancerAmount){
		f.addUnits(this, archerAmount, horsemanAmount, lancerAmount);
	}
	
	// Für KI
	public int addAllUnitsToField(GameField f){
		
		int archerAmount = units.getArcher().size();
		int horsemanAmount = units.getHorseman().size();
		int lancerAmount = units.getLancer().size();
		
		double temp = Settings.UNIT_CAP_FIELD;
				
		// rechnet die Anzahl an einheiten aus die Plaziert werden können für
		// jeden Slot Archer ,Horseman und Lancer ( /3)
		if(f.getOwnerFraction() != null && getFraction() != null){
			if(f.getOwnerFraction().equals(getFraction())){
				temp = ((1D-(f.getUnitAmountDef()/Settings.UNIT_CAP_FIELD))*Settings.UNIT_CAP_FIELD)/3;
			}else{
				temp = ((1D-(f.getUntiAmountAtk()/Settings.UNIT_CAP_FIELD))*Settings.UNIT_CAP_FIELD)/3;
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
		if((money+moneyPerTime)+((fraction.getOwning()/(Settings.MAP_SIZE*Settings.MAP_SIZE))*Settings.MONEY_PER_FIELD) < Settings.MONEY_CAP){
			this.money += moneyPerTime+((fraction.getOwning()/(Settings.MAP_SIZE*Settings.MAP_SIZE))*Settings.MONEY_PER_FIELD);
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
		if((money+moneyPerTime)+(owning*Settings.MONEY_PER_FIELD) < maxMoney){
			this.money += moneyPerTime+(owning*Settings.MONEY_PER_FIELD);
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
		if(Settings.MAP_SIZE > x && 0 <= x ){
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
		
		if(Settings.MAP_SIZE > y && 0 <= y ){
			this.y = y;
		}
	}
	
	public void setXY(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @return the isBot
	 */
	public boolean isBot() {
		return isBot;
	}

	/**
	 * @param isBot the isBot to set
	 */
	public void setBot(boolean isBot) {
		this.isBot = isBot;
	}

	/**
	 * @return the xPosition
	 */
	public int getxPosition() {
		return xPosition;
	}

	/**
	 * @param xPosition the xPosition to set
	 */
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	/**
	 * @return the yPosition
	 */
	public int getyPosition() {
		return yPosition;
	}

	/**
	 * @param yPosition the yPosition to set
	 */
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	/**
	 * @return the reports
	 */
	public ArrayList<BattelReport> getReports() {
		return reports;
	}

	/**
	 * @param reports the reports to set
	 */
	public void setReports(ArrayList<BattelReport> reports) {
		this.reports = reports;
	}
}

