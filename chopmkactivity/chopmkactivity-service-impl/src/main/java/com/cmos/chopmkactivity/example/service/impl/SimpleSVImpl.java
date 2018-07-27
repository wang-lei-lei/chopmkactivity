package com.cmos.chopmkactivity.example.service.impl;

import org.springframework.stereotype.Component;

import com.cmos.chopmkactivity.example.service.ISimpleSV;
/**
 * Created by alen on 17-2-16.
 */

@Component
public class SimpleSVImpl implements ISimpleSV {

    @Override
    public String talk(String name) {
        System.out.println("Talk with " + name);
        return "Welcome, " + name;
    }

}
