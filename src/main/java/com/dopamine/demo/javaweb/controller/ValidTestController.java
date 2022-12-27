package com.dopamine.demo.javaweb.controller;

import com.dopamine.demo.javaweb.entity.ParamValidTest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author chenzi.ma
 * @date 2022/12/27 11:21
 **/
@RestController
@RequestMapping("/javaweb/validTest")
public class ValidTestController {

    @PostMapping("validTest")
    public void validTest(@Valid @RequestBody ParamValidTest paramValidTest){
        System.out.println("方法完成");
    }
}
