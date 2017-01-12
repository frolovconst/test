package TB;

import Entity.Graphs.EdgeWeightedGraph;
import Entity.Graphs.Path.DijkstraSPT;
import Entity.InputReaders.InputReader;

import java.io.*;

/**
 * Created by Konstantin on 10.01.2017.
 */
public class DijkstraTest {
    public static void main(String[] args) {

        try {
            File f = new File("src/input/input07.txt");
            FileInputStream fis = new FileInputStream(f);
            InputStreamReader isr = new InputStreamReader(fis);
            long totTime = System.nanoTime();
            int N = readInt(isr);
            for(int i=0; i<N; i++){
                long timeOfRead = System.nanoTime();
                int Nodes = readInt(isr);
                int Edges = readInt(isr);
                EdgeWeightedGraph anEWG = new EdgeWeightedGraph(Nodes + 1);

                for(int j=0; j<Edges; j++){
                    int v = readInt(isr);
                    int w = readInt(isr);
                    int weight = readInt(isr);
                    anEWG.AddEdge(v, w, weight);
                }

                int src = readInt(isr);
                timeOfRead = System.nanoTime() - timeOfRead;

                long timeB4Dij = System.nanoTime();
                DijkstraSPT pathSearch = new DijkstraSPT(anEWG, src);
                long timeB4Print = System.nanoTime() - timeB4Dij;
                pathSearch.PrintDistances();
                System.out.println(timeB4Print/1e9);
                System.out.println(timeOfRead/1e9);
            }
            isr.close();
            totTime = System.nanoTime() - totTime;
            System.out.println(totTime/1e9);
        }
        catch(IOException e){
                e.printStackTrace();
        }
    }

    private static int stoi(String s){
        int result = 0;
        int length = s.length();
        for(int i=0; i<length; i++){
            result = result*10 + s.charAt(i) - '0';
        }
        return result;
    }

    private static int readInt(InputStreamReader isr) throws IOException {
        int result = 0, bfr;
        while((bfr = isr.read()) > 47){
            result = result*10 + bfr - '0';
        }
        return result;
    }
}
