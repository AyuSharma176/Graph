package Implementation;

import java.util.HashSet;

public class Graph_client {
    public static void main(String[] args) {
        Graph g = new Graph(7);

        g.addEdge(1, 4, 6);
        g.addEdge(1, 2, 10);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, 5);
        g.addEdge(4, 5, 1);
        g.addEdge(5, 6, 4);
        g.addEdge(7, 5, 2);
        g.addEdge(6, 7, 3);
        System.out.println(g.hasPath(1, 6,new HashSet<>()));
        g.display();
        g.printallPaths(1,6,new HashSet<>(),"");
        System.out.println(g.BFS(1,6));
        System.out.println(g.DFS(1,6));
        g.BFT();
        g.DFT();
    }
}
