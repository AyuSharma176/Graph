package Algos;

import java.util.*;
public class Dijkstra_algo {
    private HashMap<Integer,HashMap<Integer,Integer>> map;

    public Dijkstra_algo(int v) {
        map = new HashMap<>();
        for (int i = 1; i <=v; i++) {
            map.put(i, new HashMap<>());
        }
    }
    public void addEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);

        map.get(v2).put(v1, cost);
    }
    public void Dijkstra(int src) {
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<Dijkstrapair> pq = new PriorityQueue<>(new Comparator<Dijkstrapair>() {

            @Override
            public int compare(Dijkstrapair t1, Dijkstrapair t2) {
                return t1.cost-t2.cost;
            }
        });
        pq.add(new Dijkstrapair(src,""+src,0));
        while (!pq.isEmpty()) {
            Dijkstrapair rp = pq.poll();
            if(visited.contains(rp.vtx)){
                continue;
            }
            visited.add(rp.vtx);
            System.out.println(rp);
            for(int nbrs:map.get(rp.vtx).keySet()){
                if(!visited.contains(nbrs)){
                    int cost=rp.cost+map.get(rp.vtx).get(nbrs);
                    Dijkstrapair np = new Dijkstrapair(nbrs,rp.acq+nbrs,cost);
                    pq.add(np);
                }
            }
        }
    }
    static class Dijkstrapair{
        int vtx;
        String acq;
        int cost;
        public Dijkstrapair(int vtx, String acq, int cost) {
            this.vtx = vtx;
            this.acq = acq;
            this.cost = cost;
        }
        @Override
        public String toString(){
            return this.vtx+": "+this.acq+":"+" @: "+this.cost;
        }
    }
    public static void main(String[] args) {
        Dijkstra_algo d = new Dijkstra_algo(7);
        d.addEdge(1, 4, 2);
        d.addEdge(1, 2, 3);
        d.addEdge(2, 3, 5);
        d.addEdge(3, 4, 1);
        d.addEdge(4, 5, 6);
        d.addEdge(5, 6, 11);
        d.addEdge(7, 5, 1);
        d.addEdge(6, 7, 3);
        d.Dijkstra(1);
    }
}
