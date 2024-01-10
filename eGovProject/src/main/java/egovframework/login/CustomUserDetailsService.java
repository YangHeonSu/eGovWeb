package egovframework.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import egovframework.domain.UserVO;
import egovframework.service.impl.UserService;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserService userService; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO user = userService.selectByUserId(username);
		if (user == null) {
			throw new UsernameNotFoundException("User Not Exists : " +  username);
		}
		
		return new CustomUserDetailDTO(user);
	}
}