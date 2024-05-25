from collections import deque

# Matrix (2D grid)
grid = [[0, 0, 0, 0],
        [1, 1, 0, 0],
        [0, 0, 0, 1],
        [0, 1, 0, 0]]


# Shortest path from top left to bottom right
def bfs(grid):
    ROWS, COLS = len(grid), len(grid[0])
    length = 0
    queue = deque()
    queue.append((0, 0))
    visit = set()
    visit.add((0, 0))

    while queue:
        for i in range(len(queue)):
            r, c = queue.popleft()
            if r == ROWS - 1 and c == COLS - 1:
                return length

            steps = [[0, 1], [1, 0], [-1, 0], [0, -1]]
            for sr, sc in steps:
                if min(r + sr, c + sc) < 0 or r + sr == ROWS or c + sc == COLS or (r + sr, c + sc) in visit or grid[r + sr][c + sc] == 1:
                    continue
                queue.append((r + sr, c + sc))
                visit.add((r + sr, c + sc))
        length += 1


print(bfs(grid))


####
# Time & Space : O(N*M)
class Solution:
    def shortestPath(self, grid: List[List[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        visit = set()
        queue = deque()
        queue.append((0, 0))
        visit.add((0, 0))

        length = 0
        while queue:
            for i in range(len(queue)):
                r, c = queue.popleft()
                if r == ROWS - 1 and c == COLS - 1:
                    return length

                neighbors = [[0, 1], [0, -1], [1, 0], [-1, 0]]
                for dr, dc in neighbors:
                    if (min(r + dr, c + dc) < 0 or
                        r + dr == ROWS or c + dc == COLS or
                            (r + dr, c + dc) in visit or grid[r + dr][c + dc] == 1):
                        continue
                    # This 2 line is very important, add to visit set let us not duplicate the path
                    queue.append((r + dr, c + dc))
                    visit.add((r + dr, c + dc))
            length += 1
        return -1
