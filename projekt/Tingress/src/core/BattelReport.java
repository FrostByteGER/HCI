package core;

public class BattelReport {
	
	private boolean isWon;
	private boolean isDefending;
	private GameField field;
	private int defLostArcher = 0;
	private int atkLostArcher = 0;
	private int defLostLancer = 0;
	private int atkLostLancer = 0;
	private int defLostHorseman = 0;
	private int atkLostHorseman = 0;
	
	public BattelReport(boolean isWon ,boolean isDefending ,GameField field) {
		this.isWon = isWon;
		this.isDefending = isDefending;
		this.field = field;
	}

	/**
	 * @return the isWon
	 */
	public boolean isWon() {
		return isWon;
	}

	/**
	 * @param isWon the isWon to set
	 */
	public void setWon(boolean isWon) {
		this.isWon = isWon;
	}

	/**
	 * @return the isDefending
	 */
	public boolean isDefending() {
		return isDefending;
	}

	/**
	 * @param isDefending the isDefending to set
	 */
	public void setDefending(boolean isDefending) {
		this.isDefending = isDefending;
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

	/**
	 * @return the field
	 */
	public GameField getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(GameField field) {
		this.field = field;
	}
}
