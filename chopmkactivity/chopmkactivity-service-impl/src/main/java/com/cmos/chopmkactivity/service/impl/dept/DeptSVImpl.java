package com.cmos.chopmkactivity.service.impl.dept;

import com.alibaba.dubbo.config.annotation.Service;
import com.cmos.chopmkactivity.dao.dept.DeptDAO;
import com.cmos.chopmkactivity.iservice.dept.IDeptSV;
import com.cmos.chopmkactivity.beans.dept.Dept;

import org.springframework.beans.factory.annotation.Autowired;

@Service(group = "chopmkactivity")
public class DeptSVImpl implements IDeptSV {

    @Autowired
    private DeptDAO deptDAO;


    @Override
    public int deleteByPrimaryKey(Long parameterId) {
        return deptDAO.deleteByPrimaryKey(parameterId);
    }

    @Override
    public int insert(Dept record) {
        return deptDAO.insert(record);
    }

    @Override
    public Dept getByPrimaryKey(Long parameterId) {
        return deptDAO.selectByPrimaryKey(parameterId);
    }

    @Override
    public int updateByPrimaryKey(Dept record) {
        return deptDAO.updateByPrimaryKey(record);
    }


    @Override
    public Dept getByDname(String dname) {
        return deptDAO.getByDname(dname);
    }
}
