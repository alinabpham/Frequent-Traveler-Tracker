import java.util.ArrayList;
import java.util.Scanner;

public class FrequentTravelerTracker
{
	public static void main(String[] args)
	{
		//Create an array list of Travelers to hold multiple travelers
		ArrayList<Traveler> listOfTravelers = new ArrayList<Traveler>();
		Scanner in = new Scanner(System.in);

		System.out.println("Welcome to the Frequent Traveler Tracker!");
		boolean done = false;
		do
		{
			int choose = -1000;
			boolean valid = false;
			do
			{
				//Ask if the traveler wants to create a traveler, purchase a traveler, or quit
				System.out.println("Please choose from the following options:");
				System.out.println("1: Create a traveler");
				System.out.println("2: Purchase travel");
				System.out.println("3: Quit");
				System.out.print("> ");

				int option = in.nextInt();

				//If they want to create a traveler...
				if(option == 1)
				{
					System.out.print("Enter traveler name: ");
					in.nextLine();
					String name = in.nextLine();
					
					//Array list of memberships belonging to the traveler
					ArrayList<Memberships> listOfMem = new ArrayList<Memberships>();
					
					boolean newMembership = false;
					do
					{
						//Ask user to select the memberships they want to join
						System.out.println("Select a frequent traveler program to join:");
						System.out.println("1: Delta Airlines");
						System.out.println("2: American Airlines");
						System.out.println("3: Priority Club");
						System.out.println("4: Starwood Preferred Guest");
						System.out.print(">");
						
						
						int join = in.nextInt();

						//If Delta Airlines...
						if(join == 1)
						{
							//Will not add Delta Airlines if they already have this membership
							if(alreadyExists(FlierMembership.DELTA, listOfMem))
							{
								System.out.println("Already has this membership");
							}
							//Otherwise, initialize and add the membership to the array
							else
							{
								FlierMembership delta = new FlierMembership(FlierMembership.DELTA, FlierMembership.newFlierId(), 
										new FrequentFlierProgram());
								listOfMem.add(delta);
							}
	
						}
						//If American Airlines...
						else if(join == 2)	
						{
							//Will not add American Airlines if they already have this membership
							if(alreadyExists(FlierMembership.AA, listOfMem))
							{
								System.out.println("Already has this membership");
							}
							//Otherwise, initialize and add the membership to the array
							else
							{
								FlierMembership aa = new FlierMembership(FlierMembership.AA, FlierMembership.newFlierId(), 
										new FrequentFlierProgram());
								listOfMem.add(aa);
							}
						}
						//If Priority Club...
						else if(join == 3)
						{
							//Will not add Priority Club if they already have this membership
							if(alreadyExists(GuestMembership.PC, listOfMem))
							{
								System.out.println("Already has this membership");
							}
							//Otherwise, initialize and add the membership to the array
							else
							{
								GuestMembership pc = new GuestMembership(GuestMembership.PC, GuestMembership.newGuestId(), 
										new FrequentGuestProgram());
								listOfMem.add(pc);
							}
						}
						//If Starwood Preferred Guest...
						else if(join == 4)
						{
							//Will not add Starwood Preferred Guest if they already have this membership
							if(alreadyExists(GuestMembership.SPG, listOfMem))
							{
								System.out.println("Already has this membership");
							}
							//Otherwise, initialize and add the membership to the array
							else
							{
								GuestMembership spg = new GuestMembership(GuestMembership.SPG, GuestMembership.newGuestId(), 
										new FrequentGuestProgram());
								listOfMem.add(spg);
							}
						}
						//If they input an out of range value, print error message and let them try again
						else
						{
							System.out.println("Option value out of range, please re-enter.");
							newMembership = false;
						}

						//Ask if the user is finished selecting programs.
						//If yes, then create the traveler and print its information.
						//If no, then loop through again and allow them to add another program
						System.out.println("Are you finished selecting programs? (Y, N): ");
						String yesorno = in.next();
						if(yesorno.equalsIgnoreCase("y"))
						{
							listOfTravelers.add(new Traveler(name, new ArrayList<Memberships>(listOfMem)));
							System.out.println("Added new traveler");
							//listOfTravelers.get(listOfTravelers.size() - 1).updateTraveler();
							for(Traveler t : listOfTravelers)
							{
								t.updateTraveler();
							}
							newMembership = true;
						}
						else if(yesorno.equalsIgnoreCase("n"))
						{
							newMembership = false;
						}
						else
						{
							System.out.println("Option value out of range, please re-enter.");
							newMembership = false;
						}
					}
					while(!newMembership);
					valid = false;
				}
				//If they want to purchase a travel...
				else if(option == 2)	
				{
					//If no travelers exist, print an error message and return to the main menu
					if(listOfTravelers.size() == 0)
					{
						System.out.println("No travelers exist yet.");
						valid = false;
					}
					else
					{
						boolean purchaseTravel = false;
						do
						{
							//Ask user to select one of the travelers to make the purchase under
							System.out.println("Select traveler: ");
							for(int i = 0; i < listOfTravelers.size(); i++)
							{
								int num = i+1;
								System.out.println(num + ": " + listOfTravelers.get(i));
							}
							System.out.print(">");
							
							choose = in.nextInt();
							
							//If input is out of range, print error message and restart
							if(choose > listOfTravelers.size())
							{
								System.out.println("Option value out of range, please re-enter.");
								purchaseTravel = false;
							}
							//Otherwise, continue on below
							else
							{
								purchaseTravel = true;
							}
						}
						while(!purchaseTravel);
						valid = true;
					}
				}
				//If wants to quit...
				else if(option == 3)
				{
					//End the program
					System.out.println("Goodbye");
					System.exit(0);
				}
				else
				{
					System.out.println("Option value out of range, please re-enter.");
					valid = false;
				}
			}
			while(!valid);
			
			//The traveler chosen is put into a variable for easier use
			int t = choose - 1;
			Traveler buyer = listOfTravelers.get(t);
			
			//Ask what they want to purchase
			System.out.println("Please choose from the following options:");
			System.out.println("1: Buy plane ticket");
			System.out.println("2: Book hotel");
			System.out.println("3: Return to main menu");
			System.out.print(">");
			int action = in.nextInt();
			
			//If wants to purchase a plane ticket...
			if(action == 1)
			{
				//Check if the buyer has a flier membership
				//If not, print that the buyer does not belong to any flier memberships
				if(buyer.hasFlierMembership())
				{
					//If has flier membership, ask user to select an airline
					//Would only print out the airlines that the member belongs to
					System.out.println("Select airline");
					
					ArrayList<Integer> location = new ArrayList<Integer>();
					int num = 1;
					for(int i = 0; i < buyer.getMem().size(); i++)
					{
						if(buyer.getMem().get(i) instanceof FlierMembership)
						{
							System.out.println(num + ": " + buyer.getMem().get(i).getType());
							num ++;
							location.add(i);
						}
						
					}
					System.out.print(">");
					
					int a = in.nextInt();
					
					//Cast Membership to FlierMembership
					FlierMembership airline = (FlierMembership) buyer.getMem().get(location.get(a-1));
					if(((a-1) >= 0 ) && ((a-1) < location.size()))
					{
						//Ask for number of Travelers
						System.out.println("Number of Travelers: ");
						int numTravelers = in.nextInt();
						
						//Check if this is a rewards ticket
						String r = "";
						boolean yn = false;
						do
						{
							System.out.println("Will this be a rewards ticket? (Y, N): ");
							r = in.next();
							if((r.equalsIgnoreCase("y")) || (r.equalsIgnoreCase("n")))
							{
								yn = true;
							}
							else
							{
								System.out.println("Must enter y or n!");
								yn = false;
							}
						}
						while(!yn);
						
						//If using Delta Airlines...
						if(airline.getType().equals(FlierMembership.DELTA))
						{
							//If using their rewards...
							if(wantsRewards(r))
							{
								//Ask for level of purchase
								System.out.println("Select a level of purchase");
								//List out levels of purchase from Delta Airlines
								FlierMembership.listLevels(FlierMembership.DELTA);
								int chooseLevel = in.nextInt();
								
								//If Domestic...
								if(chooseLevel == 1)
								{
									int purLevel = (Level.DELTA_DOM);
									
									//Check if has enough mileage to use rewards
									if(airline.enoughMiles(purLevel, numTravelers))
									{
										//Redeem miles
										airline.useRewards(purLevel, numTravelers);
										System.out.println("Redeemed " + purLevel*numTravelers + " frequent flier miles");
										System.out.println("Purchased " + numTravelers + " Domestic ticket(s) with Delta Airlines");
										buyer.updateTraveler();
									} 
									else if(!airline.enoughMiles(purLevel, numTravelers))
									{
										//Print failure message if not enough miles
										System.out.println("Failed to redeem award travel. Passenger has "
												+ airline.getFlierProgram().getMiles() + " miles but requires " + 
												Level.DELTA_DOM + " miles for " + numTravelers + " Domestic ticket(s)");
										buyer.updateTraveler();
									}
								}
								//If Domestic First
								else if(chooseLevel == 2)
								{
									int purLevel = (Level.DELTA_FIRST);
									if(airline.enoughMiles(purLevel, numTravelers))
									{
										airline.useRewards(purLevel, numTravelers);
										System.out.println("Redeemed " + purLevel*numTravelers + " frequent flier miles");
										System.out.println("Purchased " + numTravelers + " Domestic First ticket(s) with Delta Airlines");
										buyer.updateTraveler();
									}
									else if (!airline.enoughMiles(purLevel, numTravelers))
									{
										System.out.println("Failed to redeem award travel. Passenger has "
												+ airline.getFlierProgram().getMiles() + " miles but requires " + Level.DELTA_FIRST 
												+ " miles for " + numTravelers + " Domestic First ticket(s)");
										buyer.updateTraveler();
									}
								}
								//If International...
								else if(chooseLevel == 3)
								{
									int purLevel = (Level.DELTA_INT);
									if(airline.enoughMiles(purLevel, numTravelers))
									{
										airline.useRewards(purLevel, numTravelers);
										System.out.println("Redeemed " + purLevel*numTravelers + " frequent flier miles");
										System.out.println("Purchased " + numTravelers + " International ticket(s) with Delta Airlines");
										buyer.updateTraveler();
									}
									else if(!airline.enoughMiles(purLevel, numTravelers))
									{
										System.out.println("Failed to redeem award travel. Passenger has "
												+ airline.getFlierProgram().getMiles() + " miles but requires " + Level.DELTA_INT 
												+ " miles for " + numTravelers + " International ticket(s)");
										buyer.updateTraveler();
									}
								}
								else
								{
									System.out.println("Please enter a valid option!");
								}
							//If not using rewards...
							}
							else if(!wantsRewards(r))
							{
								//Ask for number of miles traveling
								System.out.println("Number of miles: ");
								int milesTraveling = in.nextInt();
								
								//If the miles traveling times the number of travelers is less than the min
								//number of miles for Delta, then add the min miles from Delta. Otherwise
								//add miles traveling times the number of travelers
								if((milesTraveling*numTravelers) > airline.getMin())
								{
									airline.getFlierProgram().addMiles(milesTraveling*numTravelers);
								}
								else
								{
									airline.getFlierProgram().addMiles(airline.getMin());
								}
								System.out.println(airline.getFlierProgram().getMiles());
								System.out.println("Purchased tickets for " + numTravelers + " traveler(s) with Delta Airlines");
								buyer.updateTraveler();
							}
						}
						//If American Airlines... (code is the same as for Delta)
						else if(airline.getType().equals(FlierMembership.AA))
						{
							if(wantsRewards(r))
							{
								System.out.println("Select ticket type:");
								FlierMembership.listLevels(FlierMembership.AA);
								int chooseLevel = in.nextInt();
								if(chooseLevel == 1)
								{ 
									int purLevel = (Level.AA_DOM);
									if(airline.enoughMiles(purLevel, numTravelers))
									{
										airline.useRewards(purLevel, numTravelers);
										System.out.println("Redeemed " + purLevel*numTravelers + " frequent flier miles");
										System.out.println("Purchased " + numTravelers + " Domestic ticket(s) with American Airlines");
										buyer.updateTraveler();
									}
									else
									{
										System.out.println("Failed to redeem award travel. Passenger has "
												+ airline.getFlierProgram().getMiles() + " miles but requires " + Level.AA_DOM + " miles for " 
												+ numTravelers + " Domestic ticket(s)");
										buyer.updateTraveler();
									}
								}
								else if(chooseLevel == 2)
								{
									int purLevel = (Level.AA_INT);

									if(airline.enoughMiles(purLevel, numTravelers))
									{
										airline.useRewards(purLevel, numTravelers);
										System.out.println("Redeemed " + purLevel*numTravelers + " frequent flier miles");
										System.out.println("Purchased " + numTravelers + " International ticket(s) with American Airlines");
										buyer.updateTraveler();
									}
									else
									{
										System.out.println("Failed to redeem award travel. Passenger has "
												+ airline.getFlierProgram().getMiles() + " miles but requires " + Level.AA_INT + " miles for " 
												+ numTravelers + " International ticket(s)");
										buyer.updateTraveler();
									}
								}
							}
							else
							{
								System.out.println("Number of miles: ");
								int milesTraveling = in.nextInt();

								if((milesTraveling*numTravelers) > airline.getMin())
								{
									airline.getFlierProgram().addMiles(milesTraveling*numTravelers);
								}
								else
								{
									airline.getFlierProgram().addMiles(airline.getMin());
								}
								System.out.println(airline.getFlierProgram().getMiles());
								System.out.println("Purchased tickets for" + numTravelers + " traveler(s) with American Airlines");
								buyer.updateTraveler();
								
							}

						} 

					}
				}
				//Print that the buyer does not belong to any airline program
				else
				{
					System.out.println(buyer.getName() + " does not belong to any airline programs.");
					done = false;
				}
			}
			
			else if(action == 2)
			{
				//Check if the buyer has a guest membership
				//If not, print that the buyer does not belong to any guest memberships
				//(Code notes are the same as for purchasing a plane ticket)
				if(buyer.hasGuestMembership())
				{
					ArrayList<Integer> location = new ArrayList<Integer>();
					int num = 1;
					for(int i = 0; i < buyer.getMem().size(); i++)
					{
						if(buyer.getMem().get(i) instanceof GuestMembership)
						{
							System.out.println(num + ": " + buyer.getMem().get(i).getType());
							num ++;
							location.add(i);
						}
						
					}
					System.out.print(">");

					int h = in.nextInt();
					GuestMembership hotel = (GuestMembership) buyer.getMem().get(location.get(h-1));
					if(((h-1) >= 0 ) && ((h-1) < location.size()))
					{
						//If Priority Club...
						if(hotel.getType().equals(GuestMembership.PC))
						{
							System.out.println("Select property level:");
							GuestMembership.listLevels(GuestMembership.PC);
							int property = in.nextInt();

							System.out.println("Number of Nights: ");
							int numNights = in.nextInt();

							String r = "";
							boolean yn = false;
							do
							{
								System.out.println("Will this be a rewards ticket? (Y, N): ");
								r = in.next();
								if((r.equalsIgnoreCase("y")) || (r.equalsIgnoreCase("n")))
								{
									yn = true;
								}
								else
								{
									System.out.println("Must enter y or n!");
									yn = false;
								}
							}
							while(!yn);

							//If budget level...
							if(property == 1)
							{ 
								int purLevel = (Level.PC_BUD_PUR);
								if(wantsRewards(r))
								{
									if(hotel.enoughPoints(purLevel, numNights))
									{
										hotel.useRewards(purLevel, numNights);
										System.out.println("Redeemed " + purLevel*numNights + " frequent guest points");
										System.out.println("Purchased " + numNights + " night(s) in a Budget room at Priority Club");
										buyer.updateTraveler();
									}
									else
									{
										System.out.println("Failed to redeem award travel. Passenger has "
												+ hotel.getGuestProgram().getPoints() + " points but requires " + Level.PC_BUD_PUR + " points for " 
												+ numNights + " night(s) in a Budget room with Priority Club.");
										buyer.updateTraveler();
									}
								}
								else
								{
									//Add award points
									hotel.getGuestProgram().addPoints((Level.PC_BUD_AWD)*numNights);
									System.out.println("Purchased " + numNights + " night(s) in a Budget room at Priority Club");
									buyer.updateTraveler();
								}
							}
							//If moderate level...
							else if(property == 2)
							{
								int purLevel = (Level.PC_DEL_PUR);
								if(wantsRewards(r))
								{
									if(hotel.enoughPoints(purLevel, numNights))
									{
										hotel.useRewards(purLevel, numNights);
										System.out.println("Redeemed " + purLevel*numNights + " frequent guest points");
										System.out.println("Purchased " + numNights + " night(s) in a Deluxe room at Priority Club");
									}
									else
									{
										System.out.println("Failed to redeem award travel. Passenger has "
												+ hotel.getGuestProgram().getPoints() + " points but requires " + Level.PC_DEL_PUR + " points for " 
												+ numNights + " night(s) in a Deluxe room with Priority Club.");
									}
								}
								else
								{
									//Add award points
									hotel.getGuestProgram().addPoints((Level.PC_DEL_AWD)*numNights);
									System.out.println("Purchased " + numNights + " night(s) in a Deluxe room at Priority Club");
								}
							}
							//If deluxe level...
							else if(property == 3)
							{
								int purLevel = (Level.PC_MOD_PUR);
								if(wantsRewards(r))
								{
									if(hotel.enoughPoints(purLevel, numNights))
									{
										hotel.useRewards(purLevel, numNights);
										System.out.println("Redeemed " + purLevel*numNights + " frequent guest points");
										System.out.println("Purchased " + numNights + " night(s) in a Moderate room at Priority Club");
									}
									else
									{
										System.out.println("Failed to redeem award travel. Passenger has "
												+ hotel.getGuestProgram().getPoints() + " points but requires " + Level.PC_MOD_PUR + " points for " 
												+ numNights + " night(s) in a Moderate room with Priority Club.");
									}
								}
								else
								{
									//Add award points
									hotel.getGuestProgram().addPoints((Level.PC_MOD_AWD)*numNights);
									System.out.println("Purchased " + numNights + " night(s) in a Moderate room at Priority Club");
								}

							}
						}
						//If Starwood Preferred Guest...
						else if(hotel.equals(GuestMembership.SPG))
						{
							System.out.println("Select property level:");
							GuestMembership.listLevels(GuestMembership.SPG);							
							int property = in.nextInt();

							System.out.println("Number of Nights: ");
							int numNights = in.nextInt();

							String r = "";
							boolean yn = false;
							do
							{
								System.out.println("Will this be a rewards ticket? (Y, N): ");
								r = in.next();
								if((r.equalsIgnoreCase("y")) || (r.equalsIgnoreCase("n")))
								{
									yn = true;
								}
								else
								{
									System.out.println("Must enter y or n!");
									yn = false;
								}
							}
							while(!yn);
							
							//If budget level...
							if(property == 1)
							{
								int purLevel = (Level.SPG_BUD_PUR);
								if(wantsRewards(r))
								{
									if(hotel.enoughPoints(purLevel, numNights))
									{
										hotel.useRewards(purLevel, numNights);
										System.out.println("Redeemed " + purLevel*numNights + " frequent guest points");
										System.out.println("Purchased " + numNights + " night(s) in a Budget room at Starwood Preferred Guest");
									}
									else
									{
										System.out.println("Failed to redeem award travel. Passenger has "
												+ hotel.getGuestProgram().getPoints() + " points but requires " + Level.SPG_BUD_PUR + " points for " 
												+ numNights + " night(s) in a Budget room with Starwood Preferred Guest.");
									}
								}
								else
								{
									hotel.getGuestProgram().addPoints((Level.SPG_BUD_AWD)*numNights);									
									System.out.println("Purchased " + numNights + " night(s) in a Budget room at Starwood Preferred Guest");
								}
							}
							//If deluxe level...
							else if(property == 2)
							{
								int purLevel = (Level.SPG_DEL_PUR);
								if(wantsRewards(r))
								{
									if(hotel.enoughPoints(purLevel, numNights))
									{
										hotel.useRewards(purLevel, numNights);
										System.out.println("Redeemed " + purLevel*numNights + " frequent guest points");
										System.out.println("Purchased " + numNights + " night(s) in a Deluxe room at Starwood Preferred Guest");
									}
									else
									{
										System.out.println("Failed to redeem award travel. Passenger has "
												+ hotel.getGuestProgram().getPoints() + " points but requires " + Level.SPG_DEL_PUR + " points for " 
												+ numNights + " night(s) in a Deluxe room with Starwood Preferred Guest.");
									}
								}
								else
								{
									//Add award points
									hotel.getGuestProgram().addPoints((Level.SPG_DEL_PUR)*numNights);
									System.out.println("Purchased " + numNights + " night(s) in a Deluxe room at Starwood Preferred Guest");
								}
							}
						}

					}
				}
				//Print that buyer does not belong to any hotel programs.
				else
				{
					System.out.println(buyer.getName() + " does not belong to any hotel programs.");
					done = false;
				}

			}
			done = false;
		}
		while(!done);
	}


	/**
	 * method to check if user wants to use rewards
	 * 
	 * @param yesorno
	 * @return boolean
	 */
	public static boolean wantsRewards(String yesorno)
	{
		boolean wantsRewards = false;
		if(yesorno.equalsIgnoreCase("y"))
		{
			wantsRewards = true;
		}
		return wantsRewards;
	}
	
	/**
	 * check to see if the membership type already exists in the array list of memberships
	 * 
	 * @param type
	 * @param mem
	 * @return boolean
	 */
	public static boolean alreadyExists(String type, ArrayList<Memberships> mem)
	{
		boolean alreadyExists = false;
		for(int i = 0; i < mem.size(); i++)
		{
			if(mem.get(i).getType().equals(type))
			{
					alreadyExists = true;
			}
			
		}
		return alreadyExists;
	}	
	
}
