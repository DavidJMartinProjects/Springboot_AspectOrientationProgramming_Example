package example.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import example.exceptions.CalculatorException;
import example.exceptions.NumberExceedsAllowedLimitException;
import example.exceptions.NumberFallsBelowAllowedLimitException;

@Component
public class InputValidation {
	
	Logger LOG  = LoggerFactory.getLogger(this.getClass());
	
	public void validateNumerical(int number) throws CalculatorException {		
	}
	
	public boolean isNumberExceedsLimit(int number) {
		if(number < 1000) {			
			return false;
		}
		LOG.info("InputValidation.isNumberExceedsLimit() : argument must be less than 1000 but was "+number+".");
		return true;
	}	
	
	public boolean isNumberFallsBelowLimit(int number) {
		if(number > 0) {
			return false;
		}
		LOG.info("InputValidation.isNumberFallsBelowLimit() : argument must be greater than 1 but was "+number+".");
		return true;
	}
	
	public void validate(int number1, int number2) throws CalculatorException {
		if(isNumberExceedsLimit(number1) || isNumberExceedsLimit(number2)) {
			throw new NumberExceedsAllowedLimitException(); 
		} else if(isNumberFallsBelowLimit(number1) || isNumberFallsBelowLimit(number2)) {
			throw new NumberFallsBelowAllowedLimitException();
		}
		LOG.info("Success : InputValidation.validateNumerical() : args have passed validation");
	}

}
