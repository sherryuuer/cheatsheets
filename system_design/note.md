### daily learning tasks
1. review system design
2. read docs
3. coding practice
4. video of basic skill

### SA

**（上流工程）**
- ビジネス目標達成する、問題解決する、新しいストラテジー生み出す、業務の需要、システム開発の需要、両方の達成
- 定量、定性的にサービスレベルを決める
- 最適な技術選定と、最適な開発、運用フローの決定

**（プロジェクトマネジメント）**
- コスト（予算、人員、時間）、変化の対応

**（より高い目線）**
- 可用性と災害回復、拡張性、パフォーマンス（リスポンスとスループット）、安全性、運用性


**流れ：**
1. トップレベルの考慮事項：
  - ビジネス目的・ゴール
  - 問題点は何でしょうか、いわゆるWHY
  - 定量定性的に（ユーザー量、KPIなど）
  - プロジェクトの制限事項、コスト、質、時間、スコープのトレンドオッフ
  - 技術選定：拡張性・マイクロサービス・API・疎結合
  - 開発手法：アジャイル

2. ユースケース分析：（基本設計まで）
  - ターゲット：アクター（登場人物、ユーザは誰なのか）
  - ユースケース、流れ、フローチャート
  - モデリング：画面、機能とデータの仕様

3. アーキテクチャを作る
  - コンポーネント
  - API設計
  - データベース選定

4. 非機能要件を説明と工夫
  - 拡張性ありでパフォーマンス高い
  - 災害復旧機能が高くて、可用性が高い
  - セキュアな
  - 優れる運用手法
  - コスト抑えられる

5. POCとプロトタイプ開発


### coding approch

steps:

1. Ask Constraints

- Are the nums all positive?
- Are there any duplicates?
- edge case? []case? one element case? Does it have solution?
- What do I return when no solution? None?
- The solution is only one pair?

2. Write some test cases
3. Figure out a solution without code
4. Write out the solution code
5. Doule check for errors
6. Test the code with test cases: this is really explain the code step by step
7. Analyze space and time complexity: if it is exponential, it definitly can by improved
8. Optimize the solution

Strategies:

1. **Break the problem down**: Start by thoroughly understanding the problem. Clarify any ambiguities, restate the problem in your own words, and break it into smaller parts. Interviewers often value how you approach a problem more than just finding the optimal solution right away.

2. **Pattern recognition**: Many problems in coding interviews are variations of common patterns (two pointers, sliding window, dynamic programming, divide and conquer, etc.). Try to map the problem to a pattern you're familiar with. Even if it’s new, it likely has some familiar structure.

3. **Start simple**: Don't worry about jumping to the optimal solution immediately. Start by explaining the brute-force approach or the most intuitive one. This shows you understand the problem, and you can then discuss how to optimize it.

4. **Think aloud**: Share your thought process openly during the interview. It helps you organize your thinking, and interviewers can give hints if they see you heading in the right direction.

5. **Ask for constraints**: Interviewers might not explicitly mention important constraints (e.g., size limits). Asking about them can help you avoid over-engineering or missing key insights.

6. **Practice flexibility**: Exposure to different problem types will improve your ability to adapt. As you practice more problems, you'll start seeing patterns that are common across a range of problems, improving your ability to adapt quickly in an interview.

* Break down a problem into a sub problem! like the 06 problem.

*Memo*:

1. ask for constraints, edge case
2. test case and confirm
3. start simple and pattern recognition: find solution by draw, simulation by thinking
4. write code clearly
5. test code
6. analyze the bigO
7. discuss trade-off and improve

**coding pattern! and template**

### thinking perspective

