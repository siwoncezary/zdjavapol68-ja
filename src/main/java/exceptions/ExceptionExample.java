package exceptions;

public class ExceptionExample {

    public static int avg(int ...arg){
        int sum = 0;
        for(int l: arg){
            sum += l;
        }
        return sum /arg.length;

    }
    public static void main(String[] args) {
        try {
            System.out.println(avg());
        } catch (ArithmeticException e){
            System.out.println("Nie dziel przez zero, lista wartości pusta!!");
        }
    }
}
