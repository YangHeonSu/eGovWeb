package egovframework.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import egovframework.domain.DeptVO;
import egovframework.domain.UserVO;
import egovframework.service.impl.DeptService;
import egovframework.service.impl.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DeptService deptService;
	
	@RequestMapping(value = "/userForm.do", method = RequestMethod.GET)
	public String getSaveFormPage(Model model) throws Exception {	
		List<DeptVO> dept = deptService.selectDept();
		model.addAttribute("dept", dept);
		return "user/userForm";
	}
	
	
	@RequestMapping(value = "/userForm.do", method = RequestMethod.POST)
	public void save(@RequestBody UserVO vo) throws Exception {	
		userService.save(vo);
	}

}
