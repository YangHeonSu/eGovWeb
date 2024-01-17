package egovframework.login;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import egovframework.domain.UserVO;

public class CustomUserDetailDTO implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String userPassword;
	private String authority;

	public CustomUserDetailDTO(UserVO user) {
		this.userId = user.getUserId();
		this.userPassword = user.getPassword();
		this.authority = user.getAuth();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getUsername() {
		return userId;
	}

	@Override
	public String getPassword() {
		return userPassword;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collection = new ArrayList();
		collection.add(() -> "" + authority);
		return collection;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}