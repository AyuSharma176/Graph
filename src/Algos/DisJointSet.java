package Algos;

import java.util.HashMap;

public class DisJointSet {
    static class Node{
        int val;
        int rank;
        Node parent;
    }
    private HashMap<Integer,Node> map= new HashMap<>();
    public void createset(int v){
        Node nn = new Node();
        nn.val = v;
        nn.rank = 0;
        nn.parent = nn;
        map.put(v,nn);
    }

    public int find(int v){
        Node nn = map.get(v);
        return find(nn).val;
    }
    private Node  find(Node nn){
        if(nn.parent == nn){
            return nn;
        }
        Node rn= find(nn.parent);
        nn.parent=rn;//path compresion
        return rn;
    }
    public void union(int v1,int v2){
        Node nn1 = map.get(v1);
        Node nn2 = map.get(v2);
        Node rn1= find(nn1);
        Node rn2= find(nn2);
        if(rn1.rank==rn2.rank){
            rn1.parent=rn2;
            rn2.rank++;
        }
        else if(rn1.rank>rn2.rank){
            rn2.parent=rn1;
        }
        else{
            rn1.parent=rn2;
        }
    }
}
