package com.cmos.chopmkactivity.example.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cmos.chopmkactivity.example.service.ISimpleSV;
import com.cmos.chopmkactivity.iservice.IExampleSV;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by alen on 17-2-16.
 */
@Service(group = "chopmkactivity")
public class ExampleSVImpl implements IExampleSV {

    @Autowired
    private ISimpleSV simpleService;

    @Override
    public String sayHello(String name) {
        return simpleService.talk(name);
    }

}
