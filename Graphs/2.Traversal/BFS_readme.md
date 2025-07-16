
# 🔍 BFS Traversal in Java — Graph.getOrDefault Explained

## What is `graph.getOrDefault(topNode, new ArrayList<>())`?

This method is used to safely fetch the neighbors of a node in the graph during BFS traversal.

### ✅ Behavior:
```java
graph.getOrDefault(topNode, new ArrayList<>())

	•	If graph contains topNode as a key:
→ Returns the corresponding adjacency list (i.e., its neighbors).
	•	If not:
→ Returns an empty list to avoid NullPointerException.

⸻

⚠️ Why It’s Important

Using just:

for (int nbr : graph.get(topNode))

can crash your program with a NullPointerException if topNode has no entry in the graph map.

Example:

If the graph contains only:

edges = { {0, 1}, {1, 2} }

and you try:

bfs(3, graph, n); // Node 3 is disconnected

Then:

graph.get(3); // returns null → ❌ NullPointerException


⸻

✅ Safe Alternative

Using getOrDefault:

for (int nbr : graph.getOrDefault(topNode, new ArrayList<>())) {
    // Process neighbors safely
}

ensures that even if topNode is not in the graph (i.e., has no edges), the BFS doesn’t break — it just skips that node’s neighbors.

⸻

🧠 TL;DR

graph.getOrDefault(topNode, new ArrayList<>()) is a defensive programming practice that:
	•	Prevents runtime errors,
	•	Makes your BFS implementation robust,
	•	Handles disconnected or isolated nodes gracefully.

```java
import java.util.*;

class BFS {
    public static void main(String[] args) {
        List<int[]> edgeList = Arrays.asList(
            new int[]{0, 1},
            new int[]{1, 4},
            new int[]{1, 2},
            new int[]{2, 3}
        );
        int n = 5;
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Undirected graph construction
        for (int[] edge : edgeList) {
            int a = edge[0];
            int b = edge[1];
            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        bfs(0, graph, n);
    }

    static void bfs(int src, Map<Integer, List<Integer>> graph, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.offer(src);
        visited[src] = true; // Fix added here

        while (!q.isEmpty()) {
            int topNode = q.poll();
            System.out.print(topNode + " ");
            for (int nbr : graph.getOrDefault(topNode, new ArrayList<>())) {
                if (!visited[nbr]) {
                    q.offer(nbr);
                    visited[nbr] = true;
                }
            }
        }
    }
}