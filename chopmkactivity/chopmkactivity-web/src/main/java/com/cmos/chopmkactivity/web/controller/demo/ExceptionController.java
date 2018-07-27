package com.cmos.chopmkactivity.web.controller.demo;

import com.cmos.common.exception.GeneralException;
import com.cmos.chopmkactivity.beans.common.UserInfo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alen on 16-12-6.
 */
@RestController
@RequestMapping(path = "/exception")
public class ExceptionController {

    @RequestMapping(path = "/throw1")
    public UserInfo throw1(@RequestParam(name = "name", required = false) String name) throws GeneralException {
        if (null == name) {
            throw new GeneralException("CSF404");
        }
        return new UserInfo("b63b39a598e13a0c20bee1d78f843d123", "201612061722", "127.0.0.1", "10002");
    }

}
