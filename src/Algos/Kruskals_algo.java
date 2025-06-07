package Algos;

import java.util.*;

public class Kruskals_algo {
    private HashMap<Integer, HashMap<Integer,Integer>> map;

    public Kruskals_algo(int v) {
        map = new HashMap<>();
        for (int i = 1; i <=v; i++) {
            map.put(i, new HashMap<>());
        }
    }
    public void addEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }
    public void Krushkals(){
        List<edgepair> res= alledge();
        Collections.sort(res,new  Comparator<edgepair>(){
            @Override
            public int compare(edgepair o1, edgepair o2) {
                return o1.cost-o2.cost;
            }
        });
        int ans=0;
        DisJointSet ds= new DisJointSet();
        for(int v:map.keySet()){
            ds.createset(v);
        }
        for(edgepair e:res){
            int e1=e.e1;
            int e2=e.e2;
            int re1=ds.find(e1);
            int re2=ds.find(e2);
            if(re1==re2){

            }else{
                ds.union(e1,e2);
                System.out.println(e);
                ans+=e.cost;
            }
        }
        System.out.println(ans);
    }
    static class edgepair{
        int e1;
        int e2;
        int cost;
        public edgepair(int e1,int e2,int cost){
            this.e1=e1;
            this.e2=e2;
            this.cost=cost;
        }
        @Override
        public String toString(){
            return this.e1+" "+this.e2+" "+this.cost;
        }
    }
    public List<edgepair> alledge(){
        List<edgepair> res=new ArrayList<>();
        for(int e1:map.keySet()){
            for(int e2:map.get(e1).keySet()){
                int cost=map.get(e1).get(e2);
                res.add(new edgepair(e1,e2,cost));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Kruskals_algo ka =new Kruskals_algo(7);
        ka.addEdge(1,2,3);
        ka.addEdge(1,4,4);
        ka.addEdge(1,2,3);
        ka.addEdge(2,3,5);
        ka.addEdge(3,4,5);
        ka.addEdge(4,5,8);
        ka.addEdge(5,6,2);
        ka.addEdge(5,7,1);
        ka.addEdge(6,7,9);
        ka.Krushkals();
    }
}
