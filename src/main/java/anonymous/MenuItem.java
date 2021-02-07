package anonymous;

public class MenuItem {
    final String label;
    final int number;

    public MenuItem(String label, int number) {
        this.label = label;
        this.number = number;
    }

    public String getLabel() {
        return label;
    }

    public int getNumber() {
        return number;
    }
}
