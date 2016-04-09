package com.piggsoft;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * <br>Created by fire pigg on 2016/4/9.
 *
 * @author piggsoft@163.com
 */
@Service
public class UserBean {

    @Autowired
    private RuntimeService runtimeService;

    @Transactional
    public void hello() {
        //这里，你可以在你们的领域模型中做一些事物处理。
        //当在调用Activiti RuntimeService的startProcessInstanceByKey方法时，
        //它将会结合到同一个事物中。
        Map<String, Object> variables = new HashMap<>();
        variables.put("numberOfDays", "5");
        variables.put("employeeName", "haha");
        variables.put("vacationMotivation", "12");
        variables.put("vacationApproved", "true");
        runtimeService.startProcessInstanceByKey("vacationRequest", variables);
    }
}
