package example5;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScopeExampleController {
	@Resource
	private RequestScopeExampleBean  requestScopeExampleBean;
	@Resource
	private SessionScopeExampleBean sessionScopeExampleBean;
	
	@GetMapping("/checkSessionScope")
	public ResponseEntity<Integer> checkSessionScope() {
		ResponseEntity<Integer> result = new ResponseEntity<Integer>(sessionScopeExampleBean.getNumber(), HttpStatus.OK);
		return result;
	}
	
	@GetMapping("/checkRequestScope")
	public ResponseEntity<Integer> checkRequestScope() {
		ResponseEntity<Integer> result = new ResponseEntity<Integer>(requestScopeExampleBean.getNumber(), HttpStatus.OK);
		return result;
	}
	
	@GetMapping("/checkSessionScope2")
	public ResponseEntity<SessionScopeExampleBean> checkRequestScope2() {
		ResponseEntity<SessionScopeExampleBean> result = new ResponseEntity<SessionScopeExampleBean>(sessionScopeExampleBean, HttpStatus.OK);
		return result;
	}
}
