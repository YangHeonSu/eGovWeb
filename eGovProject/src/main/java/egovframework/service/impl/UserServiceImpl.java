package egovframework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import egovframework.dao.UserMapper;
import egovframework.domain.UserVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service
public class UserServiceImpl extends EgovAbstractServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEnCoder;

	@Override
	public List<UserVO> selectAll() {
		return userMapper.selectAll();
	}

	@Override
	public UserVO selectById(String id) {
		return userMapper.selectById(id);
	}

	@Override
	public void save(UserVO vo) {
		vo.setPassword(bcryptPasswordEnCoder.encode(vo.getPassword())); // 비밀번호 암호화
		userMapper.saveUser(vo);
	}

	@Override
	public void update(UserVO vo) {
		userMapper.update(vo);
	}

	@Override
	public void delete(String id) {
		userMapper.delete(id);
	}

}