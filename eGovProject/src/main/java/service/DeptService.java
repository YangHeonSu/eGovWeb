package service;

import java.util.List;

import domain.DeptVO;

public interface DeptService {
	
	List<DeptVO> selectDept(DeptVO deptVO) throws Exception;

}
