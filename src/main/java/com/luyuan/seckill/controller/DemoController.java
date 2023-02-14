package com.luyuan.seckill.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO 测试
 * @Author: IsaiahLu
 * @date: 2023/2/14 14:05
 */

@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/hello")
    public String test(Model model){
        Model model1 = model.addAttribute("name", "xxxxxx");
        return "hello sekill...";
    }
}
