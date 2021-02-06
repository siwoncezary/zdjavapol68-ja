package interfaces;

public class Report implements Printable{
    final String content;

    public Report(String content) {
        this.content = content;
    }

    @Override
    public String print(String device) {
        System.out.println("Printing using device: " + device);
        return "Report nr \n" + content ;
    }
}
