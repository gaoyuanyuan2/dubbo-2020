# dubbo-2020

## springboot和dubbo整合

### SpringBoot与dubbo整合的三种方式：

1）、导入dubbo-starter，在application.properties配置属性，使用@Service【暴露服务】使用@Reference【引用服务】

2）、保留dubbo xml配置文件;
    导入dubbo-starter，使用@ImportResource导入dubbo的配置文件即可
    
3）、使用注解API的方式：
    将每一个组件手动创建到容器中,让dubbo来扫描其他的组件
    
### 整合hystrix

Hystrix 旨在通过控制那些访问远程系统、服务和第三方库的节点，从而对延迟和故障提供更强大的容错能力。
Hystrix具备拥有回退机制和断路器功能的线程和信号隔离，请求缓存和请求打包，以及监控和配置等功能

如果达到则启动断路器熔断机制，这时再有请求过来就会直接到fallback路径。在断路器打开之后，会有一个sleep window，
每经过一个sleep window，当有请求过来的时候，断路器会放掉一个请求给remote 服务，让它去试探下游服务是否已经恢复，
如果成功，断路器会恢复到正常状态，让后续请求重新请求到remote 服务，否则，保持熔断状态。

