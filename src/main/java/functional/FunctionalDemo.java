package functional;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface FunctionWithTwoOperands{
    double operator(double a, double b);
}
// a + b -> wynik
// a - b -> wynik
// a * b -> wynik
// a / b -> wynik
class Addition implements FunctionWithTwoOperands{

    @Override
    public double operator(double a, double b) {
        return a + b;
    }
}

public class FunctionalDemo {
    public void start(){

    }
    public static void main(String[] args) {
        FunctionWithTwoOperands add = new Addition();
        FunctionWithTwoOperands diff = new FunctionWithTwoOperands() {
            @Override
            public double operator(double a, double b) {
                return a - b;
            }
        };
        List<FunctionWithTwoOperands> commands = new ArrayList<>();
        commands.add(add);
        commands.add(diff);
        // wyrażenie lambda: (a, b) -> a * b
        commands.add((a, b) -> a * b);
        //równoważnik lambdy w postaci klasy anonimowej
        commands.add(new FunctionWithTwoOperands() {
            double result;
            @Override
            public double operator(double a, double b) {
                this.result = a * b;
                return calc(a, b);
            }

            private double calc(double a, double b){
                return a * b;
            }

            @Override
            public String toString() {
                return "Funkcja mnożenia";
            }
        });
        final int[] c = new int[]{10};
        //lambda nie ma this!!!! this wskazuje na obiekt w którym definiujemy lambdę
        commands.add((a, b) -> {
            //this.start();
            c[0] = 12;
            double result = c[0] * Math.pow(a, b);
            return result;
        });
        for (FunctionWithTwoOperands f: commands){
            System.out.println(f.operator( 20, 4));
            System.out.println(f);
        }

    }
}
