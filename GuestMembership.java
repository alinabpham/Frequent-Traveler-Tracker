
/**
 * Guest Membership creates the guest memberships that the user can join
 * @author alinabpham
 *
 */
public class GuestMembership extends Memberships
{	
	public static final String PC = "Priority Club";
	public static final String SPG = "Starwood Preferred Guest";
	
	private static int id = 0;
	private int instanceID;
	private String type;
	private int min;	
	private Level level;
	private FrequentGuestProgram guest;
	
	public GuestMembership(String type, int instanceID, int min, Level level, FrequentGuestProgram guest)
	{
		this.type = type;
		this.min = min;
		this.level = level;
		this.instanceID = id;
	}
	
	public GuestMembership(String type, int instanceID, FrequentGuestProgram guest)
	{
		this.type = type;
		this.instanceID = id;
		this.setGuest(guest);
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public static void listLevels(String l)
	{
		if(l.equals(PC))
		{
			System.out.println("1: Budget");
			System.out.println("2: Moderate");
			System.out.println("3: Deluxe");
		}
		else if(l.equals(SPG))
		{
			System.out.println("1: Budget");
			System.out.println("2: Deluxe");
		}
	}

	public String toString()
	{
		String s = getType() + " Frequent Guest Program, Points = " + guest.getPoints() 
		+ ", Membership Number = " + getInstanceId();
		return s;
	}
	
	
	public int getInstanceId() {
		return instanceID;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public static int newGuestId()
	{
		return id++;
	}

	public FrequentGuestProgram getGuestProgram() 
	{
		return guest;
	}

	public void setGuest(FrequentGuestProgram guest) 
	{
		this.guest = guest;
	}
	
	public boolean enoughPoints(int reward, int numNights)
	{
		if(guest.getPoints() >= (reward*numNights))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void useRewards(int reward, int numNights)
	{
		guest.setPoints(guest.getPoints() - (reward*numNights));
	}
	
}
