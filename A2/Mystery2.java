import java.util.ArrayList;

class X<T>{

    final int k = -1;

    private T x1;
    private ArrayList<T> x2;
    private int x3;

    public X(){
        x1 = null;
        x2 = new ArrayList<T>();
        x3 = 1;
    }

    void setX1(T x1){
        this.x1 = x1;
    }
    void setX2(ArrayList<T> x2){
        this.x2 = x2;
    }
    void setX3(int x3){
        this.x3 = x3;
    }

    public T getX1(){
        return this.x1;
    }
    public ArrayList<T> getX2(){
        return this.x2;
    }
    public int getX3(){
        return this.x3;
    }

}

public class Mystery2<T>{

    private final int k = -1;

    private ArrayList<X> s;

    public Mystery2(){
        s = new ArrayList<X>();
    }

    void f1(T t1, T t2) throws Exception {

        //Ensures the correct n values given to tuples.(1st condition)
        int n;
        if(s.size() == 0){
            n = 1;
        }
        else{
            n = s.get(s.size() - 1).getX3() + 1;
        }

        T t;

        ArrayList<T> temp1 = new ArrayList<T>();

        //2nd condition
        for(int i = 0; i < s.size(); i++){
            if(s.get(i).getX1() == t2){
                t = t2;
                temp1.add(t);
                break;
            }
            //3rd condition
            if(i == s.size() - 1){
                t = (T)(Object)k;
                temp1.add(t);
            }
        }

        X x = new X();
        x.setX1(t1);
        x.setX2(temp1);
        x.setX3(n);
        ArrayList<X> temp2 = new ArrayList<X>();
        temp2.add(x);

        //Throws exception if needed.
        for(int i = 0; i < s.size(); i++){
            if(s.get(i).getX2() == t1){
                throw new Exception("First parameter must not be the same as the second field of a tuple in S");
            }
        }

        this.s = xUnion(this.s, temp2);
    }

    ArrayList<X> g1(){
        ArrayList<X> temp1 = new ArrayList<X>();
        ArrayList<T> temp2 = new ArrayList<T>();
        temp2.add((T)(Object)k);
        for(int i = 0; i < s.size(); i++){
            if(s.get(i).getX2() == temp2){
                temp1.add(s.get(i));
            }
        }
        return temp1;
    }

    ArrayList<X> g2(T t){
        ArrayList<X> temp1 = new ArrayList<X>();
        X temp2 = new X();
        ArrayList<T> temp3 = new ArrayList<T>();
        temp3.add((T)(Object)k);
        for(int i = 0; i < s.size(); i++){
            if(s.get(i).getX2().contains(t)){
                temp2.setX1(s.get(i).getX1());
                temp2.setX2(temp3);
                temp2.setX3(s.get(i).getX3());
                temp1.add(temp2);
            }
        }
        return temp1;
    }

    ArrayList<X> g3(T t){
        ArrayList<X> temp1 = new ArrayList<X>();
        ArrayList<T> temp2 = new ArrayList<T>();
        temp2.add(t);
        for(int i = 0; i < s.size(); i++){
            if(s.get(i).getX2() != t){
                temp1.add(s.get(i));
            }
        }
        return temp1;
    }

    ArrayList<X> xUnion(ArrayList<X> l1, ArrayList<X> l2) {
        for (int i = 0; i < l2.size(); i++) {
            if (l1.contains(l2.get(i)) == false) {
                l1.add(l2.get(i));
            }
        }
        return l1;
    }

    T f2() throws Exception {
        if(s.size() == 0){
            throw new Exception("S is empty");
        }
        //Finding x
        ArrayList<X> g1;
        g1 = g1();
        X x = new X();
        x = g1.get(g1.size() - 1);


        ArrayList<X> g2;
        ArrayList<X> g3;
        g2 = g2((T)x.getX1());
        g3 = g3((T)x.getX1());
        g2 = xUnion(g2, g3);
        g2.remove(x);

       this.s = g2;
       return (T)x.getX1();
    }

}
