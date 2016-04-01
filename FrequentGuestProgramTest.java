import static org.junit.Assert.*;

import org.junit.Test;

public class FrequentGuestProgramTest {
	private FrequentGuestProgram pc;
	private FrequentGuestProgram spg;
	
	public FrequentGuestProgramTest()
	{
		pc = new FrequentGuestProgram();
		spg = new FrequentGuestProgram();
	}
	
	/**
	 * The addPoints method adds the designated amount of points to the membership's Frequent Guest Program
	 *
	 */
	@Test
	public void addMilesTest()
	{
		//We begin with adding a specific amount of points
		FrequentGuestProgram pcTest = pc;
		assertEquals("This will return 500 points", 500, pcTest.addPoints(Level.PC_BUD_PUR));
		
		//Adding 1000 points will return a total of 1500 points
		assertEquals("This will return 1500 points", 1500, pcTest.addPoints(Level.PC_MOD_PUR));
		
		//Adding 2000 points will return a total of 3500 points
		assertEquals("This will return 3500 miles", 3500, pcTest.addPoints(Level.PC_DEL_PUR));
		
		//We check that we can add the specific award points of priority club
		pcTest.setPoints(0);
		assertEquals("This will return 60 points", 60, pcTest.addPoints(Level.PC_BUD_AWD));
		
		assertEquals("This will return 160 points", 160, pcTest.addPoints(Level.PC_MOD_AWD));

		assertEquals("This will return 360 points", 360, pcTest.addPoints(Level.PC_DEL_AWD));



		//Now we check the same for Starwood Preferred Guest
		FrequentGuestProgram spgTest = spg;
		assertEquals("This will return 15,000 points", 15000, spgTest.addPoints(Level.SPG_BUD_PUR));

		assertEquals("This will return 40,000 points", 40000, spgTest.addPoints(Level.SPG_DEL_PUR));
		
		//Checking for SPG award points
		spgTest.setPoints(0);
		assertEquals("This will return 125 points", 125, spgTest.addPoints(Level.SPG_BUD_AWD));
		
		assertEquals("This will return 375 points", 375, spgTest.addPoints(Level.SPG_DEL_AWD));
	}

}
