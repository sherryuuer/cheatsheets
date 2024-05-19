# Way with out pairs class
def mergesort(arr):  # divide  BigO = logn
    if len(arr) == 1:
        return arr
    length = len(arr)
    mid = length // 2
    left = arr[:mid]
    right = arr[mid:]
    return merge(mergesort(left), mergesort(right))  # O(n)


def merge(left, right):  # merge BigO = n
    result = []
    leftindex = 0
    rightindex = 0
    while leftindex < len(left) and rightindex < len(right):
        if left[leftindex] < right[rightindex]:
            result.append(left[leftindex])
            leftindex += 1
        else:
            result.append(right[rightindex])
            rightindex += 1
    return result + left[leftindex:] + right[rightindex:]


# Way with pairs class
# Input:
pairs = [(5, "apple"), (2, "banana"), (9, "cherry"),
         (1, "date"), (9, "elderberry")]

# Output:
# [(1, "date"), (2, "banana"), (5, "apple"), (9, "cherry"), (9, "elderberry")]

# Definition for a pair.


class Pair:
    def __init__(self, key: int, value: str):
        self.key = key
        self.value = value


class Solution:
    def mergeSort(self, pairs: list[Pair]) -> list[Pair]:
        def merge(left, right):
            res = []
            li = 0
            ri = 0
            while li < len(left) and ri < len(right):
                if left[li].key <= right[ri].key:
                    res.append(left[li])
                    li += 1
                else:
                    res.append(right[ri])
                    ri += 1
            return res + left[li:] + right[ri:]

        if len(pairs) <= 1:
            return pairs
        m = len(pairs) // 2
        left = pairs[:m]
        right = pairs[m:]

        return merge(self.mergeSort(left), self.mergeSort(right))


# Another way
# Definition for a pair.
# class Pair:
#     def __init__(self, key: int, value: str):
#         self.key = key
#         self.value = value


class Solution:
    # Implementation of Merge Sort
    def mergeSort(self, pairs: List[Pair]) -> List[Pair]:
        return self.mergeSortHelper(pairs, 0, len(pairs) - 1)

    def mergeSortHelper(self, pairs: List[Pair], s: int, e: int) -> List[Pair]:
        if e - s + 1 <= 1:
            return pairs

        # The middle index of the array
        m = (s + e) // 2

        # Sort the left half
        self.mergeSortHelper(pairs, s, m)

        # Sort the right half
        self.mergeSortHelper(pairs, m + 1, e)

        # Merge sorted halfs
        self.merge(pairs, s, m, e)

        return pairs

    # Merge in-place
    def merge(self, arr: List[Pair], s: int, m: int, e: int) -> None:
        # Copy the sorted left & right halfs to temp arrays
        L = arr[s: m + 1]
        R = arr[m + 1: e + 1]

        i = 0  # index for L
        j = 0  # index for R
        k = s  # index for arr

        # Merge the two sorted halfs into the original array
        while i < len(L) and j < len(R):
            if L[i].key <= R[j].key:
                arr[k] = L[i]
                i += 1
            else:
                arr[k] = R[j]
                j += 1
            k += 1

        # One of the halfs will have elements remaining
        while i < len(L):
            arr[k] = L[i]
            i += 1
            k += 1
        while j < len(R):
            arr[k] = R[j]
            j += 1
            k += 1
