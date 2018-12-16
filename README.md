# 注册配置和业务配置分离

1. 本地dubbo注册配置信息 provider-config.propertis

```
## application
dubbo.application.name = dubbo-provider-demo

## Nacos registry address
dubbo.registry.address = nacos://127.0.0.1:8848

## Dubbo Protocol
dubbo.protocol.name = dubbo
dubbo.protocol.port = -1
```

2. 业务配置可配置在nacos配置中心

```$xslt
# Provider @Service version
demo.service.version=2.0.0
demo.service.name = demoService

demo.config.name = tom

# custom config
myconfig = qqqqqqqqq
```
