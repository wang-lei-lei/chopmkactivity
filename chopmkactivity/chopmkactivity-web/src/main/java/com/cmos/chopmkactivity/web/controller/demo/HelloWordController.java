/** 
 * Project Name:itframe-web 
 * File Name:HelloWordController.java 
 * Package Name:com.cmos.chopmkactivity.web.controller
 * Date:2016年11月16日上午9:03:20 
 * Copyright (c) 2016, likerui All Rights Reserved. 
 * 
 */
package com.cmos.chopmkactivity.web.controller.demo;

import java.util.List;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cmos.chopmkactivity.iservice.emp.IEmpSV;
import com.cmos.common.bean.JsonFormatException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping(value = "/")
public class HelloWordController {

	@Reference
	private IEmpSV empSV = null;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hellWord(@RequestParam int pageNum, int pageSize) throws JsonFormatException{
		List<com.cmos.chopmkactivity.beans.emp.Emp> emps = empSV.getByPage(pageNum, pageSize);
		StringBuilder buf = new StringBuilder("\r\n");
		for(com.cmos.chopmkactivity.beans.emp.Emp emp : emps) {
			buf.append(emp.toJSONString() + "\r\n");
		}
		return "hello :" + buf.toString();
	}

}
