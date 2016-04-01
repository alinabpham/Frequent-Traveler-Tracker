/**
 * Main Memberships class to connect flier and guest memberships
 * @author alinabpham
 *
 */
public abstract class Memberships extends Level
{
	private int id;
	private String type;
	
	public Memberships(String type, int id)
	{
		this.id = id;
		this.type = type;
	}
	
	public Memberships()
	{
		this.id = 0;
		this.type = getType();
	}
	
	public String getType()
	{
		Object o = new Object();
		String s = "";
		if(o instanceof FlierMembership)
		{
			FlierMembership f = (FlierMembership) o;
			s = f.getType();
		}
		else if(o instanceof GuestMembership)
		{
			GuestMembership g = (GuestMembership) o;
			s = g.getType();
		}
		return s;
	}
	
	public String toString()
	{	
		Object o = new Object();
		String s = "";
		if(o instanceof FlierMembership)
		{
			FlierMembership f = (FlierMembership) o;
			s = f.toString();
		}
		else if(o instanceof GuestMembership)
		{
			GuestMembership g = (GuestMembership) o;
			s = g.toString();
		}
		
		return s;
	}

}
