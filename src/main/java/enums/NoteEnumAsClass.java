package enums;

public class NoteEnumAsClass {
    public final static NoteEnumAsClass C = new NoteEnumAsClass("C", 100.0);
    public final static NoteEnumAsClass D = new NoteEnumAsClass("D", 200.0);
    public final static NoteEnumAsClass E = new NoteEnumAsClass("E", 300.0);
    public final static NoteEnumAsClass F = new NoteEnumAsClass("G", 400.0);

    private final String name;
    private final double frequency;
    private NoteEnumAsClass(String name, double frequency){
        this.name = name;
        this.frequency = frequency;
    }

    public String name(){
       return name;
    }

    public double getFrequency() {
        return frequency;
    }

    public static NoteEnumAsClass[] values(){
        return new NoteEnumAsClass[]{C, D, E, F};
    }
}
