package Algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BellmanFord {
    private  HashMap<Integer, HashMap<Integer,Integer>> map;

    public BellmanFord(int v) {
        map = new HashMap<>();
        for (int i = 1; i <=v; i++) {
            map.put(i, new HashMap<>());
        }
    }
    public void addEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
    }
    public void BellmanFordAlgo(int src){
        int n=map.size();
        int[] dist=new int[n+1];
        for(int i=1;i< dist.length;i++){
            dist[i]=10000_000;
        }
        dist[src]=0;
        List<edgepairs> ll=alledge();
        for(int i=1;i<=n;i++) {
            for (edgepairs e : ll) {
                if(i==n && dist[e.e2] > dist[e.e1] + e.cost){
                    System.out.println("-ve wight cycle");
                    return;
                }
                if (dist[e.e2] > dist[e.e1] + e.cost) {
                    dist[e.e2] = dist[e.e1] + e.cost;
                }
            }
        }
        for(int i=1;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }

    }
    static class edgepairs{
        int e1;
        int e2;
        int cost;
        public edgepairs(int e1,int e2,int cost){
            this.e1=e1;
            this.e2=e2;
            this.cost=cost;
        }
        @Override
        public String toString(){
            return this.e1+" "+this.e2+" "+this.cost;
        }
    }
    public List<edgepairs> alledge(){
        List<edgepairs> res=new ArrayList<>();
        for(int e1:map.keySet()){
            for(int e2:map.get(e1).keySet()){
                int cost=map.get(e1).get(e2);
                res.add(new edgepairs(e1,e2,cost));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BellmanFord bf = new BellmanFord(5);
        bf.addEdge(1,2,8);
        bf.addEdge(1,3,4);
        bf.addEdge(1,4,5);
        bf.addEdge(3,4,-3);
        bf.addEdge(4,5,4);
        bf.addEdge(5,2,1);
        bf.addEdge(2,5,2);
//        bf.addEdge(2,5,-2);
        bf.BellmanFordAlgo(1);
    }
}
