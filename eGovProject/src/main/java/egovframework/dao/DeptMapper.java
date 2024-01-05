package egovframework.dao;

import java.util.List;

import egovframework.domain.DeptVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("deptMapper")
public interface DeptMapper {
	
	public List<DeptVO> selectDept() throws Exception;
}
