
public class Fraction {
		
	private int number = -1;
	private int owning = 0;
	private String name = "";
	
	public Fraction(int number) {
		this.number = number;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Fraction ){
			return (number==((Fraction)obj).number);
		}
		return false;
	}
	
	public void show(){
		System.out.println("Number: "+number+" Name: "+name+" Owning: "+owning);
	}
	
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the owning
	 */
	public int getOwning() {
		return owning;
	}

	/**
	 * @param owning the owning to set
	 */
	public void setOwning(int owning) {
		this.owning = owning;
	}
}
