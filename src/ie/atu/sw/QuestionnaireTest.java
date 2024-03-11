package ie.atu.sw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Timeout.ThreadMode;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class QuestionnaireTest {
	
	private static Questionnaire questionnaire;
	@BeforeEach
	public void setUp() { //Set up the class for each method. 
		questionnaire = new Questionnaire();
		
	}

	@Test
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	public void checkAgetest() {	
		
		//Expecting to return the basic rates or surcharge based on the of client 
		assertEquals(500, questionnaire.checkAge(32));
		assertEquals(500, questionnaire.checkAge(25));
		assertEquals(600, questionnaire.checkAge(19));
		
		}
	
	@ParameterizedTest
	@CsvSource({"24, 600", "19, 600", "32, 500", "45, 500", "23, 600"})
	public void ageParameter(int age, int expectedrate) { // Passing the expected results for each age group into method 
		
		int actualcrate = questionnaire.checkAge(age); // Get the actual rate from the checkage method by passing the age to method and comparing using parameters
		
		assertEquals(expectedrate, actualcrate);
		assertTrue(expectedrate == actualcrate);
	}
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void accidentHistoryTest() {
		//Passing various parameters to the caccidnetHistory method to check that it is returning the correct calculations.
		assertEquals(500, questionnaire.accidentHistory(500, 0)); // checking to make sure that it returns the value of the quote as the return method calls the other class. 
		assertEquals(7, questionnaire.accidentHistory(600, 7));
		assertNotEquals(10, questionnaire.accidentHistory(500, 9)); //Not equal case to make sure that it is using the correct integers.
		assertTrue(questionnaire.accidentHistory(500, 3) == 725);
		assertTrue(questionnaire.accidentHistory(600, 5) == 1175);
	}
	
	
	@Test
	@Timeout(value = 7000, unit = TimeUnit.MILLISECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void exceptionTest() throws Exception {
		/*
		 * Given a separate thread so that testing suite will continue and test will fail within 7 seconds if there is an error.
		 * Making new input stream for the input scanner of the runQuote method.
		 */
		
		ByteArrayInputStream in = new ByteArrayInputStream("hello\n".getBytes());
		System.setIn(in); //Sets the input stream
		assertThrows(InputMismatchException.class, ()-> {
			
			questionnaire.runQuote(); //call the method
			throw new InputMismatchException(); //throw the new exception for the method based on the input stream.
		});
		System.setIn(System.in); //Reset the input stream
		
	}
	
	@Test
	public void runQuoteTest() throws Exception {
		/*
		 * Setting the input stream to 17, in order to check that the method returns that it is not possible to insure those under
		 * the age of 18.
		 */
		ByteArrayInputStream agein = new ByteArrayInputStream("17\n".getBytes());
		System.setIn(agein);
		String result = questionnaire.runQuote();
		assertEquals("Cannot Insure", result );
	}
	
	
	@AfterAll //For user information
	public static void closeUp() {
		System.out.println("Tests Completed");
	}
	
	

}
