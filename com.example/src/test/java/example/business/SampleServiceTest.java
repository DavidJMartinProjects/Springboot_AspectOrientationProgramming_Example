package example.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import example.controller.Application;
import example.exceptions.CalculatorException;
import example.exceptions.NumberExceedsAllowedLimitException;
import example.exceptions.NumberFallsBelowAllowedLimitException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SampleServiceTest {
	
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SampleService sampleService;

	@Test
	public void whenAdditionOperationIsCalledWithTwoValidArgsThenExpectedResultIsReturned() throws InterruptedException {
		assertEquals(600, sampleService.addition(200, 400));	
	}
	
	@Test(expected = NumberFallsBelowAllowedLimitException.class)
	public void whenAdditionOperationIsCalledWithArgsLessThanAllowedLimitThenExpectedExceptionIsThrown() throws InterruptedException, CalculatorException {
		sampleService.addition(-200, 400);
	}
	
	@Test(expected = NumberExceedsAllowedLimitException.class)
	public void whenAdditionOperationIsCalledWithArgsGreaterThanAllowedLimitThenExpectedExceptionIsThrown() throws InterruptedException, CalculatorException {
		sampleService.addition(1200, 400);		
	}
	
}
