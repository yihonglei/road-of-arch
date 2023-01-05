# 前言

技术核心知识整理，以实战和问题驱动学习。 
“技术体系.xmind”为总导图，detail-xmind 为单项技术核心知识详细导图，以及对应相关技术代码实现。

# 一 计算机基础(thinking-in-base)

计算机组成原理、计算机网络、操作系统、编译原理等。

# 二、数据结构与算法([thinking-in-algorithms](https://github.com/yihonglei/thinking-in-algorithms))

### 1、复杂度分析

- 时间复杂度
- 空间复杂度
- 细分复杂度

### 2、数据结构

- 数组
- 链表
- 栈
- 队列
- 字符串
- 哈希表
- 图
- 跳表
- 树
- 堆
- 并查集
- 线段树
- 树状数组
- 字典树

### 3、算法

- 排序
- 递归
- 尾递归
- 二分查找
- 哈希算法
- 字符串匹配算法
- 深度优先搜索
- 广度优先搜索
- 贪心算法
- 分治算法
- 回溯算法
- 动态规划
- 设计
- 数论
- 数学
- 概念与统计
- 算法技巧

# 三、Java([jdk-source-code-reading](https://github.com/yihonglei/jdk-source-code-reading))

- IO
- NIO
- Reflection
- Collection
- Annotation
- Net
- JDBC
- Concurrent
- Java8
- JVM

# 四、Java 框架

## thinking-in-servlet

- Servlet 生命周期

## [thinking-in-Spring](https://github.com/yihonglei/thinking-in-spring)

- IOC
- AOP
- 注解
- 事务

## thinking-in-springmvc

- 启动流程
- 请求响应执行流程
- 核心组件
- 常用注解

## thinking-in-springboot

- 启动流程
- 请求响应执行流程
- 自动装配
- 核心组件
- 常用注解

## thinking-in-springcloud

- 设计目标与优缺点
- 整体架构
- 核心项目
- 注册中心
- 配置中心
- 网关 API

## thinking-in-dubbo

- Dubbo 线程模型
- Dubbo 注册中心
- Dubbo 注册发现流程
- Dubbo 通信协议
- Dubbo 内置容器
- Dubbo 负载均衡
- Dubbo 集群容错
- Dubbo 结果缓存
- Dubbo 服务降级

## thinking-in-mybatis

- 解析和运行原理
- 映射器
- 动态 SQL
- 二级缓存
- 插件模块

## thinking-in-netty

- 线程模型
- 零拷贝
- 粘包拆包
- 序列化
- 编码解码
- 内存池
- 无锁化

## Zookeeper

- CAP
- session 基本原理
- Watcher 事件机制原理
- 主从节点同步机制
- Leader 选举原理
- 分布式锁实现原理
- 部署方式

## [daisy-framework实战项目](https://github.com/yihonglei/daisy-framework)

含Spring体系、MyBatis、MySql、消息中间件、缓存中间件、分布式事务、分布式锁、

分库分表、高并发、高性能、高扩展、稳定性，数据分析等经典方案实战大杂烩。

# 五、MySql(thinking-in-mysql)

- 基础
- 事务隔离
- 索引
- 锁
- 主从复制
- 存储引擎
- 数据安全
- 分库分表
- 性能调优

# 六、缓存中间件(thinking-in-nosql)

Redis、MongoDB、Memcached等。

- 缓存雪崩
- 缓存穿透
- 缓存击穿
- 缓存降级
- 缓存预热
- 缓存双写一致性
- 冷热数据分析
- Redis 线程模型
- Redis 哨兵模式
- Redis 集群模式
- Redis 持久化方式
- Redis 扩容
- Redis key 过期策略
- Redis 内存淘汰机制
- Redis 主从复制原理
- Redis 事务
- Redis 分布式锁
- Redis 和 Memcached 区别

# 七、消息中间件(thinking-in-message)

RocketMQ、Kafka、RabbitMQ等。

- 消费幂等性
- 消息积压
- 消息丢失
- 顺序消息
- 延时消息
- 定时消息
- RocketMQ 高可用
- RocketMQ 工作流程
- RocketMQ 部署架构
- RocketMQ 发送方式
- RocketMQ 消费方式
- pull
- push
- RocketMQ 消费模式
- 集群消费
- 广播消费
- RocketMQ 负载均衡
- RocketMQ 存储机制
- RocketMQ 存储结构
- RocketMQ 高性能原因

