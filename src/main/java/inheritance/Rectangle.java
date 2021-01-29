package inheritance;
//TODO utworzyć jedna klasę abstrakcynją
//TODO z 1-2 polami, 1-2 metodami abstrakcyjnymi i 1-2 metodami zdefiniowanymi
//TODO Zdefiniować 1-2 klasy wyprowadzone z klasy abstrakcyjnej
//TODO Napisać testy  lub program demonstrujący obiekty klas
/*
    Przykład złego dziedziczenia, tak nie dziedziczymy
    Nie tworzymy  klas wyprowadzonych dla jakiś szeczgólnych przypadków wartości pól, czy zależności między polami
 */
class Square extends Rectangle{
    //o jeden bok za dużo!!!
    public Square(int sideA, int sideB) {
        super(sideA, sideB);
        //bes sensu, ale pozwala zachować kontrakt kwadratu
        //
        if (sideA != sideB){
            sideA = sideB;
        }
    }
}

public class Rectangle {
    int sideA;
    int sideB;

    public Rectangle(int sideA, int sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public int getSideA() {
        return sideA;
    }

    public void setSideA(int sideA) {
        this.sideA = sideA;
    }

    public int getSideB() {
        return sideB;
    }

    public void setSideB(int sideB) {
        this.sideB = sideB;
    }
}
