package com.computer_repair.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
class Controller {
    @GetMapping("/getTest")
    @ResponseBody
    public String getTest() {
        return "ok！";
    }
}
