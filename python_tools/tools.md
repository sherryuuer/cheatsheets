### 1. **defaultdict**
`defaultdict` 是 `collections` 模块中的字典类，允许为不存在的键提供默认值，避免了访问不存在的键时报错。

```python
from collections import defaultdict

# 创建一个默认值为 list 的 defaultdict
dd = defaultdict(list)
dd['key1'].append(1)  # 若 'key1' 不存在则自动创建
print(dd)  # 输出: {'key1': [1]}
```

### 2. **OrderedDict**
`OrderedDict` 是 `collections` 模块中的字典类，能够记住元素的插入顺序。尽管从 Python 3.7 开始普通字典也支持顺序，但 `OrderedDict` 仍提供一些特定的功能。

```python
from collections import OrderedDict

od = OrderedDict()
od['a'] = 1
od['b'] = 2
print(od)  # 输出: OrderedDict([('a', 1), ('b', 2)])
```

### 3. **Counter**
`Counter` 是 `collections` 模块中的类，用于计数对象的频率，特别适合统计字符、词频等。

```python
from collections import Counter

# 统计字符频率
cnt = Counter('abracadabra')
print(cnt)  # 输出: Counter({'a': 5, 'b': 2, 'r': 2, 'c': 1, 'd': 1})
```

### 4. **deque**
`deque` 是 `collections` 模块中的双端队列，支持在两端高效地添加和删除元素。

```python
from collections import deque

dq = deque([1, 2, 3])
dq.appendleft(0)
dq.append(4)
print(dq)  # 输出: deque([0, 1, 2, 3, 4])
dq.pop()    # 从右侧弹出
dq.popleft()  # 从左侧弹出
```

### 5. **bisect**
`bisect` 用于保持列表的有序性，提供二分查找功能来高效插入元素。

```python
import bisect

arr = [1, 2, 4, 5]
bisect.insort(arr, 3)  # 按顺序插入 3
print(arr)  # 输出: [1, 2, 3, 4, 5]
```

### 6. **heap**
`heapq` 模块用于创建一个最小堆（优先队列）。在 Python 中可以使用 `heapq` 的函数来维护堆结构。

```python
import heapq

nums = [1, 3, 5, 7, 9, 2, 4, 6, 8, 0]
heapq.heapify(nums)
print(nums)  # 转为最小堆, 输出: [0, 1, 2, 3, ...]

# 获取最小元素
min_element = heapq.heappop(nums)
print(min_element)  # 输出: 0
```

### 7. **map/reduce**
- `map` 用于将函数应用于序列的每个元素并返回一个迭代器。
- `reduce` 在 `functools` 模块中，用于将函数累积应用于序列。

```python
# map 示例：将每个元素乘以 2
nums = [1, 2, 3, 4]
print(list(map(lambda x: x * 2, nums)))  # 输出: [2, 4, 6, 8]

# reduce 示例：求和
from functools import reduce
result = reduce(lambda x, y: x + y, nums)
print(result)  # 输出: 10
```

### 8. **内包 (comprehension) 表记**
内包表达式提供一种简洁的方式创建列表、集合或字典。

```python
# 列表内包
squares = [x ** 2 for x in range(5)]
print(squares)  # 输出: [0, 1, 4, 9, 16]

# 字典内包
square_dict = {x: x ** 2 for x in range(5)}
print(square_dict)  # 输出: {0: 0, 1: 1, 2: 4, 3: 9, 4: 16}
```

### 9. **lambda 表达式**
`lambda` 是创建匿名函数的一种方式，常用于排序的 `key` 参数中。

```python
# 根据字符串长度排序
words = ['apple', 'banana', 'cherry']
sorted_words = sorted(words, key=lambda x: len(x))
print(sorted_words)  # 输出: ['apple', 'cherry', 'banana']
```

### 10. **with 表记**
`with` 语句用于上下文管理，通常用于确保资源在使用完后自动释放，比如文件读写时自动关闭文件。

```python
# 自动关闭文件
with open('file.txt', 'w') as f:
    f.write("Hello, world!")
# 离开 with 块后文件会自动关闭
```
