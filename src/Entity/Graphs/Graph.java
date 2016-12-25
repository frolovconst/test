package Entity.Graphs;

import java.util.LinkedList;

/**
 * Created by Konstantin on 24.12.2016.
 */
public class Graph{
    final int V;
    int E;
    LinkedList<Integer> []adj;

    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Integer> []) new LinkedList[V];
        for(int i=0; i<V; i++)
            adj[i] = new LinkedList<Integer>();
    }

    public void AddEdge(int v, int w){
        adj[v].add(v);
        adj[w].add(w);
        this.E++;
    }

    public int V(){
        return this.V;
    }

    public int E(){
        return this.E;
    }

    public LinkedList<Integer> GetAdjList(int v){
        return this.adj[v];
    }
}