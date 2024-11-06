## Requirements & Constraints

- 用户自己大部分时候也不知道需要什么样的功能需求
- 提出要求的一刻，我们就是在解决问题了
- 和 code 程序一样，系统如果是一个黑盒子，那么它也有相关的 input，event 和 output，连接的部分叫做 API，黑盒子中间是程序，input 是数据结构，也可以理解为数据库中数据的存储方式和 class 的大体内容，输出则是返回给用户或者其他组件的内容，这么看来，其实系统设计是软件设计的一种 high-level 表达

**Functional**的部分由具体的processes的API决定
**Non-Functional**的部分由设计构架决定，而且这通常是后期构架更改的原因
- trade-off 权衡考量
- testability/measurability 可测量
- feasibility 可行性

**Constraints**主要包括time，budget，staffing skillset等，这是我们需要做权衡的很大一个部分，也是框定我们 scope 的一个好的起点
- techical constraints：硬件软件，浏览器，license等
- business constraints
- legal constraints
- 分清哪些是可以商讨的，哪些不可变
- 那些在未来可能被替换的部分，比如数据库，坚持使用*loosely coupled*构架，方便未来替换部分组件

**如何收集requirements**

- use case：使用场景再现
- user flows：使用可视化的流程再现这些场景
- 将二者融合，抽取所有 actors，data，events
- Flow 由 events 组成，events 包括 actions，data，UML时序图是一个很好用的工具

## Quality Attributes

### **Performance**

- *Response time*（latency要素）= processing time + waiting time
- processing time：包括代码效率，数据库效率（数据结构，查询效率）
- waiting time：request在硬件，queue中等待被处理的时间
- response time 被认为是最重要的关于性能的指标，它符合长尾效应，有tail latency的说法，有部分处理的延迟影响整个系统的延迟
- *Throughput* 是另一重要指标，在大量数据的情景下（比如log收集系统，数据通过量越多越好）

- 影响 performance 的要素：cpu，memory，connections/I/O，message queue

### **Scalability**

- *Vertical*：无需代码修改，但是有上限，而且有单点障碍风险
- *Horizontal*：伸缩方便，高可用性，耐灾害性，自动作为备份存在，但也提高了管理的复杂度，和消耗 overhead
- *Teams/Organization*：增加 Engineers，增加 codebase（服务分割也是一种扩展）
  - 问题点：无效回忆，代码冲突，系统学习复杂度，测试复杂度
  - 解决方案：代码模块化，甚至服务分割，疏结合，用各自的发布计划，代码框架，和API，以及*DevOps*的运维框架

### **Availability**

- 可用性的影响有时候是巨大的，比如S3这种被很多business使用的服务，停电的话波及的将是整个互联网
- business 观点的影响包括服务不可用带来的利润下降，客户流失

- time 指标 = uptime / (uptime + downtime) OR MTBF / (MTBF + MTTR)
- MTBF: mean time between failure (uptime)
- MTTR: mean time to recovery (downtime) -> 高**Reliability**，快速的恢复能力，会提高可用性

### **Reliability/Fault Tolerance**

- Human Error
- Software Error
- Hardware Error

- *Failure Detection and Isolation*
  - Monitoring service：进行 healthcheck 或者听取各个node的 heartbeats/pings 信息
  - 收集的信息包括：error count，response time
  - 设置各种 alart
- *Failure Prevention*
  - 消除任何 SPOF 单点障碍点，replication/redundancy
  - redundancy 包括物理上的，也包括时间上的，时间上包括处理重试等策略，记得确保幂等性
  - replication 策略包括：active-active，active-passive
- *Recovery*
  - 停止发送 traffic 和 workload 到有问题的 host
  - 重启服务，或者启动一个新实例
  - rollback 回滚之前的版本，predefined handbook

### **Security**
### **SLA/SLOs/SLIs**

## API Design

- client -> API
- business client's backend
- between services

- 封装性
- 容易理解，容易使用
- 单向 one way
- 容易理解的变量和函数名
- 保证幂等性 idempotent
- 结果分页，容易读取
- 异步处理API，只收到一个开始处理的response，而不需要等待结果
- 版本控制，逐渐过渡

### **RPC**
- 远程程序调用
- 三个组件：
  - Interface description language（IDL）-> 编译为要使用的调用代码
  - Client Stub
  - Server Stub
