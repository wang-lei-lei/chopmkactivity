package com.cmos.chopmkactivity.web.controller.emp;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cmos.chopmkactivity.iservice.comp.ICompSV;
import com.cmos.chopmkactivity.iservice.emp.IEmpSV;
import com.cmos.common.exception.GeneralException;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuzh on 2016/11/18.
 */

@RestController
@RequestMapping("/dept")
@Validated
public class DeptController {

    @Reference(group = "chopmkactivity")
    private IEmpSV empSV = null;

    @Reference(group = "chopmkactivity")
    private ICompSV compSV = null; // 组合服务


    @GetMapping(value = "/emp/count")
    public Map getEmpCountByDeptName(@RequestParam String deptName) throws GeneralException {
        Map result = new HashMap(1);
        try {
            int count = compSV.getEmpCountByDeptName(deptName);
            result.put("result", count);
        } catch (Exception e) {
            e.printStackTrace();
            throw new GeneralException("DAE1003");
        }
        return result;
    }
}
