package generics;

import java.util.ArrayList;
import java.util.List;

public class RawDemo {
    static public <T> List<T> getList(T ...args){
        List<T> result = new ArrayList<>();
        for(T item: args){
            result.add(item);
        }
        return result;
    }

    static public <T> List<T> getList(){
        return new ArrayList<>();
    }
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(3);
        list.add(true);
        if (list.get(1) instanceof Number) {
            int a = (int) list.get(1);
            System.out.println(a + 10);
        }
        List<String> strings = getList("Adam", "Ewa", "Ala");
        List<Integer> numbers = getList(1, 2, 4);
    }
}
