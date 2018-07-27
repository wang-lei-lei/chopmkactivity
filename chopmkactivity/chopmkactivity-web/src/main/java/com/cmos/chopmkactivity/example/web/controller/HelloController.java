package com.cmos.chopmkactivity.example.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cmos.chopmkactivity.iservice.IExampleSV;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * Created by alen on 17-2-23.
 */
@RestController
@Api(description = "RestController简单示例")
public class HelloController {

    @Reference(group = "chopmkactivity")
    private IExampleSV exampleService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ApiOperation(value = "say hello", notes = "@RequestPara形式入参")
    @ApiImplicitParams(@ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String", paramType = "query"))
    public String hello(@RequestParam String name) {
        return exampleService.sayHello(name);
    }

}
