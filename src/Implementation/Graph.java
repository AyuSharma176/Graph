package Implementation;

import java.util.*;

public class Graph {
    private HashMap<Integer,HashMap<Integer,Integer>> map;

    public Graph(int v) {
        map = new HashMap<>();
        for (int i = 1; i <=v; i++) {
            map.put(i, new HashMap<>());
        }
    }
    public void addEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);

        map.get(v2).put(v1, cost);
    }
    public boolean containsEdge(int v1, int v2) {
        return map.get(v1).containsKey(v2);
    }
    public boolean containsVertex(int v1) {
        return map.containsKey(v1);
    }
    public int noOfedge(){
        int sum = 0;
        for(int i : map.keySet()){
            sum += map.get(i).size();
        }
        return sum/2;
    }
    public void removeEdge(int v1, int v2) {
        map.get(v1).remove(v2);
        map.get(v2).remove(v1);
    }
    public void removeVertex(int v1) {
        for(int nbrs: map.get(v1).keySet()){
            map.get(nbrs).remove(v1);
        }
        map.remove(v1);
    }
    public boolean hasPath(int src, int des,HashSet<Integer> visited){
        if(src==des){
            return true;
        }
        visited.add(src);
        for(int nbrs: map.get(src).keySet()) {
            if (!visited.contains(nbrs)) {
                boolean ans = hasPath(nbrs, des, visited);
                if (ans) {
                    return ans;
                }
            }
        }
        visited.remove(src);
        return false;
    }
    public void display() {
        for(int v : map.keySet()){
            System.out.println(v+" ---> "+map.get(v));
        }
    }
    public void printallPaths(int src, int des,HashSet<Integer> visited,String ans) {
        if(src==des){
            System.out.println(ans+src);
            return;
        }
        visited.add(src);
        for(int nbrs: map.get(src).keySet()) {
            if (!visited.contains(nbrs)) {
                printallPaths(nbrs, des, visited, ans+src);
            }
        }
        visited.remove(src);
    }
    public boolean BFS(int src , int des){
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            //1 remove
            int rv= q.poll();
            //2 ignore
            if(visited.contains(rv)){
                continue;
            }
            //3 marked visited
            visited.add(rv);
            //4 self work
            if(rv==des){
                return true;
            }
            for(int nbrs: map.get(rv).keySet()) {
                if (!visited.contains(nbrs)) {
                    q.add(nbrs);
                }
            }
        }
        return false;
    }
    public boolean DFS(int src , int des){
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        st.push(src);
        while(!st.isEmpty()){
            //1 remove
            int rv= st.pop();
            //2 ignore
            if(visited.contains(rv)){
                continue;
            }
            //3 marked visited
            visited.add(rv);
            //4 self work
            if(rv==des){
                return true;
            }
            for(int nbrs: map.get(rv).keySet()) {
                if (!visited.contains(nbrs)) {
                    st.push(nbrs);
                }
            }
        }
        return false;
    }
    public void BFT(){
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for(int v : map.keySet()) {
            if(visited.contains(v)){
                continue;
            }
            q.add(v);
            while (!q.isEmpty()) {
                //1 remove
                int rv = q.poll();
                //2 ignore
                if (visited.contains(rv)) {
                    continue;
                }
                //3 marked visited
                visited.add(rv);
                //4 self work
                System.out.print(rv + " ");
                for (int nbrs : map.get(rv).keySet()) {
                    if (!visited.contains(nbrs)) {
                        q.add(nbrs);
                    }
                }
            }
        }
        System.out.println();
    }
    public void DFT(){
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        for(int v : map.keySet()) {
            if(visited.contains(v)){
                continue;
            }
            st.push(v);
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
                System.out.print(rv + " ");
                for (int nbrs : map.get(rv).keySet()) {
                    if (!visited.contains(nbrs)) {
                        st.push(nbrs);
                    }
                }
            }
        }
        System.out.println();
    }
}
