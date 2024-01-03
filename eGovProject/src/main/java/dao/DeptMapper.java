package dao;

import java.util.List;

import domain.DeptVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("deptMapper")
public interface DeptMapper {
	
	public List<DeptVO> selectDept(DeptVO vo) throws Exception;
}
