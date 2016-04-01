import static org.junit.Assert.*;

import org.junit.Test;

public class GuestMembershipTest {

	private GuestMembership pc;
	private GuestMembership spg;

	public GuestMembershipTest()
	{
		
		pc = new GuestMembership(GuestMembership.PC, GuestMembership.newGuestId(), new FrequentGuestProgram());
		spg = new GuestMembership(GuestMembership.SPG, GuestMembership.newGuestId(), new FrequentGuestProgram());
	}
	
	
	/**
	 * The enoughPoints method checks to see if the user has enough frequent guest points to purchase reward nights
	 * 
	 */
	@Test
	public void enoughMilesTest() 
	{
		//Test for pc: budget, moderate, deluxe
		//Check the borders of each level
		GuestMembership pcTest = pc;
		pcTest.getGuestProgram().addPoints(499);
		assertFalse("499 points is not enough to purchase one budget Priority Club night", 
				pcTest.enoughPoints(Level.PC_BUD_PUR, 1));
		
		pcTest.getGuestProgram().addPoints(1);
		assertTrue("500 points is enough to purchase one budget Priority Club night", pcTest.enoughPoints(Level.PC_BUD_PUR, 1));
		
		pcTest.getGuestProgram().addPoints(499);
		assertFalse("999 points is not enough to purchase a moderate Priority Club night", 
				pcTest.enoughPoints(Level.PC_MOD_PUR, 1));
		
		pcTest.getGuestProgram().addPoints(1);
		assertTrue("1000 points is enough to purchase a moderate Priority Club night", pcTest.enoughPoints(Level.PC_MOD_PUR, 1));
		
		assertTrue("1000 points is enough to purchase 2 budget Priority Club nights", pcTest.enoughPoints(Level.PC_BUD_PUR, 2));
		
		pcTest.getGuestProgram().addPoints(999);
		assertFalse("1999 points is not enough to purchase 1 deluxe Priority Club night", pcTest.enoughPoints(Level.PC_DEL_PUR, 1));
		
		pcTest.getGuestProgram().addPoints(1);
		assertTrue("2000 points is enough to purchase 1 deluxe Priority Club night", pcTest.enoughPoints(Level.PC_DEL_PUR, 1));
		
		assertTrue("2000 points is enough to purchase 2 moderate Priority Club nights", pcTest.enoughPoints(Level.PC_MOD_PUR, 2));
		
		pcTest.getGuestProgram().addPoints(1);
		assertTrue("2001 points is enough to purchase 1 deluxe Priority Club night", pcTest.enoughPoints(Level.PC_DEL_PUR, 1));
		

		//Starwood Preferred Guest: budget, deluxe
		//check for the borders of each level
		GuestMembership spgTest = spg;
		spgTest.getGuestProgram().addPoints(14999);
		assertFalse("14999 points is not enough to purchase 1 budget Starwood Preferred Guest night", 
				spgTest.enoughPoints(Level.SPG_BUD_PUR, 1));

		spgTest.getGuestProgram().addPoints(1);
		assertTrue("15000 points is enough to purchase 1 budget Starwood Preferred Guest night", 
				spgTest.enoughPoints(Level.SPG_BUD_PUR, 1));

		spgTest.getGuestProgram().addPoints(9999);
		assertFalse("24999 points is not enough to purchase 1 deluxe Starwood Preferred Guest night", 
				spgTest.enoughPoints(Level.SPG_DEL_PUR, 1));

		spgTest.getGuestProgram().addPoints(1);
		assertTrue("25000 points is enough to purchase 1 deluxe Starwood Preferred Guest night", 
				spgTest.enoughPoints(Level.SPG_DEL_PUR, 1));


	}
}
