# Way1 without class
def quickSort(arr, start, end):
    if end - start + 1 <= 1:
        return

    pivot = arr[end]
    left = start

    for i in range(start, end):
        if arr[i] < pivot:
            arr[left], arr[i] = arr[i], arr[left]
            left += 1

    arr[end] = arr[left]
    arr[left] = pivot

    quickSort(arr, start, left - 1)
    quickSort(arr, left + 1, end)

    return arr


# Way 2
# Input:
pairs = [(3, "cat"), (2, "dog"), (3, "bird")]

# Output:
# [(2, "dog"), (3, "bird"), (3, "cat")]

# Definition for a pair.


class Pair:
    def __init__(self, key: int, value: str):
        self.key = key
        self.value = value


class Solution:
    def quickSort(self, pairs: list[Pair]) -> list[Pair]:
        n = len(pairs)
        if n <= 0:
            return pairs
        pivot = pairs[-1]
        left = 0
        for i in range(n - 1):
            if pairs[i].key < pivot.key:
                tmp = pairs[left]
                pairs[left] = pairs[i]
                pairs[i] = tmp
                left += 1
        pairs[-1] = pairs[left]
        pairs[left] = pivot

        return self.quickSort(pairs[:left]) + [pivot] + self.quickSort(pairs[left + 1:])

# Another way
# Definition for a pair.
# class Pair:
#     def __init__(self, key: int, value: str):
#         self.key = key
#         self.value = value


class Solution:
    # Implementation of Quick Sort
    def quickSort(self, pairs: List[Pair]) -> List[Pair]:
        self.quickSortHelper(pairs, 0, len(pairs) - 1)
        return pairs

    def quickSortHelper(self, arr: List[Pair], s: int, e: int) -> None:
        if e - s + 1 <= 1:
            return

        pivot = arr[e]  # pivot is the last element
        left = s  # pointer for left side

        # Partition: elements smaller than pivot on left side
        for i in range(s, e):
            if arr[i].key < pivot.key:
                tmp = arr[left]
                arr[left] = arr[i]
                arr[i] = tmp
                left += 1

        # Move pivot in-between left & right sides
        arr[e] = arr[left]
        arr[left] = pivot

        # Quick sort left side
        self.quickSortHelper(arr, s, left - 1)

        # Quick sort right side
        self.quickSortHelper(arr, left + 1, e)
