package com.cmos.chopmkactivity.dao.emp;


import com.cmos.chopmkactivity.beans.emp.Emp;

import java.math.BigDecimal;
import java.util.List;

/**
 * Demo示例,DAO查询接口
 * <p>该接口无需实现类,MyBatis会自动代理该接口实现底层查询
 *
 * @author zhuanghd
 * @since 1.0
 */
public interface EmpDAO {

    int deleteByPrimaryKey(Long empno);

    int insert(Emp record);

    Emp selectByPrimaryKey(Long empno);

    List<Emp> selectAll();

    int updateByPrimaryKey(Emp record);

    int countByDeptno(BigDecimal deptno);
}
