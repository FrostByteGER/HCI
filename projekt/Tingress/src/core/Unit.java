package core;
import java.util.ArrayList;
import java.util.Random;

public class Unit {
	
	private Random r = new Random();
	
	private int hp = 100;
	private int maxDamage = 15;
	private int minDamage = 10;
	
	public Unit() {
		// TODO Auto-generated constructor stub
	}
	
	public void fight(Unit enemy){
		enemy.setHp(enemy.getHp()-(r.nextInt(maxDamage-minDamage+1)+minDamage));
	}
	
	public void dieHard(ArrayList<Unit> group){
		group.remove(this);
	}
	
	/**
	 * @return the hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * @param hp the hp to set
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * @return the maxDamage
	 */
	public int getMaxDamage() {
		return maxDamage;
	}

	/**
	 * @param maxDamage the maxDamage to set
	 */
	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}

	/**
	 * @return the minDamage
	 */
	public int getMinDamage() {
		return minDamage;
	}

	/**
	 * @param minDamage the minDamage to set
	 */
	public void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}
	
}
