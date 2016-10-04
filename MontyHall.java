import java.util.Scanner;

public class MontyHall
{
	// declaring things here, makes them fields. They are accessible everywhere in the class.
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void main (String [] args)
	{
	// model the doors as ints
	int carDoor = (int) (Math.random() * 3 + 1); // Random door between 1 and 3 (inclusive)
	
	int userDoor = getUserDoor();

	// Reveal a goat (aka non-sticky note)
	System.out.println("There is a goat behind door number " + revealDoor(carDoor, userDoor));
	
	// Makes other door in case user wants to switch
	int otherDoor = getOtherDoor(userDoor, revealDoor(carDoor, userDoor));
	
	// Ask whether the user wants to swap doors.
	boolean swap = getUserSwap();
	
	// Checks whether the user's new door is correct
	boolean check;
	if (swap == false)
		check = checkIfUserIsCorrect(userDoor, carDoor);
	else
		check = checkIfUserIsCorrect(otherDoor, carDoor);
	
	// Tells user if they won or lost
	if (check == true)
		System.out.println("You chose the correct door! You win a brand new car!!!");
	else
		System.out.println("You chose the incorrect door. :( But you get a goat!");
	}
	
	/**
	* Method checks to see if the user chose the correct door
	*
	* @param chosenDoor The door that the user has chosen
	* @param correctDoor The correct door that the car is behind
	* @return Returns whether or not the user chose the correct door
	*/
	
	public static boolean checkIfUserIsCorrect(int chosenDoor, int correctDoor)
	{
		if (chosenDoor == correctDoor)
			return true;
		else
			return false;
	}
	
	/**
	* This method calculates and returns a door for the host to reveal as not the Grand Prize door.
	*
	* @param invalid1 A door that the host cannot open
	* @param invalid1 A door that the host cannot open (may be the same as invalid1).
	* @return The number of a door containing a goat.
	*/
	
	public static int revealDoor(int invalid1, int invalid2)
	{
		// Loop through all possible doors until I find one that can be revealed
		for (int revealDoor = 1; revealDoor < 4; revealDoor++)
		{
			if (revealDoor != invalid1 && revealDoor != invalid2)
				return revealDoor;
		}
		
		// I should never actually reach this line
		// javac needs to know that *something* is always returned
		return -1;
	}
	
	/**
	* This method asks the user what door they think the car is behind
	*
	* @return Returns the integer of the door they want to pick
	*/
	
	public static int getUserDoor()
	{
	System.out.print("Choose a door from 1 - 3 to be the door you think the car is behind: ");
	String input = keyboard.nextLine();
	return Integer.parseInt(input);
	}
	
	/**
	* Method asks the user whether they want to swap their door or not.
	*
	* @return Returns a boolean whether the user wants to swap. (true to swap, false to stay)
	*/
	
	public static boolean getUserSwap()
	{
	System.out.print("Would you like to switch doors? \"true\" for yes, or \"false\" for no: ");
	String switchDoor = keyboard.nextLine();
	if (switchDoor.equals("true"))
		return true;
	else
		return false;
	}
	
	/** 
	* Method finds out the door that's not the user door or the revealed door
	*
	* @param invalid1 A door that otherDoor cannot be
	* @param invalid2 A door that otherDoor cannot be
	* @return Returns the number door that the other door will be
	*/
	
	public static int getOtherDoor(int invalid1, int invalid2)
	{
		for (int otherDoor = 1; otherDoor < 4; otherDoor++)
		{
			if (otherDoor != invalid1 && otherDoor != invalid2)
				return otherDoor;
		}
		return -1;
	}
}