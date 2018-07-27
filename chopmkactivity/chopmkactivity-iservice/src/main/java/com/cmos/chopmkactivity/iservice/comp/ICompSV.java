package com.cmos.chopmkactivity.iservice.comp;

import com.cmos.common.exception.GeneralException;

/**
 * 组合服务
 *
 * @author zhuanghd
 * @since 1.0
 */
public interface ICompSV {

    /**
     * 根据部门名称获取员工数
     * @throws Exception
     */
    int getEmpCountByDeptName(String name) throws GeneralException;


}
