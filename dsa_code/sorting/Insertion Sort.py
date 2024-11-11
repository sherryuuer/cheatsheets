# 最坏的情况，完全倒置，是n方复杂度，最好的情况只有线性时间
def insertionSort(arr):
    for i in range(1, len(arr)):
        j = i - 1
        while j >= 0 and arr[j + 1] < arr[j]:
            arr[j + 1], arr[j] = arr[j], arr[j + 1]
            j -= 1
    return arr


# Definition for a pair.
# class Pair:
#     def __init__(self, key: int, value: str):
#         self.key = key
#         self.value = value
class Solution:
    # Implementation of Insertion Sort
    def insertionSort(self, pairs):
        n = len(pairs)
        res = []  # To store the intermediate states of the array

        for i in range(n):
            j = i - 1

            # Move elements that are greater than key one position ahead
            while j >= 0 and pairs[j].key > pairs[j + 1].key:
                pairs[j], pairs[j + 1] = pairs[j + 1], pairs[j]
                j -= 1

            # Clone and save the entire state of the array at this point
            res.append(pairs[:])

        return res
