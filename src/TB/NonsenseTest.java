package TB;

import Entity.DStructs.FibonacciHeap;
import Entity.Graphs.EdgeWeightedGraph;
import Entity.Graphs.EdgeWeightedGraphNonsense;

import java.util.Scanner;

/**
 * Created by Carioca on 29/12/2016.
 */
public class NonsenseTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Nodes = sc.nextInt();
        int Edges = sc.nextInt();
        EdgeWeightedGraphNonsense anEWG = new EdgeWeightedGraphNonsense(Nodes);
        for(int j=0; j<Edges; j++){
            int v = sc.nextInt() - 1;
            int w = sc.nextInt() - 1;
            int weight = sc.nextInt();
            anEWG.AddEdge(v, w, weight);
        }

        sc.close();
        FibonacciHeap<Integer> fhi = new FibonacciHeap<>();
        fhi.enqueue(1,1.0);
        fhi.enqueue(1,1.4);
        fhi.enqueue(2,1.0);

    }
}
