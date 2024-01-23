import java.util.ArrayList;

public class List {
    public static ArrayList<String> wins = new ArrayList<String>();
    public static ArrayList<Boards> AB = new ArrayList<Boards>();
    int winsFound = 1;
    String subset = "";
    String current = "";
    String move = "";
    int column = 0;
    int row = 0;
    boolean changed;
    boolean boardCanWin = true;
    public static void main(String[] args) {
        List myList = new List();
    }
    public List(){
        wins.add("100");
        System.out.println("WINS: " + wins.get(0));
//        for(int a=1;a<4;a++){
//            for(int b=0;b<4;b++){
//                for(int c=0;c<4;c++){
//                    String start = "" + a + b + c;
//                    //boards(a,b,c);
//                }
//            }
//        }
        boards(1,0,0,0,0,0,0,0,0,0);
        System.out.println(wins);
        for(int x=0;x<AB.size();x++){
            AB.get(x).print();
        }
        //System.out.println(AB);

    }
    public void boards(int q, int r, int s, int t, int u, int v, int w, int x, int y, int z){
        if(q>=r && r>=s && s>=t && t>=u && u>=v && v>=w && w>=x && x>=y && y>=z){
            System.out.println("Start Board: " + x + y + z);
        }
        for(int a=q;a<11;a++){
            for(int b=r;b<11;b++){
                for(int c=s;c<11;c++){
//                    for(int d=t;d<11;d++) {
//                        for(int e=u;e<11;e++) {
//                            for(int f=v;f<11;f++) {
//                                for (int g = w; g < 11; g++) {
//                                    for(int h=x;h<11;h++) {
//                                        for(int i=y;i<11;i++) {
//                                            for(int j=z;j<11;j++) {
                                                if (a >= b && b >= c && a != 0) {
                                                    boardCanWin = true;
                                                    changed = false;

                                                    subsets(a, b, c);
                                                    AB.add(new Boards("" + a + b + c, column, row));

//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
                    }
                }
            }
        }
//        subsets(x,y,z);
    }
    public void subsets(int x, int y, int z){
//        if(y>x){
//            System.out.println("Subset DOES NOT WORK: " + x + y + z);
//        }if(z>y){
//            System.out.println("Subset DOES NOT WORK: " + x + y + z);
//        }
//        if(x>=y && y>=z){
//            System.out.println("Direct SUBSET: " + x + y + z);
//        }
        //System.out.println("START " + x + y + z);
        current = ""+x+y+z;

        for(int j=z-1;j>-1;j--){
            //System.out.println("sub " + q+r+s+t+u+v+w+x+y+j + " pair (9," + j + ")");
            subset = ""+x+y+j;
            for(int k=0;k<wins.size();k++){
                //System.out.println(subset+"test" + wins[s]);
                if(subset.equals(wins.get(k))){
                    //System.out.println("found = " +q+r+s+t+u+v+w+x+y+z + " loses");
                    boardCanWin = false;
                    column = 2;
                    row = j;
                    return;
                }
            }
        }
        int zStore = 0;
        for(int i=y-1;i>-1;i--){
            if(i==y-1){
                zStore=z;
            }
            if(z>i){
                z=i;
            }
            //System.out.println("sub " + q+r+s+t+u+v+w+x+i+z + " pair (8," + i + ")");
            subset = ""+x+i+z;
            for(int k=0;k<wins.size();k++){
                //System.out.println("test" + wins[s]);
                if(subset.equals(wins.get(k))){
                    //System.out.println("found =" +x+y+z + " loses");
                    boardCanWin = false;
                    column = 1;
                    row = i;
                    return;
                }
            }
        }
        int yStore = 0;
        z=zStore;
        for(int h=x-1;h>-1;h--){
            if(h==x-1){
                yStore=y;
            }
            if(y>h){
                y=h;
            }
            if(z>h){
                z=h;
            }
            //System.out.println("sub " + h + y + z + " pair (7," + h + ")");
            subset = ""+h+y+z;
            for(int k=0;k<wins.size();k++){
                //System.out.println("test" + wins[s]);
                if(subset.equals(wins.get(k))){
                    //System.out.println("found =" +q+r+s+t+u+v+w+x+y+z + " loses");
                    boardCanWin = false;
                    column = 0;
                    row = h;
                    return;
                }
            }
        }

//        int xStore = 0;
//        y=yStore;
//        z=zStore;
//        for(int g=w-1;g>-1;g--){
//            if(g==w-1){
//                xStore=x;
//            }
//            if(x>g){
//                x=g;
//            }
//            if(y>g){
//                y=g;
//            }
//            if(z>g){
//                z=g;
//            }
//            subset = ""+q+r+s+t+u+v+g+x+y+z;
//            for(int k=0;k<wins.size();k++){
//                if(subset.equals(wins.get(k))){
//                    boardCanWin = false;
//                    column = 6;
//                    row = g;
//                    return;
//                }
//            }
//        }
//
//        int wStore = 0;
//        x=xStore;
//        y=yStore;
//        z=zStore;
//        for(int f=v-1;f>-1;f--){
//            if(f==v-1){
//                wStore=w;
//            }
//            if(w>f){
//                w=f;
//            }
//            if(x>f){
//                x=f;
//            }
//            if(y>f){
//                y=f;
//            }
//            if(z>f){
//                z=f;
//            }
//            subset = ""+q+r+s+t+u+f+w+x+y+z;
//            for(int k=0;k<wins.size();k++){
//                if(subset.equals(wins.get(k))){
//                    boardCanWin = false;
//                    column = 5;
//                    row = f;
//                    return;
//                }
//            }
//        }
//
//        int vStore = 0;
//        w=wStore;
//        x=xStore;
//        y=yStore;
//        z=zStore;
//        for(int e=u-1;e>-1;e--){
//            if(e==u-1){
//                vStore=v;
//            }
//            if(v>e){
//                v=e;
//            }
//            if(w>e){
//                w=e;
//            }
//            if(x>e){
//                x=e;
//            }
//            if(y>e){
//                y=e;
//            }
//            if(z>e){
//                z=e;
//            }
//            subset = ""+q+r+s+t+e+v+w+x+y+z;
//            for(int k=0;k<wins.size();k++){
//                if(subset.equals(wins.get(k))){
//                    boardCanWin = false;
//                    column = 4;
//                    row = e;
//                    return;
//                }
//            }
//        }
//
//        int uStore = 0;
//        v=vStore;
//        w=wStore;
//        x=xStore;
//        y=yStore;
//        z=zStore;
//        for(int d=t-1;d>-1;t--){
//            if(d==t-1){
//                uStore=u;
//            }
//            if(u>d){
//                u=d;
//            }
//            if(v>d){
//                v=d;
//            }
//            if(w>d){
//                w=d;
//            }
//            if(x>d){
//                x=d;
//            }
//            if(y>d){
//                y=d;
//            }
//            if(z>d){
//                z=d;
//            }
//            subset = ""+q+r+s+d+u+v+w+x+y+z;
//            for(int k=0;k<wins.size();k++){
//                if(subset.equals(wins.get(k))){
//                    boardCanWin = false;
//                    column = 3;
//                    row = d;
//                    return;
//                }
//            }
//        }
//
//        int tStore = 0;
//        u=uStore;
//        v=vStore;
//        w=wStore;
//        x=xStore;
//        y=yStore;
//        z=zStore;
//        for(int c=s-1;c>-1;c--){
//            if(c==s-1){
//                tStore=t;
//            }
//            if(t>c){
//                t=c;
//            }
//            if(u>c){
//                u=c;
//            }
//            if(v>c){
//                v=c;
//            }
//            if(w>c){
//                w=c;
//            }
//            if(x>c){
//                x=c;
//            }
//            if(y>c){
//                y=c;
//            }
//            if(z>c){
//                z=c;
//            }
//            subset = ""+q+r+c+t+u+v+w+x+y+z;
//            for(int k=0;k<wins.size();k++){
//                if(subset.equals(wins.get(k))){
//                    boardCanWin = false;
//                    column = 2;
//                    row = c;
//                    return;
//                }
//            }
//        }
//
//        int sStore = 0;
//        t=tStore;
//        u=uStore;
//        v=vStore;
//        w=wStore;
//        x=xStore;
//        y=yStore;
//        z=zStore;
//        for(int b=s-1;b>-1;b--){
//            if(b==s-1){
//                tStore=t;
//            }
//            if(s>b){
//                s=b;
//            }
//            if(t>b){
//                t=b;
//            }
//            if(u>b){
//                u=b;
//            }
//            if(v>b){
//                v=b;
//            }
//            if(w>b){
//                w=b;
//            }
//            if(x>b){
//                x=b;
//            }
//            if(y>b){
//                y=b;
//            }
//            if(z>b){
//                z=b;
//            }
//            subset = ""+q+b+s+t+u+v+w+x+y+z;
//            for(int k=0;k<wins.size();k++){
//                if(subset.equals(wins.get(k))){
//                    boardCanWin = false;
//                    column = 1;
//                    row = b;
//                    return;
//                }
//            }
//        }
//
//        s=sStore;
//        t=tStore;
//        u=uStore;
//        v=vStore;
//        w=wStore;
//        x=xStore;
//        y=yStore;
//        z=zStore;
//        for(int a=r-1;a>-1;a--){
//            if(a==r-1){
//                sStore=s;
//            }
//            if(r>a){
//                s=a;
//            }
//            if(t>a){
//                t=a;
//            }
//            if(u>a){
//                u=a;
//            }
//            if(v>a){
//                v=a;
//            }
//            if(w>a){
//                w=a;
//            }
//            if(x>a){
//                x=a;
//            }
//            if(y>a){
//                y=a;
//            }
//            if(z>a){
//                z=a;
//            }
//            subset = ""+a+r+s+t+u+v+w+x+y+z;
//            for(int k=0;k<wins.size();k++){
//                if(subset.equals(wins.get(k))){
//                    boardCanWin = false;
//                    column = 0;
//                    row = a;
//                    return;
//                }
//            }
//        }

        if(boardCanWin=true && !current.equals(wins.get(0))){
            wins.add(current);
            for(int k=0;k<2;k++){
                if(!current.substring(k,k+1).equals(subset.substring(k,k+1)) && changed==false){
                    column = k;
                    changed = true;
                }
            }
            System.out.println("column: " + column);
            //move = String(Integer(current)-);
            //winsFound+=1;
        }
    }
    // 1. write down all the possible, legal boards
    // 2. find all legal subsets from a given board
}
