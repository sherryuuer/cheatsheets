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
- **Flow 由 events 组成，events 包括 actions，data**，UML时序图是一个很好用的工具

- cost 计算：DAU决定requests量和 bandwidth 瓶颈，数据存储每日TB量

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
  - 使用不同物理区域分配服务器，用于灾害恢复
  - 停止发送 traffic 和 workload 到有问题的 host
  - 重启服务，或者启动一个新实例
  - rollback 回滚之前的版本，predefined handbook


### **Security**

- 数据安全和数据加密带来的性能问题的权衡
- 几个维度：顺序是不断接近最重要的数据的
  - 身份认证和访问安全
  - web安全：SQL注入，跨站网络攻击
  - 网络安全：端口，病毒，流量，DDoS
  - 基础设施安全：数据中心，物理安全等
  - 数据传输安全（数字证书），数据存储安全（硬件和软件加密），用户敏感信息保护

### **Cost&Operation**

- 成本和运维优化可以体现在各个方面
- cost：
  - 数据存储分 hot，warm，cold 等 tier
- operation：
  - DevOps 指导

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

### WebSocket
real-time protocol

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
- 提供多种*请求分配策略*
- **可以在后端作为internal的LB组件，每一个service都可以是一个服务器集群，那么这意味着每个集群都可以有一个LB，比如k8s就是用内部的service组件进行LB**

- **GSLB**：global server load balancer
- 是一种 DNS 和 LB 的混合体
- 解析客户端的 location，结合地理信息，发送给健康的 server/或者基于地理的子load balancers
- 由于和 data centers 进行通信，可以有独特的基于 cpu，throughput，traffic等的策略
- *灾害恢复*的重要组件

### Message Brokers

- 异步通信和疏结合的重要组件 Async
- 适用于：后端处理需要很长时间的情况 / 前端收到大量 requests 的情况
- 用于系统内部而不会暴露在外
- 使用 Queue 数据结构
- 主要功能：buffer message, message routing, transformation validation, load balancing
- 一个用例：前端收到订单，对数据库进行库存-1处理，并将订单发送到 queue 等待接受处理
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

- 需要解决的问题，是后端的各种API服务之间，难以统一管理的问题 -> API composition，让用户接口API结合为一个 single one
- Benefits：
  - 提升用户 routing 效率，从多个 requests 合并后只需要 call 一个 request
  - cache 静态内容和 response，从而提升 performance
  - 后端API易于 refactoring 和 modification
  - 便于集中管理 authentication，authorization，security，rate-limiting
  - monitoring，alarting
  - protocol translation 比如外部用 HTTP/s协议接收 request，内部使用 gRPC 协议进行服务间通信

- 注意事项：
  - 不要有任何 business logic
  - 消除 SPOF，前置 LB，进行冗余和负载均衡设置，同时用 DevOps 确保消除 human error，防止全系统失败
  - 不要让外部不必要的请求 bypass 你的API Gateway，直接 request 内部服务，只通过 API Gateway 请求，这便于维护我们的内部API接口，而不是维护多个外部接口

### CDN

- 需要解决的问题（wide world wait 问题）：地理距离，TCP握手，大文件传输（iamges，videos流，HTTP/JS/CSS文件），造成的高延迟
- 物理近便性，cache
- 提高后端服务可用性，降低传输延迟（performance）
- DDoS 防护层

- *Products*
- Cloudflare
- Google Cloud Platform CDN
- AWS CloudFront

- *特征*
- 使用优化的hardware
- 文件压缩技术，降低 bandwidth 压力
- pull 方式更新文件，设置 TTL，过期文件定期更新，不存在的文件，根据用户的 request 重新 pull
  - pro：CDN 管理一切，服务器压力小
  - con：第一个用户有延迟，TTL 设置不好会导致流量延迟或者内容过期，同样需要维护源服务器，如果被 pull 的时候出问题，用户会发生 error
- push 方式更新，很多 case 直接设置一个很长的 TTL，然后每次更新源文件都进行 push
  - pro：源服务器控制推送时机，提高内容可用性，*适合内容不经常更改的场景*，只需要更新推送即可，降低流量
  - con：需要增加源服务器逻辑，维护推送逻辑，不适合高频更新的场景

## Data Storage at GS
（GS=Global Scale）
### RDB & ACID

- *pro*：
- SQL 标准操作语言
- 数据进行正规化处理，提高存储效率
- ACID 性质保证了事务处理的高效和正确

- *con*：
- 预先设计的 schema 结构是死板的（rigid），后期不容易更改
- scale 和 maintain 难度高
- read 很慢，行存储特性

- 适用于：不需要大量 read 操作，需要复杂查询，或事务处理的场景

### NoSQL DB

- 数据不需要统一的 schema，以 attributes 的形式随意增减，因此不容易像SQL数据库那样进行分析，也不容易支持 ACID 事务处理了
- 不一定以 table 的形式存在，而是更接近编程语言的存在方式，list，map，json
- RDB用于高效存储，NoSQL适用于高速检索，由于数据结构也很多，所以有很多不同的 NoSQL 适用于不同的 usecase
- 用户的 session 数据使用NoSQL存储，就可以进行自由的应用层扩展

