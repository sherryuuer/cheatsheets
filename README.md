# cheatsheets

ztm cheatsheet:

https://zerotomastery.io/cheatsheets/


# algorithm

### 1. **数组与字符串**

- **查找重复元素**：使用哈希表来存储元素并检测是否重复。常见题：`Contains Duplicate`。
- **滑动窗口**：用于处理子数组或子字符串的连续元素问题，尤其是涉及最大/最小长度或总和等。常见题：`Longest Substring Without Repeating Characters`、`Max Sum of Subarray of Size K`。
- **前缀和**：解决累积和问题，比如在固定范围内求和。常见题：`Subarray Sum Equals K`。

### 2. **哈希表**

- **查找与存储**：用于快速查找、计数和映射关系。典型题：`Two Sum`、`Group Anagrams`。
- **查找频率**：用于统计元素的频次，适合找 Top K 等问题。结合 `heap` 或 `bucket` 排序。常见题：`Top K Frequent Elements`、`Word Frequency`。

### 3. **栈与队列**

- **括号匹配**：用栈来检查有效的括号序列。常见题：`Valid Parentheses`。
- **单调栈**：适合处理下一个更大/更小元素的查找问题。常见题：`Next Greater Element`。
- **BFS**：用于遍历树或图的层级结构，适合最短路径、最近距离类问题。典型题：`Minimum Depth of Binary Tree`、`Shortest Path in Binary Maze`。
- **队列**：常用于处理滑动窗口问题，如最大/最小值查找。常见题：`Sliding Window Maximum`。

### 4. **链表**

- **反转链表**：使用指针迭代或递归反转链表。常见题：`Reverse Linked List`。
- **快慢指针**：查找链表的中点、检测环路。常见题：`Linked List Cycle`、`Middle of the Linked List`。
- **合并链表**：适用于有序链表的合并问题，通常使用优先级队列（小顶堆）。常见题：`Merge K Sorted Lists`。

### 5. **树与图**

- **DFS 和 BFS**：用于树和图的遍历，解决路径、连通性和分区问题。常见题：`Binary Tree Inorder Traversal`、`Number of Islands`。
- **二叉搜索树（BST）**：适合排序数据的快速插入、删除和查找。常见题：`Validate Binary Search Tree`、`Kth Smallest Element in a BST`。
- **最短路径算法**：
  - **Dijkstra**：用于加权图的单源最短路径，适合无负权重的图。
  - **Bellman-Ford**：用于加权图的单源最短路径，可处理负权重边。
  - **Floyd-Warshall**：用于加权图的多源最短路径。

### 6. **堆（优先队列）**

- **Top K 类问题**：用于找出最大/最小的 K 个元素，适合频次统计问题。常见题：`Top K Frequent Elements`、`Kth Largest Element in an Array`。
- **合并排序的流数据**：比如合并多个有序数组。常见题：`Merge K Sorted Lists`。

### 7. **动态规划**

- **子序列问题**：如最大递增子序列（LIS），适合带状态转移的最优解问题。常见题：`Longest Increasing Subsequence`。
- **背包问题**：典型的最优子结构问题，适合处理有限资源最大化。常见题：`Knapsack`。
- **路径规划**：如在网格上求最短路径、最大路径。常见题：`Unique Paths`、`Minimum Path Sum`。
- **字符串比较**：如编辑距离、最长公共子序列。常见题：`Edit Distance`、`Longest Common Subsequence`。

### 8. **双指针**

- **左右指针**：适合有序数组的查找问题。常见题：`Two Sum II - Input array is sorted`、`Container With Most Water`。
- **快慢指针**：用于环检测和中点查找。常见题：`Linked List Cycle Detection`、`Remove Duplicates from Sorted Array`。

### 9. **排序、拓扑排序和二分查找**

- **基础排序**：
  - **快速排序（Quick Sort）**：适合对大多数数组进行原地排序，平均时间复杂度为 **O(n log n)**。
  - **归并排序（Merge Sort）**：适合处理链表或需要稳定排序的情况，复杂度为 **O(n log n)**。
  - **计数排序、基数排序**：适合整数范围较小、需要线性时间的排序。
  - **用例**：任何需要将数据按顺序排列的情况，如`Sort an Array`、`Largest Number`、`Meeting Rooms II`。

- **二分查找**：
  - **在有序数组中查找目标值**：经典的 **O(log n)** 时间复杂度搜索算法，适合需要快速定位数据的位置。
  - **变体**：查找目标的最左/最右位置，查找满足某一条件的最小/最大值。
  - **用例**：`Binary Search`、`Find First and Last Position of Element in Sorted Array`、`Median of Two Sorted Arrays`。
  - **二分查找的应用场景**：如在峰值、旋转排序数组中查找某值，或进行满足条件的最优值查找等。

- **拓扑排序**：
  - **定义**：拓扑排序用于有向无环图（DAG），用于确定任务的依赖顺序。
  - **算法**：使用 Kahn’s Algorithm（基于 BFS）或 DFS 进行拓扑排序。
  - **用例**：任务调度问题、编译依赖问题等。常见题：`Course Schedule`、`Alien Dictionary`。
