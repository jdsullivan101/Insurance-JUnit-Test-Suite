package ie.atu.sw;

import java.util.*;

public class Questionnaire {

	private int basicInsurance = 500; // instantiate the variables
	private int surcharge = 100;
	CostOfInsurance coi = new CostOfInsurance(); // make an instance of the coi class

	public String runQuote() throws Exception {
		// Handling the scanner in one class. so that it will call the appropriate
		// methods during runtime.

		System.out.print("Enter your age: ");
		int age, accidents;

		try (Scanner input = new Scanner(System.in)) { // will automatically close
			age = input.nextInt();

			if (age >= 18) { //Ends the program if age is less than 18. 
				checkAge(age);
				System.out.print("\nHow many accidents did you have?: ");
				accidents = input.nextInt();
				accidentHistory(basicInsurance, accidents);
			} else {
				System.out.println("\nCannot Insure");
			}

		} catch (InputMismatchException e) { //For situations where user input is letters not numbers.
			System.out.println("\nCannot accept Non-Numeric Values" + e.getMessage());
		}
		return "Cannot Insure";

	}

	public int checkAge(int age) {
		//Check the age of applicant. will determine and return the base rate for the applicant. 
		if (age >= 25) {
			System.out.println("No additional surcharge.");

			return (basicInsurance);

		} else {

			basicInsurance += surcharge;
			System.out.println("Additional surcharge: " + surcharge);

			return (basicInsurance);
		}
	}
	
	//calculating the total cost of the insurance based on the previous passed information and taking the number of accidents. 
	public int accidentHistory(int basicrate, int accidents) { // Get the accidents to pass to the cost class

		if (accidents >= 6) {
			System.out.println("No insurance");

		} else {
			return coi.totalCost(basicrate, accidents);
		}
		
		// Returning the number of accidents where it exceeds 6 accidents. 
		return accidents;

	}

}
