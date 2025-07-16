import  java.util.*;
class DFS{
    public static void main(String[] args) {
        List<int []> edgeList = Arrays.asList(
        new int[] {0,1},
        new int[] {1,4},
        new int[] {1,2},
        new int[] {2,3}
        );
        int n = 5;
        Map<Integer,List<Integer>> graph = new HashMap<>();
        boolean visted[] = new boolean[n + 1];
        // Undirected graph construction
        for(int []edge : edgeList){
            int a = edge[0];
            int b = edge[1];
            graph.computeIfAbsent(a,k->new ArrayList<>()).add(b);
            graph.computeIfAbsent(b,k->new ArrayList<>()).add(a);
        }

        dfs(0,graph,visted);

    }

    static void dfs(int src,Map<Integer,List<Integer>> graph,boolean []visted){
        int node = src;
        System.out.print(node + " ");
        visted[node] = true;
        for(int ngr : graph.get(node)){
            if(!visted[ngr]){
                dfs(ngr,graph,visted);
            }
        }
    }
}
