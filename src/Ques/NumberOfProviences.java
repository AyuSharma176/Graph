package Ques;
import java.util.*;
public class NumberOfProviences {
    class Solution {

        public int findCircleNum(int[][] isConnected) {
            int n= isConnected.length;
            HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
            for(int i=0;i<n;i++){
                map.put(i,new HashMap<>());
            }
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(isConnected[i][j]==1){
                        map.get(i).put(j,1);
                        map.get(j).put(i,1);
                    }
                }
            }
            return DFT(map);
        }
        public int DFT(HashMap<Integer,HashMap<Integer,Integer>> map){
            HashSet<Integer> visited = new HashSet<>();
            Stack<Integer> st = new Stack<>();
            int count=0;
            for(int v : map.keySet()) {
                if(visited.contains(v)){
                    continue;
                }
                st.push(v);
                count++;
                while (!st.isEmpty()) {
                    //1 remove
                    int rv = st.pop();
                    //2 ignore
                    if (visited.contains(rv)) {
                        continue;
                    }
                    //3 marked visited
                    visited.add(rv);
                    //4 self work
//                    System.out.print(rv + " ");
                    for (int nbrs : map.get(rv).keySet()) {
                        if (!visited.contains(nbrs)) {
                            st.push(nbrs);
                        }
                    }
                }
            }
            return count;
        }
    }
}
