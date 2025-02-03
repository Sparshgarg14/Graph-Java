class Solution {
    public boolean dfs(int node,HashMap<Integer, List<Integer>>adj, int vis[]){
        vis[node] = 1;
        for(int nbrs:adj.get(node)){
            if(vis[nbrs]==1)return true;
            else if( vis[nbrs]==0 && dfs(nbrs, adj, vis))return true;
            
        }
        vis[node]=2;
        return false;
    } 
    public boolean canFinish(int numcourses, int[][] pre) {
        int n  =pre.length;
        HashMap<Integer, List<Integer>>adj  = new HashMap<>();
        for(int i =0;i<numcourses;i++){
            adj.put(i, new ArrayList<>());
            }
        for(int i =0;i<n;i++){
            int u = pre[i][0];
            int v = pre[i][1];
            adj.get(v).add(u);
        }
        // System.out.println(adj);
        int vis[] = new int[numcourses];
       
       for(int i =0;i<numcourses;i++){
        if(vis[i]==0){
            if(dfs(i, adj,vis))return false;
        }
       
       
    }
     return true;
}
}