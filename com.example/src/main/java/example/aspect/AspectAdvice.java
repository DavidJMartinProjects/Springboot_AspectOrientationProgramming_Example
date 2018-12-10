package example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import example.business.InputValidation;
import example.exceptions.CalculatorException;

@Aspect
@Configuration
public class AspectAdvice {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	InputValidation inputValidation;
	
	@Around("@annotation(LogExecutionTime) && args(num1, num2)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint, int num1, int num2) {
		LOG.info(joinPoint.getSignature() + " called with arguments : " +num1+ ", " +num2);
		try {
			validateNumbers(num1, num2);
			return joinPoint.proceed();
		} catch (CalculatorException exception) {			
			return new ResponseEntity<>(exception, HttpStatus.SERVICE_UNAVAILABLE);
		} catch (Throwable e) {
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}		
	}
	
	public void validateNumbers(int num1, int num2) throws CalculatorException {
		inputValidation.validateNumerical(num1);
		inputValidation.validateNumerical(num2);
	}
	
}
