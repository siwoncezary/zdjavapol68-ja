package inner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
class Person{

}

class Worker extends Person{

}

public class HumanBodyDemo {

    public static void main(String[] args) {
        HumanBody body = new HumanBody();
        //Tworzenie obiektu klasy wewnętrznej, tylko przy pomocy obiektu klasy zewnętrznej!!!
        HumanBody.Heart heart = body.new Heart(60);
        body.setHeart(heart);
        System.out.println(heart);
        System.out.println(body);
        List<Number> str = new ArrayList<>();
        System.out.println(str);

    }
}
