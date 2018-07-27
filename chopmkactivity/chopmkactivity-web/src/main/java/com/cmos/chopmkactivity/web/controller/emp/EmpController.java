package com.cmos.chopmkactivity.web.controller.emp;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cmos.common.exception.GeneralException;
import com.cmos.chopmkactivity.iservice.comp.ICompSV;
import com.cmos.chopmkactivity.iservice.emp.IEmpSV;
import com.cmos.chopmkactivity.beans.emp.Emp;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuzh on 2016/11/18.
 */

@RestController
@RequestMapping("/emp")
@Validated
public class EmpController {

    @Reference(group = "chopmkactivity")
    private IEmpSV empSV = null;

    @Reference(group = "chopmkactivity")
    private ICompSV compSV = null; // 组合服务


    /**
     * 根据EID查询员工信息
     *
     * @param eid
     * @return
     */
    @RequestMapping(value = "/{eid}", method = RequestMethod.GET)
    public Emp getEmp(@PathVariable long eid) {
        return empSV.getByPrimaryKey(eid);
    }

    /**
     * 根据EID删除员工信息
     *
     * @param eid
     * @return
     */
    @RequestMapping(value = "/{eid}", method = RequestMethod.DELETE)
    public String delEmp(@PathVariable long eid) {
        int deleteFlag = empSV.deleteByPrimaryKey(eid);
        return deleteFlag > 0 ? "ERROR" : "SUCCESS";
    }

    /**
     * 保存员工信息
     *
     * @param emp
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public void saveEmp(Emp emp) {
        empSV.insert(emp);
    }

    /**
     * 修改员工信息
     *
     * @param emp
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public int updateEmp(Emp emp) {
        return empSV.updateByPrimaryKey(emp);
    }

    @RequestMapping(value = "/count/{deptName}", method = RequestMethod.GET)
    public Map getEmpCountByDeptName(@PathVariable String deptName) throws GeneralException {
        Map<String, Integer> result = new HashMap(1);
        int count = compSV.getEmpCountByDeptName(deptName);
        result.put("result", count);
        return result;
    }

}
