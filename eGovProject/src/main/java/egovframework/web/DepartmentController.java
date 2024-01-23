package egovframework.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import egovframework.domain.DeptVO;
import egovframework.service.impl.DepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;

	@RequestMapping(value="/deptList.do", method=RequestMethod.GET)
	public String getDeptListPage(Model model) throws Exception {
		List<DeptVO> depts =  deptService.selectDept();
		
		for(DeptVO vo : depts) {
			System.out.println(vo.getName());
		}
		
		return null;
	}
	
	/**
	 * 부서 등록 페이지
	 * @throws Exception 
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
		
		System.out.println("DeptNo : " + vo.getId());
		System.out.println("DeptName : " + vo.getName());
		System.out.println("DeptLocation : " + vo.getLocation());
	}

}
