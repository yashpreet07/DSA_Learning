import java.util.*;
class impAdjacencyList{
    public static void main(String[] args) {
        int [][] edgeList = {
            {1,2},
            {2,3},
            {3,4},
            {4,2},
            {1,3}
        };
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int[] edge : edgeList){
            int a = edge[0];
            int b = edge[1];
            graph.computeIfAbsent(a,k -> new ArrayList<>()).add(b);
            // Since undirected graph.
            graph.computeIfAbsent(b,k -> new ArrayList<>()).add(a);


            /*
             * Older Syntax to the above for a 
            * if (!graph.containsKey(a)) {
                graph.put(a, new ArrayList<>());
                }
                graph.get(a).add(b);
                then same for b.
             */
        }
        printGraph(graph);
    }
    static void printGraph(Map<Integer, List<Integer>> graph) {
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            System.out.print("Node: " + entry.getKey() + ", Neighbors: ");
            for (int neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}