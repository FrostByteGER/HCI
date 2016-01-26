package core;
import java.util.ArrayList;

public class UnitGroup {
	
	private ArrayList<Unit> archer = new ArrayList<Unit>();
	private ArrayList<Unit> horseman = new ArrayList<Unit>();
	private ArrayList<Unit> lancer = new ArrayList<Unit>();
	
	private ArrayList<Item> items = new ArrayList<Item>();
	
	private Unit activeArcher;
	private Unit activeHorseman;
	private Unit activeLancer;
	
	private int archerDeathCounter = 0;
	private int lancerDeathCounter = 0;
	private int horsemanDeathcounter = 0;
	
	private Player owner;
	
	private int unitAmount = 0;
	
	public UnitGroup(Player p){
		owner = p;
	}
	
	public UnitGroup(Player p ,int archerAmount ,int horsemanAmount ,int lancerAmount) {
		
		owner = p;
		
		for(int i = 0 ; i < archerAmount ;i++){
			archer.add(new Archer());
		}
		nextArcher();
		for(int i = 0 ; i < horsemanAmount ;i++){
			horseman.add(new Horseman());
		}
		nextHorseman();
		for(int i = 0 ; i < lancerAmount ;i++){
			lancer.add(new Lancer());
		}
		nextLancer();
		
		refreshUnitAmount();
	}
	
	public int fightTick(UnitGroup enemys ,UnitGroup own){
		
		int end = 0;
		
		if(activeArcher != null){
			if(activeArcher.getHp() <= 0){
				enemys.getOwner().getMoreEx(Settings.EP_PER_KILL);
				end++;
				nextArcher();
			}
		}
		
		if(activeHorseman != null){
			if(activeHorseman.getHp() <= 0){
				enemys.getOwner().getMoreEx(Settings.EP_PER_KILL);
				end++;
				nextHorseman();
			}
		}
		
		if(activeLancer != null){
			if(activeLancer.getHp() <= 0){
				enemys.getOwner().getMoreEx(Settings.EP_PER_KILL);
				end++;
				nextLancer();
			}
		}
		
		if(activeArcher != null){
			if(enemys.getActiveArcher() != null){
				if(activeArcher.fight(enemys.getActiveArcher())){
					enemys.increaseArcherDeathCounter();
				}			
			}else if(enemys.getActiveLancer() != null){
				if (activeArcher.fight(enemys.getActiveLancer())){
					enemys.increaseLancerDeathCounter();
				}			
			}else if(enemys.getActiveHorseman() != null){
				if(activeArcher.fight(enemys.getActiveHorseman())){
					enemys.increaseHorsemanDeathcounter();
				}
			}			
		}
		
		if(activeHorseman != null){
			if(enemys.getActiveHorseman() != null){
				if(activeHorseman.fight(enemys.getActiveHorseman())){
					enemys.increaseHorsemanDeathcounter();
				}
			}else if(enemys.getActiveArcher() != null){
				if(activeHorseman.fight(enemys.getActiveArcher())){
					enemys.increaseArcherDeathCounter();
				}
			}else if(enemys.getActiveLancer() != null){
				if(activeHorseman.fight(enemys.getActiveLancer())){
					enemys.increaseLancerDeathCounter();
				}
			}
		}
		
		if(activeLancer != null){
			if(enemys.getActiveLancer() != null){
				if(activeLancer.fight(enemys.getActiveLancer())){
					enemys.increaseLancerDeathCounter();
				}
			}else if(enemys.getActiveHorseman() != null){
				if(activeLancer.fight(enemys.getActiveHorseman())){
					enemys.increaseHorsemanDeathcounter();
				}
			}else if(enemys.getActiveArcher() != null){
				if(activeLancer.fight(enemys.getActiveArcher())){
					enemys.increaseArcherDeathCounter();
				}
			}
		}
		refreshUnitAmount();
		
		for(int i = 0 ; i < items.size() ; i++){
			items.get(i).use(this);;
		}
		
		if(activeArcher == null && activeHorseman == null && activeLancer == null){
			
		}
		
		return end;
	}
	