[ref-thanks](https://github.com/ByteByteGoHq/system-design-101)

**stakeholders**
1. users
2. developer
3. business management

**security perspective**
1. data: store / transfer
2. infrasturcture: servers, network
3. timeline: logs, monitoring

**trouble shooting steps**
1. define the problem
2. collect data, info, log and system diagram
3. establish a theory and solution
4. implement the solution
5. (loop step 3 and 4)
6. test the system and figure out a long-time solution
7. documentation the issue

**troubleshooting root finding perspective**
1. simple is best if I know it from log or Google, do it
2. hardware: CPU, memory, IO, network issue
3. software: API, code logic
4. timeline: recent change, internal/external, users increasing
5. scope: client/external network/cloud-internal
6. data-life-cycle: client(brower/machine) -> DNS ->CDN -> router/internet -> LB -> firewall -> frontendServer -> APIServer -> cache -> database
7. security issue: like DDos attack

**system design steps**
1. requirements:
   - functional
   - non-functional(the most important points)
   - cost, time, skill stack
2. data schema high level define: table names
3. high level design:
   - main components
   - *during this part, can point out where you can go details*
4. detail design and implements:
   - from every functional requirements
   - add non-functional requirements parts
   - what services
   - what cache
   - what data schema
   - what db to use
5. test and review the system, trade off consideration
   - scalability
   - reliability/disaster recovery
   - performance: data, cache, network
   - security
   - mantainance and imprve
   - devops, monitoring and alarm, log
   - cost


*what is  API design?*
- software components communication parts
- like CLI(to system), OOP methods, http methods
- Web servers are just APIs
- RESTAPI is a way of HTTP


*Networks basic*

HTTP = basic WWW web

- *layers*
- Link layer: local
- Internet layer: where to send
- Transport layer: how (TCP/UDP) to send
- Application layer: what to send

- *Ports and Protocols*
- port is a communication endpoint: inbound and outbound
- SFTP/SSH, all 22 port
- DHCP: 67, 68 port，is UDP connection
- HTTP: 80, basic / HTTPS: 443 port
- POP3: receive mail, 110 port
- *TCP*：ssh，http，https
- *Remote access servers*: Telnet23(不安全，发送的是纯文本), ssh22, RDP(远程桌面)


### migration model

- application, data, workloads
- on-pre or clouds to clouds
- smooth, cost-effective and secure

**framework**

- *access&plan*
  - business objective
  - current infra accessment
    * env: software, hardware, applications, database, network
    * dependencies
    * determine cloud-ready applications
  - workload analysis: from the easy part and base on the dependency
  - cost
  - risk: downtime, data loss, security
- *define strategy*
  - lift and shift(rehosting)
  - re-platform: ex move to managed database
  - re-factoring: redesign apps to microservices, serverless and containerization for cloud-native
  - re-purchasing: move to a SaaS solution
  - retiring: without migration, just abandon some parts by accessment
  - retaining: just keep some apps and data on-premise if necessary
- *design and architecture*
  - cloud-native redesign: microservices, autoscaling, managed databases, serverless architecture and high-availability features
  - network: vpc, subnets, route, firewall, vpn
  - security: iam roles, data encryption, ddos protection
  - data migration
  - disaster recovery and backup
- *execute migration*
  - pilot project prototype test
  - data migration use cloud services(database, storage)
  - application migration: break apps into microservices like container, k8s, functions
  - move securely: on trusted network or utilizes encryption
  - test and validation
- *Optimization & tuning & monitoring*
  - cost optimization
  - performance tuning:
    * database sql optimization
    * autoscaling
    * application cache
  - security tuning
    * config
    * patch
    * data protection
    * PII date scan
  - monitoring and alart implementation


### devsecops model

- plan and design: determine the rule for the team
- build and integrate CI/CD pipeline
- IaC
- security: secrets management, rbac, scan(env&vulnerabilities)
- monitoring and improvement

### cloud native model

1. Containers
   - Docker
   - Kubernetes

2. Service Mesh
   - Istio

3. Function as a Service (FaaS)
   - AWS Lambda
   - Google Cloud Functions: break down to small functions, use queue or api

4. Storage Solutions
   - Object Storage (e.g., Amazon S3, Google Cloud Storage)
   - Block Storage (e.g., Amazon EBS, Google Persistent Disks)
   - File Storage (e.g., Amazon EFS, Azure Files)

5. Databases
   - NoSQL Databases (e.g., MongoDB, Cassandra, DynamoDB)
   - SQL Databases (e.g., PostgreSQL, MySQL, Cloud Spanner)
   - Time Series Databases
   - DWH

6. Messaging Systems
   - Apache Kafka
   - Google Pub/Sub

7. CI/CD Tools
   - Jenkins
   - GitHub Actions
   - Argo CD

8. Monitoring and Observability
   - Prometheus & Grafana
   - Logging

9. Networking Components
   - Load Balancers (e.g., AWS ELB, Google Cloud Load Balancing)
   - DNS Services (e.g., Amazon Route 53, Google Cloud DNS)
   - Virtual Private Cloud (VPC)

9. Security Services
   - Identity and Access Management (IAM)
   - Secrets Management (e.g., HashiCorp Vault, AWS Secrets Manager)
   - API Security (e.g., OAuth2, OpenID Connect)

10. Serverless Framework
   - AWS SAM (Serverless Application Model)

### distribution system model

1. system design architecture
   - microservices architecture
   - load balancing implementation
   - data replication and sharding
2. consistency
   - choose right consistency model base on needs (CAP)
     - strong consistency
     - eventual consistency
3. reliablity
   - redundency: database, network, servers
   - failover: backup, recovery, dns, load-balancing
   - monitoring and alert
   - retry logic
   - CI/CD pipeline and SLA level goal
   - full TEST and Chaos Engineering
4. scalability
   - horizontal sacling: k8s, docker swarm, orchestration
   - auto-scaling based on cpu&memory
5. security
   - authentication and authorization
   - data encryption / TLS/SSL
   - role base access control
   - network security: VPN, VPCs, firewalls
6. performance optimization
   - caching: client-side, server-side, database / redis, memcached
   - database: sql performance tuning
   - data compression: reduce network load and storage needs
   - rate limiting
   - asynchronous processing: pub/sub, kafka


### kubenetes operation model

**components**

1. master
   - kube-api-server: expose point
   - etcd: key-value datastore，存储k8s的组件的元数据，status info
   - controller manager: manage the state
   - scheduler: distribute pod to node，是一个pods管理员
   - master node是关键组件，最好具有冗余备份和多node架构
2. workers
   - kubelet: manage pod
   - kube-proxy: manage communication between pod
   - container runtime: container env
3. components
   - **pod** -> *是container的抽象*，smallest application unit is usually the case 但是没有固定ip
     - 识别方法：selector
   - **service**/namespace: 用于组件*交流*！microservice architecture
     - 有*固定ip*是应用的入口ingress，即使pod被换掉，service不变，一个service可以有很多nodes(pods)，它可以作为一个*load balancer*存在
     - 在云服务商中，经常通过他们的LB（是nodePort的扩展功能）服务直接和service沟通，或者也可以用NGINX的LB功能
   - **ingress**: route traffic into cluster
   - **deployment**：是一种蓝图blueprint，定义一个service中要部署多少pod的replica之类的信息
   - **configmap**：应用程序的external的配置文件，比如db的url，username，password之类的，没必要修改整个app程序，它和secret文件一样都是一种配置，可以被development引用
   - **volume**：存储数据，不会随着db的重启而消失，可是以local的disk也可以是remote的云存储
   - **statefullset**：数据库这种组件无法立刻复制，因为要针对一个基组数据库保持数据一致，相对的，deployment是针对stateless的应用的，但是一般不在cluster中host数据库
4. network
   - between cluster will be a challenge
   - clients -> pods:
     - way1: api call to k8s API server to list all the pods
     - way2: DNS lookup to get the right pods
5. monitoring
   - prometheus
   - grafana dashboard
6. deploy strategy
   - rolling
   - canary
   - blue/green


- k8s really like a terraform Iac, in fact I think it is. code is in container image file and k8s deploy and manage them

7. 微服务构架的注意点：
- retry机制，指数退避等，不然会阻塞网络流量
- dependency治理，失败连锁反应，一个服务失败，会导致所有的dependency服务失败，就像dag
- Death Spiral导致的连锁server启动也无法防止CPU，RAM过载
- Predictive / Reactivate 的auto scaling机制非常重要


### system design thinking model

**pre research**

1. define the problem or goal, why we need the system
   - requirements：告诉系统应该做什么
   - constraints：告诉系统不应该做什么
   - *make a system working is more important than scaling*
   - 提出和框定最重要的非功能性要求，应对大量users，requests，data
2. functional
   - 分条设计功能，和数据schema
   - data search, storage, report, reduce cost, migration, new feature
   - 以每一个主体和功能为线索，将乐高组件拼接起来比如分别按get，put，post等功能走一次 flow
3. non-functional (this part! all system very likely)
   - *reliablity/availablity: when error and disaster happened*
     * fault tolerance
     * recovery & backup
     * retry strategy, every time have the same result
   - *scalability: when user inceasing*
     * horizontal
     * vertical
   - *security: data(store and transfer), people, system*
     * user auth and access
     * data protection
     * role base access control
     * pena test for security protection
     * monitoring and alart
   - *performance: think about all the parts of the system*
     * network: throughput, latency
     * load balancing
     * db query performance
     * job queue and messaging
     * use cache
4. trade-off consideration
5. monitoring, mantainance, devops, improve, easy to migration, modification

- *案例类型*：社交网络，聊天系统，视频网站，文件分布式存储系统
- 在开始的时候限定讨论的scope，以及是否要完全考虑cost，time，developer的skill stack，不完全考虑的情况，则在谈论中尽量优化这部分内容
  - cost：使用cache，CDN，GraphQL协议等降低通信成本，存储tier，等降低存储成本
  - time&skill：使用devops缩减SDLC，提高部署效率和正确度

- 针对前端user需要实现的*功能*，设计 API，API可以将 server 分开，使用集群，同时加入限流功能，想象作为一个用户使用该服务的场景
- 针对前端设计的*objects*，设计数据库 schema 元素和表

- *数据库*设计中可以用RDB作为metadata数据库，然后用NoSql数据库作为数据存储库
- *数据库*设计最重要的讨论是CAP，数据一致性和可用性讨论

- 降低*Latency*手法：cache，CDN，database read replica

- *测试*：设计完整个构架后，记得回头查看需求是否实现了


**architecture design**

0. 所有的组件都是services（一堆processes的集合）
1. components diagram -> skill stack -> divide them into model
   - frontend
   - backend
   - database
   - network
   - api and integration
2. data design -> table or json -> storage -> data flow
3. security design -> people(auth,access) / system(firewall,ddos,config,humanMiss) / data(transfer,storage,encryption) / timeline(log,monitering,alarting)
4. devops design
   - develop: IaC, modeling, refactoring
   - test system
   - code review
   - deploy strategy
   - monitoring and alart
5. documentation and logging
6. user feedback and improve


### culture building

- always be open to speak out opinion
- improve code and system
- backup whenever necessary
- security is the most important
- logs and monitoring

### problem solving model

1. define the problem
   - clarify the issue: Example: Instead of saying "Our system is too slow," define it as "The response time of our website has increased from 1 second to 5 seconds over the past week."
   - determine the scope, boundaries, edge case
   - identify stakeholders
   - prioritize, severity, urgency and potential impact
2. analyze the problem
   - gather data
   - identify root causes
   - understand constraints: time, budget, techical limitations
3. develop possible solutions
   - brainstorm solutions
   - pro and con
   - cost, time, resource and potential impact
4. select the solution
   - choose the most viable option
5. implement the solution
   - action plan, write down the steps
   - communication with stackholders
   - monitoring the execution
   - allocate the resource
6. test and validate the result
7. refine and adjust the solution, continuous improvement
8. documentation

### trouble shooting examples

- **六步故障排除法TroubleShoting**：
  1. *Identify the problem*：查看问题，查看最近针对相关组件发生的变化，进行总结
     - simple is best: check the log and google!
     - hardware or software: cpu, disk, memory, i/o, network, code logic
     - timeline: any change? internal/external, users incresing?
     - scope: client/externel/cloud-internal
     - data life cycle: client -> DNS -> router -> internet -> firewall -> server -> database, use test data to test part of the system
     - security issue? big problem, seek for help
  2. *Establish a theory of probable cause*：列出显而易见的原因列表然后排查，包括阅读日志，谷歌其他人的经验，以及进行内部外部，软件硬件各个方面的问题原因排查
  3. *Test the theroy to determine the cause*：如何测试原因，控制变量法就很不错
  4. *Establish a plan of action to resolve the problem and implement the solution*：比如更换有问题的组件，重新锁定问题根源，寻找更好的解决方案，设定方式，或者best practice，持续观察结果
  5. *Verify full system functionality*：查看整个系统是否有影响，如果在这个阶段就找到将问题完全解决的方法，长久对应则最好
  6. *Document the findings，actions and outcome*
