package example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.business.SampleService;
import example.exceptions.ErrorMessage;
import example.exceptions.NumberExceedsAllowedLimitException;
import example.exceptions.NumberFallsBelowAllowedLimitException;

@RestController
public class WebController {
	
	@Autowired
	SampleService sampleService;
	
	@GetMapping("/")
	public String greetingMsg() {
		return "Welcome to the calculator microservice";
	}
	
	@RequestMapping(value = "/calc", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<Object> calculate(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
		try {
			return new ResponseEntity<>(sampleService.addition(num1, num2), HttpStatus.OK);	
		} catch (Exception ex) {
			return handleException(ex);	
		}
	}

	private ResponseEntity<Object> handleException(Exception ex) {
		if(ex instanceof NumberExceedsAllowedLimitException) { 
			return new ResponseEntity(new ErrorMessage(((NumberExceedsAllowedLimitException) ex).getInternalErrorCode(), "test"), HttpStatus.OK);
		} else 	if(ex instanceof NumberFallsBelowAllowedLimitException) { 
			return new ResponseEntity(new ErrorMessage(((NumberExceedsAllowedLimitException) ex).getInternalErrorCode(), "test"), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ErrorMessage("SERVICE_UNAVAILABLE", "SERVICE_UNAVAILABLE"), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	


}
