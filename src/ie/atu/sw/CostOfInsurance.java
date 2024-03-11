package ie.atu.sw;

public class CostOfInsurance {
	
	/*
	 * Class to determine the cost of the policy based on user input from the previous class. 
	 */

	public int totalCost(int basicInsurance, int accident) {
		int accidentcharge = 0;

		switch (accident) { //Based on the number of accidents passed from Questionnaire class

		case 0:
			accidentcharge = 0; //The cost associated with each switch case
			break;

		case 1:
			accidentcharge = 50;
			break;

		case 2:
			accidentcharge = 125;
			break;

		case 3:
			accidentcharge = 225;
			break;

		case 4:
			accidentcharge = 375;
			break;

		case 5:
			accidentcharge = 575;
			break;
		}
		System.out.println("Additional surcharge for accident: " + accidentcharge + " \nTotal amount to pay: "
				+ (basicInsurance + accidentcharge));

		return (basicInsurance + accidentcharge); //Return costs based the switch statement from accidents been passed.

	}

}
