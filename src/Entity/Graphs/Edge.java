package Entity.Graphs;

/**
 * Created by Konstantin on 24.12.2016.
 */
public class Edge implements Comparable<Edge>{
    final int v;
    final int w;
    int weight;

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Edge(int v, int w, int weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int weight(){
        return this.weight;
    }

    public int either(){
        return this.v;
    }

    public int other(int V){
        if(this.v == V)
            return this.w;
        else
            return this.v;
    }

    @Override
    public int compareTo(Edge other){
        if(this.weight < other.weight())
            return -1;
        else if(this.weight == other.weight())
            return 0;
        else
            return 1;
    }
}