package solution.task8;
enum Color{
    RED(0xF00), GREEN(0x0F0), BLUE(0x00F);

    private int value;

    Color(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}