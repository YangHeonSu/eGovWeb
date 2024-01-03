package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import domain.DeptVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("deptDAO")
public class DeptDAO extends EgovAbstractDAO {
	
	public List<DeptVO> selectDept(DeptVO vo) throws Exception {
		return (List<DeptVO>) list("deptDAO.selectDept", vo);
	}
}
