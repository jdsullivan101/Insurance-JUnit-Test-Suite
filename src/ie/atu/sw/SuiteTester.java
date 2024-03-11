package ie.atu.sw;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({
	
	/**
	 *The test suite is here calling the QuesstionnaireTest class first and then the CostofInsuranceTest class. This is because of the
	 *logical flow of the program when the user is executing the program. The code has been refactored into 3 classes, 1 to launch the program,
	 *1 to handle the user inputs for age and accident history(Questionnaire) before passing this information to the CostofInsurance class
	 *that returns the cost of the policy. 
	 */
	
	QuestionnaireTest.class,
	CostOfInsuranceTest.class
	
	
	
})

class SuiteTester {
	
	
}
