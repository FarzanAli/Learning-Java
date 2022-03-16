import java.util.ArrayList;

class X{
    private String x;
    private String y;

    public X(String x, String y){
        this.x = x;
        this.y = y;
    }

    public String getX(){
        return this.x;
    }

    public String getY(){
        return this.y;
    }
}

public class Mystery1 {

    public ArrayList<String> s1;
    public ArrayList<X> s2;

    public Mystery1() {
        s1 = new ArrayList<String>();
        s2 = new ArrayList<X>();
    }

    private static void union(ArrayList<String> l1, ArrayList<String> l2){
        if(l1.size() == 0){
            for(int i = 0; i < l2.size(); i++){
                l1.add(l2.get(i));
            }
            return;
        }
        for(int i = 0; i < l2.size(); i++){
            for(int j = 0; j < l1.size(); j++){
                if(l2.get(i) == l1.get(j)){
                    break;
                }
                if(j == l1.size() - 1){
                    l1.add(l2.get(i));
                }
            }
        }
    }

    private static void unionWithTuples(ArrayList<X> l1, ArrayList<X> l2){
        if(l1.size() == 0){
            for(int i = 0; i < l2.size(); i++){
                l1.add(l2.get(i));
            }
            return;
        }
        for(int i = 0; i < l2.size(); i++){
            for(int j = 0; j < l1.size(); j++){
                if(l2.get(i).getX() == l1.get(j).getX() && l2.get(i).getY() == l1.get(j).getY()){
                    break;
                }
                if(j == l1.size() - 1){
                    l1.add(l2.get(i));
                }
            }
        }
    }

    int f1(){
        return s1.size();
    }

    void f2(String s){
        ArrayList<String> temp = new ArrayList<String>();
        temp.add(s);
        union(s1, temp);
    }

    void f3(String s1, String s2){
        ArrayList<X> temp = new ArrayList<X>();
        temp.add(new X(s1, s2));
        unionWithTuples(this.s2, temp);
    }

    boolean f4(String s1, String s2){
        ArrayList<ArrayList<String>> set1 = new ArrayList<ArrayList<String>>();
        ArrayList<String> result = g(s1);
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < set1.size(); j++){
                if(set1.get(j) == g(result.get(i))){
                    break;
                }
                if(j == set1.size() - 1){
                    set1.add(g(result.get(i)));
                }
            }
        }
        return set1.contains(s2) && (result.contains(s2) == false);
    }

    private ArrayList<String> g(String s){
        ArrayList<String> temp = new ArrayList<String>();
        for(int i = 0; i < s2.size(); i++){
            if(s == s2.get(i).getX()){
                temp.add(s2.get(i).getY().toString());
            }
        }
        return temp;
    }

}