- *types*
- Key-value store
- Document store：collections of objects（class -> attributes with data types）, example: json, xml, yaml
- Graph store: extension of document store, with *Link, traverse, analyze* efficently
  - 比如，欺诈检测，同一个人用不同账号进行事务处理，推介系统，社交网络

- *use case*
- 高速查询，比如 caching，放在 RDB 前面的 key-value store
- 大数据，实时 real-time 查询
- schema 不统一，比如你的推特，用户 profiles，

- Key-value Stores: Redis, Amazon DynamoDB
- Document Store: Cassandra, MongoDB
- Graph Databases: Amazon Neptune, NEO4J

### Techniques of improving SAP of DB
(SAP: scalability, availability, performance)

1. indexing
- 索引数据，优化查询（而不是 scan 全表），使用 hashmap 算法，或 B-tree，自平衡树，以 log 速度进行查询
- index 意味着将经常查询的 column 和行号 mapping，从而快速找到想要的数据，index 可以是一个 column，或多个 columns 的组合
- 但是，会增加 index 的存储量，同时 write 速度会变慢（更新表的同时要更新索引）

2. replication
- Fault Tolerance：一个烧了，也有备份
- Throughput：提高查询带宽，大家一起查
- 但是，提高了write，update，delete的操作难度

3. partitioning/sharding
- pro
  - 存储更多数据，在更多 db servers 上，提高并行查询的效率
  - 路由到正确的 shard 上，需要更大的开销 overhead
- 在 NoSQL 数据库上进行分区更自然，因为记录之间是解耦的，更容易实现
- SQL数据库中则一般需要多行查询结果，在大数据查询中，保证正确分区非常重要

### CAP
- 在一个*分布式系统*中，存在*网络通信和延迟*的情况下，只能选择*一致性*和*可用性*之一
- 但是能保证 CA 的只有一个中心化的大数据库，但它将成为 SPOF，这是不现实的，所以只能是 AP 或者 CP，A和C之间就像是一个刻度尺，是此消彼长的关系

### Unstructured Data Storage

- SQL 或者 NoSQL 都是结构化数据，非结构化数据是 images，videos，pdf，blob 等无法简单存储在数据库中的数据类型
- use cases：
  - 用户上传存储，压缩，编码，分享，备份这些数据
  - SQL，NoSQL 数据库的备份 snapshots 文件，适合灾难恢复，backup，audit，archive
  - 系统的镜像 images 备份文件
  - web hosting 时候的图片，缩略图，大型静态文件等
  - 用于大数据，IoT和机器学习的数据存储

- *DFS*：distributed file system
- 以传统的文件系统的方式存储数据
- 无需 API
- 可以直接修改，添加文件内容
- 在分布式系统上的操作高效快速
- 但有时文件数量有限制，无法通过 web api（HTTP/REST）进行访问

- *Object Storage*
- 存储数量无限制
- 单个文件 limit 很高（5～10TB）
- 提供 HTTP/S REST API 接口
- default 版本控制 versioning 功能
- 没有文件夹结构，为扁平结构，用 URI 标识
- 每个 object 有自己的 metadata 数据
- ACL 系统，控制用户对象访问
- 基本云提供商，都有 tier 存储等级，节省 cost
- 如果基于某些限制不能使用云提供商的服务，可以用开源的第三方 Object storage 存储
- 云服务的后台有 replication 机制，耐灾害性
- 无法直接修改文件，每个文件都是一个新版本
- 相比较DFS，I/O性能较低

## Architecture Patterns
- 所有的架构模式都是一种 guidelines 而不是一个枷锁，提供 best practice 来参考，但不是固守
- 随着系统的进化，一种模式可能会不适合我们的系统，migration 是有可能发生的

### Multi Tier Architecture

- 指不同的 application 在不同的物理基础设施上运行，和 multi layer（单个app的多个层）不是一个种概念
- 由于 Apps 存在于不同的servers，所以他们之间都可以用 Client-Server 模型进行通信
- 松耦合，便于更新和置换各自的内部结构

- *Three-tier architecture*
1. 前端（presentation tier），web page，mobile app，desktop app，不包括任何 business logic，用于用户交互，和取得 input 信息
2. 后端（business tier/logic tier/app tier），从前端取得数据，进行处理
3. 数据库（data tier），存储和持久化数据，包括文件和数据库
- pro
- 很多 use case，比如电子商务网站，news网页，甚至视频网站
- 易于扩展，大量数据处理效果也不差
- *适用于小规模的应用构架，代码逻辑不复杂，小团队维护，比如初创*
- con
- logic 层是一个单体 monolithic 构架层，所以每一个扩展的后端 app 服务都需高 CPU 和 memory，比如Java的垃圾回收机制需要更长的时间
- 代码逻辑会越变越大，不利于开发，理解，和维护，增加更多的开发人员反而更高的开销和代码冲突
- 虽然可以将代码模块化，但他们之间仍然是紧耦合的！