	public boolean nextArcher(){
		if(activeArcher != null){
			if(activeArcher.getHp() <= 0){
				archer.remove(activeArcher);
			}
		}
		
		if(archer.size() > 0){
			activeArcher = archer.get(0);
			return true;
		}
		activeArcher = null;
		return false;
	}
	
	public boolean nextHorseman(){
		if(activeHorseman != null){
			if(activeHorseman.getHp() <= 0){
				horseman.remove(activeHorseman);
			}
		}
		
		if(horseman.size() > 0){
			activeHorseman = horseman.get(0);
			return true;
		}
		activeHorseman = null;
		return false;
	}
	
	public boolean nextLancer(){
		if(activeLancer != null){
			if(activeLancer.getHp() <= 0){
				lancer.remove(activeLancer);
			}
		}
		
		if(lancer.size() > 0){
			activeLancer = lancer.get(0);
			return true;
		}
		activeLancer = null;
		return false;
	}
	
	public boolean addArcher(int amount){
		if(Settings.UNIT_CAP_PLAYER >= unitAmount+amount){
			for(int i = 0 ; i < amount ; i++){
				archer.add(new Archer());
			}
			//unitAmount = archer.size()+horseman.size()+lancer.size();
			refreshUnitAmount();
			if(activeArcher == null){
				nextArcher();
			}
			return true;
		}
		return false;
	}
	
	public boolean addArcher(ArrayList<Unit> us){
		if(Settings.UNIT_CAP_PLAYER >= unitAmount+us.size()){
			for(Unit u : us){
				archer.add(u);
			}
			//unitAmount = archer.size()+horseman.size()+lancer.size();
			refreshUnitAmount();
			if(activeArcher == null){
				nextArcher();
			}
			return true;
		}
		return false;
	}
	
	public boolean addArcherFrom(ArrayList<Unit> us ,int amount){
		if(Settings.UNIT_CAP_PLAYER >= unitAmount+amount && us.size() >= amount){
			for(int i = 0 ; i < amount ; i++){
				archer.add(us.remove(0));
			}
			//unitAmount = archer.size()+horseman.size()+lancer.size();
			refreshUnitAmount();
			if(activeArcher == null){
				nextArcher();
			}
			return true;
		}
		return false;
	}
	
	public boolean addHorseman(int amount){
		if(Settings.UNIT_CAP_PLAYER >= unitAmount+amount){
			for(int i = 0 ; i < amount ; i++){
				horseman.add(new Horseman());
			}
			//unitAmount = archer.size()+horseman.size()+lancer.size();
			refreshUnitAmount();
			if(activeHorseman == null){
				nextHorseman();
			}
			return true;
		}
		
		return false;
	}
	
	public boolean addHorseman(ArrayList<Unit> us){
		if(Settings.UNIT_CAP_PLAYER >= unitAmount+us.size()){
			for(Unit u : us){
				horseman.add(u);
			}
			//unitAmount = archer.size()+horseman.size()+lancer.size();
			refreshUnitAmount();
			if(activeHorseman == null){
				nextHorseman();
			}
			return true;
		}
		return false;
	}
	
	public boolean addHorsemanFrom(ArrayList<Unit> us ,int amount){
		if(Settings.UNIT_CAP_PLAYER >= unitAmount+amount && us.size() >= amount){
			for(int i = 0 ; i < amount ; i++){
				horseman.add(us.remove(0));
			}
			//unitAmount = archer.size()+horseman.size()+lancer.size();
			refreshUnitAmount();
			if(activeHorseman == null){
				nextHorseman();
			}
			return true;
		}
		return false;
	}
	
