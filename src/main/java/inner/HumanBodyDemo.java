package inner;

public class HumanBodyDemo {
    public static void main(String[] args) {
        HumanBody body = new HumanBody();
        //Tworzenie obiektu klasy wewnętrznej, tylko przy pomocy obiektu klasy zewnętrznej!!!
        HumanBody.Heart heart = body.new Heart(60);
        body.setHeart(heart);
        System.out.println(heart);
        System.out.println(body);
    }
}
