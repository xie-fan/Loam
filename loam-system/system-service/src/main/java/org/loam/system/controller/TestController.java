package org.loam.system.controller;

import jakarta.annotation.Resource;
import org.loam.common.core.bean.vo.DataSet;
import org.loam.system.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/send")
    public DataSet<String> sendMessage(@RequestParam(value = "message", required = false) String message) {
        return DataSet.success(null, testService.sendMessage(message));
    }

}
