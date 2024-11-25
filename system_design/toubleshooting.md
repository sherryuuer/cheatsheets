
#### ✅ Your marketing manager complains to you that the new company website is slow, what would you do?
- 定义问题：latency
- scope：客户端还是网路问题，或Cloud服务内部问题
- 客户端问题通过质询和分析，时间线上最近是否有系统变化
- 网络问题用nslookup查询DNS解析是否有问题，tracert查询网络jump点是否没有在TTL之内送达packets
- 服务内部问题
  - 通过monitoring和log分析
  - timeline：最近是否有系统更改
  - 硬件：CPU，memory，IO，throughput
  - 软件：code效率低，API之间有通信延迟，LB策略不均衡
  - 数据库：查询效率低，数据结构不合理，cache不中
  - 安全问题：DDoS攻击
- 验证和解决问题
- 寻求长远对策
- documentation

#### ✅ A critical system's data processing job is taking longer than expected. What steps would you take to identify the root cause and improve performance?

- **Understand Job Details and Baseline Performance**:
   - Gather details on the job
   - Check if there have been recent changes

- **Monitor and Profile the System, Examine Log Files and System Alerts**:
   - Use monitoring tools to analyze CPU, memory, disk I/O, and network utilization during the job's execution.
   - Profile the job to identify stages or steps where time is disproportionately high. For distributed environments, check if tasks are skewed to particular nodes.

- **Analyze Data Processing Pipeline**:
   - Identify which part of the pipeline
   - For batch jobs, break down execution time per stage, and for streaming jobs, review lag metrics to see where delays are introduced.

- **Evaluate and Optimize Code Logic**:
   - Review the code to check for any inefficient algorithms or loops that can be optimized.
   - Consider caching intermediate results, reducing redundant computations, or optimizing I/O operations to minimize latency.

- **Optimize Database Queries**:
   - If the job interacts with a database, analyze query performance. Look for expensive queries that could benefit from *indexing, caching, or query rewriting*.
   - Run query plans to see if indexes are being utilized effectively and if there’s scope for optimization.
- **Scale Resources or Tune Configuration**:
   - For distributed processing, assess whether adding more nodes or increasing instance sizes would help.
   - Check for *configuration settings* like batch sizes, parallelism, and memory allocations that might need adjustments.
- **Test with Sample Data**

#### ✅ A distributed application experiences frequent timeouts between services. What might cause these timeouts, and how would you approach resolving them?
1. 查看istio等的日志和系统信息，看是否能立刻解决，然后深入调查
2. 从硬件角度看，是否CPU。Memory不足，网络带宽是否有问题
3. 从软件角度，代码效率是否有问题，是否可以用cache等策略优化代码，查看kubenetes的设置是否有问题，更改重试策略，指数退避，异步通信策略等
4. 时间线角度看最近是否有什么变化，比如客户端流量大增，那么是否可以对系统的扩展上限进行提高，或者用机器学习算法来预测流量
5. 从数据生命线看，是否是下游数据库performance有问题，发生的连锁反应
6. 假定上述理论，然后测试和分析根本原因，首先解决问题，分析影响，消除影响，重新检测系统，进行长久对应方针的讨论，documentation问题和解决过程

#### ✅ An API endpoint is receiving higher-than-expected traffic, causing bottlenecks. How would you assess and mitigate this issue?（和第一个网络问题很类似）
1. 特定问题：网络流量负载过高的问题，影响到的范围是什么，现在的优先级是什么，是否能分配更多的资源来解决这个问题，需要多久来解决
2. 收集信息：日志（Prometheus、CloudWatch），最近的变化，客户端反馈等
3. 分析可能原因并提出假设
   - 硬件：是否需要负载均衡，但是LB出了问题/是否高并发导致CPU，memory不足
   - 软件：API传输中负载过大，代码效率低，返回了不必要的内容吗，重试策略是否有问题
   - timeline：最近用户量大增，用户执行了过多的请求
   - data生命循环：缓存hit率太低，数据库返回了大量数据，数据库效率问题
   - 安全问题：DDos攻击
4. 提出可行性方案，执行最佳方案
5. 检查系统
6. 必要的情况下寻找长远解决方案
7. documentation


#### ✅ Your company’s cloud costs have unexpectedly increased this quarter. How would you identify and address the main contributors to the cost hike?
1. 特定问题（哪里出了问题）
   - cost原因来自哪里：特定cost过高的服务
   - 对利益相关方的影响
   - 制定问题解决的优先度，如果手头有其他问题要解决的时候，要考虑
2. 收集信息（收集日志和系统信息）
3. 查找原因提出假设（根据信息分析问题）
   - 硬件cpu，disk等，软件效率，config问题，重试过多次，网络负载太高
   - timeline上查找最近发生的变化
   - 数据生命线来看，数据库大query是否有，存储上是否出了问题
4. 测试假设，解决问题
5. 重新检查系统
6. 制定长久策略继续优化和documentation：比如制定cost预警，优化系统效率，config上设定scale上限

#### ✅ A batch job fails intermittently in a multi-threaded environment. What are some potential causes, and how would you investigate them?
- 这里的关键词是多线程：
  - 线程等待发生deadlock
  - 竞争资源，CPU，disk不足
  - 线程池配置不合理，过小等
  - 不当的异常处理
