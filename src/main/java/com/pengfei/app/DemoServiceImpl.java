package com.pengfei.app;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.pengfei.app.api.DemoService;

@Service(version = "${demo.service.version}")
public class DemoServiceImpl implements DemoService {

    @NacosValue("${demo.service.name}")
    private String serviceName;

    @NacosValue(value = "${myconfig}", autoRefreshed = true)
    private String myconfig;

//    @NacosValue(value = "${demo.config.name}")
//    private String configName;


    public String sayHi(String name) {
        RpcContext rpcContext = RpcContext.getContext();
        return String.format("Service [name :%s , port : %d] %s(\"%s\") : Hello,%s ---- %s ",
                serviceName,
                rpcContext.getLocalPort(),
                rpcContext.getMethodName(),
                name,
                name,
                myconfig);
    }
}
