package egovframework.dao;

import java.util.List;

import egovframework.domain.UserVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("userMapper")
public interface UserMapper {
	
	// 계정 목록 조회
	List<UserVO> selectAll();
	
	// 계정 상세 조회
	UserVO selectById(String id);
	
	// 계정 등록
	void saveUser(UserVO vo);
	
	// 계정 수정
	void update(UserVO vo);
	
	// 계정 삭제
	void delete(String id);

}
