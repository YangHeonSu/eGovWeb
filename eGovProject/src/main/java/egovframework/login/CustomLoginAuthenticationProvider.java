package egovframework.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository("customLoginAuthentication")
public class CustomLoginAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private UserDetailsService userDetailService;
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String userId = authentication.getName(); // 로그인 요청 아이디
		String password = (String) authentication.getCredentials(); // 로그인 요청 비밀번호
		
		// DB에서 가져온 사용자 정보
		CustomUserDetailDTO customUserDetailDTO = (CustomUserDetailDTO) userDetailService.loadUserByUsername(userId);
		
		if (customUserDetailDTO.getUserId() == null) {
			throw new UsernameNotFoundException("아이디를 찾을 수 없습니다.");
		}
		
		if (!bcryptPasswordEncoder.matches(password, customUserDetailDTO.getPassword())) {
			throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
		}
	
		return new UsernamePasswordAuthenticationToken(customUserDetailDTO, null, customUserDetailDTO.getAuthorities());
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}