/**
 * Level class organizes the levels of purchase for plane tickets and property levels
 * @author alinabpham
 *
 */

public class Level 
{
	private int purchase;
	private int award;
	
	public static final int DELTA_DOM = 25000;
	public static final int DELTA_FIRST = 40000;
	public static final int DELTA_INT = 65000;
	public static final int AA_DOM = 20000;
	public static final int AA_INT = 60000;
	
	public static final int PC_BUD_PUR = 500;
	public static final int PC_BUD_AWD = 60;
	public static final int PC_MOD_PUR = 1000;
	public static final int PC_MOD_AWD = 100;
	public static final int PC_DEL_PUR = 2000;
	public static final int PC_DEL_AWD = 200;
	public static final int SPG_BUD_PUR = 15000;
	public static final int SPG_BUD_AWD = 125;
	public static final int SPG_DEL_PUR = 25000;
	public static final int SPG_DEL_AWD = 250;


	
	public Level(int purchase, int award)
	{
		this.setPurchase(purchase);
		this.setAward(award);
	}
	
	public Level()
	{
		this.setPurchase(0);
		this.setAward(0);
	}

	public int getPurchase() {
		return purchase;
	}

	public void setPurchase(int purchase) {
		this.purchase = purchase;
	}

	public int getAward() {
		return award;
	}

	public void setAward(int award) {
		this.award = award;
	}
	
	

}
