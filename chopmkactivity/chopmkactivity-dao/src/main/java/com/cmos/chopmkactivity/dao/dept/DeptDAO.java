package com.cmos.chopmkactivity.dao.dept;


import com.cmos.chopmkactivity.beans.dept.Dept;

import java.util.List;

public interface DeptDAO {

    int deleteByPrimaryKey(Long deptno);

    int insert(Dept record);

    Dept selectByPrimaryKey(Long deptno);

    Dept getByDname(String dname);

    List<Dept> selectAll();

    int updateByPrimaryKey(Dept record);

}
