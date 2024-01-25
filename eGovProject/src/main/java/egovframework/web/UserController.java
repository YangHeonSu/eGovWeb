package egovframework.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	/**
	 * 계정 상세 페이지
	 */
	@RequestMapping(value = "/userDetail/{id}.do", method = RequestMethod.GET)
	public String getDetailPage(@PathVariable String id, Model model) throws Exception {
		
		UserVO user = userService.selectById(id);
		List<DeptVO> dept = deptService.selectDept();
		
		model.addAttribute("dept", dept);
		model.addAttribute("user", user);
		
		return "user/userDetail";
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
		Map<String, Object> saveResult = new HashMap<String, Object>();
		userService.save(vo);
		saveResult.put("result", 200);
		return saveResult;
	}
	
	/**
	 * 게정 수정
	 */
	@RequestMapping(value = "/userUpdate.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@RequestBody UserVO vo) throws Exception {
		Map<String, Object> updateResult = new HashMap<String, Object>();
		userService.update(vo);
		updateResult.put("result", 200);
		return updateResult;
	}
}
