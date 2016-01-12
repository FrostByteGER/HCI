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
		
		for(int i = 0 ; i < Utility.GROUP_AMOUNT ; i++){
			fractions.add(new Fraction(i));
			for(int j = 0 ; j < Utility.PLAYER_PER_GROUP ; j++){
				temp = new Player((i*Utility.GROUP_AMOUNT)+j, fractions.get(i));
				players.add(temp);
				temp.setXY(r.nextInt(Utility.MAP_SIZE), r.nextInt(Utility.MAP_SIZE));
			}
		}
		
		runIt();
	}
	
	private void runIt(){
		
		for(int tick = 0 ; tick < Utility.TICK_AMOUNT ; tick++){
			
			System.out.println("GameTick: "+tick);
			
			for(Player p : players){
				p.buyUnitsUntil();//TODO  KI
				
				p.addAllUnitsToField(map.getField(p.getX(), p.getY()));
				
				playerMove(p);
				
				p.earnMoney();
			}
			
			for(int fightTicks = 0 ; fightTicks < Utility.FIGHTS_PER_TICK ; fightTicks++){
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
	
	public static void main(String[] args) {
		
		System.out.println("start");
		
		Game g = new Game();
		
		if(Utility.SHOW_EXTENDET){
			System.out.println("----------Extendet----------");
			g.showGameExt();
		}
		
		System.out.println();
		System.out.println("----------Basic----------");
		
		g.showGame();
		
		System.out.println("end");
		
	}
	
}
