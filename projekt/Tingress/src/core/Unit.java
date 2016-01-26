package core;
import java.util.ArrayList;
import java.util.Random;

public class Unit {
	
	private Random r = new Random();
	
	private int hp = Settings.UNIT_HP;
	private int maxDamage = Settings.UNIT_MAX_DAMAGE;
	private int minDamage = Settings.UNIT_MIN_DAMAGE;
	
	public Unit() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean fight(Unit enemy){
		enemy.setHp(enemy.getHp()-(r.nextInt(maxDamage-minDamage+1)+minDamage));
		return enemy.getHp() <= 0;
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
