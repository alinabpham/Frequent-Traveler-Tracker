import java.util.ArrayList;

/**
 * Flier Membership creates the flier memberships that the user can join
 * @author alinabpham
 *
 */

public class FlierMembership extends Memberships
{

	public static final String DELTA = "Delta Airlines";
	public static final String AA = "American Airlines";
	public static final int MIN_DELTA = 500;
	public static final int MIN_AA = 300;

	private static int id = 0;
	private int instanceID;
	private String type;
	private int min;
	private Level level;
	private FrequentFlierProgram flier;
	
	public FlierMembership(String type, int instanceID, int min, Level level, FrequentFlierProgram flier)
	{
		this.type = type;
		this.setMin(min);
		this.setLevel(level);
		this.instanceID = id;
		this.flier = flier;
	}
	
	public FlierMembership(String type, int instanceID, FrequentFlierProgram flier)
	{
		this.instanceID = id;
		//id = this.instanceID;
		this.type = type;
		if(type.equals(DELTA))
		{
			this.setMin(MIN_DELTA);
		}
		else if(type.equals(AA))
		{
			this.setMin(MIN_AA);
		}
		this.flier = flier;
	}
	
	/**
	 * returns the type of flier membership
	 */
	public String getType()
	{
		//System.out.println("Here: ");
		return type;
	}
	
	/**
	 * prints the ticket levels associated with each membership type
	 * @param l
	 */
	public static void listLevels(String l)
	{
		if(l.equalsIgnoreCase(DELTA))
		{
			System.out.println("1: Domestic");
			System.out.println("2: Domestic First");
			System.out.println("3: International");
		}
		else if(l.equalsIgnoreCase(AA))
		{
			System.out.println("1: Domestic");
			System.out.println("2: International");
		}
	}
	
	/**
	 * toString method for flier memberships
	 */
	public String toString()
	{
		String s = getType() + " Frequent Flier Program, Miles = " + flier.getMiles() 
		+ ", Membership Number = " + getInstanceId();
		return s;
	}

	//getters and setters
	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
	public int getInstanceId() {
		return instanceID;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * gives an updated flier ID, incrementing by one for each membership made
	 * @return
	 */
	public static int newFlierId()
	{
		return id++;
	}
	
	/**
	 * Checks to see if the membership has enough miles to use rewards
	 * @param reward
	 * @param numTravelers
	 * @return
	 */
	public boolean enoughMiles(int reward, int numTravelers)
	{
		if(flier.getMiles() >= (reward*numTravelers))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Uses the rewards and deducts the amount used from their mileage
	 * @param reward
	 * @param numTravelers
	 */
	public void useRewards(int reward, int numTravelers)
	{	
		flier.setMiles(flier.getMiles() - (reward*numTravelers));
	}
	
	//more getters and setters
	public FrequentFlierProgram getFlierProgram()
	{
		return flier;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}


}
