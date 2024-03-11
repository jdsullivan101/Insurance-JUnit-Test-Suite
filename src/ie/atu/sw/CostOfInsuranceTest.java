package ie.atu.sw;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CostOfInsuranceTest {
	
	private static CostOfInsurance costTest;
	@BeforeAll
	public static void launchTest() { //Creating an instance of the class before all the test methods are called.
		costTest = new CostOfInsurance();
		
	}

	@Test
	@Timeout(value = 5000, unit = TimeUnit.MILLISECONDS) //Timeout value of 5 seconds for the test
	void costOfInsurancetest() {
		
		//Handling the tests for the cost of insurance,
		assertTrue(costTest.totalCost(500, 0) == 500);
		assertTrue(costTest.totalCost(500, 3) == 725);
		assertTrue(costTest.totalCost(500, 2) == 625);
		assertTrue(costTest.totalCost(500, 1) == 550);
		assertTrue(costTest.totalCost(500, 4) == 875);
		assertTrue(costTest.totalCost(600, 5) == 1175);
		assertEquals(500, costTest.totalCost(500, 0));	
		
	}
	
	
	@ParameterizedTest //Like other class this is handling various parameters and their expected results. 
	@CsvSource({"500, 1, 550", "500, 2, 625", "600, 4, 975", "600, 0, 600", "600, 3, 825"})
	public void firstParameter(int basicInsurance, int accidents, int expectedCost) {
		
		int actualCost = costTest.totalCost(basicInsurance, accidents);
		assertEquals(expectedCost, actualCost); //Asserting the valuues are correct in the program. 
	}
	
	@Test
	public void arithmeticFail() { //Testing for arithmetic fails, based on the cost of insurance class. 
		
		assertThrows(ArithmeticException.class, () ->{
			int incorrect = (1110);
			int realcost = costTest.totalCost(500, 5);
			if(incorrect != realcost) {
				throw new ArithmeticException();
			}
			
		});
	}
	
	 @AfterAll
	    public static void closeDown() { //To let the user know that the test is complete for this class 
	        System.out.println("Tests Completed for Cost of Insurance Class");
	    }
	

}
