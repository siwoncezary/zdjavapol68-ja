package homework.task4;

/**
 * 1. Zdefiniuj klasę Triangle, która dziedziczy po Shape i tworzy trójkąt na podstawie
 *    trzech punktów
 * 2. Zdefiniuj klasę Circle, która dziedziczy po Shape i tworzy koło na podstawie
 *    punktu środka i promienia
 * 3. Po zdefiniowaniu obu klas usuń komentarze w wierszach 17 i 18 i
 *    sprawdź działanie programu i poprawność
 *    zwracanych pól powierzchni dla nowych klas
 */
public class Task04 {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Rectangle(new Point(10,10),10,5);
        shapes[1] = new Square(new Point(5, 10), 5);
        shapes[2] = new Section(new Point(0,0), new Point(5,5));
        //shapes[3] = new Triangle(new Point(0,0), new Point(0, 5), new Point( 5, 0));
        //shapes[4] = new Circle(new Point(5,5), 5);
        for (Shape s: shapes){
            System.out.println(s);
            if (s != null) {
                System.out.println("Pole powierzchni " + s.area());
                /**
                 4. Dopisz tutaj instrukcję, która rozpozna, który z obiektów jest prostokotąm
                 i wywoła metodę moveTo(new Point(0,0))
                 */
            }
        }
        /**
         * Oczekiwane wyniki
         * - pole trójkąta = 12.50
         * - pole koła     = 75.36
         */

    }
}
