package com.xmqbeast.redis.controller;

import com.alibaba.fastjson.JSONObject;
import com.xmqbeast.redis.service.CompanyService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ApiController {

    @Resource
    private CompanyService companyService;

    @RequestMapping(value = "/isCompany/{company}", method = RequestMethod.GET)
    public Integer isCompamy(@PathVariable("company") String company) {
        return companyService.isCompany(company);
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer isCompamy() {
        return companyService.add();
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public Integer del() {
        return companyService.del();
    }


    @RequestMapping(value = "/string/set", method = RequestMethod.GET)
    public Integer set() {
        String key = "string2";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("raw_value", "娃哈哈(北京)");
        jsonObject.put("clean_value", "娃哈哈(北京)有限公司");
        jsonObject.put("isLabel", 1);
        companyService.set(key,jsonObject.toString());

        return 1;
    }

    @RequestMapping(value = "/string/get", method = RequestMethod.GET)
    public String get() {
        return companyService.get("string2");
    }
}
