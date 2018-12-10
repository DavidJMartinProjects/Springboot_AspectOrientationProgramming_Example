package example.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import example.aspect.LogExecutionTime;

@Component
public class SampleService {
	
	Logger LOG  = LoggerFactory.getLogger(this.getClass());
	
	@LogExecutionTime
	public int addition(int num1, int num2) throws InterruptedException {		
		LOG.info("SampleService.addition() return a result of : " +  (num1 + num2));
		return num1 + num2;
	}

}
