import static org.junit.Assert.*;

import org.junit.Test;

public class FrequentFlierProgramTest 
{
	private FrequentFlierProgram delta;
	private FrequentFlierProgram amer;
	public FrequentFlierProgramTest()
	{
		delta = new FrequentFlierProgram();
		amer = new FrequentFlierProgram();
	}
	
	/**
	 * The addMiles method adds the designated amount of miles to the membership's Frequent Flier Program
	 *
	 */
	@Test
	public void addMilesTest()
	{
		//We begin with adding a specific amount of miles
		FrequentFlierProgram deltaTest = delta;
		assertEquals("This will return 3000 miles", 3000, deltaTest.addMiles(3000));
		
		//Adding 2000 miles will return a total of 5000 miles
		assertEquals("This will return 5000 miles", 5000, deltaTest.addMiles(2000));
		
		//We check that we can add the specific min mileage of the delta airline
		deltaTest.setMiles(0);
		assertEquals("This will return 500 miles", 500, deltaTest.addMiles(FlierMembership.MIN_DELTA));
		
		//Now we check the same for American Airlines
		FrequentFlierProgram amerTest = amer;
		assertEquals("This will return 3000 miles", 3000, amerTest.addMiles(3000));
		
		assertEquals("This will return 5000 miles", 5000, amerTest.addMiles(2000));

		amerTest.setMiles(0);
		assertEquals("This will return 500 miles", 300, amerTest.addMiles(FlierMembership.MIN_AA));

		
	}

}
