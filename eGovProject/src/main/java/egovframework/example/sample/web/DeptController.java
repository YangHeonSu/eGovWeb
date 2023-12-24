package egovframework.example.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeptController {
	
	/**
	 * 부서 등록 페이지
	 */
	@RequestMapping(value = "/dept.do", method = RequestMethod.GET)
	public String getdeptWritePage() {
		return "dept/deptWrite";
	}

}