- *two-tier architecture* 是将前端和后端逻辑合一，比如 mobile app 或 desktop app 中安装所有逻辑
- *four-tier architecture* 是在前端和后端中间加入 API Gateway，以应对多种前端应用形式的需求，比如协议解析，安全检查，cache等功能

### Microservices Architecture

- small code base，易于管理，部署更快，服务分离
- 组织扩展性，每个团队可以用不同的框架，语言，计划，进行开发部署
- 需要更少的cpu 和 memory，提供更高的性能，水平扩展也更快更方便
- 更安全，因为 fault 是分离的
- AWS 一开始的出现，就是因为社内的服务 API 的启发
- 服务之间依赖于通信，因为是松耦合，分布式的
- con：更多的 *overhead 和 challenges*，test 和 debug 比较难
- 需要服务之间的完全逻辑分离，不需要和其他 team 开会
- *单一责任原则 single responsibility principle*，一个服务负责一个领域，行为，资源
- 为每个服务*分离 database*，产生的数据重复应当在一个可以接受的 overhead 的限度内
- 当然该模式的好处也是有上限的，如果组织过于复杂和庞大，好处就会逐渐降低
- 从单体构架，过渡到微服务构架，是一个不错的实践方式


**构架原则：**

1. Cohesion（功能聚合，定义边界）：将相同功能的 function 放在一起，定义微服务的边界
2. Single Responsibility Principal（单一职责原则）：每个服务明确管理一个功能，和一个好用的API接口，size 并不重要
3. Loose Coupling（疏结合）：防止服务之间的过渡依赖





### Event Driven Architecture

- 无需 request 的 commands 和 data，只需 events
- 分为 fact events 和 change events
- Events producer -> message broker -> consumers
- 好处在于，*消除了服务之间的依存关系*，异步，解耦
- consumers 的添加不需要 producer 知道
- 适合 real-time 分析
- *Event source pattern* 事件源模式，告诉我们交易发生的历史过程，log分析，事件是不可变的单元，只能被添加，重放
- *CQRS（Command Query Responsibility Segregation，命令查询职责分离）*读写分离模式，事件源的数据只用于操作，事件处理服务的数据只用于读，所有变化都以事件的形式存在，比如join事件，在一个数据库发生了更改的时候，触发更新read-only数据库的*物化视图*，这个模式*好天才*！
- *物化视图 Materialized view*是事件驱动型

## Big Data Architecture

- 大量，多类型
- Data fusion：找到隐藏模式 hidden patterns 和洞察 insights
- 用于 prediction
- 高速产生 stream data 比如 IoT

- *批处理策略*
- 按照时间序列处理最新的数据批
- 比如用户评论分析，网页爬虫，网页推介系统
- 大数据分析，数据融合，洞见
- 对 latency 不敏感
- *流处理策略*
- 使用 message broker 处理
- 实时log分析，网络交易实时查询，不适合分析和洞见

### Lambda Architecture

- 同时满足批处理和流处理的构架
- 三层构架：batch layer, speed layer, serving layer
- 数据同时进入 batch 和 speed layer
- batch layer 进行批处理
- speed layer 进行流处理
- serving layer 同时拥有上面两个 layer 处理过后的 historic 数据和 recent 数据
- *Google Analysis*就是这种感觉，既有流数据又有历史数据


## Case study
### Discussion Forum（Reddit，stackoverflow）

* client -> app(write to user db and comments db) -> document db
* client -> app(calculate the votes) -> key-value db
* -> batch processing data -> generate most popular posts -> cache to CDN feed to users

- REST API
1. entities: user, posts, images, comments, votes(must be idempotent)
2. mappting them
   - users
   - posts(->images/votes) -> comments(->images/votes)
3. resources data format
   - users(json): id, other info
   - posts(json): userid, upvote, downvote, comments_list (image, title...)
4. assign operation to resources
   - users: post
   - posts: get, post, delete

- scalability:
  - LB -> web server, LB -> backend services
  - API gateway -> all servers's LB
  - db shards: hash(post id + comments id 防止热点) index + range sharding
- performance
  - image/html on CDN
  - API gateway cache
  - db indexing
  - voting service -> message broker -> posts/comments
- fault tolarence
  - db replication
  - all parts are replicated
  - GSLB 全球覆盖流量路由
- 数据库特性是 AP

### E-commerce

- Merchants:
  - upload products(image/text/video)
  - sell products: stock -1
- Users:
  - browse products
  - search
  - buy

- REST API/HTTP/S
- entities:
  - merchants
  - users
  - products: count

- mapping:
  - users(SQL): id, product_id
  - product(NoSQL): id, price, stock, merchants_id
  - merchants: id

- diagram:
- Merchants client -> (post image/text)web server -> product db -> ranking servers -> product
- user client -> (browse)web server
- user client -> (search)web server -> search engine -> cache db -> product db
- user client -> (buy)web server -> message queue/stock-1 -> pay(3rd-party api) -> end -> email
- images -> object storage

- Non-functional
  - scalability
    - LB -> servers
    - API gateway
    - db sharding
  - availability/fault tolerance
    - replication
    - GSLB
  - performance
    - image/html CDN
    - cache -> db
    - db indexing
  - CAP: AP
