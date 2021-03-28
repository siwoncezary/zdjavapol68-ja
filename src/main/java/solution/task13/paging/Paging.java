package solution.task13.paging;

import java.util.stream.Stream;

public interface Paging<T> {
    Stream<T> next();
    Stream<T> previous();
    Stream<T> skip(int i);
    Stream<T> current();
    void reset();
    int size();
    int currentPageNumber();
    int pageSize();
    int itemsCount();
}
