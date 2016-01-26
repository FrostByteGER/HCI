package core;
import java.util.ArrayList;
import java.util.Random;

public class Game {
	
	private Random r = new Random(); // for testing
	
	private Map map;
	private ArrayList<Player> players;
	private ArrayList<Fraction> fractions;
	private ArrayList<Clan> clans; // TODO not Implemented
	
	public Game() {
		
		map = new Map();
		
		players = new ArrayList<Player>();
		fractions = new ArrayList<Fraction>();
		
		Player temp;
		
		for(int i = 0 ; i < Settings.GROUP_AMOUNT ; i++){
			fractions.add(new Fraction(i));
			for(int j = 0 ; j < Settings.PLAYER_PER_GROUP ; j++){
				temp = new Player((i*Settings.GROUP_AMOUNT)+j, fractions.get(i));
				players.add(temp);
				temp.setXY(r.nextInt(Settings.MAP_SIZE), r.nextInt(Settings.MAP_SIZE));
			}
		}
		
		runIt();
	}
	
	public void runOnce(){
		for(Player p : players){
			
			if(!p.isBot()){
				p.earnMoney();
				continue;
			}
			
			p.buyUnitsUntil();//TODO  KI
			
			p.addAllUnitsToField(map.getField(p.getX(), p.getY()));
			
			playerMove(p);
			
			p.earnMoney();
		}
		
		for(int fightTicks = 0 ; fightTicks < Settings.FIGHTS_PER_TICK ; fightTicks++){
			map.fightTick();
		}	
	}
	
	private void runIt(){
		
		for(int tick = 0 ; tick < Settings.TICK_AMOUNT ; tick++){
			
			//System.out.println("GameTick: "+tick);
			
			for(Player p : players){
				
				if(!p.isBot()){
					p.earnMoney();
					continue;
				}
				
				p.buyUnitsUntil();//TODO  KI
				
				p.addAllUnitsToField(map.getField(p.getX(), p.getY()));
				
				playerMove(p);
				
				p.earnMoney();
			}
			
			for(int fightTicks = 0 ; fightTicks < Settings.FIGHTS_PER_TICK ; fightTicks++){
				map.fightTick();
			}		
		}
	}
	
	private void playerMove(Player p){
		if(r.nextBoolean()){
			p.setX(p.getX() + (r.nextInt(3)-1));
		}else{
			p.setY(p.getY() + (r.nextInt(3)-1));
		}
	}
	
	public void showGame(){
		map.show();
		System.out.println();
		for(Fraction f : fractions){
			f.show();
		}
		System.out.println();
		for(Player p : players){
			p.show();
		}
		System.out.println();
	}
	
	public void showGameExt(){
		map.showExt();
		System.out.println();
		for(Fraction f : fractions){
			f.show();
		}
		System.out.println();
		for(Player p : players){
			p.show();
		}
		System.out.println();
	}
	
	/**
	 * @return the map
	 */
	public Map getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(Map map) {
		this.map = map;
	}

	/**
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public static void main(String[] args) {
		
		System.out.println("start");
		
		Game g = new Game();
		
		if(Settings.SHOW_EXTENDET){
			System.out.println("----------Extendet----------");
			g.showGameExt();
		}
		
		System.out.println();
		System.out.println("----------Basic----------");
		
		g.showGame();
		
		System.out.println("end");
		
	}
	
}
