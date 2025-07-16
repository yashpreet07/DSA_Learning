import  java.util.*;
class BFS{
    public static void main(String[] args) {
        List<int []> edgeList = Arrays.asList(
        new int[] {0,1},
        new int[] {1,4},
        new int[] {1,2},
        new int[] {2,3}
        );
        int n = 5;
        Map<Integer,List<Integer>> graph = new HashMap<>();

        // Undirected graph construction
        for(int []edge : edgeList){
            int a = edge[0];
            int b = edge[1];
            graph.computeIfAbsent(a,k->new ArrayList<>()).add(b);
            graph.computeIfAbsent(b,k->new ArrayList<>()).add(a);
        }

        bfs(0,graph,n);

    }

    static void bfs(int src,Map<Integer,List<Integer>> graph,int n){
        Queue<Integer> q = new LinkedList<>();
        boolean visted[] = new boolean[n + 1];
        q.offer(src);
        visted[src] = true;  // You missed this line its important otherwise Wrong Answer!!
        while(!q.isEmpty()){
            int topNode = q.poll();
            System.out.println(topNode + " ");
            for(int nbr : graph.get(topNode)){ // See the readme_File
                if(!visted[nbr]){
                    q.offer(nbr);
                    visted[nbr] = true;
                }
            }
        }
    }
}

