package egovframework.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import egovframework.domain.UserVO;
import egovframework.service.impl.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserService userService; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO user = userService.selectByUserId(username);
		if (user == null) { // 로그인 요청한 아이디가 DB에 없는 경우
			throw new BadCredentialsException(username);
		}
		
		return new CustomUserDetailDTO(user);
	}
}