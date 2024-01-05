package egovframework.service.impl;

import java.util.List;

import egovframework.domain.DeptVO;

public interface DeptService {
	
	List<DeptVO> selectDept() throws Exception;

}
