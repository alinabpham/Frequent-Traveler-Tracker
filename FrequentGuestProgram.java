/**
 * A frequent guest program membership allows travelers to collect points for each hotel stay. 
 * The number of points awarded per night depends on the class of hotel (which is specific to that program). 
 * Travelers can also purchase hotel nights using their points. The number of points required depends on 
 * the class of hotel (which is specific to the program). When a traveler purchases award nights, the system 
 * will either deduct the appropriate number of points from their membership or inform them that they do not 
 * have enough (telling them how many they would have needed).
 * @author alinabpham
 *
 */

public class FrequentGuestProgram
{
	
	private int points;
	private GuestMembership guest;
	
	public FrequentGuestProgram(int points, GuestMembership guest)
	{
		this.setPoints(points);
		this.guest = guest;
	}
	
	public FrequentGuestProgram()
	{
		this.setPoints(0);
		//this.guest = new GuestMembership();
	}
	
	public int addPoints(int morePoints)
	{
		return points = points + morePoints;
	}
	

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
