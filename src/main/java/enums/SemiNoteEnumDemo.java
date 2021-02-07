package enums;

public class SemiNoteEnumDemo {
    public static void main(String[] args) {
        NoteEnumAsClass note = NoteEnumAsClass.E;
        System.out.println(note.name());

        for(NoteEnumAsClass item: NoteEnumAsClass.values()){
            System.out.println(item.name() + item.getFrequency());
        }
    }
}
