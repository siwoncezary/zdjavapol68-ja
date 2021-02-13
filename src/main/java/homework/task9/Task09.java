package homework.task9;

/**
 * Klasa GameBoard opisuje planszę do gry w kołko i krzyżyk.
 * W jej konstruktorze tworzone są dwa obiekty klasy PlayerMark,
 * oba obiekty sa zwracane przez metodę getMarks()
 * a metoda markAt() służy do stawiania znaku danego gracza na planszy
 *
 * Program Task09 ilustruje, że niestety można zaburzyć grę i możliwe jest
 * utworzenie trzeciego znaku garcza i wstawienie go na planszy.
 *
 * Pewnym rozwiązaniem byłoby uniemożliwienie tworzenia obiektów klasy PlayerMark
 * poza klasą GameBoard.
 *
 * Twoim zadaniem jest przeniesienie klasy PLayerMark do innego pliku wraz
 * ze zmianą modyfikatorów zasięgu składowych, aby tylko klasa GameBoard  mogła tworzyć
 * jej obiekty i jednocześnie można było deklarować referencje do klasy
 * PlayerMark w innych klasach.
 *
 * Po wykonaniu zadania wiersze 31 i 32 powinny zgłaszać błędy
 * co sygnalizuje, że zostało poprawnie wykonane.
 * Po usunięciu obu wierszy oraz zmianie typu referencji w wierszu 28
 * program powinien działać poprawnie.
 *
 * Czy to jednak w pełni zabezpiecza przez opisanym problemem? Spróbuj napisać program, który
 * umożliwi wstawienie na planszy znak trzeciego gracza.
 */
public class Task09 {
    public static void main(String[] args) {
        GameBoard board = new GameBoard("Anna", "Marek");
        PlayerMark[] players = board.getMarks(); // po wykonaniu zadania zmień typ referencji players
        board.markAt(players[0],0,0);
        board.markAt(players[1], 0, 1);
        PlayerMark newMark = new PlayerMark("","#"); //po wykonaniu zadania usuń ten wiersz
        board.markAt(newMark, 0,2);                   //po wykonaniu zadania usuń ten wiersz
        System.out.println(board);
        GameBoard b = new GameBoard("Dominik", "Leszek");
        board.markAt(b.getMarks()[0], 2,2);
        board.printPlayersMark();
    }
}