	public boolean addLancer(int amount){
		if(Settings.UNIT_CAP_PLAYER >= unitAmount+amount){
			for(int i = 0 ; i < amount ; i++){
				lancer.add(new Lancer());
			}
			//unitAmount = archer.size()+horseman.size()+lancer.size();
			refreshUnitAmount();
			if(activeLancer == null){
				nextLancer();
			}
			return true;
		}
		return false;
	}
	
	public boolean addLancer(ArrayList<Unit> us){
		if(Settings.UNIT_CAP_PLAYER >= unitAmount+us.size()){
			for(Unit u : us){
				lancer.add(u);
			}
			//unitAmount = archer.size()+horseman.size()+lancer.size();
			refreshUnitAmount();
			if(activeLancer == null){
				nextLancer();
			}
			return true;
		}
		return false;
	}
	
	public boolean addLancerFrom(ArrayList<Unit> us ,int amount){
		if(Settings.UNIT_CAP_PLAYER >= unitAmount+amount && us.size() >= amount){
			for(int i = 0 ; i < amount ; i++){
				lancer.add(us.remove(0));
			}
			//unitAmount = archer.size()+horseman.size()+lancer.size();
			refreshUnitAmount();
			if(activeLancer == null){
				nextLancer();
			}
			return true;
		}
		return false;
	}
	
	public boolean addUnitsFrom(UnitGroup from ,int archerAmount ,int horsemanAmount ,int lancerAmount){
		if(Settings.UNIT_CAP_FIELD >= unitAmount+archerAmount+horsemanAmount+lancerAmount){
			addArcherFrom(from.getArcher(), archerAmount);
			addHorsemanFrom(from.getHorseman(), horsemanAmount);
			addLancerFrom(from.getLancer(), lancerAmount);
			//unitAmount = archer.size()+horseman.size()+lancer.size();
			
			refreshUnitAmount();
			from.refreshUnitAmount();
			return true;
		}
		return false;
	}
	
	public ArrayList<Unit> subUnits(ArrayList<Unit> group ,int amount){
		
		activeArcher = null;
		activeHorseman = null;
		activeLancer = null;
		
		if(group.size() >= amount){
			
			ArrayList<Unit> end = new ArrayList<Unit>();
			
			for(int i = 0 ; i < amount ; i++){
				end.add(group.remove(0));
			}
			unitAmount = archer.size()+horseman.size()+lancer.size();
			return end;			
		}	
		return null;
	}
	
	public boolean subUnits(ArrayList<Unit> from ,ArrayList<Unit> to ,int amount){
		activeArcher = null;
		activeHorseman = null;
		activeLancer = null;
		
		if(from.size() >= amount){
			for(int i = 0 ; i < amount ; i++){
				to.add(from.remove(0));
			}
			//unitAmount = archer.size()+horseman.size()+lancer.size();
			refreshUnitAmount();
			return true;
		}
		return false;
	}
	
	public UnitGroup subGroup(int archers ,int horsemans ,int lancers){
		
		if(archer.size() >= archers && horseman.size() >= horsemans && lancer.size() >= lancers){
			
			subUnits(getArcher(), archers);
			subUnits(getLancer(), lancers);
			subUnits(getHorseman(), horsemans);
			
			activeArcher = null;
			activeLancer = null;
			activeHorseman = null;

			nextArcher();
			nextLancer();
			nextHorseman();
			
			//unitAmount = archer.size()+horseman.size()+lancer.size();
			refreshUnitAmount();
			return new UnitGroup(owner ,archers, horsemans, lancers);
		}else{
			return null;
		}
	}
	
	public void addGroup(UnitGroup g){
		
		if(Settings.UNIT_CAP_PLAYER >= g.getUnitAmount()+unitAmount){
			addArcher(g.getArcher());
			addHorseman(g.getHorseman());
			addLancer(g.getLancer());
			
			//unitAmount = archer.size()+horseman.size()+lancer.size();
			refreshUnitAmount();
		}
	}
	
