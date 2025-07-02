class impAdjacencyMatrix{
    public static void main(String[] args) {
        int [] [] edgeList={
            {1,2},
            {2,3},
            {3,4},
            {4,2},
            {1,3}
        };
        int n = 5;
        int AM[][] = new int [n][n];
        for(int []edge : edgeList){
            int a = edge[0];
            int b = edge[1];
            AM[a][b] = 1;
            AM[b][a] = 1;
        }
        printGraph(AM);
    }
    static void printGraph(int  [][]matrix){
        for(int i = 1;i <= 4;i++){
            System.out.print("Node : " + i + " Links : ");
            for(int j = 1;j <= 4;j++){
                if(matrix[i][j] == 1)
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}