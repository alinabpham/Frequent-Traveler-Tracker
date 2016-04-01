import java.util.Random;

/**
 * frequent flier miles for each trip purchased. When a traveler purchases a ticket, their frequent flier 
 * program membership will be credited with the number of miles flown or a minimum number (specific to that program), 
 * whichever is greater. Travelers can also purchase award travel using their miles. The number of miles required 
 * depends on the class of ticket, which depends on the airline. When they purchase an award ticket, the system will 
 * either deduct the appropriate number of miles from their membership or inform them that they do not have enough 
 * (telling them how many they would have needed for their purchase).
 * 
 * @author alinabpham
 *
 */
public class FrequentFlierProgram
{
	private int miles;
	
	public FrequentFlierProgram(int miles)
	{
		this.setMiles(miles);
		
	}
	public FrequentFlierProgram()
	{
		setMiles(0);
		
	}
	
	public int getMiles() 
	{
		return miles;
	}
	
	public void setMiles(int miles) 
	{
		this.miles = miles;
	}
	
	public int addMiles(int moreMiles)
	{
		return miles = miles + moreMiles;
	}
	
	public String toString()
	{
		return String.valueOf(getMiles());
	}
}
