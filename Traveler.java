import java.util.ArrayList;

/**
 * the Traveler class creates the traveler, taking in a name and an array list of memberships the traveler belongs to
 * @author alinabpham
 *
 */
public class Traveler extends Memberships
{
	private String name;
	private ArrayList<Memberships> memberships;
	
	
	public Traveler(String name, ArrayList<Memberships> memberships)
	{
		this.setName(name);
		this.memberships = memberships;
	}
	public Traveler()
	{
		this.name = "";
		this.memberships = new ArrayList<Memberships>();
	}
	
	/**
	 * method to check if the traveler belongs to any flier memberships
	 * @return
	 */
	public boolean hasFlierMembership()
	{
		for(Memberships m : memberships)
		{
			if(m instanceof FlierMembership)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * method to check if traveler belongs to any guest memberships
	 * @return
	 */
	public boolean hasGuestMembership()
	{
		for(Memberships m : memberships)
		{
			if(m instanceof GuestMembership)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * method to add a membership
	 * @param newM
	 */
	public void addMembership(Memberships newM)
	{
		memberships.add(newM);
	}
	
	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Memberships> getMem()
	{
		return memberships;
	}
	
	/**
	 * method that prints out all memberships the traveler belongs to
	 */
	public void printMem()
	{
		for(int i = 0; i < memberships.size(); i++)
		{
			//System.out.println(i);
			System.out.println(memberships.get(i));
		}
	}

	/**
	 * method that prints out the traveler's information
	 */
	public void updateTraveler()
	{
		System.out.println("Name: " + getName());
		System.out.println("Memberships: ");
		printMem();
		System.out.println();
	}
	
	public String toString()
	{
		return name;
	}
	
}
