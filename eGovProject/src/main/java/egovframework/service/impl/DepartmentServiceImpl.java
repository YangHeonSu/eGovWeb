package egovframework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.dao.DeptMapper;
import egovframework.domain.DeptVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service
public class DepartmentServiceImpl extends EgovAbstractServiceImpl implements DepartmentService {
	
	@Autowired
	private DeptMapper deptMapper;
	

	@Override
	public List<DeptVO> selectDept() throws Exception {
		return deptMapper.selectDept();
	}	
}
