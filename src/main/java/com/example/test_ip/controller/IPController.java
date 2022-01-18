package com.example.test_ip.controller;

import com.example.test_ip.service.IpService;
import com.example.test_ip.util.Result;
import com.example.test_ip.util.ResultUtil;
import com.example.test_ip.util.code.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping(value = "/ping")
@CrossOrigin
public class IPController {

    @Autowired
    private IpService ipService;

    @RequestMapping(value = "/pingIP", method = RequestMethod.POST)
    public Result ping_value(@RequestParam Map<String, Object> ipMap) {
        try{
            Map<String, String> ip_map = ipService.ping_value(ipMap);
            return ResultUtil.success(ip_map);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return ResultUtil.error(Code.PROGRAM_ERROR.getCode(), Code.PROGRAM_ERROR.getDesc());
        }
    }
}
