package concurrency;

public class Counter {
    int count;

    synchronized public void  inc(){
        count++;
    }

    public int getCount() {
        return count;
    }
}
