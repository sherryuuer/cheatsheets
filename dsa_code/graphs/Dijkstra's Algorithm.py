import heapq

# Given a connected graph represented by a list of edges, where
# edge[0] = src, edge[1] = dst, and edge[2] = weight,
# find the shortest path from src to every other node in the
# graph. There are n nodes in the graph.
# O(E * logV), O(E * logE) is also correct.


def shortestPath(edges, n, src):
    adj = {}
    for i in range(1, n + 1):
        adj[i] = []

    # s = src, d = dst, w = weight
    for s, d, w in edges:
        adj[s].append([d, w])

    shortest = {}
    minHeap = [[0, src]]
    while minHeap:
        w1, n1 = heapq.heappop(minHeap)
        if n1 in shortest:
            continue
        shortest[n1] = w1

        for n2, w2 in adj[n1]:
            if n2 not in shortest:
                heapq.heappush(minHeap, [w1 + w2, n2])
    return shortest


class Solution:
    def shortestPath(self, n, edges, src):
        adj = {}
        shortest = {}
        import heapq
        for i in range(n):
            adj[i] = []
            # init all the vertex to be -1
            shortest[i] = -1

        for u, v, w in edges:
            adj[u].append([w, v])

        minHeap = [[0, src]]
        while minHeap:
            w1, n1 = heapq.heappop(minHeap)
            if shortest[n1] != -1:
                continue
            shortest[n1] = w1

            for w2, n2 in adj[n1]:
                if shortest[n2] == -1:
                    heapq.heappush(minHeap, [w1 + w2, n2])

        return shortest
