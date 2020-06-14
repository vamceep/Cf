public class BipertideGraph {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        Djs[] s = new Djs[v];
        
        for(int i = 0; i < v; i++) {
            s[i] = new Djs(i);
        }
        
        for(int i = 0; i < v; i++) {
            Djs s1 = s[i].findRoot();
            Djs s2 = null;
            
            for(int j = 0; j < graph[i].length; j++) {
                int v2 = graph[i][j];
                if(j == 0) s2 = s[v2].findRoot();
                else {
                    s2.union(s[v2]);
                    s2 = s2.findRoot();
                }
                s1 = s1.findRoot();
                if(s1 == s2) {
                    return false;
                }
            }
        }
        return true;
    }
    
    class Djs {
        Djs parent;
        int data;
        int rank;
        
        public Djs(int i) {
            data = i;
            parent = this;
            rank = 0;
        }
        
        public Djs findRoot() {
            if(parent == this) return this;
            Djs par = parent.findRoot();
            parent = par;
            return par;
        }
        
        public boolean union(Djs j) {
            j = j.findRoot();
            if(parent == j) return false;
            
            if(rank < j.rank) parent = j;
            else j.parent = this;

            if(j.rank == rank)
                rank++;
            return true;
        }
    }
    public boolean isBipertideDFS(int[][] graph) {  
        int[] col = new int[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(col[i] == 0)
            if(!dfs(col, 1, graph, i))return false;
        }
        return true;
    }

    private boolean dfs(int[] v, int col, int[][] g, int i) {
        if(v[i] != 0) {
            if(v[i] != col) return false;
        }
        v[i] = col;
        for(int j = 0; j < g[i].length; j++) {
            if(!dfs(v, 3-col, g, g[i][j]))
                return false;
        }
        return true;
    }

}