package Ques;
import java.util.*;
public class graphValid_tree {
    class Solution {
        public boolean validTree(int n, int[][] edges) {
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                map.put(i, new ArrayList<>());

            }
            for (int i = 0; i < edges.length; i++) {
                int a1 = edges[i][0];
                int b1 = edges[i][1];
                map.get(a1).add(b1);
                map.get(b1).add(a1);
            }
            return isValid(map);
        }

        public boolean  isValid(HashMap<Integer, ArrayList<Integer>> map) {
            HashSet<Integer> visited = new HashSet<>();
            Queue<Integer> q = new LinkedList<>();
            int count = 0;
            for(int v : map.keySet()) {
                if(visited.contains(v)){
                    continue;
                }
                count++;
                q.add(v);
                while (!q.isEmpty()) {
                    //1 remove
                    int rv = q.poll();
                    //2 ignore
                    if (visited.contains(rv)) {
                        return false;
                    }
                    //3 marked visited
                    visited.add(rv);
                    //4 self work
//                    System.out.print(rv + " ");
                    for (int nbrs : map.get(rv)) {
                        if (!visited.contains(nbrs)) {
                            q.add(nbrs);
                        }
                    }
                }
            }
            return count==1;
        }
    }
}
