package Algos;
import java.util.*;
public class Prims_Algo {
    HashMap<Integer, HashMap<Integer, Integer>> map;

    public Prims_Algo(int v) {
        map = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            map.put(i, new HashMap<>());
        }

    }

    public void AddEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }
    class PrimsPair{
        int v;
        int acqv;
        int cost;
        public PrimsPair(int v, int acqv, int cost) {
            this.v = v;
            this.acqv = acqv;
            this.cost = cost;
        }
        @Override
        public String toString(){
            return v + " " + acqv + " " + cost;
        }
    }
    public int prims(){
        PriorityQueue<PrimsPair> pq = new PriorityQueue<>(new  Comparator<PrimsPair>() {
            @Override
            public int compare(PrimsPair o1, PrimsPair o2) {
                return o1.cost - o2.cost;
            }
        });
        HashSet<Integer> visited = new HashSet<>();
        pq.add(new PrimsPair(3,3,0));
        int sum=0;
        while(!pq.isEmpty()){
            //1 remove
            PrimsPair rp = pq.poll();
            //ignore if visited
            if(visited.contains(rp.v)){
                continue;
            }
            //3 mark visited
            visited.add(rp.v);
            //4 selfwork
            System.out.println(rp);
            sum+=rp.cost;
            //5 add un visited
            for(int nbrs: map.get(rp.v).keySet()){
                if(!visited.contains(nbrs)){
                    int cost = map.get(rp.v).get(nbrs);
                    pq.add(new PrimsPair(nbrs,rp.v,cost));
                }
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        Prims_Algo ks = new  Prims_Algo(7);
        ks.AddEdge(1,2,2);
        ks.AddEdge(1,4,5);
        ks.AddEdge(2,3,3);
        ks.AddEdge(4,3,4);
        ks.AddEdge(4,5,7);
        ks.AddEdge(5,6,1);
        ks.AddEdge(5,7,6);
        ks.AddEdge(6,7,8);
        System.out.println(ks.prims());
    }
}
