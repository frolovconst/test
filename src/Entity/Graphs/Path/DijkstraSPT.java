package Entity.Graphs.Path;

import Entity.DStructs.FibonacciHeap;
import Entity.Graphs.Edge;
import Entity.Graphs.EdgeWeightedGraph;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Carioca on 10/01/2017.
 */
public class DijkstraSPT {
        int []distanceTo;
        int []edgeTo;
        boolean []visited;
        int src;
        //Vertex []vertices;
        //Queue<Vertex> vPQ;
        FibonacciHeap.Entry<Integer> []vToEntries;
        FibonacciHeap<Integer> vPQ;



        public DijkstraSPT(EdgeWeightedGraph anEWG, int src){
            this.src = src;
            int V = anEWG.V();
            //int E = anEWG.E();
            this.distanceTo = new int[V];
            this.edgeTo = new int[V];
            this.visited = new boolean[V];
            //this.vertices = new Vertex[V];
            this.vToEntries = (FibonacciHeap.Entry<Integer> [])new FibonacciHeap.Entry[V];
            vPQ = new FibonacciHeap<>();
            //vPQ = new PriorityQueue<>();
            for(int i=0; i<V; i++){
                this.distanceTo[i] = (int)Double.POSITIVE_INFINITY;
                this.edgeTo[i] = -1;
            }
            this.distanceTo[src] = 0;
            vPQ.enqueue(src, 0.0);
            int vIterator;
            while(!vPQ.isEmpty()){
                vIterator = vPQ.dequeueMin().getValue();
                Relax(anEWG, vIterator);
            }
            for(int i=0; i<V; i++){
                if(edgeTo[i] == -1){
                    distanceTo[i] = -1;
                }
            }
        }


        private void Relax(EdgeWeightedGraph anEWG, int vIndex){
            int w, newDistance;
            for(Edge iteratorEdge : anEWG.adj(vIndex)){
                w = iteratorEdge.other(vIndex);
                newDistance = this.distanceTo[vIndex] + iteratorEdge.weight();
                if(newDistance < this.distanceTo[w]){
                    edgeTo[w] = vIndex;
                    distanceTo[w] = newDistance;
                    if(!visited[w]){
                        visited[w] = true;
                        vToEntries[w] = vPQ.enqueue(w, (double)newDistance);
                    }
                    else{
                        vPQ.decreaseKey(vToEntries[w], (double)newDistance);
                    }
                    //vPQ.decreaseKey(vertices[w], (double)vertices[w].getDistanceTo());
                    //else
                    //vPQ.enqueue(vertices[w], (double)vertices[w].getDistanceTo());
                }
            }
        }

        public void PrintDistances(){
            int i=1;
            OutputStream out = new BufferedOutputStream( System.out );
            try{
                while(i<src){
                    out.write((distanceTo[i++] + " ").getBytes());
                    //System.out.print(distanceTo[i++] + " ");
                }
                for(i=i+1; i<distanceTo.length; i++){
                    out.write((distanceTo[i] + " ").getBytes());
                }
                out.write(("\n").getBytes());
                out.flush();
                //System.out.println();
            }


            catch(IOException e){
                e.printStackTrace();
            }



        }

}
