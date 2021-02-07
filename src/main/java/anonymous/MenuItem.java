package anonymous;

public class MenuItem {
    final String label;
    final int number;
    Callback callback;

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

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public void process(){
        if (callback != null){
            callback.action();
        }
    }
}