# 八、搜索引擎(thinking-in-elasticsearch)

- ES 读写底层原理
- ES Lucene 原理
- ES 分布式原理
- ES 倒排索引
- ES 集群部署、索引数据量、索引分片

# 九、设计架构([daisy-framework](https://github.com/yihonglei/daisy-framework))

分布式架构，微服务架构，高可用架构，高并发架构，高性能架构等，系统监控以及运维部署等项目实战。

## 1、架构基础

- 架构演进
- BASE
- CAP
- FMEA
- DDD
- 六大原则
- UML
- 设计模式
- BFF
- 架构背景
- 架构目标
- 业务架构
- 系统架构
- 目标规划
- 团队建设
- 任务执行
- 沟通交流

## 2、技术选型

## 3、技术规范

- 编程规约
- 异常日志
- 单元测试
- 安全规约
- 数据库规约
- 工程结构
- 设计规约
- MySql 开发规范
- Redis 开发规范

## 4、分布式架构

- 分布式框架（Spring，Spring Boot，SpringCloud，Dubbo）
- 网络通信
- 负载均衡
- 分布式事务（2PC，3PC，TCC，消息最终一致性）
- 分布式锁（基于 Redis，Zookeeper，MySQL 实现）
- 分布式会话（session）
- 分布式全局唯一 ID（分布式系统的全局 ID 如何实现? Snowflake 是否受冬令时切换影响？）
- 一致性 Hash 算法
- 分布式调度（Elastic-job，xxl-job）

## 5、微服务架构

- 注册中心（Zookeeper，Eureka，Nacos，Consul）
- 配置中心（Spring Config，Apollo，Nacos，Diamond，Disconf）
- API 网关（Zuul，Gateway，OpenResty，Kong）

## 6、安全性架构

- Web 攻击
- 安全算法
- 摘要认证
- 签名认证
- HTTPS 协议
- OAuth 协议

## 7、高可用架构

- 日志分析
- 集群容错
- 服务故障隔离
- 系统监控

## 8、高并发架构

- 系统拆分
- 缓存中间件（Redis，Memcached，MongoDB）
- 消息中间件（RocketMQ + Canal）
- 读写分离（提高查询能力）
- 分库分表（ShardingJdbc，MyCat）
- 搜索引擎（Elasticsearch）

## 9、高性能架构

- 秒杀设计
- 性能优化

## 10、数据分析

- 日志聚合
- 离线数据分析
- 流式数据分析
- 数据同步
- 数据报表
- 海量数据处理

## 11、硬件架构

## 12、技术方案汇总

- 通信协议
- 序列化
- 分布式事务
- 分布式锁
- 分布式会话
- 单点登录
- 负载均衡
- 分布式全局唯一 ID
- 一致性 Hash 算法
- 注册中心
- 配置中心
- API网关
- 网络安全
- 幂等性
- 缓存双写一致性
- 消息丢失
- 消费幂等性
- 消息积压
- 延迟消息
- 消息顺序性
- 线程池
- 分库分表
- 读写分离
- 主从延时
- 多数据源
- KV表设计
- 连接池
- 集群容错
- 系统监控
- 海量数据
- 秒杀设计
- 工作流

# 十、部署运维

- Linux
- git
- maven
- Jenkins
- Nginx
- Tomcat
- Devops
- Docker
- K8s

# 十一、大数据核(thinking-in-bigdata)

## 系统集成

## 离线计算

- 数据源：数据文件、数据库中的数据等
- 数据采集：Sqoop 等
- 数据存储：HDFS
- 数据分析：MapReduce、HIve、Spark
- 计算结果：Hive 结果表（HiveJDBC 查询）、导出至关系型数据库

## 实时计算

- 数据源：日志文件增量监听等
- 数据采集：Flume
- 中间件：Kafka
- 数据分析：Spark-Streaming，Storm，Flink
- 计算结果：HBase

## 通用架构

- 数据来源层
- 数据传输层
- 数据存储层
- 资源管理层
- 数据计算层
- 任务调度层
- 多维度分析层
- 应用层

## 通用流程

- 数据采集
- 数据存储
- 数据分析
- 数据应用

## 数仓架构

- 源数据层
- 数据仓库层
- 数据集市层
- 数据应用层