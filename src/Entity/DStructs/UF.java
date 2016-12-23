package Entity.DStructs;

/**
 * Created by Konstantin on 23.12.2016.
 */
public class UF {
    int []p;
    int []size;

    public UF(int N){
        p = new int[N];
        size = new int[N];
        for(int i = 0; i < N; i++){
            p[i] = i;
            size[i] = 1;
        }
    }

    public int Find(int x){
        if(this.p[x] == x)
            return x;
        else{
            this.p[x] = this.p[p[x]];
            return Find(p[x]);
        }
    }

    public void Merge(int x, int y){
        int xP = Find(x);
        int yP = Find(y);
        if(yP == xP)
            return;
        else{
            this.p[yP] = xP;
            this.size[xP] += this.size[yP];
            this.size[yP] = 0;
        }
    }

    public int size(int x){
        return this.size[Find(x)];
    }
}
