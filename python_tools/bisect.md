`bisect` 是 Python 标准库中的一个模块，提供了二分查找算法的实现。它可以帮助我们在有序列表中快速地找到插入位置、查找元素的位置等操作，非常适合在有序的数据结构中使用。

`bisect` 的主要方法包括：

### 1. `bisect_left(list, item, lo=0, hi=len(list))`
- **功能**：找到 `item` 在 `list` 中可以插入的最左侧位置，使得插入后列表仍然有序。
- **返回值**：插入位置的索引。
- **例子**：

    ```python
    from bisect import bisect_left

    arr = [1, 3, 5, 7]
    print(bisect_left(arr, 5))  # 输出 2，表示插入 5 的最左侧位置是索引 2
    print(bisect_left(arr, 4))  # 输出 2，表示插入 4 的最左侧位置也是索引 2
    ```

### 2. `bisect_right(list, item, lo=0, hi=len(list))`（或 `bisect`）
- **功能**：找到 `item` 在 `list` 中可以插入的最右侧位置，使得插入后列表仍然有序。
- **返回值**：插入位置的索引。
- **例子**：

    ```python
    from bisect import bisect_right

    arr = [1, 3, 5, 7]
    print(bisect_right(arr, 5))  # 输出 3，表示插入 5 的最右侧位置是索引 3
    print(bisect_right(arr, 4))  # 输出 2，表示插入 4 的最右侧位置也是索引 2
    ```

### 使用 `bisect` 查找插入位置的优势
`bisect` 的核心优势是**高效性**。它在 **O(log n)** 时间复杂度下完成查找，适合在排序列表中频繁插入或查找位置的场景。

### 3. 插入操作 `insort_left` 和 `insort_right`
- `insort_left(list, item, lo=0, hi=len(list))`：将 `item` 插入到 `list` 的最左位置，保持列表有序。
- `insort_right(list, item, lo=0, hi=len(list))`：将 `item` 插入到 `list` 的最右位置，保持列表有序。

**例子**：

```python
from bisect import insort_left

arr = [1, 3, 5, 7]
insort_left(arr, 5)
print(arr)  # 输出 [1, 3, 5, 5, 7]
```

### 总结

`bisect` 模块适用于有序列表中的快速查找和插入操作，是实现诸如区间查找、范围管理等问题的利器。
