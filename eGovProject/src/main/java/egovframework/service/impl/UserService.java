package egovframework.service.impl;

import java.util.List;

import egovframework.domain.UserVO;

public interface UserService {
		
	// 계정 목록 조회
	List<UserVO> selectAll();
	
	// 계정 상세 조회
	UserVO selectById(String id);
	
	// 계정 아이디를 통한 상세 조회
	UserVO selectByUserId(String userId);
	
	// 계정 등록
	void save(UserVO vo);
	
	// 계정 수정
	void update(UserVO vo);
	
	// 계정 삭제
	void delete(String id);
}
