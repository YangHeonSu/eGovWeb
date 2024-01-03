package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.DeptDAO;
import domain.DeptVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import service.DeptService;

public class DeptServiceImpl extends EgovAbstractServiceImpl implements DeptService {
	
	@Autowired
	private DeptDAO deptDAO; 

	@Override
	public List<DeptVO> selectDept(DeptVO deptVO) throws Exception {
		return deptDAO.selectDept(deptVO);
	}	
}
