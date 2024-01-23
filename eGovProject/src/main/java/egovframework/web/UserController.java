package egovframework.web;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.domain.DeptVO;
import egovframework.domain.UserVO;
import egovframework.service.impl.DepartmentService;
import egovframework.service.impl.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private DepartmentService deptService;
	
	/**
	 * 계정 목록 페이지
	 */
	@RequestMapping(value="/userList.do", method= RequestMethod.GET)
	public String getListPage() {
		return "user/userList";
	}

	/**
	 * 계정 등록 페이지
	 */
	@RequestMapping(value = "/userForm.do", method = RequestMethod.GET)
	public String getSaveFormPage(Model model) throws Exception {
		List<DeptVO> dept = deptService.selectDept();
		model.addAttribute("dept", dept);
		return "user/userForm";
	}
	
	
	/*** API ***/
	
	/**
	 * 계정 목록 조회
	 */
	@RequestMapping(value = "/users.do", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<UserVO>> getUserList() {
		List<UserVO> users = userService.selectAll();
		return ResponseEntity.ok(users);
	}
	
	/**
	 * 계정 등록
	 */
	@RequestMapping(value = "/userSave.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(@RequestBody UserVO vo) throws Exception {
		Map<String, Object> result = new HashedMap();
		userService.save(vo);
		result.put("result", 200);
		return result;
	}
}
