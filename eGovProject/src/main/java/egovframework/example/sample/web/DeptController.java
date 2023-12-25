package egovframework.example.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import egovframework.example.sample.service.DeptVO;

@Controller
public class DeptController {
	
	/**
	 * 부서 등록 페이지
	 */
	@RequestMapping(value = "/dept.do", method = RequestMethod.GET)
	public String getdeptWritePage() {
		return "dept/deptWrite";
	}
	
	/**
	 * 부서 등록 
	 */
	@RequestMapping(value = "/deptSave.do", method = RequestMethod.POST)
	public void deptSave(DeptVO vo) {
		
		System.out.println("DeptNo : " + vo.getDeptNo());
		System.out.println("DeptName : " + vo.getDeptName());
		System.out.println("DeptLocation : " + vo.getDeptLocation());
	}

}
