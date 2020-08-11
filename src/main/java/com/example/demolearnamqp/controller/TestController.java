package com.example.demolearnamqp.controller;

import com.example.demolearnamqp.bean.WorkOrder;
import com.example.demolearnamqp.bean.WorkorderBaseDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Slf4j
@RestController
public class TestController {

    @Autowired
    private WorkorderBaseDao workorderBaseDao;

    @GetMapping("/test")
    public Object test() {

        WorkOrder workOrder = new WorkOrder();
        workOrder.setTitle("这是标题啊啛啛喳喳啊奥术大师多");
        workOrder.setContent("这是内容啛啛喳喳错啊奥术大师多发发发啊");
        workorderBaseDao.save(workOrder);

        return Arrays.asList("xxx","asdasd", "asdasd", "dasdasdasdddddddddadasdsadddddddddddd");
    }
}
