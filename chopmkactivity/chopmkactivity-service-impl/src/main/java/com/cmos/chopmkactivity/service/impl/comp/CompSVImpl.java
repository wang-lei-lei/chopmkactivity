package com.cmos.chopmkactivity.service.impl.comp;

import com.alibaba.dubbo.config.annotation.Service;
import com.cmos.common.exception.DataAccessException;
import com.cmos.common.exception.GeneralException;
import com.cmos.chopmkactivity.iservice.comp.ICompSV;
import com.cmos.chopmkactivity.iservice.dept.IDeptSV;
import com.cmos.chopmkactivity.iservice.emp.IEmpSV;
import com.cmos.chopmkactivity.beans.dept.Dept;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * 组合服务实现
 *
 * @author zhuanghd
 * @see ICompSV
 * @since 1.0
 */
@Service(group = "chopmkactivity")
public class CompSVImpl implements ICompSV {

    @Autowired
    private IEmpSV empSV = null;

    @Autowired
    private IDeptSV deptSV = null;

    @Override
    public int getEmpCountByDeptName(String name) throws GeneralException {
        // 查询部门编号
        Dept dept = deptSV.getByDname(name);
        if (dept == null) {
            throw new DataAccessException("DAE1001");
        }
        long deptno = dept.getDeptno();
        // 查询员工数量
        return empSV.countByDeptno(BigDecimal.valueOf(deptno));
    }

}
