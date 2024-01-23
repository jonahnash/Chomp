public class Boards {
    public String col;
    public int x,y;

    public Boards(String myCol,int xx,int yy){
        col=myCol;
        x=xx;
        y=yy;
    }
    public void print(){
        System.out.println(col+"("+x+","+y+")");
    }
}
