**本项目提供了两种服务治理方式eureka/consul**
# 项目结构
|模块             |功能                               |
|:------          |:--------------------              |
|eureka-server    |服务注册服务端(服务注册中心)       |
|eureka-client    |eureka服务提供端                   |
|consul-client    |consul服务提供者                   |


# 服务部署启动
*  使用eureka方式，则需要启动eureka-server(服务注册中心)和eureka-client(服务提供者)
*  使用consul方式，需要在控制台启动consul服务端，然后再启动consul-client客户端
    * 启动consul服务端方式：consul agent -dev