	public void refreshUnitAmount(){
		unitAmount = archer.size()+horseman.size()+lancer.size();
	}
	
	/**
	 * @return the activeArcher
	 */
	public Unit getActiveArcher() {
		return activeArcher;
	}

	/**
	 * @param activeArcher the activeArcher to set
	 */
	public void setActiveArcher(Unit activeArcher) {
		this.activeArcher = activeArcher;
	}

	/**
	 * @return the activeHorseman
	 */
	public Unit getActiveHorseman() {
		return activeHorseman;
	}

	/**
	 * @param activeHorseman the activeHorseman to set
	 */
	public void setActiveHorseman(Unit activeHorseman) {
		this.activeHorseman = activeHorseman;
	}

	/**
	 * @return the activeLancer
	 */
	public Unit getActiveLancer() {
		return activeLancer;
	}

	/**
	 * @param activeLancer the activeLancer to set
	 */
	public void setActiveLancer(Unit activeLancer) {
		this.activeLancer = activeLancer;
	}
	
	/**
	 * @return the unitAmount
	 */
	public int getUnitAmount() {
		return unitAmount;
	}

	/**
	 * @param unitAmount the unitAmount to set
	 */
	public void setUnitAmount(int unitAmount) {
		this.unitAmount = unitAmount;
	}
	
	/**
	 * @return the archer
	 */
	public ArrayList<Unit> getArcher() {
		return archer;
	}

	/**
	 * @param archer the archer to set
	 */
	public void setArcher(ArrayList<Unit> archer) {
		this.archer = archer;
	}

	/**
	 * @return the horseman
	 */
	public ArrayList<Unit> getHorseman() {
		return horseman;
	}

	/**
	 * @param horseman the horseman to set
	 */
	public void setHorseman(ArrayList<Unit> horseman) {
		this.horseman = horseman;
	}

	/**
	 * @return the lancer
	 */
	public ArrayList<Unit> getLancer() {
		return lancer;
	}

	/**
	 * @param lancer the lancer to set
	 */
	public void setLancer(ArrayList<Unit> lancer) {
		this.lancer = lancer;
	}

	/**
	 * @return the owner
	 */
	public Player getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public boolean addItem(Item i){
		if(Settings.ITEM_CAP_UNITGROUP < items.size()){
			items.add(i);
			return true;
		}		
		return false;
	}
	
	public Item subItem(Item i){
		
		if(items.remove(i)){
			return i;
		}
		return null;	
	}

	/**
	 * @return the archerDeathCounter
	 */
	public int getArcherDeathCounter() {
		return archerDeathCounter;
	}

	/**
	 * @param archerDeathCounter the archerDeathCounter to set
	 */
	public void setArcherDeathCounter(int archerDeathCounter) {
		this.archerDeathCounter = archerDeathCounter;
	}
	
	public void increaseArcherDeathCounter(){
		this.archerDeathCounter++;
	}
	
	/**
	 * @return the lancerDeathCounter
	 */
	public int getLancerDeathCounter() {
		return lancerDeathCounter;
	}

	/**
	 * @param lancerDeathCounter the lancerDeathCounter to set
	 */
	public void setLancerDeathCounter(int lancerDeathCounter) {
		this.lancerDeathCounter = lancerDeathCounter;
	}

	public void increaseLancerDeathCounter(){
		this.lancerDeathCounter++;
	}
	
	/**
	 * @return the horsemanDeathcounter
	 */
	public int getHorsemanDeathcounter() {
		return horsemanDeathcounter;
	}

	/**
	 * @param horsemanDeathcounter the horsemanDeathcounter to set
	 */
	public void setHorsemanDeathcounter(int horsemanDeathcounter) {
		this.horsemanDeathcounter = horsemanDeathcounter;
	}
	
	public void increaseHorsemanDeathcounter(){
		this.horsemanDeathcounter++;
	}
}
