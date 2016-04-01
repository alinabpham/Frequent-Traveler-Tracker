import static org.junit.Assert.*;

import org.junit.Test;

public class FlierMembershipTest 
{
	private FlierMembership delta;
	private FlierMembership amer;

	public FlierMembershipTest()
	{
		
		delta = new FlierMembership(FlierMembership.DELTA, FlierMembership.newFlierId(), new FrequentFlierProgram());
		amer = new FlierMembership(FlierMembership.AA, FlierMembership.newFlierId(), new FrequentFlierProgram());
	}
	
	
	/**
	 * The enoughMiles method checks to see if the user has enough frequent flyer miles to purchase reward tickets
	 * 
	 */
	@Test
	public void enoughMilesTest() 
	{
		//Test for delta: domestic, domestic first, international
		//Check the borders of each level
		FlierMembership deltaTest = delta;
		deltaTest.getFlierProgram().addMiles(24999);
		assertFalse("24,999 miles is not enough to purchase one domestic Delta ticket", deltaTest.enoughMiles(Level.DELTA_DOM, 1));
		
		deltaTest.getFlierProgram().addMiles(1);
		assertTrue("25,000 miles is enough to purchase one domestic Delta ticket", deltaTest.enoughMiles(Level.DELTA_DOM, 1));
		
		deltaTest.getFlierProgram().addMiles(14999);
		assertFalse("39,999 miles is not enough to purchase a domestic first Delta ticket", 
				deltaTest.enoughMiles(Level.DELTA_FIRST, 1));
		
		deltaTest.getFlierProgram().addMiles(1);
		assertTrue("40,000 miles is enough to purchase a domestic first Delta ticket", deltaTest.enoughMiles(Level.DELTA_FIRST, 1));
		
		//test for false: need 50,000 miles for 2 domestic Delta tickets
		assertFalse("40,000 miles is not enough to purchase 2 domestic Delta tickets", deltaTest.enoughMiles(Level.DELTA_DOM, 2));
		
		deltaTest.getFlierProgram().addMiles(10000);
		assertTrue("50,000 miles is enough to purchase 2 domestic Delta tickets", deltaTest.enoughMiles(Level.DELTA_DOM, 2));
		
		assertTrue("50,000 miles is enough to purchase 1 domestic first Delta ticket", deltaTest.enoughMiles(Level.DELTA_FIRST, 1));
		
		deltaTest.getFlierProgram().addMiles(14999);
		assertFalse("64,999 miles is not enough to purchase 1 international Delta ticket", 
				deltaTest.enoughMiles(Level.DELTA_INT, 1));
		
		deltaTest.getFlierProgram().addMiles(1);
		assertTrue("65,000 miles is enough to purchase 1 domestic Delta tickets", deltaTest.enoughMiles(Level.DELTA_INT, 1));
		

		//american: domestic, international
		//check for the borders of each level
		FlierMembership amerTest = amer;
		amerTest.getFlierProgram().addMiles(19999);
		assertFalse("19,999 miles is not enough to purchase 1 domestic American Airlines ticket", 
				amerTest.enoughMiles(Level.AA_DOM, 1));

		amerTest.getFlierProgram().addMiles(1);
		assertTrue("20,000 miles is enough to purchase one domestic American Airlines ticket", 
				amerTest.enoughMiles(Level.AA_DOM, 1));

		amerTest.getFlierProgram().addMiles(20000);
		assertTrue("40,000 miles is enough to purchase 2 domestic American Airlines ticket", 
				amerTest.enoughMiles(Level.AA_DOM, 2));

		amerTest.getFlierProgram().addMiles(19999);
		assertFalse("59,999 miles is not enough to purchase one international American Airlines ticket", 
				amerTest.enoughMiles(Level.AA_INT, 1));

		amerTest.getFlierProgram().addMiles(1);
		assertTrue("60,000 miles is enough to purchase 1 international American Airlines ticket", 
				amerTest.enoughMiles(Level.AA_INT, 1));

		amerTest.getFlierProgram().addMiles(240000);
		assertTrue("300,000 miles is enough to purchase one domestic American Airlines ticket", 
				amerTest.enoughMiles(Level.AA_INT, 5));

	}


}
