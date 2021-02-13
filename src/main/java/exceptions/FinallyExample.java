package exceptions;

import java.util.Scanner;
/*
    kombinacje klauzul w try .. catch .. finally:
    - try .. catch
    - try .. catch .. finally
    - try .. finally
    liczba catch dowolna np:
    try{
    } catch(..){
    } catch(..){
    }..
      catch(..){
    }
 */
public class FinallyExample {
    public static int parse(String str){
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e){
            return 0;
        //blok finaly dominuje nad wszystkimi return-ami w metodzie
        //i tylko jego return zwróci wartość z metody
        } finally {
            System.out.println("KONIEC");
            return -1;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //CZESC 1
        System.out.println("CZESC 1");
        try {
            int number = Integer.parseInt(str);
            System.out.println("koniec " + number);
        } catch (NumberFormatException e){
            System.out.println("Niepoprawna liczba całkowita");
        }
        finally {
            System.out.println("KONIEC");
        }

        //CZESC 2
        System.out.println("CZESC 2");
        System.out.println(parse(str));
    }
}