- 调用远程程序宛如在本地执行，所有的 error 和 exception 也宛如在本地
- 但是可能会有*通信延迟*，最佳实践为对处理时间较长的请求*异步执行*
- 需要小心设计，不然会引起用户使用上的歧义，所以坚持 idempotent 设计很重要
- 使用场景：
  - 主要用做后端服务，或者大型系统的服务之间的 API 通信，*不用于客户端通信*
  - 主要用于处理 actions，而不是处理 data/resources，或者对数据的 CRUD 操作
- frameworks: Apache Thrift, gRPC

### **REST API**
- 注意它不是一个 standard 或者 protocol，而是一个 API的style
- 和RPC调用的不同在意，*RPC 调用全是基于 methods，RESTAPI 调用基于 resources*
- 在返回 json 中可带有动态超链接，用于提示用户接下来的操作，HATEOAS
- 优势在于：
  - server 是 *stateless* 的，由于不需要维护 session，这提高了可用性和可扩展性
  - 可 cache 的，降低系统 workload 负担
- URI 层级资源，可以是任何形式：image，blob file，link，html，code 等
- 分 single（用名词单数表示）资源和 collection（用名词复数表达）资源
- Operations：
  - GET：idempotent，可cache
  - POST（create）：json/XML
  - PUT（update）：idempotent，json/XML
  - DELETE：idempotent
- 设计流程：
  - Identifying entities
  - Mapping entities to URI
  - Defining Resource representation: use Json is great
  - Assigning HTTP methods to Operations on Resources

## LS-System building blocks
(large scale system)

### Load Balancer
- scalability：servers 集群组件，根据 requests 和 network bandwith 增减服务器
- availability：有 monitor 功能，排除故障 servers
- performance（throughput）：虽然它本身有 response 延迟，但是和后端集群的处理速度相比，这是可以接受的范围

- *products*
- layer7层的HTTP/S类型LB，或者叫Application LB
- layer4层的TCP/UDP类型的LB，或者叫Network LB
- Gateway LB用于虚拟网络设备的路由比如防火墙
- GSLB：AWS的Route53，GCP的Cloud DNS

- *types*

- *DNS*：一个 domain 可对应多个 ips
- 只能用 round-robin 的分配方案
- 但是无法监控 servers 的状况，基于 TTL 无效化 ip，这导致需要时间来切换到健康的 server
- 会暴露ip端点，这是不安全的，比如 DDoS 攻击风险

- *hardware/software LB*：专用的硬件设备或者软件程序
- 较为安全
- 有监控功能
- 提供多种请求分配策略
- **可以在后端作为internal的LB组件，每一个service都可以是一个服务器集群，那么这意味着每个集群都可以有一个LB，比如k8s就是用内部的service组件进行LB**

- **GSLB**：global server load balancer
- 是一种 DNS 和 LB 的混合体
- 解析客户端的 location，结合地理信息，发送给健康的 server/或者基于地理的子load balancers
- 由于和 data centers 进行通信，可以有独特的基于 cpu，throughput，traffic等的策略
- *灾害恢复*的重要组件

### Message Brokers

- 异步通信和疏结合的重要组件 Async
- 适用于：后端处理需要很长时间的情况 / 前端收到大量requests的情况
- 用于系统内部而不会暴露在外
- 使用Queue数据结构
- 主要功能：buffer message, message routing, transformation validation, load balancing
- 一个用例：前端收到订单，对数据库进行库存-1处理，并将订单发送到queue等待接受处理
- 大多 Brokers 拥有*Pub/Sub*构架功能，很容易进行 service 服务订阅的添加，提高系统的*可用性和扩展性*

- *fault tolerance*
- 即使后端有些服务暂时不可用也不会影响系统运作，可以待系统恢复再进行处理
- 防止待处理数据丢失，存储在buffer中，有一个保存期限
- *availability/scalability*
- 即使上游有流量瓶颈也可以按照自己的速率进行处理，确保可扩展系统的稳定性
- *performance*
- 会为latency付出一点代价，但是和好处相比并不明显，毕竟是异步通信

- *products*
- Apache Kafka：a distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications
- AWS SQS
- GCP Pub/Sub

### API Gateway
