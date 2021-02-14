package anonymous;
//Zamiast tablicy zastosuj kolekcję
public class Menu {
    final MenuItem[] menuItems;

    public Menu(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    public void print(){
        for(MenuItem item: menuItems){
            System.out.println(item.number+". "+item.label);
        }
    }

    public void process(int number){
        for(MenuItem item: menuItems){
            if (item.getNumber() == number){
                item.process();
            }
        }
    }
}
