# from 0 to n - 1
# return all the vertex
class Solution:
    def topologicalSort(self, n: int, edges: List[List[int]]) -> List[int]:
        adj = defaultdict(list)
        for src, dst in edges:
            adj[src].append(dst)

        topSort = []
        visited = set()  # Visited nodes
        visiting = set()  # Nodes being visited in the current call (for detecting cycles)

        def dfs(src):
            if src in visited:
                return True
            if src in visiting:
                return False  # Cycle detected

            visiting.add(src)
            for neighbor in adj[src]:
                if not dfs(neighbor):
                    return False  # Cycle detected

            visiting.remove(src)
            visited.add(src)
            topSort.append(src)

            return True

        for i in range(n):
            if not dfs(i):
                return []  # Return an empty list if cycle detected

        topSort.reverse()
        return topSort
