package example.business;

import org.springframework.stereotype.Component;

import example.aspect.LogExecutionTime;

@Component
public class SampleService {
	
	@LogExecutionTime
	public void doSomething() throws InterruptedException {		
		Thread.sleep(2000);
	}

}
