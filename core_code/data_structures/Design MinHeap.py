# MinHeap Class Implementation
class MinHeap:
    def __init__(self):
        # 如此，第一个元素就是index1上的，后面计算大小比较的时候，计算更方便
        self.heap = [0]  # Initialize heap with a dummy value at index 0

    def push(self, val: int) -> None:
        """Pushes a value onto the heap."""
        self.heap.append(val)
        self._bubble_up(len(self.heap) - 1)

    def pop(self) -> int:
        """Pops the smallest value off the heap."""
        if len(self.heap) <= 1:
            return -1
        if len(self.heap) == 2:
            return self.heap.pop()

        # Move the last element to the root and bubble it down.
        root = self.heap[1]
        self.heap[1] = self.heap.pop()
        self._bubble_down(1)
        return root

    def top(self) -> int:
        """Returns the smallest value without popping it."""
        # 因为index0上是dummy
        return self.heap[1] if len(self.heap) > 1 else -1

    def heapify(self, nums: List[int]) -> None:
        """Transforms a list into a heap in-place."""
        self.heap = [0] + nums
        for i in reversed(range(1, len(self.heap) // 2 + 1)):
            # 这里做bubble down是因为就可以省掉最下面一层的重组，减少一半的时间复杂度
            self._bubble_down(i)

    def _bubble_up(self, index: int) -> None:
        parent = index // 2
        while index > 1 and self.heap[parent] > self.heap[index]:
            self.heap[parent], self.heap[index] = self.heap[index], self.heap[parent]
            index = parent
            parent = index // 2

    def _bubble_down(self, index: int) -> None:
        child = 2 * index  # left child
        while child < len(self.heap):
            if child + 1 < len(self.heap) and self.heap[child] > self.heap[child + 1]:
                child += 1

            if self.heap[child] >= self.heap[index]:
                break

            self.heap[child], self.heap[index] = self.heap[index], self.heap[child]
            index = child
            child = 2 * index  # left child
