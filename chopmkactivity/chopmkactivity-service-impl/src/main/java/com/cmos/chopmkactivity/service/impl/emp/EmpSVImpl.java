package com.cmos.chopmkactivity.service.impl.emp;

import com.alibaba.dubbo.config.annotation.Service;
import com.cmos.chopmkactivity.dao.emp.EmpDAO;
import com.cmos.chopmkactivity.iservice.emp.IEmpSV;
import com.cmos.chopmkactivity.beans.emp.Emp;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

/**
 * Demo示例,员工信息服务实现类
 * <p>使用了Dubbo服务注解,自动注册为Dubbo服务
 *
 * @author zhuanghd
 * @since 1.0
 */
@Service(group = "chopmkactivity")
public class EmpSVImpl implements IEmpSV {

    @Autowired
    private EmpDAO empDAO;


    @Override
    public List<Emp> getByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return empDAO.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Long parameterId) {
        return empDAO.deleteByPrimaryKey(parameterId);
    }

    @Override
    public int insert(Emp record) {
        return empDAO.insert(record);
    }

    @Override
    public Emp getByPrimaryKey(Long parameterId) {
        return empDAO.selectByPrimaryKey(parameterId);
    }

    @Override
    public int updateByPrimaryKey(Emp record) {
        return empDAO.updateByPrimaryKey(record);
    }

    @Override
    public int countByDeptno(BigDecimal deptno) {
        return empDAO.countByDeptno(deptno);
    }
}
