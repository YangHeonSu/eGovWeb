package egovframework.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	/**
	 * 로그인 페이지
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login/loginForm";
	}
}
