package Ques;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public static void main(String[] args) {
        int[][] graph= {{1,2,3},{0,2},{0,1,3},{0,2}};
        HashMap<Integer,Integer> visited=new HashMap<>();
        Queue<Bipartitepair> q=new LinkedList<>();
        for(int v=0;v<graph.length;v++) {
            if(visited.containsKey(v)){
                continue;
            }
            q.add(new Bipartitepair(v,0));
            while (!q.isEmpty()) {
                //1 remove
                Bipartitepair rv = q.poll();
                //2 ignore
                if (visited.containsKey(rv.vtx)) {
                    if(visited.get(rv.vtx)!=rv.distance) {
                        System.out.println("Not Bipartite");
                        return;
                    }
                    else{
                        continue;
                    }
                }
                //3 marked visited
                visited.put(rv.vtx,rv.distance);
                //4 self work
//                    System.out.print(rv + " ");
                for (int nbrs : graph[rv.vtx]) {
                    if (!visited.containsKey(nbrs)) {
                        Bipartitepair np = new Bipartitepair(nbrs,rv.distance+1);
                        q.add(np);
                    }
                }
            }
        }
        System.out.println("Bipartite");
    }
    static class Bipartitepair{
        int vtx;
        int distance;
        public Bipartitepair(int vtx, int distance) {
            this.vtx = vtx;
            this.distance = distance;
        }
    }
}
